(ns neetcode-clojure.array-and-hashing.contains-duplicate)

;; https://leetcode.com/problems/contains-duplicate/

(def nums [1, 2, 3, 1])

(defn contains-duplicate? [nums]
  (loop [e (first nums)
         l (rest nums)]
    (if-let [next-e (first l)]
      (if (= next-e e)
        true
        (recur (first l) (rest l)))
      false)))

