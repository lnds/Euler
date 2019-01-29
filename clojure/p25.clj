(ns p25 (:use [fibo]))

(println (dec (count (take-while #(< (count (str %)) 1000) fib-seq))) )
