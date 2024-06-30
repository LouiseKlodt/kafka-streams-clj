(ns kafka-streams-clj.config
  (:import
    (java.util Properties)
    (org.apache.kafka.common.serialization Serdes)
    (org.apache.kafka.streams StreamsConfig)))

(def streams-config
  (doto
    (new Properties)
    (.put StreamsConfig/APPLICATION_ID_CONFIG "example-app-id")
    (.put StreamsConfig/BOOTSTRAP_SERVERS_CONFIG "localhost:9092")
    (.put StreamsConfig/DEFAULT_KEY_SERDE_CLASS_CONFIG (.getName (.getClass (Serdes/String))))
    (.put StreamsConfig/DEFAULT_VALUE_SERDE_CLASS_CONFIG (.getName (.getClass (Serdes/String))))))
