(def fib-seq
  ((fn fib [a b]
       (lazy-seq (cons a (fib b (+' a b)))))
    0 1))

(println (dec (count (take-while #(< (count (str %)) 1000) fib-seq))) )
