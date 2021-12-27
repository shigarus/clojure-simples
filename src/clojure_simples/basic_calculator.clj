(ns clojure-simples.basic-calculator
  "https://leetcode.com/problems/basic-calculator-ii/")

(defn to-int [sym-or-str] (Integer. (str sym-or-str)))

(defn operate
  [sign i1 i2]
  (let [op (case sign
             "+" +
             "-" -
             "*" *
             "/" / )]
    (op (to-int i1) (to-int i2))))

(defn to-math-li
  [expr]
  (flatten
   (reduce
    (fn [[res collected-int] cur-sym]
      (cond
        (= cur-sym \space) [res
                            collected-int]
        (#{\/ \+ \- \*} cur-sym) [(into res [collected-int (str cur-sym)])
                                  ""]
        :else [res
               (str collected-int cur-sym)]))
    [[] ""]
    (seq expr))))

(defn muldiv-state
  [expr]
  (reduce
   (fn [acc cur]
     (let [sign (:sign acc)]
       (cond
         (#{"+" "-"} cur) {:last-int nil
                           :res (into (:res acc) [(:last-int acc) cur])
                           :sign nil}
         (#{"/" "*"} cur) (assoc acc :sign cur)
         (nil? sign) (assoc acc :last-int cur)
         :else (assoc acc
                      :sign nil
                      :last-int (operate
                                 sign
                                 (:last-int acc)
                                 cur)))))
   {:last-int (str 
               (first expr))
    :res []
    :sign nil}
   (rest expr)))

(defn muldiv
  [expr]
  (let [{:keys [last-int res]} (muldiv-state expr)]
    (conj res last-int)))

(defn plusminus
  [expr]
  (first
   (reduce
    (fn [[res sign] cur]
      (if (nil? sign)
        [res cur]
        [(operate sign res cur)
         nil]))
    [(first expr) nil]
    (rest expr))))

(defn do-math [expr]
  (-> (to-math-li expr)
      muldiv
      plusminus))
