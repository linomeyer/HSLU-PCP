(ns week6.e03-scale)

(defn scale [x-low x-high y-low y-high value]
  (let [proportion (/ (- value x-low) (- x-high x-low))]
    (+ y-low (* proportion (- y-high y-low)))))

(scale 0 100 32 212 30)                                     ; => 86


;; partial fixes the first arguments of scale and returns a new function
;; that only waits for the remaining argument: value

;; currencies: 0 CHF = 0 EUR, 1 CHF = 1.08 EUR
(def chf-to-euro (partial scale 0 1 0 1.08))

(chf-to-euro 10)
;; == 10.8

;; temperatures: 0 °C = 32 °F, 100 °C = 212 °F
(def celsius-to-fahrenheit (partial scale 0 100 32 212))

(celsius-to-fahrenheit 30)
;; == 86

;; the reverse conversions only swap the two scales
(def euro-to-chf (partial scale 0 1.08 0 1))
(def fahrenheit-to-celsius (partial scale 32 212 0 100))

(euro-to-chf 10.8)
;; == 10.0
(fahrenheit-to-celsius 86)
;; == 30
