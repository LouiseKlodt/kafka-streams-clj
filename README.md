# kafka-streams-clj

Kafka Streams Examples in Clojure using Java Interop and Docker.

## Installation

Clone this repo. You need Docker and Leiningen installed.

## Usage

    $ java -jar kafka-streams-clj-0.1.0-standalone.jar [args]


## Example Usage Flow

1. Start the Kafka and Zookeper containers via Docker: `$ docker-compose up`
2. Create the topics required for the example streams application, a simple topology which performs a left join on `topic-a` with `topic-b` and writes the joined result to `output-topic`. Run: `$ docker exec broker kafka-topics --create --topic <topic-name> --bootstrap-server localhost:9092` for the 3 topics mentioned above.
3. Once the topics are created, you can start the kafka streams app: `$ lein run`.
4. Produce some messages to `topic-a` and `topic-b` using the same record key, as this is what will be joined on (see below producer command)
5. Check messages are joined and written to `output-topic` (see below consumer command)

To run the `broker` commands inside the container, run: `$ docker exec -it broker bash` and execute below commands from within the container.

Create topics:
```sh
kafka-topics --create --topic <topic-name> --bootstrap-server localhost:9092
```

List topics:
```sh
kafka-topics --list --bootstrap-server localhost:9092
```
Consume from topic:
```sh
kafka-console-consumer --topic <topic-name> --from-beginning --bootstrap-server localhost:9092 --property print.key=true --property "key.separator=:"
```
Produce to topic:
```sh
kafka-console-producer --topic <topic-name> --bootstrap-server localhost:9092 --property "parse.key=true" --property "key.separator=:"
```

## License

Copyright © 2024 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
