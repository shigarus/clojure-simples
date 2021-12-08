(ns clojure-simples.insert-position
  "https://leetcode.com/problems/search-insert-position/"
  (:require 
   [clojure.test :refer [is]]))

(defn get-place
  {:test #(do
            (is (= 2 (get-place [1 3] 1 2)))
            (is (= 3 (get-place [1 3] 2 2)))
            (is (= 3 (get-place [1 3] 3 2)))
            (is (= ##Inf (get-place [1 3] 5 2)))
            (is (= -1 (get-place [1 3] 0 2)))
            (is (= 0 (get-place [2] 1 0)))
            (is (= 6 (get-place [2] 3 5)))
            (is (= 6 (get-place [] 3 6))))}
  [[x1 x2] target x1-pos]
  (cond
    (every? nil? [x1 x2]) x1-pos
    (= x1 target) x1-pos
    (nil? x2) (if (> target x1) (inc x1-pos) x1-pos)
    (or (= x2 target) (< x1 target x2)) (inc x1-pos)
    (< target x1) -1
    (> target x2) ##Inf))

(defn get-insert-pos
  ([vec-to-ins target]
   (get-insert-pos vec-to-ins target 0))
  ([vec-to-ins target cur-subvector-pos]
   (let [only-two-left (= 2 (count vec-to-ins))
         middle (if only-two-left
                  cur-subvector-pos
                  (-> (count vec-to-ins) (/ 2) int))
         middle-vec (if only-two-left
                      vec-to-ins
                      (->> vec-to-ins (take (+ 2 middle)) (drop middle)))
         pos (get-place middle-vec target middle)]
     (case pos
       ##Inf (get-insert-pos
              (drop middle vec-to-ins)
              target
              (+ cur-subvector-pos middle))
        -1   (get-insert-pos
              (take (inc middle) vec-to-ins)
              target
              cur-subvector-pos)
       (+ pos cur-subvector-pos)))))
