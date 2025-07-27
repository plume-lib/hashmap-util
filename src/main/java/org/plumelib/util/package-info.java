/**
 *
 *
 * <h2>Plume-lib HashMap Util: Utility libraries for Java HashMaps</h2>
 *
 * <p>Note that <a
 * href="http://plumelib.org/plume-util/api/org/plumelib/util/package-summary.html#package.description">Plume
 * Util</a> defines other classes in the {@code org.plumelib.util} package.
 *
 * <h3 id="Collections_and_iterators">Collections and iterators</h3>
 *
 * <dl>
 *   <dt>{@link org.plumelib.util.Hasher Hasher}
 *   <dd>The {@code Hasher} interface is an optional argument to a hash table (such as {@link
 *       org.plumelib.util.WeakHasherMap WeakHasherMap}) that specifies the {@code hashCode()} and
 *       {@code equals()} methods.
 *   <dt>{@link org.plumelib.util.WeakHasherMap WeakHasherMap}
 *   <dd>{@code WeakHashMap} is a modified version of {@code WeakHashMap}, that adds a constructor
 *       that takes a {@link org.plumelib.util.Hasher Hasher} argument.
 *   <dt>{@link org.plumelib.util.WeakIdentityHashMap WeakIdentityHashMap}
 *   <dd>{@code WeakIdentityHashMap} is a modified version of {@code WeakHashMap}, that uses {@code
 *       System.identityHashCode()} rather than the object's hash code.
 * </dl>
 */
package org.plumelib.util;
