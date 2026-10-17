(ns week5.e06-eval)

(def a '(* 3 4))
(def b 'a)
(def c 'b)

;; c         => b          (Wert von c ist das Symbol b)
;; (eval c)  => a          (eval wertet das Symbol b aus -> Symbol a)
;; (eval (eval c)) => (* 3 4)  (Symbol a ausgewertet -> die Liste)
;; ein drittes eval rechnet die Liste aus
(eval c)                                                    ; => a
(eval (eval c))                                             ; => * 3 4
(eval (eval (eval c)))                                      ; => 12
