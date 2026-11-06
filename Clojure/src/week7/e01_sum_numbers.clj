(ns week7.e01-sum-numbers)

(defn sum-numbers [nums]
  (map println nums)                                        ;; println wird nie ausgeführt
  (reduce + nums))

;; Warum wird println nie ausgeführt?
;; map ist lazy: es liefert nur eine lazy sequence zurück, deren Elemente erst
;; berechnet werden, wenn jemand sie konsumiert. Der Rückgabewert von (map println nums)
;; wird aber verworfen (nur der letzte Ausdruck wird zurückgegeben),
;; also fordert niemand die Elemente an und println wird nie aufgerufen.

;; Möglichkeit 1: Realisierung der lazy sequence mit dorun erzwingen
(defn sum-numbers-dorun [nums]
  (dorun (map println nums))
  (reduce + nums))

;; Möglichkeit 2:
(defn sum-numbers-doall [nums]
  (doall (map println nums))
  (reduce + nums))

;; Weitere Varianten: (run! println nums) oder (mapv println nums), da mapv eager ist

(sum-numbers [1 2 3])                                       ;; => 6, keine Ausgabe
(sum-numbers-dorun [1 2 3])                                 ;; gibt 1 2 3 aus, => 6
(sum-numbers-doall [1 2 3])                                 ;; gibt 1 2 3 aus, => 6
