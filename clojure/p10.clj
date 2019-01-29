(ns p10 (:use [primes]))

(println (reduce + (primes-seq (dec 2000000))))