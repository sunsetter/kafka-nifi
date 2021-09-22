package aorlov.kafkanifi.consumer;

import java.util.TreeSet;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import aorlov.kafkanifi.model.BitCoinTransaction;

@Component
public class BitCoinTransactionConsumer {
    public static final int ITEMS_MAX_LENGTH = 10;
    private TreeSet<BitCoinTransaction> topItems = new TreeSet<>();

    @KafkaListener(topics = "${message.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupFoo(BitCoinTransaction event) {
        System.out.println("Received new event: " + event);
        add(event);

        System.out.println("Top " + ITEMS_MAX_LENGTH + " list: ");
        topItems.forEach(System.out::println);
        System.out.println("\n\n");
    }

    public void add(BitCoinTransaction newItem) {
        if (topItems.size() < ITEMS_MAX_LENGTH) {
            topItems.add(newItem);
        } else {
            var first = topItems.first();
            if (first.compareTo(newItem) < 0) {
                topItems.pollFirst();
                topItems.add(newItem);
            }
        }
    }
}
