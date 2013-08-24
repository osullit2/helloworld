(ns clj_proj.http)
(use 'lamina.core 'aleph.http)
(println "Ready, Server started.")
(defn hello-world [channel request]
  (println "Hello")
  (enqueue channel
    {:status 200
     :headers {"content-type" "text/html"}
     :body "Hello World!"}))

(start-http-server hello-world {:port 8008})
