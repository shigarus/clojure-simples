(ns clojure-simples.tree-tilt-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.tree-tilt :refer [get-tilt]]))

(def case1
  {:val 1
   :left {:val 2
          :left nil
          :right nil}
   :right {:val 3
          :left nil
          :right nil}})

(def case2
  {:val 4
   :left {:val 2
          :left {:val 3
                 :left nil
                 :right nil}
          :right {:val 5
                  :left nil
                  :right nil}}
   :right {:val 9
           :left nil
           :right {:val 7
                   :left nil
                   :right nil}}})

(def case3 
  {:val 21
   :left {:val 7
          :left {:val 1
                 :left {:val 3
                        :left nil
                        :right nil}
                 :right {:val 3
                         :left nil
                         :right nil}}
          :right {:val 1
                  :left nil
                  :right nil}}
   :right {:val 14
           :left {:val 2
                  :left nil
                  :right nil}
           :right {:val 2
                   :left nil
                   :right nil}}})

(deftest get-tilt-test
  (is (= 1 (get-tilt case1)))
  (is (= 15 (get-tilt case2)))
  (is (= 9 (get-tilt case3))))
