(ns p2 (:use [fibo]))
; P2 Euler Project
; sum of even fibonacci numbers


(println (reduce + (filter even? (take-while (partial > 4000000) fib-seq))))
