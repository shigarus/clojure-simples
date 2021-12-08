(ns clojure-simples.find-firsts-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.find-firsts :refer [find-pos]]))

(deftest find-firsts-test
  (is (= [0 1] (find-pos [2 7 11 15] 9)))
  (is (= [1 2] (find-pos [3 2 4] 6)))
  (is (= [0 1] (find-pos [3 3] 6))))
