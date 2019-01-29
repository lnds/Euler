(defn primes [n]
      (let [root (-> n Math/sqrt int)
            sieve (boolean-array n true)]
           (loop [i 2]
                 (when (< i root)
                       (when (aget sieve i)
                             (loop [j (* i 2)]
                                   (when (< j n)
                                         (aset sieve j false)
                                         (recur (+ j i)))))
                       (recur (inc i))))
           (filter #(aget sieve %) (range 2 n))))


(defn digits [n]
      (->> n
           (iterate #(quot % 10))
           (take-while pos?)
           (mapv #(mod % 10))
           rseq))

(defn to-num [digs]
      (reduce + (map * (reverse digs) (iterate #(* 10 %) 1))))

(defn tails [a-seq]
      (if (empty? a-seq)
        (list ())
        (cons (seq a-seq) (tails (rest a-seq)))))

(defn inits [a-seq]
      (reverse (map reverse (tails (reverse a-seq)))))

(defn rotations [a-seq]
       (map concat (tails a-seq) (inits a-seq)))

(def prime-table (set (primes 1000000)))

(defn is-prime? [n] (contains? prime-table n))

(defn is-circular? [n]
      (let [d (digits n) perms (rotations d)]
           (= (count perms) (count (filter #(is-prime? (to-num %)) perms)) )))


(println (rotations (digits 11)) (is-circular? 11))
;
;

(let [candidates (filter is-circular? (primes 1000000))] (println (count candidates) candidates))


