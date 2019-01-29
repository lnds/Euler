(ns p67)

(def triangle
  (map #(Integer/parseInt %)(map #(reduce str %) (partition 2 2 (remove #(or (= \newline %) (= \  %))
                                                                        (seq (slurp "p67.txt")))))))

(def tree
  (loop [lst triangle n 1 newlist nil]
        (if (empty? lst) (reverse newlist)
                         (recur (drop n lst) (inc n) (cons (take n lst) newlist)))))


(defn max-row [l]
      (map #(reduce max %) (partition 2 1 l)))

(defn step-max [l1 l2]
      (map + (max-row l1) l2))

(println (reduce step-max (reverse tree)))