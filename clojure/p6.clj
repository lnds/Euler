(ns p6)
; P6 of Euler Project

(defn sum-n [n] (/ (* n (inc n)) 2))

(defn square-sum [n] (let [s (sum-n n)] (* s s)))

(defn sum-n-square [n] (reduce + (map #(* % %) (range 1 (inc n)))))

(defn dif-squares [n] (- (square-sum n) (sum-n-square n)))

(println (dif-squares 100))