(ns p16 (:use [digits]))


; 2^1000 = (reduce * (repeat 1000 2))
; uses bigint
(println (reduce + (num-to-digits (reduce * (repeat 1000 2N)))))