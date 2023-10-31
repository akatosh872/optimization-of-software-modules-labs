import java.util.ArrayList;
import java.util.Random;

// Інтерфейс реалізації методів сортування
interface Sorter {
    ArrayList<Integer> sort(ArrayList<Integer> input);
}

// Клас сортування бульбашкою
class BubbleSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int n = input.size();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n - 1; i++) {
            if (System.currentTimeMillis() - startTime > 40000){
                break;
            }

            for (int j = 0; j < n - i - 1; j++) {
                if (input.get(j) > input.get(j + 1)) {

                    int temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }

        return input;
    }
}

// Клас сортування Шелла
class ShellSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int n = input.size();
        for (int gap = n / 2; 0 < gap; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = input.get(i);
                int j;
                for (j = i; j >= gap && input.get(j - gap) > temp; j -= gap) {
                    input.set(j, input.get(j - gap));
                }
                input.set(j, temp);
            }
        }
        return input;
    }
}

// Клас сортування злиттям
class MergeSorter implements Sorter {
    //    Поділ на частини
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int n = input.size();

        if (n < 2){
            return input;
        }

        int mid = n / 2;
        ArrayList<Integer> left = new ArrayList<>(input.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(input.subList(mid, n));

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }
    // Злиття
    private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));

        return result;
    }
}

// Клас швидкого сортування
class QuickSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        quickSort(input, 0, input.size() - 1);
        return input;
    }

    private void quickSort(ArrayList<Integer> input, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(input, low, high);
            quickSort(input, low, pivotIndex - 1);
            quickSort(input, pivotIndex + 1, high);
        }
    }

    private int partition(ArrayList<Integer> input, int low, int high) {
        int pivot = input.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (input.get(j) < pivot) {
                i++;
                int temp = input.get(i);
                input.set(i, input.get(j));
                input.set(j, temp);
            }
        }

        int temp = input.get(i + 1);
        input.set(i + 1, input.get(high));
        input.set(high, temp);

        return i + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        for (int count : new int[]{10, 1000, 10000, 1000000}) {
            System.out.println("Number of elements: " + count);
            ArrayList<Integer> input = generateRandomArray(count);

            for (SortingType type : SortingType.values()) {

                System.out.println("Sorting type: " + type);
                Sorter sorter = getSorter(type);

                ArrayList<Integer> sorted = sorterTime(input, sorter);

                if (count <= 50) {
                    System.out.println("Sorted array: " + sorted);
                }
            }
        }
    }

    private static ArrayList<Integer> generateRandomArray(int count) {
        ArrayList<Integer> array = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            array.add(rand.nextInt(count));
        }
        return array;
    }

    private static Sorter getSorter(SortingType type) {
        return switch (type) {
            case BUBBLE -> new BubbleSorter();
            case SHELL -> new ShellSorter();
            case MERGE -> new MergeSorter();
            case QUICK -> new QuickSorter();
            default -> throw new IllegalArgumentException("Unknown sorting type");
        };
    }

    private static ArrayList<Integer> sorterTime(ArrayList<Integer> input, Sorter sorter){
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> sorted = sorter.sort(new ArrayList<>(input));
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        if (executionTime < 40000) {
            System.out.println("Execution time: " + executionTime + " ms");
        } else {
            System.out.println("The method was interrupted, execution took more than 40000 ms");
        }
        return sorted;
    }

    enum SortingType {
        BUBBLE, SHELL, MERGE, QUICK
    }
}