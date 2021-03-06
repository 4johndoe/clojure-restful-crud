(ns restful-crud.core
  (:require [toucan.db :as db]
            [toucan.models :as models]
            [ring.adapter.jetty :refer [run-jetty]]
            [compojure.api.sweet :refer [api routes]]
            [restful-crud.user :refer [user-entity-route]]
            [restful-crud.book :refer [book-entity-route]]))

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

(def swagger-config
  {:ui "/swagger"
   :spec "/swagger.json"
   :options {:ui {:validatorUrl nil}
             :data {:info {:version "1.0.0", :title "Restful CRUD API"}}}})

;; (def app (api {:swagger swagger-config} 
;;               (apply routes (concat user-routes book-routes))))

(def app (api {:swagger swagger-config}
              (apply routes (concat book-entity-route user-entity-route))))

(defn -main
  [& args]
  (db/set-default-db-connection! db-spec)
  (models/set-root-namespace! 'restful-crud.models)
  (run-jetty app {:port 3000})) 
