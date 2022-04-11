(ns clojure-simples.shift-grid
  "https://leetcode.com/problems/shift-2d-grid/
   Shifting reverse direction")

(defn- get-shifted-cords
  [i j max-i max-j k]
  (let [ik (+ i k)
        j-shift-from-i (quot ik max-i)
        jk (+ j j-shift-from-i)
        new-i (mod ik max-i)
        new-j (mod jk max-j)]
    [new-j new-i]))

(defn get-shifted-matrix
  [matrix k]
  (let [max-i (count (first matrix))
        max-j (count matrix)]
    (for [j (range max-j)]
      (for [i (range max-i)]
       (get-in matrix
              (get-shifted-cords i j max-i max-j k))))))
