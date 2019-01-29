(defn count-chain [n values]
      (if (contains? values n)
        [(get values n) values]
        (if (zero? (mod n 2))
          (let [[val, nvalues] (count-chain (/ n 2) values)]
               [(inc val), (assoc nvalues n val)])
          (let [[val, nvalues] (count-chain (/ (inc (* 3 n)) 2) values)]
               [(+ 2 val), (assoc nvalues n val)]))))

(loop [n 500000, lc 0, ans -1, values {1 1}]
      (if (== n 1000000)
        (println ans)
        (let [[cc nvalues] (count-chain n values) nlc (if (> cc lc) cc lc) nans (if (> nlc lc) n ans)]
             (recur (inc n) nlc nans nvalues))))

