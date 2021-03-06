(ns menu-calculator.core-test
  (:require [clojure.test :refer :all]
            [menu-calculator.core :refer :all]
            [menu-calculator.menu :refer :all]))

(deftest menu-loading
  (testing "loads menu from csv"
    (is (string? (load-menu "resources/menu.txt"))))

  (testing "generates target price"
    (is (= (target-price) 15.05)))

  (testing "menu has items and prices as k/v pairs"
    (is (=  ["mixed fruit" "$2.15"] (first (menu-map)))))

  (testing "final menu has k/v pairs with prices as floats"
    (is (= ["mixed fruit" 2.15] (first (menu))))))

(deftest currency-manipulation
  (testing "strips dollar signs from price"
    (is (= 12.05 (strip-currency-symbols "$12.05"))))

  (testing "strips euro symbol from price"
    (is (= 13.49 (strip-currency-symbols "13.49€")))))

(deftest combo-generation
  (testing "combo names returns the hash"
    (is (= (combo-names) {"mixed fruit" 1, "hot wings" 2, "sampler plate" 1}))))
