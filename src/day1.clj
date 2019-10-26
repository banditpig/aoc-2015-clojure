(ns day1
  (:require [utils :as utils]))

(def input (utils/read-input "resources/input1.txt"))
(defn parens
  [c]
  (if (= c \()
    1
    -1))



(defn eval-parens [paren]
  (reduce + (map parens paren)))


(defn sum-to-n [target acc n xs]
  (if (= target acc)
    n
    (sum-to-n target (+ acc (nth xs n)) (+ n 1) xs)))

(defn part-one
  [brackets]
  (eval-parens brackets))

(defn part-two
  [xs]
  (sum-to-n -1 0 0  (map parens xs)))


(defn main [& args]
    (println "Part 1..")
    (println (part-one input))
    (println "Part 2.")
    (println (part-two input)))
