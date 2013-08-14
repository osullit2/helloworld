(ns clj_proj.guiEG)

;(import '(javax.swing JFrame JLabel JTextField JButton)
;  '(java.awt.event ActionListener)
;  '(java.awt GridLayout))
;
;(let [frame (new JFrame "Celsius Converter")
;      temp-text (new JTextField)
;      celsius-label (new JLabel "Celsius")
;      convert-button (new JButton "Convert")
;      fahrenheit-label (new JLabel "Fahrenheit")]
;  (. convert-button
;    (addActionListener
;      (proxy [ActionListener] []
;        (actionPerformed [evt]
;          (let [c (Double/parseDouble (. temp-text (getText)))]
;            (. fahrenheit-label
;              (setText (str (+ 32 (* 1.8 c)) " Fahrenheit"))))))))
;  (doto frame
;    ;(.setDefaultCloseOperation (JFrame/EXIT_ON_CLOSE)) ;uncomment this line to quit app on frame close
;    (.setLayout (new GridLayout 2 2 3 3))
;    (.add temp-text)
;    (.add celsius-label)
;    (.add convert-button)
;    (.add fahrenheit-label)
;    (.setSize 300 80)
;    (.setVisible true)))
;
;
;
;;(import '(javax.swing JFrame JButton JOptionPane JTextField)) ;'
;;(import '(java.awt.event ActionListener))          ;'
;;
;;(let [frame (JFrame. "User Adder")
;;      button (JButton. "Click Me")
;;      userfield (JTextField. "Enter UserName")]
;;  (.addActionListener button
;;    (proxy [ActionListener] []
;;      (actionPerformed [evt]
;;        (JOptionPane/showMessageDialog  nil,
;;          (str "<html>Hello from <b>Clojure</b>. Button "
;;            (.getActionCommand evt) " clicked.")))))
;;
;;  (.. frame getContentPane (add button))
;;
;;
;;  (doto frame
;;    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
;;    .pack
;;    (.setVisible true)))