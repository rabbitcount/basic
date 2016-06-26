/******************************************************************************
 * Compilation:  javac Insertion.java
 * Execution:    java Insertion < input.txt
 * Dependencies: StdOut.java StdIn.java
 * Data files:   http://algs4.cs.princeton.edu/21sort/tiny.txt
 * http://algs4.cs.princeton.edu/21sort/words3.txt
 * <p>
 * Sorts a sequence of strings from standard input using insertion sort.
 * <p>
 * % more tiny.txt
 * S O R T E X A M P L E
 * <p>
 * % java Insertion < tiny.txt
 * A E E L M O P R S T X                 [ one string per line ]
 * <p>
 * % more words3.txt
 * bed bug dad yes zoo ... all bad yet
 * <p>
 * % java Insertion < words3.txt
 * all bad bed bug dad ... yes yet zoo   [ one string per line ]
 ******************************************************************************/

package edu.princeton.cs.algs4;

import edu.princeton.cs.SortingHelper;

import java.util.Comparator;

/**
 *  The <tt>Insertion</tt> class provides static methods for sorting an
 *  array using insertion sort.
 *  <p>
 *  This implementation makes ~ <b> 1/2 N^2 compares and exchanges </b> in
 *  the worst case, so it is not suitable for sorting large arbitrary arrays.
 *  More precisely, the number of exchanges is exactly equal to the number
 *  of inversions. So, for example, it sorts a partially-sorted array
 *  in linear time.
 *  <p>
 *  The sorting algorithm is stable and uses O(1) extra memory.
 *  <p>
 *  See <a href="http://algs4.cs.princeton.edu/21elementary/InsertionPedantic.java.html">InsertionPedantic.java</a>
 *  for a version that eliminates the compiler warning.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Insertion extends SortingHelper {

    // This class should not be instantiated.
    private Insertion() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the subarray a[lo..hi] in ascending order, using the natural order.
     * @param a the array to be sorted
     * @param lo left endpoint
     * @param hi right endpoint
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
        assert isSorted(a, lo, hi);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
            assert isSorted(a, 0, i, comparator);
        }
        assert isSorted(a, comparator);
    }

    /**
     * Rearranges the subarray a[lo..hi] in ascending order, using a comparator.
     * @param a the array
     * @param lo left endpoint
     * @param hi right endpoint
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
        }
        assert isSorted(a, lo, hi, comparator);
    }


    // return a permutation that gives the elements in a[] in ascending order
    // do not change the original array a[]

    /**
     * Returns a permutation that gives the elements in the array in ascending order.
     * @param a the array
     * @return a permutation <tt>p[]</tt> such that <tt>a[p[0]]</tt>, <tt>a[p[1]]</tt>,
     *    ..., <tt>a[p[N-1]]</tt> are in ascending order
     */
    public static int[] indexSort(Comparable[] a) {
        int N = a.length;
        int[] index = new int[N];
        for (int i = 0; i < N; i++)
            index[i] = i;

        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--)
                exch(index, j, j - 1);

        return index;
    }

    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Insertion.sort(a);
        show(a);
    }
}