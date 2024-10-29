package edu.grinnell.csc207;

import java.util.Arrays;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.util.SearchUtils;

/**
 * Tests of our search methods.
 *
 * @author Your Name Here
 * @author Your Name Here
 * @author Samuel A. Rebelsky
 */
public class TestSearch {
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * A string version of a call to binary search.
   *
   * @param values
   *   The array.
   * @param val
   *   The value we're searching for.
   *
   * @return
   *   The string "binarySearch(values, val)"
   */
  String bsCall(int[] values, int val) {
    return String.format("binarySearch(%s, %d)", Arrays.toString(values), val);
  } // bsCall

  /**
   * Assert that a search for a particular value finds the value at an
   * expected index.
   *
   * @param expected
   *   The expected index.
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFinds(int expected, int[] values, int val) 
      throws Exception {
    assertEquals(expected, SearchUtils.binarySearch(values, val),
        () -> bsCall(values, val));
  } // assertBinarySearchFinds(int, int[], int)

  /**
   * Assert that a search for a particular value finds the value.
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFinds(int[] values, int val) throws Exception {
    assertEquals(val, values[SearchUtils.binarySearch(values, val)],
        () -> String.format("values[%s]", bsCall(values, val)));
  } // assertBinarySearchFinds(int[], int)

  /**
   * Assert that a search for a particular value fails (hopefully, because 
   * the value * is not in the array).
   *
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFails(int[] values, int val) throws Exception {
    assertThrows(Exception.class,
        () -> SearchUtils.binarySearch(values, val),
        () -> bsCall(values, val));
  } // assertBinarySearchFails()

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * Searching the empty array should fail.
   */
  @Test
  void testBinarySearchEmpty() throws Exception {
    assertBinarySearchFails(new int[] { }, 0);
  } // testSearchEmpty()

  /**
   * Searching in a one-element array.
   */
  @Test
  void testBinarySearchOne() throws Exception {
    assertBinarySearchFinds(0, new int[] { 5 }, 5);
    assertBinarySearchFails(new int[] { 5 }, 0);
    assertBinarySearchFails(new int[] { 5 }, 10);
  } // testBinarySearchOne()

  /**
   * Searching in a two-element array.
   */
  @Test
  void testBinarySearchTwo() throws Exception {
    assertBinarySearchFinds(0, new int[] { 7, 11 }, 7);
    assertBinarySearchFinds(1, new int[] { 7, 11 }, 11);
    assertBinarySearchFails(new int[] { 7, 11 }, 0);
    assertBinarySearchFails(new int[] { 7, 11 }, 10);
    assertBinarySearchFails(new int[] { 7, 11 }, 20);
  } // testBinarySearchTwo()

  /**
   * Searching with duplicates. (Credit to SD, MM, JV.)
   */
  @Test
  void testBinarySearchDups() throws Exception {
    assertBinarySearchFinds(new int[] { 1, 1, 1, 2, 2, 3 }, 1);
    assertBinarySearchFinds(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
    assertBinarySearchFinds(new int[] { 1, 1, 1, 2, 2, 3 }, 3);
  } // testBinarySearchDups()

  /**
   * Finds each value in the range 0-50 correctly
   * @throws Exception
   */
  @Test
  void findRange() throws Exception {
    int[] arr = new int[50];
    for (int i = 0; i < 50; i++) {
      arr[i] = i;
    } // for
    for (int i = 0; i < 50; i++) {
      assertBinarySearchFinds(i, arr, i);
    } // for
  } // findRange

  /**
   * Finds each value in the range -50-0 correctly
   * @throws Exception
   */
  @Test 
  void findNegatives() throws Exception {
    int[] arr = new int[50];
    for (int i = -50; i < 0; i++) {
      arr[i + 50] = i;
    } // for
    for (int i = -50; i < 0; i++) {
      assertBinarySearchFinds(i + 50, arr, i);
    } // for
  } // findNegatives

  /**
   * Finds each value in the range 0-50 (only odds) correctly
   * @throws Exception
   */
  @Test 
  void findOdds() throws Exception {
    int[] arr = new int[25];
    for (int i = 0; i < 25; i++) {
      arr[i] = 2 * i + 1;
    } // for
    for (int i = 0; i < 25; i++) {
      assertBinarySearchFinds(i, arr, 2 * i + 1);
    } // for
  } // findsOdds
} // class TestSearch
