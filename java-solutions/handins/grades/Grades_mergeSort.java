import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Grades_mergeSort {
    private static Map<String, Integer> Gnum = new HashMap<String, Integer>() {{
        put("A", 7);
        put("B", 6);
        put("C", 5);
        put("D", 4);
        put("E", 3);
        put("FX", 2);
        put("F", 1);
    }};

    private static Grade[] aux; 

    private static boolean less(Grade a, Grade b) {
        if (a.grade == b.grade) {                           
            if (a.mod == b.mod)                         // if grades and modifiers are equal, name is compared
                return b.name.compareTo(a.name) < 1;    
            else return a.mod < b.mod;                  // else we compare modifiers
        } 
        else return a.grade < b.grade;                  // else we compare grades
    }
    
    static void merge(Grade[] arr, int l, int m, int r) {   // similar to segdewick, see p. 271
        int i = l, j = m + 1;                               // pointer initialization for left and right halves of arr
        for (int k = l; k <= r; k++) {                      // copy elements from arr to aux
            aux[k] = arr[k];
        }
        for (int k = l; k <= r; k++) {              // iterate over range l..r (including r)
            if (i > m) {                            // if all elements of first half have been processed
                arr[k] = aux[j++]; 
            } else if (j > r) {                     // if all elements of second half have been processed
                arr[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {      // if element at pos i < j, place the element j at k in arr
                arr[k] = aux[j++]; 
            } else { arr[k] = aux[i++]; }           // if element at pos j < i, place element i at k in arr
        }
    }

    private static void sort(Grade[] arr, int l, int r) {   // recursively "split" arr into two halves
        if (r <= l) return;
        int m = l + (r - l) / 2;        // calc mid position
        sort(arr, l, m);                // sort left half
        sort(arr, m + 1, r);            // sort right half
        merge(arr, l, m, r);            // merge the left and right
    }
    
    public static Grade[] sort(Grade[] arr) {
        if (arr.length == 1) return arr;            // in case array is of length 1, it is sorted
        aux = new Grade[arr.length];                // initialize the auxiliary array    
        sort(arr, 0, arr.length - 1);             // start sorting
        return arr;                                 // return the result.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Grade[] arr = new Grade[n];
        for (int i = 0; i < n; i++) { 
            arr[i] = new Grade(scanner.nextLine());
        }
        scanner.close();
        Grade[] sorted = sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(sorted[i].name);
        }
    }

    static class Grade {
        String name;
        int grade, mod = 0; 

        public Grade(String ln) {
            String[] spl = ln.split(" ");
            name = spl[0];
            String[] gSpl = spl[1].split("(?=[+-])", 2);        // split by "+/-"
            grade = Gnum.get(gSpl[0]);                                      // lookup int rep of grade chars
            if (gSpl.length > 1) {                                          // add value to modifier
                int modLen = gSpl[1].length();
                mod = gSpl[1].startsWith("+") ? modLen : -modLen;
            }
        }
    }
}
