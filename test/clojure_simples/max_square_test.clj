(ns clojure-simples.max-square-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.max-square :refer [get-max-ones]]))

(deftest get-max-ones-test
  (is (= 3 (get-max-ones [[1 1 1]
                          [1 1 1]
                          [1 1 1]])))
  (is (= 1 (get-max-ones [[1 1 1]
                          [1 0 1]
                          [1 1 1]])))
  (is (= 2 (get-max-ones [[0 1 1]
                          [1 1 1]
                          [1 1 1]])))
  (is (= 1 (get-max-ones [[1]])))
  (is (= 0 (get-max-ones [[0]]))))
