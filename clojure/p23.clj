(defn proper-divisors [n]
      (if (= n 1)
        []
        (filter #(zero? (mod n %)) (range 1 n))))


(defn perfect? [n]
      (= n (reduce + (proper-divisors n))))

(defn abundant? [n]
      (< n (reduce + (proper-divisors n))))

(defn deficient [n]
      (> n (reduce + (proper-divisors n))))

(def abundants (filter abundant? (range 1 28124)))

(def from-abundants-pairs (set (filter #(< % 28124) (for [x abundants y abundants] (+ x y)))) )

(println (reduce + (filter #(not (contains? from-abundants-pairs %)) (range 1 28124))) )