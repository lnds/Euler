(use '[clojure.string :only (join split)])

(def digit-names ["one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

(def digit-prefixes ["thir" "four" "fif" "six" "seven" "eigh" "nine"])

(def teen-names (->> digit-prefixes
                     (mapv #(str % "teen"))
                     (into ["eleven" "twelve"])))

(def tees-names (as-> digit-prefixes d
                      (assoc d 1 "for") ; forty drops the "u" for some reason
                      (into ["twen"] d)
                      (mapv #(str % "ty") d)))

(def tens-names (as-> digit-prefixes d
                      (assoc d 1 "for") ; forty drops the "u" for some reason
                      (into ["twen"] d)
                      (mapv #(str % "ty") d)))

(defn- str-ones [digit]
       (if (zero? digit)
         ""
         (digit-names (dec digit))))


(defn div-mod [numer denom]
      ((juxt quot mod) numer denom))

(defn- str-teen [n]
       (teen-names (- n 11)))


(defn- str-tens-place [tens-place]
       (if (zero? tens-place)
         ""
         (tens-names (- tens-place 2))))

(defn- str-mid-less-hundred [n]
       (let [[tens ones] (div-mod n 10)]
            (str (str-tens-place tens)
                 (if (or (zero? tens) (zero? ones))
                   ""
                   "-")
                 (str-ones ones))))


(declare num-to-words)


(defn- str-greater-hundred [n]
       (let [[hundreds tens-and-ones] (div-mod n 100)]
            (str (str-ones hundreds) " hundred"
                 (if (zero? tens-and-ones)
                   ""
                   (str " and "
                        (num-to-words tens-and-ones))))))

(defn num-to-words [n]
      (let [f (condp > n
                     10 str-ones
                     11 (constantly "ten")
                     20 str-teen
                     100 str-mid-less-hundred
                     1000 str-greater-hundred
                     (constantly "one thousand"))]
           (f n)))


(defn len-num-to-words [n]
      (count (filter #(Character/isLetter %) (num-to-words n))))

(println (num-to-words 342) (len-num-to-words 342))
(println (num-to-words 115) (len-num-to-words 115))
(println (num-to-words 23) (len-num-to-words 23))
(println (reduce + (map len-num-to-words (range 1 1001))))