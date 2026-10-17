(ns week5.e03-expression)

(+ (* 2 3) (/ 3 4))                              ;; 27 / 4
;;(+ - * /)                                      ;; - * / können nicht addiert werden
'(+ - * /)                                       ;; - * / werden nicht evaluiert sondern einfach als Daten ausgegeben
(str 1.0 2 true)                                 ;; string "1.02true"
(+ (parse-long "123") (parse-double "0.45"))     ;; 123.45
(or "this" "is" "crazy")                         ;; this - evaluiert nur erstes Argument und gibt dieses zurück
(and "this" "is" "crazy")                        ;; crazy - evaluiert alle und gibt letztes zurück
;;(not "this" "is" "crazy")                      ;; not erwartet nur ein Argument
((fn [x] (/ 1 x)) (/ 5 2))                       ;; 2 / 5
(int? 3000000000)                                ;; true - ist tatsächlich ein int