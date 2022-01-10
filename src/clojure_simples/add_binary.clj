(ns clojure-simples.add-binary
  "https://leetcode.com/problems/add-binary/"
  (:require [clojure.test :refer [is]]))

(defn- add-char-bins
  {:test #(do (is (= [\0 \0] (add-char-bins \0 \0 \0)))
              (is (= [\1 \0] (add-char-bins \0 \1 \0)))
              (is (= [\0 \1] (add-char-bins \1 \1 \0)))
              (is (= [\1 \1] (add-char-bins \1 \1 \1))))}
  [& bins]
  (let [res (apply + (map #(Integer/parseInt %) (map str bins)))]
   (case res
     0 [\0 \0]
     1 [\1 \0]
     2 [\0 \1]
     3 [\1 \1])))

(defn- rev-get
  {:test #(do (is (= \1 (rev-get "000010" 6 1)))
              (is (= \0 (rev-get "000010" 6 7)))
              (is (= \1 (rev-get "000001" 6 0)))
              (is (= \1 (rev-get "100000" 6 5))))}
  [coll len pos]
  (get coll (- len 1 pos) \0))

(defn sum-bins
  [val-1 val-2]
  (let [count-1 (count val-1)
        count-2 (count val-2)
        [res rest-res] (reduce
                        (fn [[res to-add] i]
                          (let [i-1 (rev-get val-1 count-1 i)
                                i-2 (rev-get val-2 count-2 i)
                                [to-res next-to-add] (add-char-bins i-1 i-2 to-add)]
                            [(str to-res res) next-to-add]))
                        ["" \0]
                        (range (max count-1 count-2)))]
    (if (= rest-res \1)
      (str rest-res res)
      res)))
