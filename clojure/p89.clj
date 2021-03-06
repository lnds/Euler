(ns p89
    (:require [clojure.string :as str]))

(def data (slurp "p089_roman.txt"))

(def shortened-data (-> data
                        (str/replace #"IIIIIIIII" "IX")
                        (str/replace #"IIIIIIII" "VIII")
                        (str/replace #"IIIIIII" "VII")
                        (str/replace #"IIIIII" "VI")
                        (str/replace #"IIIII" "V")
                        (str/replace #"VIIII" "IX")
                        (str/replace #"IIII" "IV")
                        (str/replace #"LXXXX" "XC")
                        (str/replace #"XXXX" "XL")
                        (str/replace #"DCCCC" "CM")
                        (str/replace #"CCCC" "CD")))

(println
      (- (count data)
         (count shortened-data)))