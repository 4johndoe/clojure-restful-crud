(ns restful-crud.core
  (:require [toucan.db :as db]
            [toucan.models :as models])
  (:gen-class))

(def db-spec
  [:dbtype "postgres"
   :dbname "restful-crud"
   :user "postgres"
   :password "postgres"])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
