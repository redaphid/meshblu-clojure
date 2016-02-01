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

(defn status [ & [options]]
  "get the current status of meshblu"
  (let [{:keys [url data]} (merge meshblu-json options)]
   (:meshblu (:body (http/get (str url "/status") {:as :json})))
  )
)

(comment
  (status)
)

(defn register [& [options]]
  "register a device with meshblu"
  (let [{:keys [url data]} (merge meshblu-json options)]
    (:body (http/post (str url "/devices") {:content-type :json :form-params data :as :json}))
  )
)

(comment
  (:uuid (register {:data {:type "clojure-test"}}))
)

(defn get-device [& [options]]
  (let [{:keys [url uuid auth metadata]} (merge meshblu-json options)]
    (:body
      (http/get (str url "/v2/devices/" uuid)
      {:basic-auth (str (:uuid auth) ":" (:token auth)) :as :json})
    )
  )
)

(comment
  (get-device {
    :uuid "10fc2b3a-4e6d-4dda-8d4f-270a2305fb35"
    :auth {
      :uuid "10fc2b3a-4e6d-4dda-8d4f-270a2305fb35"
      :token "dd211078aed58c5f8daffb3bbdbc783cdd4ac953"
    }
  })
)
