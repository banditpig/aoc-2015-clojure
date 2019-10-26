(ns day3
  (:require [utils :as utils] [digest :as digest]) )

(def input (utils/read-input "resources/input3.txt"))

(defn step
  [c x y]
  (case c
    \< (vector (- x 1) y)
    \> (vector (+ x 1) y)
    \^ (vector x (- y 1))
    \v (vector x (+ y 1))))


(defn moves
  [f path steps]
  (if (empty? steps)
    path
  (let  [[x1 y1] (last path)
         [this-step & rest] steps]
    (recur f (conj  path (f this-step x1 y1)) rest))))


(defn alternate
  [xs rx ry]
  (if (empty? xs)
    (vector rx ry)
    (let [[xs1 xs2 & rest] xs]
      (recur rest (conj rx xs1) (conj ry xs2)))))

(defn main* [& args]
  (let  [ [s1 s2] (alternate input [] [])]
    (println "Part 1.")
    (println (count (distinct (moves step [[0 0]] input))))
    (println "Part 2.")
    (print (count (distinct (concat (moves step [[0 0]] s1) (moves step [[0 0]] s2)))))))