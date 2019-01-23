(defn fact [n] (reduce *' (range 1 (inc n))))

(println
  (loop [digits (range 10)
         top 1000000
         i 0
         init 9
         result []]
        (let [f (fact init)]
             (cond
               (zero? init) (apply str (concat result digits))
               (< f top) (recur digits (- top f) (inc i) init result)
               :else (recur (concat (take i digits) (drop (inc i) digits)) top 0 (dec init) (conj result (nth digits i)))))))