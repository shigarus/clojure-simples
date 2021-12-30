(ns clojure-simples.smallest-one-divider
  "https://leetcode.com/problems/smallest-integer-divisible-by-k/")

(defn get-divider-len
  [k]
  (if (even? k)
    -1
    (reduce
     (fn [_ cur-len]
       (let [cur-val (BigInteger. (apply str (repeat cur-len "1")))]
         (if (= 0 (mod cur-val k))
           (reduced cur-len)
           -1)))
     -1
     (range 1 100))))
