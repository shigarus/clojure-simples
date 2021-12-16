(ns clojure-simples.next-permutation-test)
(ns clojure-simples.next-permutation-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.next-permutation :refer [get-next-permutation]]))

(deftest get-next-permutation-test
  (is (= [1 2 3] (get-next-permutation [3 2 1])))
  (is (= [1 5 1] (get-next-permutation [1 1 5])))
  (is (= [1 3 2] (get-next-permutation [1 2 3])))
  (is (= [1] (get-next-permutation [1]))))
