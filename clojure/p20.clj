(defn digits [n]
      (->> n
           (iterate #(quot % 10))
           (take-while pos?)
           (mapv #(mod % 10))
           rseq))

(defn fact [n] (reduce *' (range 1 (inc n))))

(let [f100 (fact 100)]
     (println (reduce + (digits f100))))
