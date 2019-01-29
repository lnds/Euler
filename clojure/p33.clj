(ns p33)

(defn canceling [x y]
  (let [qx (quot x 10) rx (rem x 10)
        qy (quot y 10) ry (rem y 10)]
       (if (or (zero? rx) (zero? ry))
         nil
              (or
                (and (= (/ x y) (/ qx ry)) (= 1 (/ rx qy)))
                (and (= (/ x y) (/ rx qy)) (= 1 (/ qx ry)))))))




(println (reduce * (map #(/ (first %) (second %)) (for [x (range 10 100) y (range 10 100) :when (and (< (/ x y) 1) (canceling x y))  ] [x y]))))


