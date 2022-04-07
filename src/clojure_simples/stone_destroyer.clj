(ns clojure-simples.stone-destroyer
  "https://leetcode.com/problems/last-stone-weight/")

(defn- abs [n] (max n (-' n)))

(defn get-left
  [stones]
  (if (empty? stones)
    0
    (let [sorted-stones (reverse (sort stones))]  
      (reduce
       (fn [prev-stone cur-stone]
         (abs (- cur-stone prev-stone)))
       (first sorted-stones)
       (drop 1 sorted-stones)))))
