(ns clojure-simples.smallest-one-divider-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.smallest-one-divider :refer [get-divider-len]]))

(deftest get-divider-len-test
  (is (= -1 (get-divider-len 2)))
  (is (= 1 (get-divider-len 1)))
  (is (= 3 (get-divider-len 3)))
  (is (= 6 (get-divider-len 7))))
