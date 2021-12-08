(ns clojure-simples.convert-to-int-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.convert-to-int :refer [get-int]]))

(deftest get-int-test
  (is (= 5 (get-int [1 0 1])))
  (is (= 0 (get-int [0])))
  (is (= 1 (get-int [1])))
  (is (= 18880 (get-int [1 0 0 1 0 0 1 1 1 0 0 0 0 0 0])))
  (is (= 0 (get-int [0 0]))))
