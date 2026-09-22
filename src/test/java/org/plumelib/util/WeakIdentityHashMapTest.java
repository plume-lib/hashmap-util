package org.plumelib.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public final class WeakIdentityHashMapTest {

  /**
   * These tests could be much more thorough. Basically all that is tested is that identity is used
   * rather than a normal hash. The tests will fail, however, if WeakHashMap is swapped for
   * WeakIdentityHashMap.
   */
  @SuppressWarnings("PMD.StringInstantiation")
  @Test
  void testWeakIdentityHashMap() {

    String s1 = "one";
    String s2 = "two";
    String s3 = "three";

    WeakIdentityHashMap<String, Integer> m = new WeakIdentityHashMap<>();
    // WeakHashMap<String,Integer> m = new WeakHashMap<>();

    m.put(s1, 1);
    m.put(s2, 2);
    m.put(s3, 3);

    String s1a = new String(s1);
    String s2a = new String(s2);
    String s3a = new String(s3);

    m.put(s1a, 1);
    m.put(s2a, 2);
    m.put(s3a, 3);

    assertEquals(Integer.valueOf(1), m.get(s1));
    assertEquals(Integer.valueOf(2), m.get(s2));
    assertEquals(Integer.valueOf(3), m.get(s3));
    assertEquals(Integer.valueOf(1), m.get(s1a));
    assertEquals(Integer.valueOf(2), m.get(s2a));
    assertEquals(Integer.valueOf(3), m.get(s3a));

    m.remove(s1);
    m.remove(s2);
    m.remove(s3);
    // Removing a key does not affect a distinct, identity-unequal key with equal contents.
    assertNull(m.get(s1));
    assertNull(m.get(s2));
    assertNull(m.get(s3));
    assertEquals(Integer.valueOf(1), m.get(s1a));
    assertEquals(Integer.valueOf(2), m.get(s2a));
    assertEquals(Integer.valueOf(3), m.get(s3a));
  }
}
