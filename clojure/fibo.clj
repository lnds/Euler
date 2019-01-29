;; fibonacci functions
(ns fibo)

(def fib-seq
  ((fn fib [a b]
       (lazy-seq (cons a (fib b (+ a b)))))
    0 1))