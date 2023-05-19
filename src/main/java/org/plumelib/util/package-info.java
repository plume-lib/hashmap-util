/**
 *
 *
 * <h2>Plume-lib HashMap Util: Utility libraries for Java HashMaps</h2>
 *
 * <h3 id="Collections_and_iterators">Collections and iterators</h3>
 *
 * <dl>
 *   <dt>{@link org.plumelib.util.Hasher Hasher}
 *   <dd>The Hasher interface is an optional argument to a hash table (such as {@link
 *       org.plumelib.util.WeakHasherMap WeakHasherMap}) that specifies the {@code hashCode()} and
 *       {@code equals()} methods.
 *   <dt>{@link org.plumelib.util.WeakHasherMap WeakHasherMap}
 *   <dd>WeakHashMap is a modified version of WeakHashMap, that adds a constructor that takes a
 *       {@link org.plumelib.util.Hasher Hasher} argument.
 *   <dt>{@link org.plumelib.util.WeakIdentityHashMap WeakIdentityHashMap}
 *   <dd>WeakIdentityHashMap is a modified version of WeakHashMap, that uses
 *       System.identityHashCode() rather than the object's hash code.
 * </dl>
 */
package org.plumelib.util.hashmap;
