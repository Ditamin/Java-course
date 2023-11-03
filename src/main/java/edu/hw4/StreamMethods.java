package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;

public class StreamMethods {
    final static private int HUNDRED = 100;

    private StreamMethods() {}

    // Отсортировать животных по росту от самого маленького к самому большому -> List<Animal>
    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::height))
            .toList();
    }

    // Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых -> List<Animal>
    public static List<Animal> task2(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

    // Сколько животных каждого вида -> Map<Animal.Type, Integer>
    public static Map<Animal.Type, Long> task3(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    // У какого животного самое длинное имя -> Animal
    public static Animal task4(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }

    // Каких животных больше: самцов или самок -> Sex
    public static Animal.Sex task5(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .orElseThrow()
            .getKey();
    }

    // Самое тяжелое животное каждого вида -> Map<Animal.Type, Animal>
   public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
       var weights = animals.stream()
           .collect(Collectors.groupingBy(
               Animal::type,
               Collectors.maxBy(Comparator.comparing(Animal::weight))));

       Map<Animal.Type, Animal> typeMaxWeight = new HashMap<>();

       for (var type : weights.entrySet()) {
           typeMaxWeight.put(type.getKey(), type.getValue().orElse(null));
       }

       return typeMaxWeight;
    }

    // K-е самое старое животное -> Animal
    public static Animal task7(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    // Самое тяжелое животное среди животных ниже k см -> Optional<Animal>
    public static Optional<Animal> task8(List<Animal> animals, int k) {
        return animals.stream()
            .filter(it -> it.height() < k)
            .max(Comparator.comparing(Animal::weight));
    }

    // Сколько в сумме лап у животных в списке -> Integer
    public static Integer task9(List<Animal> animals) {
        return animals.stream()
            .map(Animal::paws)
            .reduce(0, Integer::sum);
    }

    // Список животных, возраст у которых не совпадает с количеством лап -> List<Animal>
    public static List<Animal> task10(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    // Список животных, которые могут укусить (bites == true) и рост которых превышает 100 см -> List<Animal>
    public static List<Animal> task11(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > HUNDRED)
            .toList();
    }

    // Сколько в списке животных, вес которых превышает рост -> Integer
    public static Integer task12(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    // Список животных, имена которых состоят из более чем двух слов -> List<Animal>
    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    // Есть ли в списке собака ростом более k см -> Boolean
    public static Boolean task14(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type().equals(DOG) && animal.height() > k);
    }

    // Найти суммарный вес животных каждого вида, которым от k до l лет -> Map<Animal.Type, Integer>
    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    // Список животных, отсортированный по виду, затем по полу, затем по имени -> List<Animal>
    public static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    // Правда ли, что пауки кусаются чаще, чем собаки -> Boolean (если данных для ответа недостаточно, вернуть false)
    public static Boolean task17(List<Animal> animals) {
        var dogs = animals.stream().filter(animal -> animal.type() == DOG).count();
        var bitingDogs = animals.stream().filter(animal -> animal.type() == DOG && animal.bites()).count();
        var spiders = animals.stream().filter(animal -> animal.type() == SPIDER).count();
        var bitingSpiders = animals.stream().filter(animal -> animal.type() == SPIDER && animal.bites()).count();
        return bitingSpiders * dogs > bitingDogs * spiders;
    }

    // Найти самую тяжелую рыбку в 2-х или более списках -> Animal
    public static Animal task18(List<Animal>... lists) {
        Stream<Animal> animals = Stream.empty();

        for (var list : lists) {
            animals = Stream.concat(animals, list.stream());
        }
        return animals.filter(animal -> animal.type() == FISH)
            .max(Comparator.comparing(Animal::weight))
            .orElse(null);
    }

    // Животные, в записях о которых есть ошибки: вернуть имя и список ошибок -> Map<String, Set<ValidationError>>.
    public static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(Animal::name, ValidationError::check));
    }

    // Сделать результат предыдущего задания более читабельным:
    // вернуть имя и названия полей с ошибками, объединенные в строку -> Map<String, String>
    public static Map<String, String> task20(Map<String, Set<ValidationError>> mistakes) {
        return mistakes.entrySet()
            .stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                mistake -> mistake.getValue()
                    .stream()
                    .map(ValidationError::fieldName)
                    .collect(Collectors.joining(", "))));
    }
}
