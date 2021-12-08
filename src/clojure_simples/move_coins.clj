(ns clojure-simples.move-coins
  "Not a leetcode task"
  (:require [clojure.test :refer [is]]))

(defn abs [n] (max n (-' n)))

(defn get-steps
  [coins-arr middle-pos]
  (reduce-kv
   (fn
     [[pre-middle past-middle] pos cur-coins]
     (let [to-middle (abs (- middle-pos pos))]
      (cond
        (< pos middle-pos) [(+ pre-middle (* to-middle cur-coins)) 0]
        (= pos middle-pos) [pre-middle 0]
        :else [pre-middle (+ past-middle (* to-middle cur-coins))])))
   [0 0]
   coins-arr))

(defn get-middle
  {:test #(do
            (is (= 0 (get-middle [0 0 0] 0)))
            (is (= 0 (get-middle [] 0)))
            (is (= 2 (get-middle [1 2 4] (/ 7 2))))
            (is (= 1 (get-middle [1 1 1] (/ 3 2)))))}
  ([coins-arr half-coins]
   (if (empty? coins-arr)
     0
     (get-middle coins-arr half-coins 0 0)))
  ([coins-arr half-coins coins-met cur-pos]
   (let [cur-coins (+ coins-met (get coins-arr cur-pos))]
     (if (>= cur-coins half-coins)
       cur-pos
       (recur coins-arr half-coins cur-coins (inc cur-pos))))))

(defn get-min-move
  [coins-arr]
  (let [half-coins (/ (reduce + coins-arr) 2)
        middle-pos (get-middle coins-arr half-coins)]
    (apply + (get-steps coins-arr middle-pos))))
