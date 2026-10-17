(ns week5.e07-umrechnungen)

;; a)
(defn chf-to-euro [x] (* (double x) 1.08))

(chf-to-euro 10)


;; b)

(defn celsius-to-fahrenheit [x] (+ (* (double x) (/ 9 5)) 32))

(celsius-to-fahrenheit 10)


;; c)

;; proportion => wie weit value zwischen x-low und x-high liegt (0 bis 1),
;; denselben Anteil auf die y-Skala übertragen
(defn scale [x-low x-high y-low y-high value]
  (let [proportion (/ (- value x-low) (- x-high x-low))]
    (+ y-low (* proportion (- y-high y-low)))))

(scale 0 100 32 212 30)                                     ; => 86

;; Währungen: 0 CHF = 0 EUR, 1 CHF = 1.08 EUR
(defn chf-to-euro-scale [x] (scale 0 1 0 1.08 x))
(chf-to-euro-scale 10)                                      ; => 10.8

(defn celsius-to-fahrenheit-scale [x] (scale 0 100 32 212 x)) ;
(celsius-to-fahrenheit-scale 30)                            ; => 86

