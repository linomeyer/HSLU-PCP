(ns week7.e05-pythagoras)
(require '[clojure.math :as math])

(for [a (range 1 100)
      b (range 1 100)
      c (range 1 100)
      :when (== (+ (math/pow a 2) (math/pow b 2)) (math/pow c 2))]
  (list a b c))