import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int n = 19999999;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }

        MergeSort(a);

        System.out.println("Done");

        System.out.println(Arrays.toString(a));
    }

    public static void SelectionSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    public static void InsertionSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if ((aux[j] < aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void sort(int[] a, int[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
    public static void MergeSort(int[] a)
    {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void BubbleSort(int a[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] < a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }
}
