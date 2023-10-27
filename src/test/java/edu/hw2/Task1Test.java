package edu.hw2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw2.Task1.*;
import edu.hw2.Task1.Expr.*;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    void basicTest() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));
        Assertions.assertThat(res.evaluate()).isEqualTo(37);
    }

    @Test
    @DisplayName("Тест класса Constant")
    void constantClassTest() {
        Expr one = new Constant(1);
        Constant oneCopy = new Constant(one);
        Assertions.assertThat(one.evaluate()).isEqualTo(oneCopy.evaluate()).isEqualTo(1);
    }

    @Test
    @DisplayName("Тест класса Negate")
    void negateClassTest() {
        var one = new Constant(1);
        Expr negOne = new Negate(one);
        Negate negOneCopy = new Negate(1);
        Assertions.assertThat(negOne.evaluate()).isEqualTo(negOneCopy.evaluate()).isEqualTo(-1);
    }

    @Test
    @DisplayName("Тест класса Exponent")
    void exponentClassTest() {
        var two = new Constant(2);
        Expr twoSquared = new Exponent(two, two);
        Exponent rootSixteen = new Exponent(16, 0.5);
        var negTwoSquared = new Exponent(new Negate(two), 2);
        var negPower = new Exponent(2, negTwoSquared);
        Assertions.assertThat(negTwoSquared.evaluate()).isEqualTo(4);
        Assertions.assertThat(rootSixteen.evaluate()).isEqualTo(4);
        Assertions.assertThat(negPower.evaluate()).isEqualTo(16);
        Assertions.assertThat(twoSquared.evaluate()).isEqualTo(4);
    }

    @Test
    @DisplayName("Тест класса Addition")
    void additionClassTest() {
        Addition sumTwoFour = new Addition(2, 4);
        Expr sumNegOneSeven = new Addition(new Negate(1), new Constant(7));
        var sumOneFive = new Addition(new Constant(1), 5);
        var sumFractions = new Addition(1.5, new Constant(4.5));
        Assertions.assertThat(sumOneFive.evaluate()).isEqualTo(6);
        Assertions.assertThat(sumNegOneSeven.evaluate()).isEqualTo(6);
        Assertions.assertThat(sumFractions.evaluate()).isEqualTo(6);
        Assertions.assertThat(sumTwoFour.evaluate()).isEqualTo(6);
    }

    @Test
    @DisplayName("Тест класса Multiplication")
    void multiplicationClassTest() {
        Multiplication twoMultFour = new Multiplication(2, 4);
        Expr negOneMultSix = new Multiplication(new Negate(1), new Constant(6));
        var zeroMultOne = new Multiplication(new Constant(0), 1);
        var multFractions = new Multiplication(1.5, new Constant(3));
        Assertions.assertThat(zeroMultOne.evaluate()).isEqualTo(0);
        Assertions.assertThat(negOneMultSix.evaluate()).isEqualTo(-6);
        Assertions.assertThat(multFractions.evaluate()).isEqualTo(4.5);
        Assertions.assertThat(twoMultFour.evaluate()).isEqualTo(8);
    }
}
