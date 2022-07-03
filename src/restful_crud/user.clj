(ns restful-crud.user
  (:require [schema.core :as s]
            [restful-crud.string-util :as str]))

(defn valid-username? [name]
  (str/non-blank-with-max-length? 50 name))

(defn valid-password? [password]
  (str/length-in-range? 5 50 password))

(s/defschema UserRequestSchema
             {:username (s/constrained s/Str valid-username?)
              :password (s/constrained s/Str valid-password?)
              :email (s/constrained s/Str str/email?)})