(ns my-app.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (reduce str '() "2"))
  (println "Hell, World!"))


; Data Structures

;; a vector
[1 2 3]   
;; another vectoer
[1 :two "three"] 
;; a hashmap with keywords as keys
{:a 1 :b 2}
;; a hashmap with integers as keys
{1 "one" 3 4 "five" 6}
;; an unordered set
#{1 2 3 :a}
;; a linked list
'("1" 2 3)

; Checking Data types

(def myvar "var")
myvar
(type myvar)

; Quoting
(+ 1 2 3)
'(+ 1 2 3)

; Let bindings
(let [width     10
      height    20
      thickness 2]
  (* width height thickness))

; Importing and Aliasing
(require '[clojure.repl :as repl])
(repl/doc print)

; Functions for Creating Data Structures
(list + 1 2 3)
(vector 1 2 3)
(hash-map 1 2 3 4)
(hash-set 1 2 3 4)
(set '(1 2 3 4))
(vec '(1 2 3 4))
(zipmap '(1 2 3 4) ["one" "two" "3"])
(apply hash-map '(1 2 3 4))

; Functions for Vectors
(def v [:a :b :c])
(v 0)
(nth v 0)
(first v)
(rest v)
(last v)
(next v)

; Functions for Lists
(let [l '(:a :b :c)]
  [
   ;; (l 0) error
   (nth l 2)
   (first l)
   (rest l)
   (last l)
   (next l)
   ])

; Functions for Maps and Sets
(let [m {:a 1 :b 2} s #{:a :b :c}]
  [
   (m :a)
   (:a m)
   (s :a)
   (:a s)
   ]
  )

; Collections Are Immutable
(let [m {:a 1
         :b 2}
      s #{:a :b}]
  [
   (conj s :c 3)
   (disj s :a)
   (assoc m :c 3)
   s
   m
   ]
  )

; Control Structures
(if :t :a :b)
(if (seq []) :a :b)
(if (seq nil) :a :b)
(if (empty? []) :a :b)
(if (empty? nil) :a :b)
(if (= "a" "a") "yes" "no")

; Define Functions
(defn my-func
  [a b & others]
  (print (type others))
  (+ a b (reduce + others)))
(my-func 1 2 3 4)

; Declare Before Usage
(declare do-it)
(defn do-it-twice []  (do-it) (do-it))
(defn do-it [] (println "do-it"))
(do-it-twice)
; Do and Side Effects
(do
  (println "side effects!")
  (+ 1 2))
(doseq [i ["a" "b" "c"]] (println i))  
(dotimes [i 10] (print i))

; Destructuring
(def concert  {:band "bbb" :location "lll" :time "ttt"})
(let [{:keys [band location]} concert]
  (println band)
  (println location)
  )

; TODO: Laziness

(println "end of file")


; Java/Scala interlop
(.toUpperCase "hh")
(java.lang.Math/abs 1)
(. "hh" toUpperCase)

(let [stack (java.util.Stack.)]
  (.push stack "Latest episode of Game of Thrones, ho!")
  (.push stack 2222)
  (.pop stack))


(let [os os.package$/MODULE$]
[
 (type os)
 (str (.home os))
 (str (.pwd os))
 ]
)
;; (type os.package$)
;; (type os.package$/MODULE$)
;; (type (.pwd os.package$/MODULE$))
;; (str (.pwd os.package$/MODULE$))
