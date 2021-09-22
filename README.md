# Overview
Application compute top 10 bitcoin transactions based on `price` field (descending) and print them to std out
- maintain a collection of top 10 transactions from the beginning
- after each consumer poll update this collection
- after the update, print collection to the std out.


# Create topic
`./init-topic.sh`

# Build
`mvn package`

# Run

```
export KAFKA_BOOTSTRAPADDRESS=localhost:29092
export MESSAGE_TOPIC_NAME=bitcoin-transaction

java -jar kafka-nifi-0.0.1-SNAPSHOT.jar
```

# Delivery strategy
Starting with version 2.3, the Spring framework sets enable.auto.commit to false unless explicitly set in the configuration.

