(ns clojure-simples.move-cheaps
  "https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/")

(defn get-even-odd-sums
  [cheaps-arr]
  (reduce
   (fn [[evens odds] pos]
     (if (odd? pos)
       [evens (inc odds)]
       [(inc evens) odds]))
   [0 0]
   cheaps-arr))

(defn get-min-cost
  [cheaps-arr]
  (apply min (get-even-odd-sums cheaps-arr)))
