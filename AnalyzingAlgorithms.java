public class AnalyzingAlgorithms {
    public static void main(String[] args) {
        int[] A = {64, 25, 12, 22, 11};

        //2.2-1
        System.out.println("Exercise 2.2-1");
        BigONotation();

        //2.2-2
        System.out.println("Exercise 2.2-2");
        selectionSort(A);
        printArray(A);

        //2.2-3
        System.out.println("Exercise 2.2-3");
        averageCase(A);

        //2.2-4
        System.out.println("Exercise 2.2-4");
        bestCase();
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

    /**
     * 2.2-1
     * Express the function n^3/1000 -  100n^2 - 100n + 3 in 
     * terms of Big O-notation.
     */
    private static void BigONotation() {
        System.out.println("n^3/1000 -  100n^2 - 100n + 3 in terms of Big O-notation is: ");
        System.out.println("O(n^3) because we ignore lower-order terms and the leading term's constant coefficient");
    }

    /**
     * 2.2-2
     * Consider sorting n numbers stored in array A by first finding the smallest element
     * of A and exchanging it with the element in A[1]. Then find the second smallest
     * element of A, and exchanging it with A[2]. Continue in this manner for the first
     * n-1 elements of A. Write pseudocode for this algorithm, which is known as selection
     * sort. What loop invariant does this algorithm maintain? Why does it need to run
     * for only the first n-1 elements, rather than for all n elements? Give the best-case
     * and worst-case running times of selection sort in O-notation.
     */
    private static void selectionSort(int[] A) {
        /**
         * Pseudocode for Selection Sort
         * 1. for i = 1 to A.length-1
         * 2.   min_index = i
         * 3.   for j = i+1 to A.length
         * 4.       if A[j] < A[min_index]
         * 5.           min_index = j
         * 6.   temp = A[min_index]
         * 7.   A[min_index] = A[i]
         * 8.   A[i] = temp
         */

        /**
         * - Loop invariant that this algorithm maintains is that min_index is the
         *   minimum value in A[i..j]
         * - It only needs to run n-1 elements because in the n-1th loop the n-1th element 
         *   is compared with the nth element to be sorted without looping the nth time.
         * - Best-case running time: O(n^2)
         * - Worst-case running time: O(n^2)
         */
        for(int i = 0; i < A.length-1; i++) {
            int min_index = i;
            for(int j = i+1; j < A.length; j++) {
                if(A[j] < A[min_index])
                    min_index = j;
            }
            int temp = A[min_index];
            A[min_index] = A[i];
            A[i] = temp;
        }
    }

    /**
     * 2.2-3
     * Consider linear search again (see Exercise 2.1-3). How many elements of the
     * input sequence need to be checked on the average, assuming that the element
     * being searched for is equally likely to be any element in the array? How about
     * in the worst case? What are the average-case and worst-case running times of
     * linear search in O-notation? Justify your answers.
     */
    private static void averageCase(int[] A) {
        int best = 0, average = 0, worst = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 11)
                best = i+1;
            if(A[i] == 22)
                average = i+1;
            if(A[i] == 64)
                worst = i+1;
        }
        System.out.printf("Best: %d\nAverage: %d\nWorst: %d\n", best, average, worst);
        System.out.println("Elements of input sequence to check on average is (n+1)/2");
        //Average case is the average of best(1) and worst(n) cases
        System.out.println("Elements of input sequence to check on worst is n");
        //Worst case is when element is not found which means there are n comparisons
        System.out.println("Average-case running time is O(n)");
        //After ignoring lower-order terms and the leading term's constant coefficient
        //of (n+1)/2 it's n
        System.out.println("Worst-case running time is O(n)");
        //There are no lower-order terms and the leading term's constant coefficient
        //to delete, so it's simply n
    }

    /**
     * 2.2-4
     * How can we modify almost any algorithm to have a good best-case running time?
     */
    private static void bestCase() {
        System.out.println("Checking if the array is already sorted before sorting makes the best-case running time to be O(n)");
    }
}
