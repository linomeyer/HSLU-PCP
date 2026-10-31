(ns week7.e04-for)

(mapcat (fn [x] (map #(+ x %) (range 3))) (range 3))

(for [x (range 3)
      y (range 3)]
  (+ x y))                                                  ;; => (0 1 2 1 2 3 2 3 4)


(map #(list % %) (filter #(== (mod % 3) 0) (range 10)))

(for [x (range 10)
      :when (== (mod x 3) 0)]
  (list x x))                                               ;; ((0 0) (3 3) (6 6) (9 9))



(filter #(> (second %) (first %))
        (mapcat (fn [x] (map #(list x %) (range 4))) (range 4)))

(for [x (range 4)
      y (range 4)
      :when (> y x)]
  (list x y))                                               ;; ((0 1) (0 2) (0 3) (1 2) (1 3) (2 3))

