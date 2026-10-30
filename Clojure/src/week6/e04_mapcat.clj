(ns week6.e04-mapcat)

(def repeat-twice #(repeat 2 %))

(map repeat-twice [1 2 3])

(mapcat repeat-twice [1 2 3])

(defn my-mapcat [f coll] (apply concat (map f coll)))

(my-mapcat repeat-twice [1 2 3])

(mapcat #(remove even? %) [[1 2] [2 2] [2 3]])

(defn my-filter [filter coll] (mapcat #(if (filter %) [%] []) coll))

(my-filter #(even? %) [1 2 3 4 5 6])