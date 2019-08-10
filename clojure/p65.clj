(ns p65 (:use [digits]))

(defn calc-n-convergent [limit]
      (loop [d 1N, n 2N, i 2N]
            (if (> i limit)
              n
              (let [c (if (zero? (mod i 3)) (* 2 (/ i 3)) 1)]
                   (recur n (+ d  (* c n)) (inc i))))))

(println (reduce + (num-to-digits (calc-n-convergent 100))))