(ns week5.e05-mitternachtsformel)

(defn diskriminante [a b c]
  (- (* b b) (* 4 a c)))

;; a) lösbar, wenn die Diskriminante nicht negativ ist
(defn loesbar? [a b c]
  (>= (diskriminante a b c) 0))

(loesbar? 1 -3 2)                                           ; => true
(loesbar? 1 0 1)                                            ; => false

;; b) Anzahl Lösungen
(defn check-number-of-solutions-mitternachtsformel [a b c]
  (let [d (diskriminante a b c)]
    (cond
      (pos? d) 2
      (zero? d) 1
      :else 0)))

(check-number-of-solutions-mitternachtsformel 1 -3 2)       ; => 2
(check-number-of-solutions-mitternachtsformel 1 2 1)        ; => 1
(check-number-of-solutions-mitternachtsformel 1 0 1)        ; => 0

;; c) Lösungen als Vektor
(defn x1 [a b c]
  (/ (+ (- b) (Math/sqrt (diskriminante a b c))) (* 2 a)))

(defn x2 [a b c]
  (/ (- (- b) (Math/sqrt (diskriminante a b c))) (* 2 a)))

(defn solve-mitternachtsformel [a b c]
  (case (check-number-of-solutions-mitternachtsformel a b c)
    2 [(x1 a b c) (x2 a b c)]
    1 [(x1 a b c)]
    0 []))

(solve-mitternachtsformel 1 -3 2)                           ; => [2.0 1.0]
(solve-mitternachtsformel 1 2 1)                            ; => [-1.0]
(solve-mitternachtsformel 1 0 1)                            ; => []
