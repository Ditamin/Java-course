package edu.hw2;

public class Task1 {
    public sealed interface Expr {
        double evaluate();

        public record Constant(double value) implements Expr {
            Constant(Expr value) {
                this(value.evaluate());
            }

            public double evaluate() {
                return value;
            }
        }

        public record Negate(Expr value) implements Expr {
            Negate(double val) {
                this(new Constant(val));
            }

            public double evaluate() {
                return -value.evaluate();
            }
        }

        public record Exponent(Expr base, Expr power) implements Expr {
            public Exponent(double base, double power) {
                this(new Constant(base), new Constant(power));
            }

            public Exponent(double base, Expr power) {
                this(new Constant(base), power);
            }

            public Exponent(Expr base, double power) {
                this(base, new Constant(power));
            }

            public double evaluate() {
                return Math.pow(base.evaluate(), power.evaluate());
            }
        }

        public record Addition(Expr first, Expr second) implements Expr {
            public Addition(double first, double second) {
                this(new Constant(first), new Constant(second));
            }

            public Addition(Expr first, double second) {
                this(first, new Constant(second));
            }

            public Addition(double first, Expr second) {
                this(new Constant(first), second);
            }

            public double evaluate() {
                return first.evaluate() + second.evaluate();
            }
        }

        public record Multiplication(Expr first, Expr second) implements Expr {
            public Multiplication(double first, double second) {
                this(new Constant(first), new Constant(second));
            }

            public Multiplication(Expr first, double second) {
                this(first, new Constant(second));
            }

            public Multiplication(double first, Expr second) {
                this(new Constant(first), second);
            }

            public double evaluate() {
                return first.evaluate() * second.evaluate();
            }
        }
    }
}
