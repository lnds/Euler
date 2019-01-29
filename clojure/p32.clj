(require '[clojure.set :as s])

; from problem 20
(defn digits [n]
      (->> n
           (iterate #(quot % 10))
           (take-while pos?)
           (mapv #(mod % 10))
           rseq))

(defn to-digits [[a b c]]
      [(digits a) (digits b) (digits c)])

(defn check-9-pandigital [a b c]
      (let [all-digits (s/union (set (digits a)) (set (digits b)) (set (digits c)) ) ]
           (and
             (= 9 (count all-digits))
             (nil? (all-digits 0)))))

(defn multiple-of? [x n] (zero? (mod n x)))

(defn valid-product? [x]
      (some
        #(and
           (multiple-of? % x)
           (check-9-pandigital % (quot x %) x))
        (range 2 (int (Math/sqrt x)))))

(let [candidates (filter valid-product? (range 1000 10000) )]
     (println (reduce + candidates)))

