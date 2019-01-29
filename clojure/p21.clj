(ns p21 (:use [factors]))


(defn d [n] (reduce +' (proper-divisors n)))

(defn amicable? [a b]
      (and (not= a b)
           (== a (d b))
           (== b (d a))))

(println (reduce + (let [sums (mapv d (range 1 10000))]
                        (for [i (range 1 10000)]
                             (if (amicable? i (nth sums (dec i))) i 0)))))



