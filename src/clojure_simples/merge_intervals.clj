(ns clojure-simples.merge-intervals
  "https://leetcode.com/problems/merge-intervals/
   Works for sorted intervals, presented as tests on leetcode
   If intervals are not sorted - add sorting by start value")

(defn overlap?
  [[_ i1] [i2 _]]
  (<= i2 i1))

(defn get-merged
  [intervals]
  (reduce
   (fn [res cur]
     (let [last-interval (last res)]
      (if (overlap? last-interval cur)
        (conj (pop res) [(first last-interval)
                         (last cur)])
        (conj res cur))))
   [(first intervals)]
   intervals))
