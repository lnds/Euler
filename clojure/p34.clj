(ns p34 (:use [digits]))


(defn do-fact [n] (reduce *' (range 1 (inc n))))

(def fact  (memoize do-fact))

(defn is-curious? [n] (let [d (num-to-digits n) sum-d (reduce + (map fact d))]
                           (= n sum-d)))

(def limit (* 7 (fact 9)))

(println (reduce + (filter is-curious? (range 3 limit))))




