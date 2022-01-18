(ns clojure-simples.plant-flower-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.plant-flower :refer [can-be-planted?]]))

(deftest can-be-planted-test
  (is (true? (can-be-planted? [1 0 0 0 1] 1)))
  (is (false? (can-be-planted? [1 0 0 0 1] 2)))
  (is (true? (can-be-planted? [1 0 0] 1)))
  (is (false? (can-be-planted? [1 0 0 0] 2)))
  (is (true? (can-be-planted? [1 0 0 0 0] 2))))
