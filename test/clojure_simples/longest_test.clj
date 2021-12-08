(ns clojure-simples.longest-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.longest :refer [longest]]))

(deftest longest-test
  (is (= 3 (longest "abcabcbb")))
  (is (= 1 (longest "bbbbb")))
  (is (= 3 (longest "pwwkew")))
  (is (= 0 (longest ""))))
