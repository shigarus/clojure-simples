(ns clojure-simples.power-string
  "https://leetcode.com/problems/consecutive-characters/")

(defn get-power
  [s]
  (:max-power
   (reduce
    (fn [{:keys [prev-sym max-power cur-power]} cur-sym]
      (let [next-cur-power (if (= prev-sym cur-sym)
                      (inc cur-power)
                      1)]
        {:prev-sym cur-sym
         :max-power (max max-power next-cur-power)
         :cur-power next-cur-power}))
    {:prev-sym nil
     :max-power 0
     :cur-power 0}
    s)))
