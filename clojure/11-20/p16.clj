(defn digits [n]
      (->> n
           (iterate #(quot % 10))
           (take-while pos?)
           (mapv #(mod % 10))
           rseq))

; 2^1000 = (reduce * (repeat 1000 2))
; uses bigint
(println (reduce + (digits (reduce * (repeat 1000 2N)))))