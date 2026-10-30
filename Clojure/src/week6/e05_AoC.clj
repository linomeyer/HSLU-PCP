(ns week6.e05-AoC)


(def start [3 4 3 1 2])

(defn step [coll]
  (mapcat #(if (> % 0) [(dec %)] [6 8]) coll))

(defn steps [count coll]
  (nth (iterate step coll) count))

(count (steps 80 start))
;; == 5934

;; b) simulating every number does not work for 256 steps (about 27 billion numbers)
;;    the order does not matter, so we only count how many numbers have each value 0-8
;;    counts is a vector of 9 elements: index = value, element = how many numbers have that value

(defn to-counts [coll]
  (mapv #(get (frequencies coll) % 0) (range 9)))           ;; values that don't occur get count 0

(to-counts start)
;; == [0 1 1 2 1 0 0 0 0]

;; every value moves down one index, the zeros wrap around to index 8 (new numbers)
;; and are additionally added to index 6 (the numbers that were 0 and reset to 6)
(defn step-counts [counts]
  (let [zeros (first counts)]
    (update (conj (subvec counts 1) zeros) 6 + zeros)))     ;subvec counts 1 = minus 1 for all positions, zeros get added to the end (conj ... zeroes) == new 8's | update adds zeroes to position 6 too

(step-counts (to-counts start))
;; == [1 1 2 1 0 0 0 0 0]   (= [2 3 2 0 1] after step 1)

(defn count-after [n coll]
  (reduce + (nth (iterate step-counts (to-counts coll)) n)))

(count-after 80 start)
;; == 5934
(count-after 256 start)
;; == 26984457539
