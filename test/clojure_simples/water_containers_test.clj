(ns clojure-simples.water-containers-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.water-containers :refer [get-max-water]]))

(deftest get-wax-water-test
  (is (= 1 (get-max-water [1,1])))
  (is (= 16 (get-max-water [4,3,2,1,4])))
  (is (= 2 (get-max-water [1,2,1])))
  (is (= 49 (get-max-water [1,8,6,2,5,4,8,3,7]))))
