(ns p92 (:use [digits]))

(defn do-sum-square-digits [n]
      (reduce + (map #(* % %) (num-to-digits n))))

(def sum-square-digits (memoize do-sum-square-digits))


(defn chain-seq [n]
      ((fn chain [j]
           (lazy-seq (cons j (chain (sum-square-digits j)))))
        n))


(defn solve-p92 [n]
      (let [nums (int-array (* 10 n) [0 1 89 89 89 89 89 1 89 89 1])]
             (loop [i 11]
                   (cond
                     (= i n) (count (filter #(= 89 %) (seq nums)))
                     (= 1 (aget nums i)) (recur (inc i))
                     (= 89 (aget nums i)) (recur (inc i))
                     :else
                     (do
                       (loop [j (sum-square-digits i)]
                             (cond
                               (= 1 j) (aset nums i 1)
                               (= 89 j) (aset nums i 89)
                               :else (recur (sum-square-digits j)) ))
                       (recur (inc i)))))))


(println (take 20 (chain-seq 1)))
(println (take 20 (chain-seq 2)))
(println (take 20 (chain-seq 3)))
(println (take 20 (chain-seq 4)))
(println (take 20 (chain-seq 5)))
(println (take 20 (chain-seq 6)))
(println (take 20 (chain-seq 7)))
(println (take 20 (chain-seq 8)))
(println (take 20 (chain-seq 9)))
(println (take 20 (chain-seq 10)))
(println (take 20 (chain-seq 11)))
(println (take 20 (chain-seq 12)))
(println (solve-p92 10000000))