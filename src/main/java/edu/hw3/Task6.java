package edu.hw3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Task6 {
    interface StockMarket {
        void add(Stock stock);

        void remove(Stock stock);

        Stock mostValuableStock();
    }

    class StockExchange implements StockMarket {
        final private PriorityQueue<Stock> stocks = new PriorityQueue<>(Comparator.comparingInt(x -> x.value));

        @Override
        public void add(Stock stock) {
            if (stock == null) {
                throw new NullPointerException();
            }

            stocks.add(stock);
        }

        @Override
        public void remove(Stock stock) {
            stocks.remove(stock);
        }

        @Override
        public Stock mostValuableStock() {
            if (stocks.isEmpty()) {
                throw new IllegalStateException();
            }

            return stocks.peek();
        }

        public int size() {
            return stocks.size();
        }
    }

    public record Stock(int value) {}

}
