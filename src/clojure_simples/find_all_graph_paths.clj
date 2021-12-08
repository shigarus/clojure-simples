(ns clojure-simples.find-all-graph-paths
  "https://leetcode.com/problems/all-paths-from-source-to-target/")

(defn to-flat [arr]
  (reduce
   #(if (vector? (get %2 0)) (into %1 %2) (conj %1 %2))
   []
   arr))

(defn find-all-paths
  ([graph]
   (->
    (map #(find-all-paths graph % [0]) (get graph 0))
    to-flat))
  ([graph cur-pos prev-path]
   (let [cur-path (conj prev-path cur-pos)
         cur-cell (get graph cur-pos)]
     (if (empty? cur-cell)
       cur-path
       (-> (map #(find-all-paths graph % cur-path)
                cur-cell)
           to-flat)
       ))))


(comment 
  (to-flat [[1 2 3] [[1 2] [1 2]]])
  (find-all-paths [[4 3 1] [3 2 4] [3] [4] []]))