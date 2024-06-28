(ns kafka-streams-clj.core
  (:gen-class)
  (:import
    (java.util Properties)
    (org.apache.kafka.common.serialization Serdes)
    (org.apache.kafka.streams KafkaStreams StreamsBuilder StreamsConfig)))

(defn streams-config []
  (doto
    (new Properties)
    (.put StreamsConfig/APPLICATION_ID_CONFIG "example-app-id")
    (.put StreamsConfig/BOOTSTRAP_SERVERS_CONFIG "localhost:9092")
    (.put StreamsConfig/DEFAULT_KEY_SERDE_CLASS_CONFIG (.getClass (Serdes/String)))
    (.put StreamsConfig/DEFAULT_VALUE_SERDE_CLASS_CONFIG (.getClass (Serdes/String)))))


(def topology
  (let [builder (new StreamsBuilder)
        stream-a (.stream builder "topic-a")
        stream-b (.stream builder "topic-b")]
    builder))

(def streams
  (new KafkaStreams (.build topology) (streams-config)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(comment

  (.start streams)
  (.close streams)




  42)