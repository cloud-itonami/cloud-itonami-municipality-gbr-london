(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest london-has-culture-basis
  (let [sb (facts/spec-basis "london")]
    (is (= 8 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "london" (:culture/municipality %)) sb))
    (is (every? #(= "GBR" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "manchester")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["london" "manchester"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["manchester"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "london" :dish))))
  (is (= ["london.beverage.porter"]
         (mapv :culture/id (facts/by-kind "london" :beverage))))
  (is (= 1 (count (facts/by-kind "london" :craft))))
  (is (empty? (facts/by-kind "manchester" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
