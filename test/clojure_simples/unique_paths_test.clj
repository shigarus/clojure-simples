(ns clojure-simples.unique-paths-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.unique-paths :refer [go-deep
                                                  go-wide
                                                  go-recur]]))

(deftest unique-paths-test
  (is (= 28 (go-deep 3 7) (go-wide 3 7) (go-recur 3 7)))
  (is (= 3 (go-deep 3 2) (go-wide 3 2) (go-recur 3 2)))
  (is (= 28 (go-deep 7 3) (go-wide 7 3) (go-recur 7 3)))
  (is (= 6 (go-deep 3 3) (go-wide 3 3) (go-recur 3 3))))
