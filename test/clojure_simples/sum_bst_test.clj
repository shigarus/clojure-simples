(ns clojure-simples.sum-bst-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.sum-bst :refer [get-sum]]))

(def case1
  {:val 10
   :left {:val 5
          :left {:val 3
                 :left nil
                 :right nil}
          :right {:val 7
                  :left nil
                  :right nil}}
   :right {:val 15
          :left nil
          :right {:val 18
                  :left nil
                  :right nil}}})

(def case2
  {:val 10
   :left {:val 5
          :left {:val 3
                 :left {:val 1
                        :left nil
                        :right nil}
                 :right nil}
          :right {:val 7
                  :left {:val 6
                         :left nil
                         :right nil}
                  :right nil}}
   :right {:val 15
           :left {:val 13
                  :left nil
                  :right nil}
           :right {:val 18
                   :left nil
                   :right nil}}})

(deftest get-sum-test
  (is (= 32 (get-sum case1 [7 15])))
  (is (= 23 (get-sum case2 [6 10]))))
