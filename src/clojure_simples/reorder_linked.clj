(ns clojure-simples.reorder-linked
  "https://leetcode.com/problems/reorder-list/
   only split list part of task"
  (:require [clojure.test :refer [is]]))

(defn split-by-odd
  {:test #(do (is (= [{:val 2, :next {:val 0}}
                      {:val 1, :next {:val 1}}]
                     (split-by-odd {:val 2
                                    :next {:val 1
                                           :next {:val 0
                                                  :next {:val 1}}}})))
              (is (= [{:val 2} {:val 1}]
                     (split-by-odd {:val 2 :next {:val 1}}))))}
  [to-split]
  (reduce
   (fn [[li-1 li-2 cur-node] idx]
     (let [next-node (:next cur-node)
           cur-val (:val cur-node)
           node-to-add {:val cur-val}]
       (cond
         (nil? cur-node) (reduced [li-1 li-2])
         (odd? idx) [li-1
                     (assoc li-2 :next node-to-add)
                     next-node]
         :else [(assoc li-1 :next node-to-add)
                li-2
                next-node])))
   [{:val (:val to-split)}
    {:val (get-in to-split [:next :val])}
    (get-in to-split [:next :next])]
   (range 2 ##Inf)))
