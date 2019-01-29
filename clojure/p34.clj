; from problem 20
(defn digits [n]
      (->> n
           (iterate #(quot % 10))
           (take-while pos?)
           (mapv #(mod % 10))
           rseq))

(defn do-fact [n] (reduce *' (range 1 (inc n))))

(def fact  (memoize do-fact))

(defn is-curious? [n] (let [d (digits n) sum-d (reduce + (map fact d))]
                           (= n sum-d)))


(def limit (* 7 (fact 9)))



(println (reduce + (filter is-curious? (range 3 limit))))




