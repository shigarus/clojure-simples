(ns clojure-simples.stone-destroyer-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.stone-destroyer :refer [get-left]]))

(deftest sum-bins-test
  (is (= 0 (get-left [])))
  (is (= 2 (get-left [2])))
  (is (= 0 (get-left [2 2])))
  (is (= 1 (get-left [1 1 1])))
  (is (= 1 (get-left [2 7 4 1 8 1]))))
