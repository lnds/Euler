(defn leap? [year]
      (or (and (zero? (mod year 4)) (not (zero? (mod year 100)))) (zero? (mod year 400))))

(defn days-in-month [year] [0 31 (if (leap? year) 29 28) 31 30 31 30 31 31 30 31 30 31])

(defn count-sundays [year sum]
      (let [months (days-in-month year)]
           (loop [m 1 acum sum count 0]
                 (if (> m 12)
                   count
                   (recur (inc m) (+ (get months m) acum) (if (zero? (mod acum 7)) (inc count) count)))))
      )


(println (count-sundays 1900 0))
(println (count-sundays 1901 365))
(println (leap? 2000))

(loop [year 1901 acum 365 count 0]
      (if (== year 2000)
        (println count)
        (recur (inc year) (+ acum (if (leap? year) 366 365)) (+ count (count-sundays year acum)))))

