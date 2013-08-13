(ns clj_proj.sever

  (:use [lamina.core]
      [aleph.tcp]
       [gloss.core]))

(println "Ready Server, Server Started")
(defn handler [ch client-info]
  (receive-all ch
    #(do (println %)
       (enqueue ch (str "You said " %)))))

(start-tcp-server handler {:port 10000, :frame (string :utf-8 :delimiters ["\r\n"])})
