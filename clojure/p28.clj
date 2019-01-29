(ns p28)
; size of square is 2*n+1
;
(defn sum-diag [n]
      (if (zero? n)
        1
        (let [n21 (inc (* 2 n))] (+ (- (* 4 n21 n21) (* 12 n)) (sum-diag (dec n))))))


(println (sum-diag 500))

