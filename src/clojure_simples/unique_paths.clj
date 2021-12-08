(ns clojure-simples.unique-paths
  "https://leetcode.com/problems/unique-paths/")

(defn go-recur
  [m n]
  (+ (if (= m n 1) 1 0)
     (if (> m 1) (go-recur (- m 1) n) 0)
     (if (> n 1) (go-recur m (- n 1)) 0)))

(defn next-steps-from-cords 
  [m n]
  (cond 
    (= 1 m n) []
    (= 1 n) [[(- m 1) n]]
    (= 1 m) [[m (- n 1)]]
    :else [[m (- n 1)] [(- m 1) n]]))
  
(defn next-steps-from-steps
    [steps]
    (reduce
     (fn [new-steps [m n]]
       (into
        new-steps
        (next-steps-from-cords m n)))   
     []
     steps))

(defn go-wide
  [m n]
  (loop [going-to [[m n]]]
    (if (some #(= % [1 1]) going-to)
      (count going-to)
      (recur (next-steps-from-steps going-to)))))

(defn go-deep
  [m n]
  (loop [going-to (conj clojure.lang.PersistentQueue/EMPTY
                        [m n])
         paths-found 0]
    (if (empty? going-to)
      paths-found
      (let [[cur_m cur_n] (first going-to)]
       (recur
        (pop (into going-to (next-steps-from-cords cur_m cur_n)))
        (+ paths-found (if (= 1 cur_m cur_n) 1 0)))))))
