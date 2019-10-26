(ns utils)

(defn foldl [f val coll]
  (if (empty? coll) val
  (foldl f (f val (first coll)) (rest coll))))



(defn read-input [f]
  (seq (slurp f)))