(ns day2
  (:require [clojure.string :as str]))

(def input (str/split-lines (slurp "resources/input2.txt")))

(defn extract-values
  [xs]
  ( map #(str/split %1 #"x") xs)
  )
(defn to-numbers
  [xs]
  (map #(map read-string %1) xs)
  )

(defn calc-area
  [[l w h]]
  (let [x (* 2 l w)
        y (* 2 w h)
        z (* 2 h l)]
  (+ x y z ( / (min x y z) 2)))
  )



(defn calc-area*
  [[l w h]]
  (let [srtd (sort [l w h])
        x (first srtd)
        y (second srtd)]
    (reduce + [(* 2 x) (* 2 y) (* w l h)]))
  )

  ;(let [x (* 2 l w)
  ;      y (* 2 w h)
  ;      z (* 2 h l)]
  ;  (+ x y z ( / (min x y z) 2)))

(defn main [& args]
  (let [
        xs1 (extract-values input)
        xs2 (to-numbers xs1)
        xs3 (map calc-area* xs2)
        xs4 (reduce + xs3)
        ]

       (print xs4)
     )
  )

;(map calc-area [[3 4 5] [1 2 3]])