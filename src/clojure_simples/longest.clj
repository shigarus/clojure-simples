(ns clojure-simples.longest
  "https://leetcode.com/problems/longest-substring-without-repeating-characters/")

(defn reducable-str [s] (->> s vec (map str) vec))
(defn map-from-slice
  [s from to]
  (->> s
       reducable-str
       (take to)
       (drop from)
       (map-indexed #(vector %2 (+ from %1)))
       (reduce (fn [acc [idx sym]] (assoc acc idx sym)) {})
       ))

(defn longest [s]
  (:max (reduce-kv
         (fn [acc idx sym]
           (let [repeated-at (get-in acc [:symbols sym] nil)]
             (if (some? repeated-at)
               (assoc acc
                      :symbols (map-from-slice s (inc repeated-at) (inc idx))
                      :prev-not-repeated-pos (inc repeated-at))
               (assoc acc
                      :symbols (assoc (:symbols acc) sym idx)
                      :max (max (:max acc) (- (inc idx) (:prev-not-repeated-pos acc)))))))
         {:max 0 :symbols {} :prev-not-repeated-pos 0}
         (reducable-str s))))