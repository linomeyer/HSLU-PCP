(ns week7.e01-sum-numbers)

(defn sum-numbers [nums]
  (map println nums)                                        ;; println wird nie ausgeführt
  (reduce + nums))

;; Warum wird println nie ausgeführt?
;; map ist lazy: es liefert nur eine lazy sequence zurück, deren Elemente erst
;; berechnet werden, wenn jemand sie konsumiert. Der Rückgabewert von (map println nums)
;; wird aber verworfen (nur der letzte Ausdruck im defn-Body wird zurückgegeben),
;; also fordert niemand die Elemente an und println wird nie aufgerufen.
;; (In der REPL sieht man bei (map println [1 2 3]) die Ausgabe nur, weil die REPL
;; das Resultat zum Ausgeben realisiert.)

;; Möglichkeit 1: Realisierung der lazy sequence mit dorun (oder doall) erzwingen
(defn sum-numbers-dorun [nums]
  (dorun (map println nums))
  (reduce + nums))

;; Möglichkeit 2: doseq verwenden, gedacht für Seiteneffekte und nicht lazy
(defn sum-numbers-doseq [nums]
  (doseq [n nums]
    (println n))
  (reduce + nums))

;; Weitere Varianten: (run! println nums) oder (mapv println nums), da mapv eager ist

(sum-numbers [1 2 3])                                       ;; => 6, keine Ausgabe
(sum-numbers-dorun [1 2 3])                                 ;; gibt 1 2 3 aus, => 6
(sum-numbers-doseq [1 2 3])                                 ;; gibt 1 2 3 aus, => 6
