(ns clojure-simples.min-diff-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.min-diff :refer [get-min-diff-pairs]]))

(deftest get-min-cost-test
  (is (= [[1 2] [2 3] [3 4]] (get-min-diff-pairs [4 2 1 3])))
  (is (= [[1 3]] (get-min-diff-pairs [1 3 6 10 15])))
  (is (= [[-14 -10] [19 23] [23 27]] (get-min-diff-pairs [3 8 -10 23 19 -4 -14 27]))))
