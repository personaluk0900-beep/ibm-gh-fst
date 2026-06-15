package fst123;

public class Activity4 {

    public static void main(String[] args) {

        int[] numbers = {1, 4, 2, 3, 5};

        System.out.print("Before Sorting: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        Sort(numbers);

        System.out.print("\nAfter Sorting: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void Sort(int arr[]) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}