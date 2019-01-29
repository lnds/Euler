(ns p29 (:use [math]))

(println
  (->>
    (for [a (range 2 101) b (range 2 101)] (pow a b))
    (distinct)
    (count)))

