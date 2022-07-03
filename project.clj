(defproject restful-crud "0.1.0-SNAPSHOT"
  :description "simple restful crud backend on clj & pgsql"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 ; Web
                 [prismatic/schema "1.3.0"]
                 [metosin/compojure-api "2.0.0-alpha31"]
                 [ring/ring-jetty-adapter "1.9.5"]

                 ; Database
                 [toucan "1.18.0"]
                 [org.postgresql/postgresql "42.4.0"]


                 ; Password Hashing
                 [buddy/buddy-hashers "1.8.158"]]
  :main ^:skip-aot restful-crud.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
