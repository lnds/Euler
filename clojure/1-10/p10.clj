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

(println (reduce + (primes (dec 2000000))))