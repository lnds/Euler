; P3 of Euler Project in Clojure

(defn factor-of? [f n]
	(zero? (rem n f)))

(defn prime-factors [f n]
  (cond 
  	  (= n 1) (lazy-seq [])
  	  (factor-of? f n) (lazy-seq (cons f (prime-factors f (/ n f))))
      :else (recur (inc f) n)))

(println (last (prime-factors 2 600851475143)))