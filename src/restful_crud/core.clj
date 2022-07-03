(ns restful-crud.core
  (:require [toucan.db :as db]
            [toucan.models :as models]
            [ring.adapter.jetty :refer [run-jetty]]
            [compojure.api.sweet :refer [routes]]
            [restful-crud.user :refer [user-routes]]))

(def db-spec
  {:classname   "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname     "//localhost:5434/restful-crud"
   :user        "postgres"
   :password    "postgres"}
  ;; [:dbtype "postgres"
      ;; :dbname "localhost:5434/restful-crud"
      ;; :user "postgres"
      ;; :password "postgres"]
  )

(def app (apply routes user-routes))

(defn -main
  [& args]
  (db/set-default-db-connection! db-spec)
  (models/set-root-namespace! 'restful-crud.models)
  (run-jetty app {:port 3000}))
