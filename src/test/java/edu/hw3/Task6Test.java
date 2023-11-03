package edu.hw3;

import edu.hw3.Task6.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    Task6 task6 = new Task6();

    @Test
    @DisplayName("Проверка метода add")
    void addTest() {
        StockExchange stockMarket = task6.new StockExchange();
        stockMarket.add(new Stock(4));
        stockMarket.add(new Stock(3));
        stockMarket.add(new Stock(5));
        stockMarket.add(new Stock(5));
        Assertions.assertThat(stockMarket.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка метода remove")
    void removeTest() {
        StockExchange stockMarket = task6.new StockExchange();
        stockMarket.add(new Stock(4));
        stockMarket.add(new Stock(3));
        stockMarket.add(new Stock(5));
        stockMarket.remove(new Stock(3));
        stockMarket.remove(new Stock(1));
        Assertions.assertThat(stockMarket.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Проверка метода mostValuableStock")
    void mostValuableStockTest() {
        StockExchange stockMarket = task6.new StockExchange();
        stockMarket.add(new Stock(4));
        stockMarket.add(new Stock(3));
        stockMarket.add(new Stock(5));
        stockMarket.remove(new Stock(3));
        Stock mostValuableStock = stockMarket.mostValuableStock();
        Assertions.assertThat(mostValuableStock.value()).isEqualTo(4);
    }

    @Test
    @DisplayName("Взаимодействие с пустой биржей")
    void emptyStockMarketTest() {
        StockExchange stockMarket = task6.new StockExchange();
        Assertions.assertThatThrownBy(stockMarket::mostValuableStock).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("Добавление null акции")
    void nullStockTest() {
        StockExchange stockMarket = task6.new StockExchange();
        Assertions.assertThatThrownBy(() -> {
            stockMarket.add(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
