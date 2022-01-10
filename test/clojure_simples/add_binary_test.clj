(ns clojure-simples.add-binary-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.add-binary :refer [sum-bins]]))

(deftest sum-bins-test
  (is (= "11" (sum-bins "11" "0")))
  (is (= "100" (sum-bins "11" "1")))
  (is (= "10101" (sum-bins "1010" "1011"))))
