; problem 4 in project Euler

(defn rev 
	"reverse an integer number"
	[num]
	(loop [reversed 0 n num]
		(if (zero? n) reversed
			(recur (+ (* 10 reversed) (mod n 10)) (int (/ n 10))))))

(defn palindrome? [n] (= n (rev n)))

(println (apply max (filter palindrome? (for [x (range 100 1000) y (range 100 1000)] (* x y)))))


