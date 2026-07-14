(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest london-has-spec-basis
  (let [sb (facts/spec-basis "london")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://www.legislation.gov.uk/") sb))
    (is (every? #(= :local-act (:ordinance/kind %)) sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "manchester")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["london" "manchester"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["manchester"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["london.local-authorities-act-2012"]
         (mapv :ordinance/id (facts/by-topic "london" :street-trading))))
  (is (empty? (facts/by-topic "london" :labor)))
  (is (empty? (facts/by-topic "manchester" :licensing))))
