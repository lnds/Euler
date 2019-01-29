(ns digits)

(defn num-to-digits [n]
      (->> n
           (iterate #(quot % 10))
           (take-while pos?)
           (mapv #(mod % 10))
           rseq))


(defn digits-to-num [digs]
      (reduce + (map * (reverse digs) (iterate #(* 10 %) 1))))

