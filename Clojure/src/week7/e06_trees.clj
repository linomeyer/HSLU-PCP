(ns week7.e06-trees
  (:require [week6.e06-stack :refer [run-command]]
            [week7.parser :refer [parse]])
  (:import (week7.parser Op Val)))

; Beispiel: Baum für (2+3) * 4
(def expr1 (Op. * (Op. + (Val. 2) (Val. 3)) (Val. 4)))

; Beispiel: Baum für (2+3) * 4, aber mit parse
(def expr2 (parse "(2+3) * 4"))

(= expr1 expr2)                                             ; sollte true ergeben

;; b) 2 * (4-2) + (6/3)
(def expr3 (Op. + (Op. * (Val. 2) (Op. - (Val. 4) (Val. 2))) (Op. / (Val. 6) (Val. 3))))

;; c)
(def expr4 (parse "2 * (4-2) + (6/3)"))

(= expr3 expr4)                                             ; => true

; ------------------------------------------------
; TODO - Implementieren Sie die Funktion eval-expr
;
; Tipp: Im Input wurde gezeigt, wie man nach Typ
; verzweigen kann (Folie 20)
;
; In dieser Aufgabe brauchen Sie nur die Typen
; Op und Val. Sie können davon ausgehen, dass
; nur mit Ganzahlen gerechnet wird, die Division
; ist also auch immer ganzzahlig.
; ------------------------------------------------

(defn eval-expr [expr]
  (cond
    (instance? Val expr) (:value expr)
    (instance? Op expr) (let [op (:op expr)
                              l (eval-expr (:left expr))
                              r (eval-expr (:right expr))]
                          (if (= op /)
                            (quot l r)                      ; ganzzahlige division
                            (op l r)))))

(eval-expr expr1)                                           ; => 20
(eval-expr expr3)                                           ; => 6

; ------------------------------------------------
; TODO: Compilieren Sie eine Expression für unsere
; Stackmaschine aus der letzten Übung
; ------------------------------------------------
(def op-command-map {+ "ADD" - "SUB" * "MUL" / "DIV"})

(defn compile-expr [expr]
  (cond
    (instance? Val expr) [(str "LOAD " (:value expr))]
    (instance? Op expr) (-> (compile-expr (:left expr))     ; zuerst linker Teilbaum
                            (into (compile-expr (:right expr))) ; dann rechter Teilbaum anhängen
                            (conj (op-command-map (:op expr)))))) ; zuletzt der Operator wird am Ende angefügt weil Vektor und conj | (Op. * (Val. 2) (Val. 3)) -> LOAD 2 LOAD 3 MUL

(compile-expr expr1)                                        ; => ["LOAD 2" "LOAD 3" "ADD" "LOAD 4" "MUL"]
(compile-expr expr3)

; ------------------------------------------------
; TODO: Testen Sie an einem Ausdruck, ob die
; Stack-Maschine das gleiche Ergebnis liefert
; wie die eval-expr-Funktion
; ------------------------------------------------
(defn run-program [program]
  (first (reduce run-command () program)))                  ; führt run-command aus letzter Woche mit leerem stack () und kompilierter command liste (compile-expr)  aus

(run-program (compile-expr expr1))                          ; => 20
(run-program (compile-expr expr3))                          ; => 6

(eval-expr expr1)                                           ; => 20
(eval-expr expr3)                                           ; => 6