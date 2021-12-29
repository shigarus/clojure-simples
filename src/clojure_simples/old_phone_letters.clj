(ns clojure-simples.old-phone-letters
  "https://leetcode.com/problems/letter-combinations-of-a-phone-number/")

(def keyboard
  {\2 [\a \b \c]
   \3 [\d \e \f]
   \4 [\g \h \i]
   \5 [\j \k \l]
   \6 [\m \n \o]
   \7 [\p \q \r \s]
   \8 [\t \u \v]
   \9 [\w \x \y \z]})


(defn get-combinations
  [digits]
  (if (empty? digits)
    []
    (reduce
     (fn [acc cur-num]
       (for [prev acc
             to-add (get keyboard cur-num)]
         (str prev to-add)))
     (map str (get keyboard (first digits)))
     (rest digits))))
