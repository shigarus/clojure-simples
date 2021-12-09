(ns clojure-simples.tree-tilt
  "https://leetcode.com/problems/binary-tree-tilt/")

(defn abs [n] (max n (-' n)))

(defn add-sums
  [{:keys [left right val]}]
  (cond
    (nil? val) nil
    (every? nil? [left right]) {:sums val :left nil :right nil}
    :else (let [new-left (add-sums left)
                new-right (add-sums right)]
            {:sums (+ (:sums new-left 0)
                      (:sums new-right 0)
                      val)
             :left new-left
             :right new-right})))

(defn get-tilt-from-sums
  [{:keys [left right]}]
  (+ (abs (- (:sums left 0) (:sums right 0)))
     (if (nil? left) 0 (get-tilt-from-sums left))
     (if (nil? right) 0 (get-tilt-from-sums right))))

(defn get-tilt
  [node]
  (get-tilt-from-sums (add-sums node)))
