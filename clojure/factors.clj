(ns factors)

(defn factor-of? [f n]
      (zero? (rem n f)))

(defn prime-factors [f n]
      (cond
        (= n 1) (lazy-seq [])
        (factor-of? f n) (lazy-seq (cons f (prime-factors f (/ n f))))
        :else (recur (inc f) n)))