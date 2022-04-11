(ns clojure-simples.shift-grid-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.shift-grid :refer [get-shifted-matrix]]))

(deftest sum-bins-test
  (is (= [[5 6 7] [8 9 1] [2 3 4]] (get-shifted-matrix  [[1 2 3] [4 5 6] [7 8 9]] 4)))
  (is (= [[2 3 4] [5 6 7] [8 9 1]] (get-shifted-matrix  [[1 2 3] [4 5 6] [7 8 9]] 10)))
  (is (= [[1]] (get-shifted-matrix  [[1]] 4)))
  (is (= [[]] (get-shifted-matrix  [[]] 4))))
