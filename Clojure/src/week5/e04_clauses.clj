(ns week5.e04-clauses)

;; a) Temperaturen
;; Nein. cond prüft die Klauseln von oben nach unten und nimmt die erste, die
;; zutrifft. Die Bedingungen überlappen sich (40 ist > 35, > 25 und > 15).
;; Vertauscht man z.B. die ersten beiden Klauseln, ergibt 40 "warm" statt "heiss".
;; :else muss sowieso immer zuletzt stehen.
(defn temperatur-text [temperatur]
  (cond
    (> temperatur 35) "heiss"
    (> temperatur 25) "warm"
    (> temperatur 15) "mittel"
    :else "kalt"))

(temperatur-text 40)                                        ; => "heiss"

;; b) Teilbarkeit
;; Nein. Vielfache von 6 sind durch 2 und durch 3 teilbar.
(defn teilbarkeit [zahl]
  (cond
    (zero? (rem zahl 2)) "durch 2 teilbar"
    (zero? (rem zahl 3)) "durch 3 teilbar"
    :else "weder durch 2 noch durch 3 teilbar"))

(teilbarkeit 6)                                             ; => "durch 2 teilbar"

;; c) a) nur mit if
(defn temperatur-text-if [temperatur]
  (if (> temperatur 35)
    "heiss"
    (if (> temperatur 25)
      "warm"
      (if (> temperatur 15)
        "mittel"
        "kalt"))))

(temperatur-text-if 40)
(temperatur-text-if 20)
(temperatur-text-if 10)

;; d) case
;; case vergleicht einen Wert auf Gleichheit
;; Sachen wie (> temperatur 35) gehen damit nicht.
;;
;; a) Nicht sinnvoll: Man müsste jede Temperatur einzeln aufzählen
;; b) auch nicht wirklich, aber geht halbwegs mit mod
(defn teilbarkeit-case [zahl]
  (case (mod zahl 6)
    (0 2 4) "durch 2 teilbar"
    3 "durch 3 teilbar"
    "weder durch 2 noch durch 3 teilbar"))

(teilbarkeit-case 6)                                        ; => "durch 2 teilbar"
(teilbarkeit-case 9)                                        ; => "durch 3 teilbar"
(teilbarkeit-case 7)                                        ; => "weder durch 2 noch durch 3 teilbar"