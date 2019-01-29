(ns p12 (:use [factors]))

; tn[n] = n * (n+1)/2
(defn triangle-num [n]
      (/ (* n (inc n)) 2))

(def triangles
      (map triangle-num (iterate inc 1)))

(defn num-div [n]
      (* 2 (count (divisors n))))


(println (first (drop-while #(< (num-div %) 500) triangles)))
