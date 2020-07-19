(ns forca.core)

(def total-de-vidas 6)
(def palavra-secreta "MELANCIA")

(defn perdeu [] (print "Você perdeu"))
(defn ganhou [] (print "Você ganhou!"))

(defn ja-tem-letra? [acertos letra]
  (contains? acertos (str letra)))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (ja-tem-letra? acertos letra)) palavra))

(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-faltantes palavra acertos)))

(defn le-letra! [] (read-line))

(defn acertou? [chute palavra] (.contains palavra chute))

(defn imprime-forca [vidas palavra acertos]
  (println "Vidas" vidas)
  (println (reduce str (map (fn [letra] (if (ja-tem-letra? acertos letra)
                                          (str letra " ")
                                          (str "_" " "))) palavra)))
  (println))

(defn jogo [vidas palavra acertos]
  (imprime-forca vidas palavra acertos)
  (cond (= vidas 0) (perdeu)
        (acertou-a-palavra-toda? palavra acertos) (ganhou)
        :else (let [chute (le-letra!)]
                (if (acertou? chute palavra)
                  (do
                    (println "Acertou a letra!")
                    (recur vidas palavra (conj acertos chute)))
                  (do
                    (println "Errou a letra! Perdeu a vida!")
                    (recur (dec vidas) palavra acertos))))))

(defn comeca-o-jogo []
  (jogo total-de-vidas palavra-secreta #{}))