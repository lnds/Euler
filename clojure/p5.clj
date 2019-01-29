; P5 of Euler Project 

(defn gcd [x y]
	(loop [a x b y]
		(if (zero? b) a
			(recur b (mod a b)))))

(defn lcm [a b]
	(cond 
		(zero? a) 0
		(zero? b) 0
		:else (* b (int (/ a (gcd a b))))))

(defn divisors 
	([] (divisors 20))
	([n] (reduce lcm 1 (range 2 (inc n)))))

(println (divisors))

