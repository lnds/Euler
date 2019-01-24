(defn pow [b n] (apply *' (repeat n b)))

(defn find-bases [n]
      (for [a (range 1 10)] (pow a n)))


(defn limit [n] (* (pow 10 n) 10))

; from problem 20
(defn digits [n]
      (->> n
           (iterate #(quot % 10))
           (take-while pos?)
           (mapv #(mod % 10))
           rseq))


(defn check-digits [num n]
      (= num (reduce + (for [d (digits num)] (pow d n)))))

(println (filter #(check-digits % 4) (range 2 (limit 4))))

(println (reduce + (filter #(check-digits % 4) (range 2 (limit 4)))))

(println (filter #(check-digits % 5) (range 2 (inc (limit 5)))))

(println (reduce + (filter #(check-digits % 5) (range 2 (inc (limit 5))))))

