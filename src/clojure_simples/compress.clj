(ns clojure-simples.compress
  "Not from leetcode. No tests intentional")

(defn compress
  [inp]
  (:res (reduce
         (fn [acc cur_sym]
           (cond
             (nil? (:last acc)) (assoc acc
                                       :count 1
                                       :last cur_sym)
             (= (:last acc) cur_sym) (update acc :count inc)
             :else (assoc acc
                          :res (str (:res acc) (:last acc) (when (> (:count acc) 1) (:count acc)))
                          :last cur_sym
                          :count 1)))
         {:res "" :count 1 :last (first inp)}
         (conj (vec inp) nil))))
