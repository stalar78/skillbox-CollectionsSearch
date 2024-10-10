package practice;

import java.util.*;

import static practice.CoolNumbers.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        // Генерация номеров
        List<String> coolNumbers = generateCoolNumbers();

        // Сортировка для бинарного поиска
        List<String> sortedCoolNumbers = new ArrayList<>(coolNumbers);
        Collections.sort(sortedCoolNumbers);

        // Создание HashSet и TreeSet
        HashSet<String> hashSet = new HashSet<>(coolNumbers);
        TreeSet<String> treeSet = new TreeSet<>(coolNumbers);

        // Тестовый номер для поиска
        String testNumber = coolNumbers.get(100); // Берем случайный номер для теста

        // Поиск по разным коллекциям
        bruteForceSearchInList(coolNumbers, testNumber);
        binarySearchInList(sortedCoolNumbers, testNumber);
        searchInHashSet(hashSet, testNumber);
        searchInTreeSet(treeSet, testNumber);

    }
}
