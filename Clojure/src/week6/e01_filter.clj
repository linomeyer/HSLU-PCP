(ns week6.e01-filter
  (:refer-clojure :exclude [filter]))

;; a) filterEven / filterOdd using only empty?, first and rest

(defn filterEven [coll]
  (if (empty? coll)
    '()
    (if (even? (first coll))                                ;; if even
      (cons (first coll) (filterEven (rest coll)))          ;; then keep element and recursion with rest
      (filterEven (rest coll)))))                           ;; else just recursion with rest

(defn filterOdd [coll]
  (if (empty? coll)
    '()
    (if (odd? (first coll))
      (cons (first coll) (filterOdd (rest coll)))
      (filterOdd (rest coll)))))

(filterEven [1 2 3 4 5 6])
;; == (2 4 6)
(filterOdd [1 2 3 4 5 6])
;; == (1 3 5)

;; b) generic filter, predicate passed as a function, tail-recursive with recur
;;    the accumulator is a vector so conj appends at the end and keeps the order

(defn filter [pred coll]
  (loop [remainingColl coll acc []]                         ;; remaining collection with starting value of input variable coll | accumulator with starting value [] (empty vector)
    (if (empty? remainingColl)
      (seq acc)                                             ;; if empty convert accumulator to sequence
      (recur (rest remainingColl)                           ;; recursion back to loop with remaining collection minus first element with new accumulator value according to if else result below
             (if (pred (first remainingColl))               ;; if matches predicate
               (conj acc (first remainingColl))             ;; add current value to accumulator
               acc)))))                                     ;; else keep accumulator as is

(filter even? [1 2 3 4 5 6])
;; == (2 4 6)
(filter odd? [1 2 3 4 5 6])
;; == (1 3 5)
(filter #(> % 3) [1 2 3 4 5 6])
;; == (4 5 6)
(filter even? (range 100000))
;; no StackOverflowError thanks to recur
