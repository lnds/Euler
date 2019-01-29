(ns digits)

(defn num-to-digits [n]
      (->> n
           (iterate #(quot % 10))
           (take-while pos?)
           (mapv #(mod % 10))
           rseq))
