(ns clojure-simples.merge-intervals-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.merge-intervals :refer [get-merged]]))

(deftest merge-intervals-test
  (is (= [[1 6] [8 10] [15 18]] (get-merged [[1 3] [2 6] [8 10] [15 18]])))
  (is (= [[1 5]] (get-merged [[1 4] [4 5]])))
  (is (= [[1 5]] (get-merged [[1 5]]))))
