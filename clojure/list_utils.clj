(ns list-utils)

(defn tails [a-seq]
      (if (empty? a-seq)
        (list ())
        (cons (seq a-seq) (tails (rest a-seq)))))

(defn inits [a-seq]
      (reverse (map reverse (tails (reverse a-seq)))))

(defn rotations [a-seq]
      (map concat (tails a-seq) (inits a-seq)))