(ns clojure-simples.sum-linkeds
  "https://leetcode.com/problems/add-two-numbers/")

(defn get-sum-and-remains
  [prev_remains vals]

  (as-> (str (apply + (conj vals prev_remains))) res
   (map str res)
   (map #(Integer/parseInt %) res)
   (if (> (count res) 1)
      res
      (into [0] res))))

(defn sum-linkeds

  ([l1 l2]
  (sum-linkeds l1 l2 0))

  ([l1 l2 remains]
  (let [ls (filter some? [l1 l2])
        [next_remains cur_val] (get-sum-and-remains
                                remains
                                (map :val ls))]
    {
     :val cur_val
     :next (when (or 
                  (not= 0 next_remains) 
                  (some some? (map :next ls)))
             (sum-linkeds (:next l1) (:next l2) next_remains))
    })))