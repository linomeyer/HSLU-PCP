(ns week5.e09-algorithm)

(defn algorithm [n]
  (when (> n 1)
    (println n)
    (algorithm (if (even? n)
                 (/ n 2)
                 (+ 1 (* 3 n))))))

(algorithm 7)