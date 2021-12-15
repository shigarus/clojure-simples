(ns clojure-simples.merge-n-lists
  "https://leetcode.com/problems/merge-k-sorted-lists/")

(defn get-min-list-pos
  [lists]
  (:pos (reduce-kv
         (fn [acc pos cur-list]
           (let [cur-val (nth cur-list 0)]
             (if (< cur-val (:min acc))
               {:min cur-val :pos pos}
               acc)))
         {:min ##Inf
                 :pos nil}
         lists)))

(defn remove-at
  [li idx]
  (vec
   (concat
    (subvec li 0 idx)
    (subvec li (inc idx)))))

(defn merge-lists
  [lists]
  (loop [lists-left (vec (remove empty? lists))
         res []]
    (if (empty? lists-left)
      res
     (let [min-pos (get-min-list-pos lists-left)
           min-list (get lists-left min-pos)]
      (recur
       (->>
        (update lists-left min-pos #(pop %))
        (remove empty?)
        vec)
       (conj res (nth min-list 0)))))))

(comment (merge-lists ['(1 4 5) '(1 3 4) '(2 6)]))
