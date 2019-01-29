(ns p32 (:use [digits] [factors]) (:require [clojure.set :as s]))


(defn to-digits [[a b c]]
      [(num-to-digits a) (num-to-digits b) (num-to-digits c)])

(defn check-9-pandigital [a b c]
      (let [all-digits (s/union (set (num-to-digits a)) (set (num-to-digits b)) (set (num-to-digits c)) ) ]
           (and
             (= 9 (count all-digits))
             (nil? (all-digits 0)))))


(defn valid-product? [x]
      (some
        #(and
           (multiple-of? % x)
           (check-9-pandigital % (quot x %) x))
        (range 2 (int (Math/sqrt x)))))

(let [candidates (filter valid-product? (range 1000 10000) )]
     (println (reduce + candidates)))

