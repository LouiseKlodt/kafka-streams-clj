# kafka-streams-clj

Kafka Streams Examples in Clojure using Java Interop and Docker.

## Installation

Clone this repo. You need Docker and Leiningen installed.

## Usage

    $ java -jar kafka-streams-clj-0.1.0-standalone.jar [args]


## Examples

### Docker

To start the Kafka and Zookeper containers, run: `$ docker-compose up`

To create the topics, run: `$ docker exec broker kafka-topics --create --topic topic-a --bootstrap-server localhost:9092`

Or run the commands inside the container, run: `$ docker exec -it broker bash`

Commands:

List topics:
```sh
kafka-topics --list --bootstrap-server localhost:9092
```
Consume from topic:
```sh
kafka-console-consumer --topic topic-a --from-beginning --bootstrap-server localhost:9092
```
Produce to topic:
```sh
kafka-console-producer --topic topic-a --bootstrap-server localhost:9092
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
