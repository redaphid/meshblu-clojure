(ns meshblu-clojure.core
  (:require [clj-http.client :as http])
  (:gen-class)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn status [& {:keys [url metadata] :or {url "https://meshblu.octoblu.com"}}]
  (:meshblu (:body (http/get (str url "/status") {:as :json})))
)

(comment
  (status)
)


(defn register [&
  {:keys [url data metadata] :or {url "https://meshblu.octoblu.com"}}]
  (:body (http/post (str url "/devices")
    {:content-type :json :form-params data :as :json}))
)

(comment
  (:type (register :data {:type "clojure-test"}))
)
