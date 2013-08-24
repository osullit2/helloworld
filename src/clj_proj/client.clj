(ns clj_proj.client

  (:use [lamina.core]
        [aleph.tcp]
        [gloss.core]))

(def ch
  (wait-for-result
    (tcp-client {:host "localhost",
                 :port 8888,
                 :frame (string :utf-8 :delimiters ["\r\n"])})))
(enqueue ch "Hello, server!")
(println "Message sent to server Waiting for response")
(println "Repsonse: " (wait-for-message ch))
