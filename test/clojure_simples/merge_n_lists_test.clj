(ns clojure-simples.merge-n-lists-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.merge-n-lists :refer [merge-lists]]))

(deftest merge-lists-test
  (is (= [1 1 2 3 4 4 5 6]
         (merge-lists ['(1 4 5) '(1 3 4) '(2 6)])))
  (is (= []
         (merge-lists ['()])))
  (is (= []
         (merge-lists []))))
