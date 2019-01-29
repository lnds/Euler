; Euler Project P1 in Clojure
(println 
	(reduce + (filter #(or (zero? (mod % 5)) (zero? (mod % 3))) (range 1000))))
