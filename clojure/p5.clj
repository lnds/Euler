(ns p5 (:use [factors]))
; P5 of Euler Project

(defn lcm-divisors [n] (reduce lcm 1 (range 2 (inc n))))

(println (lcm-divisors 20))

