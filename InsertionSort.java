public class InsertionSort {
    public static void main(String[] args) {
        int[] A = {31, 41, 59, 26, 41, 58};

        //INSERTION-SORT(A)
        System.out.println("INSERTION-SORT");
        insertionSort(A);
        printArray(A);

        //2.1-1
        System.out.println("Exercise 2.1-1");
        int[] B = {31, 41, 59, 26, 41, 58};
        illustrate(B);

        //2.1-2
        System.out.println("Exercise 2.1-2");
        insertionSortRev(A);
        printArray(A);

        //2.1-3
        System.out.println("Exercise 2.1-3");
        int[] C = {1, 5, 4, 3, 2, 6};
        findValue(C, 6);

        //2.1-4
        System.out.println("Exercise 2.1-4");
        int[] binaryA = {1,0,0,1,0,1};
        int[] binaryB = {1,1,0,0,1,1};
        binarySum(binaryA, binaryB);  
    }

    private static void printArray(int A[]) {
        System.out.print("[");
        for(int i = 0; i < A.length; i++) {
            if(i == A.length-1) {
                System.out.print(A[i] + "]\n");
                break;
            }
            System.out.print(A[i] + ",");
        }
    }

    private static void insertionSort(int[] A) {
        for(int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j-1;
            while(i >= 0 && A[i] > key){
                A[i+1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
    }

    /**
     * 2.1-1
     * Using Figure 2.2 as a model, illustrate the operation of INSERTION-SORT
     * on the array A = [31, 41, 59, 26, 41, 58]
     */
    private static void illustrate(int[] A) {
        for(int j = 1; j < A.length; j++) {
            System.out.printf("%d)", j);
            printArray(A);
            int key = A[j];
            int i = j-1;
            while(i >= 0 && A[i] > key){
                A[i+1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
        System.out.printf("%d)", A.length);
        printArray(A);
    }

    /**
     * 2.1-2 
     * Rewrite the INSERTION-SORT procedure to sort into nonincreasing
     * instead of nondecreasing order.
     * @param A = [31, 41, 59, 26, 41, 58]
     */
    private static void insertionSortRev(int[] A) {
        for(int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j-1;
            while(i >= 0 && A[i] < key){
                A[i+1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
    }

    /**
     * 2.1-3
     * Consider the searching problem:
     * Input: A sequence of n numbers A = [a1, a2,..., an] and a value v.
     * Output: An index i such that v = A[i] or the special value NIL
     * if v does not appear in A.
     * Write pseudocode for linear search, which scans through the sequence,
     * looking for v. Using a loop invariant, prove that your algorithm is correct.
     * Make sure that your loop invariant fulfills the three necessary properties.
     */
    private static void findValue(int[] A, int v) {
        /**
         * Pseudocode for findValue
         * 1. for i = 1 to A.length
         * 2.   if A[i] == v
         * 3.       return i
         * 4. return NIL
         */

        /**
         * 1. Loop Invariant Initialization: when i = 0, it is guaranteed
         *    that it will check the first element of the array in the
         *    first loop, the loop invariant holds.
         * 2. Loop Invariant Maintenance: for loop works by iterating
         *    A[i] until it matches value v. Incrementing i for the next
         *    iteration of the for loop preserves the loop invariant.
         * 3. Loop Invariant Termination: The condition causing for loop
         *    to terminate is A[i] == v or i == A.length, each iteration
         *    increases i by 1, so if v does not match any of the elements
         *    in the array, we have i = A.length at termination.
         *    We observe that we output NIL, so the algorithm is correct.
         */
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] == v){
                System.out.println("The index for v is " + i);
                return;
            }
        }
        System.out.println("The index for v is NIL");
    }

    /**
     * 2.1-4
     * Consider the problem of adding two n-bit binary integers,
     * stored in two n-element arrays A and B. The sum of the two 
     * integers should be stored in binary form in an (n + 1)-element
     * array C. State the problem formally and write pseudocode for
     * adding the two integers.
     */
    private static void binarySum(int[] A, int[] B) {
        /**
         * Pseudocode for binarySum
         * 1. n = A.length
         * 2. next = 0
         * 3. for i = n to 1
         * 4.   sum = A[i-1] + B[i-1] + next
         * 5.   if sum = 0
         * 6.       C[i] = 0
         * 7.       next = 0
         * 8.   else if sum = 1
         * 9.       C[i] = 1
         * 10.      next = 0
         * 11.  else if sum = 2
         * 12.      C[i] = 0
         * 13.      next = 0
         * 14.  else
         * 15.      C[i] = 1
         * 16.      next = 0
         * 17. C[0] = next
         */
        int n = A.length;
        int next = 0;
        int[] C = new int[n+1];
        for(int i = n; i > 0; i--) {
            int sum = A[i-1]+B[i-1]+next;
            if(sum == 0){
                C[i] = 0;
                next = 0;
            }
            else if(sum == 1){
                C[i] = 1;
                next = 0;
            }
            else if(sum == 2){
                C[i] = 0;
                next = 1;
            }
            else{
                C[i] = 1;
                next = 1;
            }
        }
        C[0] = next;
        printArray(C);
    }
}
