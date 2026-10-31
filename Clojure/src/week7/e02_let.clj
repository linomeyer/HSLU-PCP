(ns week7.e02-let)

(let [a 1 b 2 c 3]
  (let [b c]                                                ;; neues b bekommt wert c [a 1 b 3 c 3]
    (let [a b]                                              ;; neues a bekommt wert b [a 3 b 3 c 3]
      (let [c a]                                            ;; neues c bekommt wert a [a 3 b 3 c 3]
        [a b c]))))                                         ;; ursprüngliches a b c sind immer noch 1 2 3, es wird immer ein neues binding
;; mit denselben namen erstellt, die die äusseren a b c Variablen shadowen

