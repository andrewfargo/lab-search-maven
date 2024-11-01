package edu.grinnell.csc207.experiments;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.function.Predicate;

import edu.grinnell.csc207.util.SearchUtils;


/**
 * Assorted experiments for searching structures.
 *
 * @author Richard Lin
 * @author Andrew Fargo
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchExperiments {
  /**
   * Run our experimens.
   *
   * @param args
   *   Command-line arguments. Ignored.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] tmp =
        new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                       "foxtrot", "golf", "hotel", "india",
                       "juliett", "kilo", "lima", "mike",
                       "november", "oscar", "papa", "quebec",
                       "romeo", "sierra", "tango", "uniform",
                       "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));

    String ex1c = SearchUtils.search(strings, (str) -> str.length() < 5 );

    try {
      String ex1g = SearchUtils.search(strings, (s) -> s.length() == 6);
      pen.println("The first string of exactly six letters is " + ex1g);
    } catch (Exception e) {
      pen.println("There are no strings of exactly six letters.");
    } // try/catch

    String ex2c = SearchUtils.search(strings, (str) -> str.contains("u"));

    // for (String str: tmp) {
    //   pen.println(str);
    // } // for

    //String ex3c = SearchUtils.search(tmp, (str) -> str.length() == 7);
    // fails

    int[] testArr = new int[1000];

    for (int i = 0; i < 1000; i++) {
      testArr[i] = i;
    }

    for (int i = 0; i < 10; i ++) {
      for (int k = 0; k < Math.pow(2, i) + 1; k++) {
        SearchUtils.binarySearch(testArr, 0, 0);
      }
    }
    
    pen.close();
  } // main(String[])
} // class SearchUtils
