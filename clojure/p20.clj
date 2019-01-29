(ns p20 (:use [digits] [factorials]))

(let [f100 (fact 100)]
     (println (reduce + (num-to-digits f100))))
