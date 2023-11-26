package edu.hw7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Task3 {
    public record Person(int id, String name, String address, String phoneNumber) {}

    interface PersonDatabase {
        void add(Person person);

        void delete(int id);

        List<Person> findByName(String name);

        List<Person> findByAddress(String address);

        List<Person> findByPhone(String phone);
    }

    class PersonDatabaseSynchronized implements PersonDatabase {
        private Map<String, HashSet<Integer>> nameIdMap = new HashMap<>();
        private Map<String, HashSet<Integer>> addressIdMap = new HashMap<>();
        private Map<String, HashSet<Integer>> phoneIdMap = new HashMap<>();
        private Map<Integer, Person> persons = new HashMap<>();

        @Override
        public synchronized void add(Person person) {
            persons.put(person.id(), person);

            if (!nameIdMap.containsKey(person.name())) {
                nameIdMap.put(person.name(), new HashSet<>());
            }

            if (!addressIdMap.containsKey(person.address())) {
                addressIdMap.put(person.address(), new HashSet<>());
            }

            if (!phoneIdMap.containsKey(person.phoneNumber())) {
                phoneIdMap.put(person.phoneNumber(), new HashSet<>());
            }

            nameIdMap.get(person.name()).add(person.id());
            addressIdMap.get(person.address()).add(person.id());
            phoneIdMap.get(person.phoneNumber()).add(person.id());
        }

        @Override
        public synchronized void delete(int id) {
            if (!persons.containsKey(id)) {
                return;
            }

            Person person = persons.get(id);
            nameIdMap.get(person.name()).remove(id);
            addressIdMap.get(person.address()).remove(id);
            phoneIdMap.get(person.phoneNumber()).remove(id);
            persons.remove(id);
        }

        @Override
        public synchronized List<Person> findByName(String name) {
            if (!nameIdMap.containsKey(name)) {
                return List.of();
            }

            return nameIdMap.get(name).stream().map((id -> persons.get(id))).toList();
        }

        @Override
        public synchronized List<Person> findByAddress(String address) {
            if (!addressIdMap.containsKey(address)) {
                return List.of();
            }

            return addressIdMap.get(address).stream().map((id -> persons.get(id))).toList();
        }

        @Override
        public synchronized List<Person> findByPhone(String phone) {
            if (!phoneIdMap.containsKey(phone)) {
                return List.of();
            }

            return phoneIdMap.get(phone).stream().map((id -> persons.get(id))).toList();
        }
    }

    class PersonDataBaseReadWriteLock implements PersonDatabase {
        private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
        private Map<String, HashSet<Integer>> nameIdMap = new HashMap<>();
        private Map<String, HashSet<Integer>> addressIdMap = new HashMap<>();
        private Map<String, HashSet<Integer>> phoneIdMap = new HashMap<>();
        private Map<Integer, Person> persons = new HashMap<>();

        @Override
        public void add(Person person) {
            lock.writeLock().lock();

            try {
                persons.put(person.id(), person);

                if (!nameIdMap.containsKey(person.name())) {
                    nameIdMap.put(person.name(), new HashSet<>());
                }

                if (!addressIdMap.containsKey(person.address())) {
                    addressIdMap.put(person.address(), new HashSet<>());
                }

                if (!phoneIdMap.containsKey(person.phoneNumber())) {
                    phoneIdMap.put(person.phoneNumber(), new HashSet<>());
                }

                nameIdMap.get(person.name()).add(person.id());
                addressIdMap.get(person.address()).add(person.id());
                phoneIdMap.get(person.phoneNumber()).add(person.id());
            } finally {
                lock.writeLock().unlock();
            }
        }

        @Override
        public void delete(int id) {
            lock.writeLock().lock();

            try {
                if (!persons.containsKey(id)) {
                    return;
                }

                Person person = persons.get(id);
                nameIdMap.get(person.name()).remove(id);
                addressIdMap.get(person.address()).remove(id);
                phoneIdMap.get(person.phoneNumber()).remove(id);
                persons.remove(id);
            } finally {
                lock.writeLock().unlock();
            }
        }

        @Override
        public List<Person> findByName(String name) {
            lock.readLock().lock();

            try {
                if (!nameIdMap.containsKey(name)) {
                    return List.of();
                }

                return nameIdMap.get(name).stream().map((id -> persons.get(id))).toList();
            } finally {
                lock.readLock().unlock();
            }
        }

        @Override
        public List<Person> findByAddress(String address) {
            lock.readLock().lock();

            try {
                if (!addressIdMap.containsKey(address)) {
                    return List.of();
                }

                return addressIdMap.get(address).stream().map((id -> persons.get(id))).toList();
            } finally {
                lock.readLock().unlock();
            }
        }

        @Override
        public List<Person> findByPhone(String phone) {
            lock.readLock().lock();

            try {
                if (!phoneIdMap.containsKey(phone)) {
                    return List.of();
                }

                return phoneIdMap.get(phone).stream().map((id -> persons.get(id))).toList();
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
