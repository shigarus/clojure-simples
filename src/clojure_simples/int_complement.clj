(ns clojure-simples.int-complement
  "https://leetcode.com/problems/complement-of-base-10-integer/")

(defn get-complement
  [inp-int]
  (Integer/parseInt
   (reduce
    (fn [res cur-sym]
      (str res (if (= cur-sym \0) "1" "0")))
    ""
    (Integer/toBinaryString inp-int))
   2))
