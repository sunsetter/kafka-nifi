package aorlov.kafkanifi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BitCoinTransaction implements Comparable<BitCoinTransaction> {
    private String channel;
    private String event;
    private Data data;

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {

        private String id;
        private String id_str;
        private String order_type;
        private String datetime;
        private String microtimestamp;
        private String amount;
        private String amount_str;
        private double price;
        private String price_str;
    }

    @Override
    public int compareTo(BitCoinTransaction bitCoinTransaction) {
        return Double.compare(data.price, bitCoinTransaction.getData().price);
    }
}
