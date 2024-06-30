(ns ^{:doc "left join topology"}
  kafka-streams-clj.left-join
  (:gen-class)
  (:import
    (java.time Duration)
    (org.apache.kafka.streams StreamsBuilder)
    (org.apache.kafka.streams.kstream JoinWindows KStream ValueJoiner)))

(def time-difference-s 20)

(def value-joiner
  (reify ValueJoiner
    (apply [_ left-val right-val]
      (println "joining left value and right value")
      (str "left value: " left-val " right value: " right-val))))

(def join-window
  (JoinWindows/ofTimeDifferenceWithNoGrace (Duration/ofSeconds time-difference-s)))

(def topology
  (let [builder (new StreamsBuilder)
        left ^KStream (.stream builder "topic-a")
        right ^KStream (.stream builder "topic-b")
        joined (.leftJoin left right ^ValueJoiner value-joiner ^JoinWindows join-window)
        _ (.to joined "output-topic")]
    builder))
