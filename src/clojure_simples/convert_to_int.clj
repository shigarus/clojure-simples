(ns clojure-simples.convert-to-int
  "https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/"
  (:require [clojure.test :refer [is]]))

(defn to-tree
  {:test #(do
            (is (= {:elem 1 :next nil} (to-tree [1])))
            (is (= {:elem 1 :next {:elem 0 :next nil}} (to-tree [1 0]))))}
  ([arr]
   (to-tree arr 0))
  ([arr pos]
   (let [next-pos (inc pos)]
    {:elem (get arr pos)
    :next (if (= next-pos (count arr))
            nil
            (to-tree arr next-pos))})))


(defn get-int
  ([binary-list]
   (get-int (to-tree binary-list) 0))
  ([tree intval]
   (let [{:keys [elem next]} tree
         next-intval (+ (* 2 intval) elem)]
     (if (nil? next)
       next-intval
       (recur next next-intval)))))
