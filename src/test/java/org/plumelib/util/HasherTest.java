package org.plumelib.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public final class HasherTest {

  /**
   * A Hasher that delegates to the objects' own methods, as the {@code Hasher} documentation says
   * clients should behave when no Hasher is provided.
   */
  private static final Hasher DEFAULT_HASHER =
      new Hasher() {
        @Override
        public int hashCode(Object o) {
          return o.hashCode();
        }

        @Override
        public boolean equals(Object o1, Object o2) {
          return o1.equals(o2);
        }
      };

  @Test
  void testDefaultHasher() {
    String a = "value";
    String b = "value";
    String c = "other";

    assertTrue(DEFAULT_HASHER.equals(a, b));
    assertFalse(DEFAULT_HASHER.equals(a, c));
    assertEquals(a.hashCode(), DEFAULT_HASHER.hashCode(a));
    // Equal objects have equal hash codes.
    assertEquals(DEFAULT_HASHER.hashCode(a), DEFAULT_HASHER.hashCode(b));
  }
}
