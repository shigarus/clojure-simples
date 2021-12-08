(ns clojure-simples.core-test
  (:require [clojure.test :refer [is deftest]]
            [clojure-simples.core :refer [-main]]))

(deftest main
  (is (= "Hello, World!" (-main))))
