#!/bin/bash

kafka-topics.sh --create \
  --zookeeper localhost:2181 \
  --replication-factor 2 --partitions 1 \
  --topic bitcoin-transaction
