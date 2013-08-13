(ns clj-proj.core
  (:gen-class)
  (:import [javax.swing JTextField]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))


(import '(javax.swing JFrame JButton JOptionPane JTextField)) ;'
(import '(java.awt.event ActionListener))          ;'

(let [frame (JFrame. "User Adder")
      button (JButton. "Click Me")
      userfield (JTextField. "Enter UserName")]
  (.addActionListener button
    (proxy [ActionListener] []
      (actionPerformed [evt]
        (JOptionPane/showMessageDialog  nil,
          (str "<html>Hello from <b>Clojure</b>. Button "
            (.getActionCommand evt) " clicked.")))))

  (.. frame getContentPane (add button))


  (doto frame
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    .pack
    (.setVisible true)))

;print("code sample");
(println "Done")