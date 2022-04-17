(ns clojure-simples.valid-sudoku
  "https://leetcode.com/problems/valid-sudoku/")

(defn- seq-no-dupes?
  [row]
  (boolean
   (reduce
    (fn [prev-digits digit]
      (cond
        (= digit ".") prev-digits
        (contains? prev-digits digit) (reduced false)
        :else (conj prev-digits digit)))
    #{}
    row)))

(defn- cols-from-sudoku
  [sudoku]
  (for [i (range 9)]
    (for [j (range 9)]
      (get-in sudoku [j i]))))

(defn- squares-from-sudoku
  [sudoku]
  (for [start-i (range 0 9 3)
        start-j (range 0 9 3)]
    (for [i (range 3)
          j (range 3)]
      (get-in sudoku [(+ start-i i)
                      (+ start-j j)]))))

(defn valid-sudoku?
  [sudoku]
  (and
   (every? seq-no-dupes? sudoku)
   (every? seq-no-dupes? (cols-from-sudoku sudoku))
   (every? seq-no-dupes? (squares-from-sudoku sudoku))))
