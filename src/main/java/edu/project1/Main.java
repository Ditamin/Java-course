package edu.project1;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
//        System.out.println("""
//              a b c d e f g h i j k l m n o p q r s t u v w x y z
//
//                w e r t y u i o p
//               a s d f g h j   l
//                z x c v   n m
//
//              ____
//             |    |
//             |   ( )
//             |   /|\\
//             |  / | \\
//             |   / \\
//             |  /   \\
//             |
//             """);
        new CommandLineParser().run();
    }
}
