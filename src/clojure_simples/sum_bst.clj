(ns clojure-simples.sum-bst
  "https://leetcode.com/problems/range-sum-of-bst/")

(defn update-queue
  [queue {:keys [left right]}]
  (into (pop queue)
        (filter some? [left right])))

(defn get-sum
  [root-node [min-val max-val]]
  (loop [going-to (conj
                  clojure.lang.PersistentQueue/EMPTY
                  root-node)
         total-sum 0]
    (if (empty? going-to)
      total-sum
      (let [cur-node (first going-to)
            cur-val (:val cur-node)
            val-in-range? (<= min-val cur-val max-val)
            next-sum (+ total-sum
                        (if val-in-range? cur-val 0))
            next-queue (update-queue going-to cur-node)]
        (recur next-queue next-sum)))))
