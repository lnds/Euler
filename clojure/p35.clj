(ns p35 (:use [primes] [digits] [list-utils]))

(def prime-table (set (primes-seq 1000000)))

(defn is-prime? [n] (contains? prime-table n))

(defn is-circular? [n]
      (let [d (num-to-digits n) perms (rotations d)]
           (= (count perms) (count (filter #(is-prime? (digits-to-num %)) perms)) )))

(println (rotations (num-to-digits 11)) (is-circular? 11))

(let [candidates (filter is-circular? (primes-seq 1000000))]
     (println (count candidates) candidates))


