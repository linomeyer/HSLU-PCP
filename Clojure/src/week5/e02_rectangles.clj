(ns week5.e02-rectangles)

;; a) Rechteck
(def laenge 4)
(def breite 3)

(* laenge breite)                                           ; Fläche => 12
(* 2 (+ laenge breite))                                     ; Umfang => 14
(Math/sqrt (+ (* laenge laenge) (* breite breite)))         ; Diagonale => 5.0

;; b) Quader
(def hoehe 5)

(* laenge breite hoehe)                                       ; Volumen => 60
(* 2 (+ (* laenge breite) (* laenge hoehe) (* breite hoehe))) ; Oberfläche => 94

;; c) Funktionen
(defn rechteck-flaeche [l b]
  (* l b))

(defn rechteck-umfang [l b]
  (* 2 (+ l b)))

(defn rechteck-diagonale [l b]
  (Math/sqrt (+ (* l l) (* b b))))

(defn quader-volumen [l b h]
  (* l b h))

(defn quader-oberflaeche [l b h]
  (* 2 (+ (* l b) (* l h) (* b h))))

(rechteck-flaeche 4 3)                                      ; => 12
(rechteck-umfang 4 3)                                       ; => 14
(rechteck-diagonale 4 3)                                    ; => 5.0
(quader-volumen 4 3 5)                                      ; => 60
(quader-oberflaeche 4 3 5)                                  ; => 94