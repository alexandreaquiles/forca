(ns forca.aula)

(+ 1 2)
(* 5 4)
(/ 6 2)

(def idade 29)
(+ idade 3)

(+ 10 2)

(* 7 6)

(/ 6 3)

(+ 2 (+ 5 5))

(+ 4 (+  1 2) )

(- (+ (+ 1 20) 4) 7)

(+ (* 5 (/ 10 2) ) 1)

(defn mult2 [x] (* x 2))

(mult2 1)

(mult2 -1)

(mult2 -8)

(mult2 7)

(defn mult-square [x] (* x (+ 2 x)))

(mult-square 1)

(mult-square 2)

(defn pow3 [x] (* x (Math/pow 2 x)))

(pow3 1)

(pow3 2)

(pow3 3)

(= 10 6)

(= 20 20)

(= 15 15)

(not= 10 10)

(not= 10 20)

;(def total-de-vidas 6)
;(defn perdeu [] (println "Você perdeu..."))
;(defn jogo [vidas]
;  (println "Vidas" vidas)
;  (if (= vidas 0)
;    (perdeu)
;    (jogo (dec vidas))))
;(jogo total-de-vidas)

(defn fib [n]
  (if (<= n 1)
    n
    (+ (fib (- n 1)) (fib (- n 2)))))
(map fib (range 10))

(def numeros [1 2 3 4 5])
(def carros [50000.0 60000.0])

(remove (fn [n] (not= (rem n 2) 0)) numeros)

(map #(* % 3) numeros)

;(def total-de-vidas 6)
;(defn perdeu [] (println "Você perdeu..."))
;(defn letras-faltantes [palavra acertos]
;  (remove (fn [letra] (contains? acertos (str letra))) palavra))
;(defn acertou-a-palavra-toda? [palavra acertos]
;  (empty? (letras-faltantes palavra acertos)))
;(defn jogo [vidas palavra acertos]
;  (if (= vidas 0)
;    (perdeu)
;    (if (acertou-a-palavra-toda? palavra acertos)
;      (ganhou)
;      (println "Chuta, amigo!"))))

(filter #(or (< % 2) (> % 4) ) numeros)

(def palavra #{"A" "L" "U" "R"})
(contains? palavra "A")
(contains? palavra "O")

(defn le-letra! [] (read-line))

(* 7 (Integer/parseInt (le-letra!)))

(defn fib[x]
  (loop [a 1 b 1 numero 2]
    (if (= numero x)
      b
      (recur b (+ a b) (inc numero)))))

(map fib (range 2 10))
; => (1 2 3 5 8 13 21 34)
; o do exercício da aula não funciona com 0 e 1

(defn fib*[x]
  (loop [a 0 b 1 numero x]
    (if (= numero 0)
      a
      (recur b (+ a b) (dec numero)))))

(map fib* (range 10))
; => (0 1 1 2 3 5 8 13 21 34)
; esse funciona com 0 e 1

;(def total-de-vidas 6)
;(defn perdeu [] (println "Você perdeu..."))
;(defn letras-faltantes [palavra acertos]
;  (remove (fn [letra] (contains? acertos (str letra))) palavra))
;(defn acertou-a-palavra-toda? [palavra acertos]
;  (empty? (letras-faltantes palavra acertos)))
;(defn le-letra! [] (read-line))
;(defn acertou? [chute palavra] (.contains palavra chute))
;(defn jogo [vidas palavra acertos]
;  (cond
;    (= vidas 0) (perdeu)
;    (acertou-a-palavra-toda? palavra acertos) (ganhou)
;    :else
;    (let [chute (le-letra!)]
;      (if (acertou? chute palavra)
;        (do
;          (println "Acertou a letra!")
;          (recur vidas palavra (conj acertos chute)))
;        (do
;          (println "Errou a letra! Perdeu vida!")
;          (recur (dec vidas) palavra acertos))))))

(defn soma [n]
  (loop [contador 1 soma 0]
    (if (> contador n)
      soma
      (recur (inc contador) (+ contador soma)))))

(soma 5)
; => 15

(take 7 (map #(* % %) (range)) )

(def total-de-vidas 6)
(defn perdeu [] (println "Você perdeu..."))
(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra))
(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-faltantes palavra acertos)))
(defn le-letra! [] (read-line))
(defn acertou? [chute palavra] (.contains palavra chute))
(defn imprime-forca [vidas palavra acertos]
  (println "Vidas " vidas)
  (doseq [letra (seq palavra)]
    (if (contains? acertos (str letra))
      (print letra " ") (print "_" " ")))
  (println))
(defn jogo [vidas palavra acertos]
  (imprime-forca vidas palavra acertos)
  (cond
    (= vidas 0) (perdeu)
    (acertou-a-palavra-toda? palavra acertos) (ganhou)
    :else
    (let [chute (le-letra!)]
      (if (acertou? chute palavra)
        (do
          (println "Acertou a letra!")
          (recur vidas palavra (conj acertos chute)))
        (do
          (println "Errou a letra! Perdeu vida!")
          (recur (dec vidas) palavra acertos))))))

(def carros [50000.0, 60000.0])

(map #(* % 2) carros)
;=> (100000.0 120000.0)

(map #(- % 200.0) (map #(* % 2) carros))
;=> (99800.0 119800.0)

(->> carros
     (map #(* % 2))
     (map #(- % 200.0)))
;=> (99800.0 119800.0)

(def carros2 [50000.0, 60000.0, 70000.0])
(reduce + carros2)

(->> carros
     (map #(* % 2))
     (map #(* % 3))
     (reduce +))