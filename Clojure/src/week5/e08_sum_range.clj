(ns week5.e08-sum-range)

;; a) a + Summe von (a+1) bis b, bis a grösser als b ist
(defn sum-range [a b]
  (if (> a b)
    0
    (+ a (sum-range (inc a) b))))

(sum-range 1 5)                                             ; => 15
(sum-range 3 9)                                             ; => 42

;; b) gleich wie a), aber a² statt a addieren
(defn sum-squares [a b]
  (if (> a b)
    0
    (+ (* a a) (sum-squares (inc a) b))))

(sum-squares 1 4)                                           ; => 30
