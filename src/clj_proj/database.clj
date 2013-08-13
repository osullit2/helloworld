(ns clj_proj.database
  (:gen-class)
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]
            [clj_proj.encrypter :as encr]))

(def mykey "SecretKey")

(def mysql-db {:subprotocol "mysql"
               :subname "//127.0.0.1:3306/MYDB"
               :user "root"
               :password "0411tjosullivan"})

(defn database-entry
  "Enters Values provided into database"
  [username password]
  (let [encrypted-password (encr/encrypt password mykey)
        name username]
    (j/insert! mysql-db :users
      {:name name :password encrypted-password })
    (println "User entered to database: " username)))
;; ({:generated_key 1} {:generated_key 2})
;
;(println (j/query mysql-db
;           (s/select * :cities )))
;(database-entry "TJ O Sullivan" "My password")


(defn select-from-database
  "Retrieves username and password from database"
  [username]
  (doseq [info (j/query mysql-db
               (s/select * :users (s/where {:name username})))]
    (let [password (encr/decrypt (:password info) mykey)]
    (println "Username: " (:name info) " \nPassword: " password )
    )))

(select-from-database "TJ O Sullivan")

(println "Done")


