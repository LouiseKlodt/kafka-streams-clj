(ns kafka-streams-clj.core
  (:require
    [kafka-streams-clj.config :refer [streams-config]]
    [kafka-streams-clj.left-join :as left-join])
  (:import
    (org.apache.kafka.streams KafkaStreams))
  (:gen-class))

(defn streams [topology]
  (new KafkaStreams (.build topology) streams-config))

(defn -main [& args]
  (let [streams (streams left-join/topology)]
    (println "Starting Kafka Streams app")
    (.start streams)
    (.addShutdownHook (Runtime/getRuntime)
                      (Thread. (fn []
                                 (println "Closing Kafka Streams app")
                                 (.close streams))))
    (while true
      (println "still running...")
      (Thread/sleep 5000))))
