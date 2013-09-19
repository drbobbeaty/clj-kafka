(defproject clj-kafka/clj-kafka "0.0.8-0.7"
  :description "Clojure wrapper for Kafka's Java API"
  :url "https://github.com/drbobbeaty/clj-kafka"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojars.paul/core-kafka_2.8.0 "0.7.0-1"
                  :exclusions
                  [javax.mail/mail
                   javax.jms/jms
                   com.sun.jdmk/jmxtools
                   com.sun.jmx/jmxri
                   jline/jline
                   net.sf.jopt-simple/jopt-simple
                   junit/junit]]
                 [org.scala-lang/scala-library "2.8.0"]
                 [zookeeper-clj "0.9.2"]]
  :repositories [["internal" "http://nexus-app1-dev.snc1/content/groups/public"]
                 ["releases" {:url "http://nexus-app1-dev.snc1/content/repositories/releases/"
                              :sign-releases false}]])
