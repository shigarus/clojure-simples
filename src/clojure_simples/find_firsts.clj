(ns clojure-simples.find-firsts
  "https://leetcode.com/problems/two-sum/")

(defn find-firsts
  [arr target]
  (let [searcher (set arr)]
    (keep-indexed
     #(when (searcher (- target %2)) %1)
     arr)))


(defn last-index-of-vec
  [arr item]
  (- (count arr) 1 (.indexOf (reverse arr) item)))


(defn find-seconds
  [arr target firsts]
  (some
   #(let
     [other_val (last-index-of-vec arr (- target (get arr %)))]
      (when
       (not= other_val %)
        [% other_val]))
   firsts))


(defn find-pos
  [arr target]
  (->>
   (find-firsts arr target)
   (find-seconds arr target)
   ))