; P2 Euler Project
; sum of even fibonacci numbers

(def fib-seq
	((fn fib [a b]
		(lazy-seq (cons a (fib b (+ a b)))))
	0 1))

(println (reduce + (filter even? (take-while (partial > 4000000) fib-seq))))
