(ns clojure-simples.next-permutation
  "https://leetcode.com/problems/next-permutation/
   swaps only one pair of values or sorting")

(defn get-decrease-pos
  [arr]
  (let [last-idx (dec (count arr))]
    (reduce-kv
     (fn [prev pos cur]
       (cond
         (< cur prev) (reduced pos)
         (= pos last-idx) (reduced nil)
         :else cur))
     -1
     arr)))

(defn get-lower-pos
  [arr to-compare]
  (first (keep-indexed
          #(when (< to-compare %2) %1)
          arr)))

(defn from-reversed-pos
  [arr pos]
   (- (count arr) pos 1))

(defn get-next-permutation
  [arr]
  (let [reversed (vec (rseq arr))
        rev-decreased-at (get-decrease-pos reversed)]
   (if (nil? rev-decreased-at)
     (sort arr)
     (let [decreased-at (from-reversed-pos arr rev-decreased-at)
           decreased-val (get arr decreased-at)
           rev-to-swap (get-lower-pos reversed decreased-val)
           to-swap (from-reversed-pos arr rev-to-swap)]
       (assoc arr
              to-swap decreased-val
              decreased-at (get arr to-swap))))))
