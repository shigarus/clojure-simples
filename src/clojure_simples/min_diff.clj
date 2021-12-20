(ns clojure-simples.min-diff
  "https://leetcode.com/problems/minimum-absolute-difference/")

(defn get-min-diff-pairs
  [arr]
  (first
   (let [sorted-arr (sort arr)]
     (reduce
      (fn [[pairs cur-min prev-val] cur-val]
        (let [cur-diff (- cur-val prev-val)]
          (cond
            (< cur-diff cur-min) [[[prev-val cur-val]]
                                  cur-diff
                                  cur-val]
            (= cur-diff cur-min) [(conj pairs
                                        [prev-val cur-val])
                                  cur-diff
                                  cur-val]
            :else [pairs cur-min cur-val])))
      [[] ##Inf (first sorted-arr)]
      (drop 1 sorted-arr)))))
