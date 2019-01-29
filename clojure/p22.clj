(ns p22)

(require '[clojure.string :as str])

(defn strip-quotes [s] (subs s 1 (dec (count s))))

(defn name-value [[pos name]] (* (inc pos) (reduce + (map #(inc (- (int %) (int \A))) name))))

(let [names (sort (map strip-quotes (str/split  (slurp "names.txt") #","))) ]
    (println (reduce + (map name-value (map-indexed vector names))))  )