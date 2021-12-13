(ns clojure-simples.power-string-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.power-string :refer [get-power]]))

(deftest get-min-cost-test
  (is (= 2 (get-power "leetcode")))
  (is (= 5 (get-power "abbcccddddeeeeedcba")))
  (is (= 5 (get-power "triplepillooooow")))
  (is (= 11 (get-power "hooraaaaaaaaaaay")))
  (is (= 1 (get-power "tourist")))
  (is (= 1 (get-power "t")))
  (is (= 0 (get-power ""))))
