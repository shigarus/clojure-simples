(ns clojure-simples.max-square
  "https://leetcode.com/problems/maximal-square/"
  (:require [clojure.test :refer [is]]))

(defn get-border-nums
  {:test #(do (is (= #{3 0 8 6 7}
                     (get-border-nums [[1 2 3]
                                       [4 5 0]
                                       [6 7 8]]
                                      0 0 2)))
              (is (= #{3 0 8 6 7}
                     (get-border-nums [[1 2 3]
                                       [4 5 0]
                                       [6 7 8]]
                                      0 0 2)))
              (is (= #{2 4 5}
                     (get-border-nums [[1 2 3]
                                       [4 5 0]
                                       [6 7 8]]
                                      0 0 1)))
              (is (= #{1}
                     (get-border-nums [[1 2 3]
                                       [4 5 0]
                                       [6 7 8]]
                                      0 0 0)))
              (is (= #{0 7 8}
                     (get-border-nums [[1 2 3]
                                       [4 5 0]
                                       [6 7 8]]
                                      1 1 1)))
              (is (= #{5 6 7}
                     (get-border-nums [[1 2 3]
                                       [4 5 0]
                                       [6 7 8]]
                                      1 0 1)))
              (is (= #{0}
                     (get-border-nums [[0]]
                                      0 0 0))))}
  [matrix start-x start-y border-pos]
  (let [y-border (+ start-y border-pos)
        x-border (+ start-x border-pos)
        to-take (inc border-pos)

        x-nums (->> (get matrix x-border)
                    (take to-take)
                    (drop start-x)
                    set)
        y-nums (for [y (range start-y (+ start-y to-take))]
                 (get (get matrix y) y-border))]
    (into x-nums y-nums)))

(defn get-size
  {:test #(do (is (= 3 (get-size [[1 1 1]
                                  [1 1 1]
                                  [1 1 1]]
                                 0 0)))
              (is (= 1 (get-size [[1 1 1]
                                  [1 0 1]
                                  [1 1 1]]
                                 0 0)))
              (is (= 0 (get-size [[0 1 1]
                                  [1 1 1]
                                  [1 1 1]]
                                 0 0)))
              (is (= 2 (get-size [[0 1 1]
                                  [1 1 1]
                                  [1 1 1]]
                                 1 0)))
              (is (= 1 (get-size [[1]]
                                 0 0)))
              (is (= 0 (get-size [[0]]
                                 0 0))))}
  [matrix start-x start-y]
  (reduce
   (fn [_ size]
     (let [border-nums (get-border-nums matrix
                                        start-x
                                        start-y
                                        (dec size))]
       (print border-nums)
       (if (= #{1} border-nums)
         size
         (reduced (dec size)))))
   1
   (range 1 (count matrix))))

(comment
  (get-size [[0 1 1]
             [1 1 1]
             [1 1 1]]
            1 0))
