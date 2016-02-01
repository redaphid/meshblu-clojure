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

(defn register [& {data :data metadata :metadata}]
  (:body (http/post "https://meshblu.octoblu.com/devices"
    {:content-type :json :form-params data :as :json}))
)
;(:test (register :data {:test true}))
