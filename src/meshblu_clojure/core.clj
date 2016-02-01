(ns meshblu-clojure.core
  (:require [clj-http.client :as http])
  (:gen-class)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def meshblu-json {
  :url "https://meshblu.octoblu.com" :port 443
})


(defn status [& [options]]
  (let [{:keys [url]} (merge meshblu-json options)]
   (:meshblu (:body (http/get (str url "/status") {:as :json})))
  )
)

(defn register [[& options]]
  (let [{:keys [url data]} (merge meshblu-json options)]
    (:body (http/post (str url "/devices") {:content-type :json :form-params data :as :json}))
  )
)

(comment
  (:type (register {:data {:type "clojure-test"}}))
)

(defn get-device [
  {:keys [uuid token]} &
  {:keys [url metadata uuid] :or {url "https://meshblu.octoblu.com" uuid auth-uuid}}]
  {:body (http/get (str url "/devices/" ))}
)

(get-device)
