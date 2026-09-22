package org.plumelib.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;
import java.util.Map;
import org.junit.jupiter.api.Test;

public final class WeakHasherMapTest {

  /** A Hasher that treats strings as equal when they are equal ignoring case. */
  private static final Hasher CASE_INSENSITIVE_HASHER =
      new Hasher() {
        @Override
        public int hashCode(Object o) {
          return ((String) o).toLowerCase(Locale.ROOT).hashCode();
        }

        @Override
        public boolean equals(Object o1, Object o2) {
          return ((String) o1).equalsIgnoreCase((String) o2);
        }
      };

  /** Without a Hasher, keys are compared using their own {@code equals} and {@code hashCode}. */
  @Test
  void testDefaultHashing() {
    WeakHasherMap<String, Integer> m = new WeakHasherMap<>();
    m.put("one", 1);
    m.put("two", 2);

    assertEquals(2, m.size());
    assertEquals(Integer.valueOf(1), m.get("one"));
    assertEquals(Integer.valueOf(2), m.get("two"));
    assertTrue(m.containsKey("one"));
    // Keys that are unequal under the default hasher are not found.
    assertFalse(m.containsKey("ONE"));
    assertNull(m.get("ONE"));

    assertEquals(Integer.valueOf(1), m.remove("one"));
    assertNull(m.remove("one"));
    assertEquals(1, m.size());
  }

  /** With a Hasher, keys are compared using the Hasher's {@code equals} and {@code hashCode}. */
  @Test
  void testHasher() {
    WeakHasherMap<String, Integer> m = new WeakHasherMap<>(CASE_INSENSITIVE_HASHER);
    m.put("Hello", 1);

    // Lookups succeed for any key the Hasher considers equal.
    assertTrue(m.containsKey("Hello"));
    assertTrue(m.containsKey("HELLO"));
    assertTrue(m.containsKey("hello"));
    assertEquals(Integer.valueOf(1), m.get("HELLO"));
    assertEquals(Integer.valueOf(1), m.get("hello"));

    // Putting an equal-but-differently-cased key replaces the existing mapping.
    Integer previous = m.put("HELLO", 2);
    assertEquals(Integer.valueOf(1), previous);
    assertEquals(1, m.size());
    assertEquals(Integer.valueOf(2), m.get("hello"));

    assertEquals(Integer.valueOf(2), m.remove("hELLo"));
    assertTrue(m.isEmpty());
  }

  /** The entry set reflects the map's contents, and {@code clear} empties the map. */
  @Test
  void testEntrySetAndClear() {
    WeakHasherMap<String, Integer> m = new WeakHasherMap<>();
    m.put("a", 1);
    m.put("b", 2);
    m.put("c", 3);

    int sum = 0;
    int count = 0;
    for (Map.Entry<String, Integer> e : m.entrySet()) {
      sum += e.getValue();
      count++;
    }
    assertEquals(3, count);
    assertEquals(6, sum);

    m.clear();
    assertTrue(m.isEmpty());
    assertEquals(0, m.size());
    assertFalse(m.entrySet().iterator().hasNext());
  }
}
