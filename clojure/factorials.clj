(ns factorials)

(defn fact [n] (reduce *' (range 1 (inc n))))
