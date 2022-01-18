(ns clojure-simples.plant-flower
  "https://leetcode.com/problems/can-place-flowers/"
  (:require [clojure.test :refer [is]]))

(defn- free-to-plant?
  {:test #(do (is (true? (free-to-plant? [0 0 0] 0)))
              (is (true? (free-to-plant? [0 0 0] 1)))
              (is (true? (free-to-plant? [0 0 0] 2)))
              (is (false? (free-to-plant? [0 1 0] 0)))
              (is (false? (free-to-plant? [0 1 0] 1)))
              (is (false? (free-to-plant? [0 1 0] 2))))}
  [flowerbed pos]
  (= 0
     (get flowerbed (dec pos) 0)
     (get flowerbed pos)
     (get flowerbed (inc pos) 0)))

(defn can-be-planted?
  [flowerbed to-plant]
  (= 0
     (first
      (reduce
       (fn [[left-to-plant has-planted] pos]
         (cond
           (= 0 left-to-plant) (reduced [0 false])
           (true? has-planted) [left-to-plant false]
           (free-to-plant? flowerbed pos) [(dec left-to-plant) true]
           :else [left-to-plant false]))
       [to-plant false]
       (range 1 (count flowerbed))))))
