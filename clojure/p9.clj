(ns p9)

(let [[[a b c]]
	  (for [a (range 1 250) b (range 251 500) c (range 1 500) 
		:when (and (= 1000 (+ a b c)) (= (+ (* a a) (* b b)) (* c c)))] [a b c])]
	(println (* a b c)))
