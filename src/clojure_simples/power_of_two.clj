(ns clojure-simples.power-of-two
  (:require [clojure.test :refer [is]]))

(defn power-of-two?
  {:test #(do (is (= true (power-of-two? 2)))
              (is (= true (power-of-two? 1)))
              (is (= true (power-of-two? 1024)))
              (is (= false (power-of-two? 1023)))
              (is (= false (power-of-two? -1))))}
  [i]
  (let [as-str (Integer/toString i 2)]
    (and (> i 0)
         (= \1 (first as-str))
         (every? #(= \0 %) (rest as-str)))))
