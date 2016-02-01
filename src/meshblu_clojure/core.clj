(ns meshblu-clojure.core
  (:require [clj-http.client :as http])
  (:gen-class)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn status []
  (:meshblu (:body (http/get "https://meshblu.octoblu.com/status" {:as :json})))
)
;(status)
(defn register )
