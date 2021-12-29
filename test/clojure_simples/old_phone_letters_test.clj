(ns clojure-simples.old-phone-letters-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.old-phone-letters :refer [get-combinations]]))

(deftest get-combinations-test
  (is (= [] (get-combinations "")))
  (is (= ["a" "b" "c"] (get-combinations "2")))
  (is (= (set ["dgj" "egj" "fgj"
               "dhj" "ehj" "fhj"
               "dij" "eij" "fij"
               "dgk" "egk" "fgk"
               "dhk" "ehk" "fhk"
               "dik" "eik" "fik"
               "dgl" "egl" "fgl"
               "dhl" "ehl" "fhl"
               "dil" "eil" "fil"])
         (set (get-combinations "345")))))
