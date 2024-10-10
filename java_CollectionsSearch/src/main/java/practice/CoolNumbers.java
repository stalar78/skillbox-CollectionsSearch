package practice;

import java.util.*;

public class CoolNumbers {

    private static final List<Character> LETTERS =
            Arrays.asList('А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х');
    private static final Random RANDOM = new Random();

    // Метод генерации номеров
    public static List<String> generateCoolNumbers() {
        List<String> coolNumbers = new ArrayList<>();

        for (int i = 0; i < 2_000_000; i++) {
            String number = generateRandomNumber();
            coolNumbers.add(number);
        }
        return coolNumbers;
    }

    // Генерация одного случайного номера
    private static String generateRandomNumber() {
        char letter1 = LETTERS.get(RANDOM.nextInt(LETTERS.size()));
        int number = RANDOM.nextInt(1000); // Генерация трехзначного числа
        char letter2 = LETTERS.get(RANDOM.nextInt(LETTERS.size()));
        char letter3 = LETTERS.get(RANDOM.nextInt(LETTERS.size()));
        int region = 1 + RANDOM.nextInt(199); // Генерация региона от 01 до 199

        return String.format("%c%03d%c%c%d", letter1, number, letter2, letter3, region);
    }

    // Поиск перебором в ArrayList
    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long startTime = System.nanoTime();
        boolean found = list.contains(number);
        long endTime = System.nanoTime();
        System.out.printf("Поиск перебором: номер %s, поиск занял %dнс%n",
                found ? "найден" : "не найден", endTime - startTime);
        return found;
    }

    // Бинарный поиск в сортированном ArrayList
    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long startTime = System.nanoTime();
        int index = Collections.binarySearch(sortedList, number);
        long endTime = System.nanoTime();
        System.out.printf("Бинарный поиск: номер %s, поиск занял %dнс%n",
                index >= 0 ? "найден" : "не найден", endTime - startTime);
        return index >= 0;
    }

    // Поиск в HashSet
    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long startTime = System.nanoTime();
        boolean found = hashSet.contains(number);
        long endTime = System.nanoTime();
        System.out.printf("Поиск в HashSet: номер %s, поиск занял %dнс%n",
                found ? "найден" : "не найден", endTime - startTime);
        return found;
    }

    // Поиск в TreeSet
    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long startTime = System.nanoTime();
        boolean found = treeSet.contains(number);
        long endTime = System.nanoTime();
        System.out.printf("Поиск в TreeSet: номер %s, поиск занял %dнс%n",
                found ? "найден" : "не найден", endTime - startTime);
        return found;
    }

}
