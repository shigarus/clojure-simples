(ns clojure-simples.move-cheaps-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.move-cheaps :refer [get-min-cost]]))

(deftest get-min-cost-test
  (is (= 1 (get-min-cost [1 2 3])))
  (is (= 2 (get-min-cost [2 2 2 3 3])))
  (is (= 1 (get-min-cost [1 1000000000]))))
