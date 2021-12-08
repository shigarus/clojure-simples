(ns clojure-simples.move-coins-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.move-coins :refer [get-min-move]]))

(deftest get-min-move-test
  (is (= 0 (get-min-move [])))
  (is (= 0 (get-min-move [0])))
  (is (= 0 (get-min-move [0 0 0])))
  (is (= 4 (get-min-move [0 2 0 3 0])))
  (is (= 39 (get-min-move [1 1 1 1 1 1 1 1 1 5]))))
