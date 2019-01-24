
(defn pow [b n] (apply *' (repeat n b)))



(println
  (->>
    (for [a (range 2 101) b (range 2 101)] (pow a b))
    (distinct)
    (count)))

