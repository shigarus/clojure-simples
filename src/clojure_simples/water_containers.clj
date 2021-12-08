(ns clojure-simples.water-containers
  "https://leetcode.com/problems/container-with-most-water/"
  (:require
   [clojure.test :refer [is]]))

(defn next-right-left
  {:test #(do
            (is (= [1 4] (next-right-left [1 2 3 4 5] 0 4)))
            (is (= [0 3] (next-right-left [1 2 3 1 5] 0 4)))
            (is (= [2 3] (next-right-left [4 4 4 4 4] 2 4))))}
  [arr left right]
  (let [next-right (dec right)
        next-left (inc left)]
    (if (> (get arr next-right) (get arr next-left))
      [left next-right]
      [next-left right])))

(defn get-max-water
  ([arr]
   (get-max-water arr [0 (dec (count arr))] 0))
  ([arr [left right] max-size]
    (let [cur-vertical (min (get arr right) (get arr left))
          cur-size (* (- right left) cur-vertical)
          next-max-size (max max-size cur-size)]
      (if (= 1 (- right left))
        next-max-size
        (recur arr
               (next-right-left arr left right)
               next-max-size)))))
