; dynamic programming
(let [mat (to-array-2d [[0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1],
                               [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]])]
     (loop [i 19]
           (if (< i 0)
             (println (aget mat 0 0))
             (recur
               (loop [j 19]
                   (if (< j 0)
                     (dec i)
                     (do
                       (aset mat i j (+ (aget mat (inc i) j) (aget mat i (inc j))))
                       (recur (dec j)))))))))

; combinatoric
(loop [i 0 paths 1]
      (if (== i 20)
        (println paths)
        (recur (inc i) (/ (* paths (- 40 i)) (inc i))  )))


; memoization after reading the pdf

(defn count-routes [n m]
      (if (or (zero? n) (zero? m))
        1
        (+ (count-routes m (dec n)) (count-routes (dec m) n))))

(def m-count-routes (memoize count-routes))


(println (m-count-routes 20 20))