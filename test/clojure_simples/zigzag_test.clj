(ns clojure-simples.zigzag-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-simples.zigzag :refer [zigzagish
                                            append-symbol-to-zigzag]]))

(deftest zigzag-test
  (is (= "PAHNAPLSIIGYIR" (zigzagish "PAYPALISHIRING" 3)))
  (is (= "PINALSIGYAHRPI" (zigzagish "PAYPALISHIRING" 4)))
  (is (= "A" (zigzagish "A" 1))))

(deftest append-zymbol-to-zigzag
  (is (= [["a" "bc" "c"] 1 :up] (append-symbol-to-zigzag
                                 [["a" "b" "c"] 2 :up]
                                 "c")))
  (is (= [["a" "b" "c"] 2 :up] (append-symbol-to-zigzag
                                [["a" "b" ""] 1 :down]
                                "c")))
  (is (= [["a" "b" ""] 1 :down] (append-symbol-to-zigzag
                                 [["a" "" ""] 0 :down]
                                 "b")))
  (is (= [["ag" "bc" "c"] 0 :down] (append-symbol-to-zigzag
                                    [["a" "bc" "c"] 1 :up]
                                    "g"))))
