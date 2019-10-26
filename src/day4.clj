(ns day4
  (:require [utils :as utils]
            [digest :as digest]
            [clojure.string :as str]) )

(def input "yzbqklnj")

(defn first-n-are-zero
  [n xs]
  (let [target (apply str (repeat n "0"))]
    (= target (subs xs 0 n))))

(defn first-5-are-zero
  [ xs]
  (first-n-are-zero 5 xs))

(defn first-6-are-zero
  [xs]
  (first-n-are-zero 6 xs))

(defn check-hash
  [count s f]
  (if (f (digest/md5 s))
    count
  (recur (+ 1 count) (str input (+ 1 count)) f )))

;"Elapsed time: 20930.732589 msecs"
(defn main
  [& args]
  (println "Part 1.")
  (println (check-hash 0 input first-5-are-zero))
  (println "Part 2.")
  (println (check-hash 0 input first-6-are-zero)))

;(def part1 (future
;             (println "started 1")
;             (check-hash 0 input first-5-are-zero)))
;
;(def part2 (future
;             (println "started 2")
;              (check-hash 0 input first-6-are-zero)))

(defn main*
  [& args]
  (def part1 (future
               (println "started 1")
               (check-hash 0 input first-5-are-zero)))

  (def part2 (future
               (println "started 2")
               (check-hash 0 input first-6-are-zero)))
  (println "Part 2.")
  (println (deref part2))

  (println "Part 1.")
  (println (deref part1))
 )




