(ns clojure-simples.int-complement-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.int-complement :refer [get-complement]]))

(deftest get-complement-test
  (is (= 2 (get-complement 5)))
  (is (= 0 (get-complement 7)))
  (is (= 5 (get-complement 10))))
