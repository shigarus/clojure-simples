(ns clojure-simples.find-all-graph-paths-tets
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.find-all-graph-paths :refer [find-all-paths]]))

(deftest find-all-paths-test
  (is (= [[0 1 3] [0 2 3]]
         (find-all-paths [[1 2] [3] [3] []])))
  (is (= [[0 4] [0 3 4] [0 1 3 4] [0 1 2 3 4] [0 1 4]]
         (find-all-paths [[4 3 1] [3 2 4] [3] [4] []])))
  (is (= [[0 1]]
         (find-all-paths [[1] []])))
  (is (= [[0 1 2 3] [0 2 3] [0 3]]
         (find-all-paths [[1 2 3] [2] [3] []])))
  (is (= [[0 1 2 3] [0 3]]
         (find-all-paths [[1 3] [2] [3] []]))))
