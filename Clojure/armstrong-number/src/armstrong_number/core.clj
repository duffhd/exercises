(ns armstrong-number.core)

(defn power
  [power number]
  (reduce * (repeat power number)))

(defn armstrong-number?
  "Given a number, use the length in characters to power each number.
  If the operation is the same as the number then it's an armstrong
  number."
  [armstrong-number]
  (let
    [length (count armstrong-number)
     input-int (Integer/parseInt armstrong-number)
     int-list (map #(Integer/parseInt %) (clojure.string/split armstrong-number #""))
     power-list (map (partial power length) int-list)
     final-number (reduce + power-list)]
    (if (= final-number input-int)
      (str input-int " is an armstrong number!")
      (str input-int " is not an armstrong number"))))

(defn -main
  "Receive a possible armstrong number"
  []
  (println "Insert a number to check if it's an armstrong number.")
  (println (armstrong-number? (read-line))))