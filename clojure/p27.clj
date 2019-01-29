; from problemm 7
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


(def prime-table (set (take 100000 (primes 1000000))) )

(defn is-prime? [n] (contains? prime-table n))

; p(n) = n^2 + a*n + b  when n == 0 then p(n) = b => b has to be prime  
(def bs (sort (concat (map #(- 0 %) (primes 1000)) (primes 1000))) )

; p(n) = n^2 + a*n + b  when n == 1 then p(n) = 1+a+b => (b == 2 => 3+a has to be eveb, b > 2 => a has to ve even  
(def as (range -1000 1000))


(defn prime-sequence [a b]
      (letfn [(p [n] (+ (* n n) (* a n) b))]
             (take-while is-prime? (for [n (range)] (p n)))))


(println (prime-sequence 1 41) (count (prime-sequence 1 41)))
(println (prime-sequence -79 1601) (count (prime-sequence -79 1601)))


(let [[a b] (->>
              (for [a as b bs] [[a b] (count (prime-sequence a b))])
              (filter #(> (second %) 1))
              (apply max-key second)
              (first))]
     (println a b (* a b) (count (prime-sequence a b)) (prime-sequence a b)))
