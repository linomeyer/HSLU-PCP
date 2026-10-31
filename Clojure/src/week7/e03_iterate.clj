(ns week7.e03-iterate)

;; 2, 4, 6, 8, 10, 12, …
(defn one [] (iterate #(+ % 2) 2))

(take 20 (one))

;; 3, 9, 27, 81, 243, …
(defn two [] (iterate #(* % 3) 3))

(take 20 (two))

;; 1, 3, 7, 15, 31, 63, 127, …
(defn three [] (iterate #(+ (* % 2) 1) 1))

(take 20 (three))

;; 1, 1, 2, 3, 5, 8, 13, 21, 34, …
(defn four [] (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))

(take 20 (four))