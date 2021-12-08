(ns clojure-simples.zigzag
  "https://leetcode.com/problems/zigzag-conversion/"
  (:require 
   [clojure.test :refer [is]]))

(defn get-direction
  {:test #(do
            (is (= :down (get-direction 1 0 :up)))
            (is (= :down (get-direction 2 1 :down)))
            (is (= :up (get-direction 3 2 :up)))
            (is (= :up (get-direction 5 5 :up))))}
  [max-depth cur-pos prev-direction]
  (case prev-direction
    :down (if (= max-depth cur-pos) :up :down)
    :up (if (= 0 cur-pos) :down :up)))

(defn get-pos-to-append
  {:test #(do
            (is (= 3 (get-pos-to-append :down 2)))
            (is (= 1 (get-pos-to-append :up 2))))}
  [direction prev-append-to]
  ((case direction
     :down inc
     :up dec)
   prev-append-to))

(defn append-symbol-to-zigzag
  [[zigzag-strings prev-append-to direction] symbol]
  (let [cur-append-to (get-pos-to-append direction prev-append-to)]
    [(update zigzag-strings cur-append-to str symbol)
     cur-append-to
     (get-direction (dec (count zigzag-strings)) cur-append-to direction)]))

(defn zigzagish
  [string-to-zigzag row-num]
  (apply str (get (reduce append-symbol-to-zigzag
                          [(vec (repeat row-num "")) -1 :down]
                          string-to-zigzag)
                  0)))
  