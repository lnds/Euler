(ns factors)

(defn factor-of? [f n]
      (zero? (rem n f)))

(defn prime-factors [f n]
      (cond
        (= n 1) (lazy-seq [])
        (factor-of? f n) (lazy-seq (cons f (prime-factors f (/ n f))))
        :else (recur (inc f) n)))

(defn gcd [x y]
      (loop [a x b y]
            (if (zero? b) a
                          (recur b (mod a b)))))

(defn lcm [a b]
      (cond
        (zero? a) 0
        (zero? b) 0
        :else (* b (int (/ a (gcd a b))))))

(defn divisors [n] (reduce lcm 1 (range 2 (inc n))))
