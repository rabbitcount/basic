/******************************************************************************
 *  Compilation:  javac Selection.java
 *  Execution:    java  Selection < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/21sort/tiny.txt
 *                http://algs4.cs.princeton.edu/21sort/words3.txt
 *
 *  Sorts a sequence of strings from standard input using selection sort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Selection < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Selection < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 ******************************************************************************/

package edu.princeton.cs.algs4;

import edu.princeton.cs.SortingHelper;

import java.util.Comparator;

/**
 *  The <tt>Selection</tt> class provides static methods for sorting an
 *  array using selection sort.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Selection extends SortingHelper {

    // This class should not be instantiated.
    private Selection() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     *
     * @param a the array
     * @param c the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator c) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min], c)) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i, c);
        }
        assert isSorted(a, c);
    }

    /**
     * Reads in a sequence of strings from standard input; selection sorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Selection.sort(a);
        show(a);
    }
}