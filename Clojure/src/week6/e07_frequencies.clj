(ns week6.e07-frequencies
  (:require [clojure.string :as str]))

;; a) frequencies of the letters a-z, upper and lower case combined, other characters ignored
;;    same pattern as to-counts in exercise 5: count once with frequencies,
;;    then look up every letter a-z in alphabetical order, missing letters get 0

(def alphabet (map char (range (int \a) (inc (int \z)))))

(defn letter-frequencies [input]
  (let [freqs (frequencies (str/lower-case input))]
    (map #(get freqs % 0) alphabet)))

(letter-frequencies "aBBcCc")
;; == [1 2 3 0 0 0 ... 0]   (26 values)
(letter-frequencies "abBcCDDdd")
;; == [1 2 2 4 0 0 ... 0]
(letter-frequencies "Hello, World! 123")
;; == spaces, punctuation and digits are ignored


;; b) cosine similarity = (a · b) / (|a| * |b|)
;;    a · b = dot product: multiply element by element, then sum up
;;    |a|   = magnitude (length) of a: square root of the sum of the squares

(defn dot-product [a b]
  (reduce + (map * a b)))                                   ;; map with two sequences: (* a1 b1) (* a2 b2) ...

(defn magnitude [v]
  (Math/sqrt (reduce + (map #(* % %) v))))

(defn cosine-similarity [a b]
  (let [mag-a (magnitude a)
        mag-b (magnitude b)]
    (if (or (zero? mag-a) (zero? mag-b))                    ;; avoid division by 0 for a vector of only zeros
      0.0
      (/ (dot-product a b) (* mag-a mag-b)))))

(cosine-similarity [1 2 3 4] [4 3 2 1])
;; == 0.666...
(cosine-similarity [1 2 3 4] [1 2 3 4])
;; == 1.0
(cosine-similarity [0 1 0 0] [1 0 0 0])
;; == 0.0

;; c)

(def de [6.51 1.89 3.06 5.08 17.40 1.66 3.01 4.76 7.55
         0.27 1.21 3.44 2.53 9.78 2.51 0.79 0.02 7.00
         7.27 6.15 4.35 0.67 1.89 0.03 0.04 1.13])
(def en [8.17 1.48 2.78 4.25 12.70 2.23 2.02 6.09 6.97
         0.15 0.77 4.03 2.41 6.75 7.51 1.93 0.10 5.99
         6.33 9.06 2.76 0.98 2.36 0.15 1.97 0.07])
(def fr [7.64 0.90 3.26 3.67 14.00 1.07 0.87 0.74 7.53
         0.55 0.05 5.46 2.97 7.10 5.38 3.02 1.36 6.55
         7.95 7.24 6.31 1.63 0.11 0.39 0.31 0.14])

(def languages [["de" de] ["en" en] ["fr" fr]])

(def text-de "Künstliche Intelligenz verändert rasant die Art und Weise, wie wir leben, arbeiten und miteinander kommunizieren. Von der medizinischen Diagnostik bis hin zu automatisierten Finanzsystemen verarbeiten Algorithmen des maschinellen Lernens riesige Datenmengen, um Muster aufzudecken, die dem Menschen entgehen könnten. Während diese technologische Entwicklung beispiellose Chancen für Effizienz und Innovation bietet, wirft sie auch kritische Fragen zum Datenschutz, zu algorithmischen Vorurteilen und zur Zukunft der Beschäftigung auf. Während die Gesellschaft diesen digitalen Wandel bewältigt, wird die Schaffung solider ethischer Rahmenbedingungen und internationaler Vorschriften von entscheidender Bedeutung sein, um sicherzustellen, dass die Technologie dem Allgemeinwohl dient und systemische Risiken minimiert.")
(def text-fr "L'intelligence artificielle transforme rapidement notre façon de vivre, de travailler et de communiquer les uns avec les autres. Des diagnostics médicaux aux systèmes financiers automatisés, les algorithmes d'apprentissage automatique traitent de vastes volumes de données pour découvrir des modèles que les humains pourraient ignorer. Bien que cette évolution technologique offre des opportunités sans précédent en matière d'efficacité et d'innovation, elle soulève également des questions cruciales sur la confidentialité des données, les biais algorithmiques et l'avenir de l'emploi. Alors que la société navigue dans cette transition numérique, l'établissement de cadres éthiques solides et de réglementations internationales sera essentiel pour garantir que la technologie serve le bien commun et minimise les risques systémiques.")
(def text-en "Artificial intelligence is rapidly transforming the way we live, work, and communicate with one another. From healthcare diagnostics to automated financial systems, machine learning algorithms process vast amounts of data to uncover patterns that humans might overlook. While this technological evolution offers unprecedented opportunities for efficiency and innovation, it also raises critical questions about data privacy, algorithmic bias, and the future of employment. As society navigates this digital transition, establishing robust ethical frameworks and international regulations will be essential to ensure that technology serves the common good and minimizes systemic risks.")

;; languages holds pairs [name frequencies], so the name stays attached to its vector
;; max-key returns the pair with the highest score (not the score itself), first takes the name out of it
(defn find-language [input]
  (let [input-freqs (letter-frequencies input)]             ;; compute once, not once per language
    (first (apply max-key
                  #(cosine-similarity input-freqs (second %)) ;; "second" -> use only value of key value language pair
                  languages))))                             ;; apply unpacks the pairs into separate arguments

(find-language text-de)
;; == "de"
(find-language text-en)
;; == "en"
(find-language text-fr)
;; == "fr"
