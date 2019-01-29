(ns p26)

(defn unit-fraction [denom]
      (loop [numer 1 i 1 known {}]
            (let [r (rem (* 10 numer) denom)]
                 (cond
                   (zero? r) 0
                   (get known r) (- i (get known r))
                   :else (recur r (inc i) (assoc known r i))))))

(println (->> (range 1 1000)
              (map #(vec [% (unit-fraction %)]))
              (apply max-key second)
              (first)))
