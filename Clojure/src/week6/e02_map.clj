(ns week6.e02-map
  (:refer-clojure :exclude [map reduce]))

;; a) tail-recursive map with recur

(defn map [f coll]
  (loop [remaining-coll coll acc []]
    (if (empty? remaining-coll)
      (seq acc)
      (recur (rest remaining-coll)
             (conj acc (f (first remaining-coll)))))))      ;; use function of first element of remaining collection and add to accumulator

(map inc [1 2 3])
;; == (2 3 4)
(map #(* % %) [1 2 3 4])
;; == (1 4 9 16)
(count (map inc (range 100000)))
;; == 100000, no StackOverflowError thanks to recur

;; b) tail-recursive reduce with multi-arity
;;    without a start value the first element is used as val
;;    in the 3-arity version val acts as the accumulator, recur jumps back to the same arity

(defn reduce
  ([f coll]
   (if (empty? coll)
     (f)
     (reduce f (first coll) (rest coll))))
  ([f val coll]
   (if (empty? coll)
     val
     (recur f (f val (first coll)) (rest coll)))))

(reduce + [1 2 3 4 5])
;; == 15
(reduce * [1 2 3 4 5])
;; == 120
(reduce + 2 [3 4])
;; == 9
(reduce * 2 [3 4])
;; == 24

;; c) map and filter implemented with reduce
;;    the start value [] is the accumulator, the reducing function decides what gets added
;; fn [acc x] (conj acc (f x))) == (acc, x) -> { acc.add(x); return acc; }
(defn map-with-reduce [f coll]
  (reduce (fn [acc x] (conj acc (f x))) [] coll))           ;; function argument | empty val | coll


(defn filter-with-reduce [pred coll]
  (reduce (fn [acc x] (if (pred x) (conj acc x) acc)) [] coll))

(map-with-reduce inc [1 2 3])
;; == [2 3 4]
(filter-with-reduce even? [1 2 3 4 5 6])
;; == [2 4 6]

;; d) clojure's map with several sequences: f gets one element of each sequence
;;    vector builds a pair out of the two elements

(def pairs (clojure.core/map vector [1 2 3] [4 5 6]))

pairs
;; == ([1 4] [2 5] [3 6])

;; e) get the original sequences back: first elements and second elements of every pair

(clojure.core/map first pairs)
;; == (1 2 3)
(clojure.core/map second pairs)
;; == (4 5 6)
