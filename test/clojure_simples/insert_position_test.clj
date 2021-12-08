(ns clojure-simples.insert-position-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.insert-position :refer [get-insert-pos]]))

(deftest get-insert-pos-test
  (is (= 2 (get-insert-pos [1 3 5 6] 5)))
  (is (= 1 (get-insert-pos [1 3 5 6] 2)))
  (is (= 4 (get-insert-pos [1 3 5 6] 7)))
  (is (= 0 (get-insert-pos [1 3 5 6] 0)))
  (is (= 0 (get-insert-pos [1] 0))))
