(ns clojure-simples.sum-linkeds-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.sum-linkeds :refer [sum-linkeds]]))

(deftest sum-linkeds-test
  (is (= {:val 2
          :next {:val 1
                 :next {:val 0
                        :next {:val 1
                               :next nil}}}}
         (sum-linkeds
          {:val 1
           :next {:val 2
                  :next {:val 3
                         :next nil}}}
          {:val 1
           :next {:val 9
                  :next {:val 6
                         :next nil}}}))))
