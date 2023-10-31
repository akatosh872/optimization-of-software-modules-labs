import java.util.*;


public class Main {
    public static void main(String[] args) {
        int countOfElements = 100000;
        int countForInsert = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        fill(arrayList, countOfElements, "ArrayList");
        fill(linkedList, countOfElements, "LinkedList");

        random_access(arrayList, countOfElements, "ArrayList");
        random_access(linkedList, countOfElements, "LinkedList");

        sequential_access(arrayList, "ArrayList");
        sequential_access(linkedList, "LinkedList");

        insert_beginning(arrayList, countForInsert, "ArrayList");
        insert_beginning(linkedList, countForInsert, "LinkedList");

        insert_end(arrayList, countForInsert, "ArrayList");
        insert_end(linkedList, countForInsert, "LinkedList");

        insert_middle(arrayList, countForInsert, "ArrayList");
        insert_middle(linkedList, countForInsert, "LinkedList");
    }
    private static void fill(List<Integer> list, int n, String listType) {
        Random random = new Random();

        long time = System.currentTimeMillis();
        for (int i=0; i<n;i++){
            list.add(random.nextInt());
        }

        System.out.printf("Fill %s: %s %n", listType, System.currentTimeMillis() - time);
    }

    private static void random_access(List<Integer> list, int n, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int value = list.get(i);
        }
        System.out.printf("Random access %s: %s %n", listType, System.currentTimeMillis() - time);
    }

    private static void sequential_access(List<Integer> list, String listType) {
        long time = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
        }
        System.out.printf("Sequential access %s: %s %n", listType, System.currentTimeMillis() - time);
    }

    private static void insert_beginning(List<Integer> list, int n, String listType) {
        Random random = new Random();

        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(0, random.nextInt(n));
        }
        System.out.printf("Insert at the beginning of %s: %d %n", listType, System.currentTimeMillis() - time);
    }

    private static void insert_end(List<Integer> list, int n, String listType) {
        long time = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(n));
        }
        System.out.printf("Insert at the end of %s: %d %n", listType, System.currentTimeMillis() - time);
    }

    private static void insert_middle(List<Integer> list, int n, String listType) {
        Random random = new Random();

        long time = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < n; i++) {
            list.add(size / 2, random.nextInt(n));
        }
        System.out.printf("Insert in the middle of %s: %d %n", listType, System.currentTimeMillis() - time);
    }
}