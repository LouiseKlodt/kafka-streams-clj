# kafka-streams-clj

Kafka Streams Examples in Clojure using Java Interop and Docker.

## Installation

Clone this repo. You need Docker and Leiningen installed.

## Usage

    $ java -jar kafka-streams-clj-0.1.0-standalone.jar [args]


## Example Usage Flow

1. Start the Kafka and Zookeper containers via Docker: `$ docker-compose up`
2. Create the two topics required for the example streams application - a simple topology which copies any messages sent to `topic-a`  to `topic-b`. Run: `$ docker exec broker kafka-topics --create --topic topic-a --bootstrap-server localhost:9092`. 
3. Once the topics are created, you can start the kafka streams app by running `lein run` from the terminal.
4. Produce some messages to `topic-a` (see below broker commands)
5. Check messages are copied to `topic-b` (see below broker commands)

To run the `broker` commands inside the container, run: `$ docker exec -it broker bash` and execute below commands from within the container.

Create topics:
```sh
kafka-topics --create --topic topic-a --bootstrap-server localhost:9092
kafka-topics --create --topic topic-b --bootstrap-server localhost:9092
```

List topics:
```sh
kafka-topics --list --bootstrap-server localhost:9092
```
Consume from topic:
```sh
kafka-console-consumer --topic topic-b --from-beginning --bootstrap-server localhost:9092
```
Produce to topic:
```sh
kafka-console-producer --topic topic-a --bootstrap-server localhost:9092
```

Any message from topic-a should appear as a copy in topic-b.
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
