(ns clojure-simples.basic-calculator-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.basic-calculator :refer [do-math]]))

(deftest do-math-test
  (is (= 7 (do-math "3+2*2")))
  (is (= 5/2 (do-math " 5/2 ")))
  (is (= 6 (do-math " 3+6 / 2 ")))
  (is (= 36 (do-math "32+2*2"))))
