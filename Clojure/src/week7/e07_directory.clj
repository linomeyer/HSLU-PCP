(ns week7.e07-directory)

(def my-phone-dir
  (atom
    [{:name "Anna" :phone 1234}
     {:name "Ben" :phone 5678}]))

;; a) Warum widerspricht diese Interaktion dem funktionalen Grundsatz?
;; Bisher galt: Funktionen sind pur, d.h. gleiche Argumente liefern immer das gleiche
;; Resultat und es gibt keine Seiteneffekte (referenzielle Transparenz).
;; Daten sind immutable.
;; Hier liefert (look-at my-phone-dir "Alex") zuerst nil und nach add-entry 2468, obwohl
;; der Aufruf exakt gleich ist. Das Resultat hängt also nicht nur von den Argumenten ab,
;; sondern vom aktuellen Zustand des Atoms.
;; add-entry gibt nil zurück und wird nur wegen seines Seiteneffekts aufgerufen: es verändert
;; den globalen, veränderlichen Zustand (my-phone-dir), statt eine neue Datenstruktur zurückzugeben.

;; b) Nummer anhand des Vornamens suchen
(defn look-at [dir name]
  (:phone (first (filter #(= (:name %) name) @dir))))       ; @dir liest den aktuellen Wert des Atoms

;; c) neue Person hinzufügen
(defn add-entry [dir name phone]
  (swap! dir conj {:name name :phone phone})                ; ersetzt den Wert des Atoms durch neuen Vektor mit neuem Eintrag am Ende
  nil)

(look-at my-phone-dir "Anna")                               ; 1234
(look-at my-phone-dir "Ben")                                ; 5678
(look-at my-phone-dir "Alex")                               ; nil
(add-entry my-phone-dir "Alex" 2468)                        ; nil
(look-at my-phone-dir "Alex")                               ; 2468
