(ns week6.e06-stack
  (:require [clojure.string :as str]))

;; a) stack state after each command
(def input-a ["LOAD 2" "LOAD 3" "ADD" "LOAD 4" "MUL"])
;;
;;    command     stack       what happens

;;    (start)     ()          empty stack
;;    "LOAD 2"    (2)         push 2
;;    "LOAD 3"    (3 2)       push 3 on top of 2
;;    "ADD"       (5)         pop 3 and 2, push 3 + 2 = 5
;;    "LOAD 4"    (4 5)       push 4 on top of 5
;;    "MUL"       (20)        pop 4 and 5, push 4 * 5 = 20


(def input-b ["LOAD 4" "LOAD 5" "ADD" "LOAD 2" "LOAD 3" "ADD" "MUL"]) ;; clojure notation reversed

;; c) execute a single command on a stack
;;    the top of the stack is the first element, so cons pushes and first / second / drop pop

(defn apply-operation [f stack]
  (cons (f (second stack) (first stack))                    ;; second = lower operand, first = top operand
        (drop 2 stack)))                                    ;; remove both operands, push the result

(defn run-command [stack command]
  (let [[operation argument] (str/split command #" ")]
    (case operation
      "LOAD" (cons (parse-long argument) stack)
      "ADD" (apply-operation + stack)
      "MUL" (apply-operation * stack)
      "SUB" (apply-operation - stack)
      "DIV" (apply-operation / stack))))

(run-command [] "LOAD 1")
;; == (1)
(run-command [1 2] "LOAD 3")
;; == (3 1 2)
(run-command [1 2 9 9 9] "ADD")
;; == (3 9 9 9)
(run-command [2 3 9 9 9] "MUL")
;; == (6 9 9 9)

(run-command [2 6] "DIV")
(run-command [2 6] "SUB")