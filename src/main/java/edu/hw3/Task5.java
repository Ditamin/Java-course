package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Task5 {
    ArrayList<Person> parseContacts(ArrayList<String> names, String comparator) {
        ArrayList<Person> persons = new ArrayList<>();

        if (names == null) {
            return persons;
        }

        for (var element : names) {
            persons.add(new Person(element));
        }

        if (comparator.equals("ASC")) {
            persons.sort(Person.COMPARE_BY_LASTNAME);
        } else if (comparator.equals("DESC")) {
            persons.sort(Collections.reverseOrder(Person.COMPARE_BY_LASTNAME));
        } else {
            throw new IllegalArgumentException();
        }

        return persons;
    }

    class Person {
        final private String firstName;
        final private String lastName;

        Person(String nameStr) {
            if (nameStr == null) {
                throw new NullPointerException();
            }

            String[] name = nameStr.split(" ");

            if (name.length == 2) {
                this.firstName = name[0];
                this.lastName = name[1];
            } else if (name.length == 1) {
                this.firstName = name[0];
                this.lastName = "";
            } else {
                throw new IllegalArgumentException();
            }
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj.getClass() != this.getClass()) {
                return false;
            }

            var other = (Person) obj;
            return Objects.equals(this.getFirstName(), other.getFirstName())
                && Objects.equals(this.getLastName(), other.getLastName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }

        public static final Comparator<Person> COMPARE_BY_LASTNAME = (lhs, rhs) -> {
            String lhsValue;
            String lhsExtraValue;
            String rhsValue;
            String rhsExtraValue;

            if (lhs.getLastName().isEmpty()) {
                lhsValue = lhs.getFirstName();
                lhsExtraValue = "";
            } else {
                lhsValue = lhs.getLastName();
                lhsExtraValue = lhs.getFirstName();
            }

            if (rhs.getLastName().isEmpty()) {
                rhsValue = rhs.getFirstName();
                rhsExtraValue = "";
            } else {
                rhsValue = rhs.getLastName();
                rhsExtraValue = rhs.getFirstName();
            }

            if (lhsValue.equals(rhsValue)) {
                return lhsExtraValue.compareTo(rhsExtraValue);
            }

            return lhsValue.compareTo(rhsValue);
        };

    }
}
