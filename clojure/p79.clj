(ns p79 (:use [digits] [kahn]) (:require [clojure.string :as str] ))

(def attempts (map #(Integer/parseInt %)  (str/split (slurp "p079_keylog.txt") #"\s+")))

(def distinct-attempts (sort (distinct attempts)) )

(println (count attempts))
(println (count distinct-attempts))


(println distinct-attempts)

(defn get-set [n]
      (let [digits (num-to-digits n)]
           {(first digits) (second digits)
            (second digits) (last digits)
            }))



(def base {0 #{} 1 #{} 2 #{} 3 #{} 4 #{} 5 #{} 6 #{} 7 #{} 8 #{} 9 #{}})

(let [pre-graph (apply merge-with conj base (vec (map get-set distinct-attempts)))
      graph (into {} (filter #(seq (val %)) pre-graph)) ]
     (println  graph)
     (println (kahn-sort graph) )
     )
