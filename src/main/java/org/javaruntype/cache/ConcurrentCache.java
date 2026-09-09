/*
 * =============================================================================
 * 
 *   Copyright (c) 2009, The JAVARUNTYPE team (http://www.javaruntype.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.javaruntype.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * <p>
 * Base synchronized cache for <code>*Registry</code> objects.
 * </p>
 * <p>
 * <b>Do not</b> use this class directly.
 * </p>
 * <p>
 * This class is <b>thread-safe</b>.
 * </p>
 * 
 * @since 1.0
 * 
 * @param <K> key type
 * @param <V> value type
 *  
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ConcurrentCache<K,V> {

    private final ConcurrentHashMap<K,V> cache; 
    
    
    
    /**
     * <p>
     * Create a new synchronized cache specifying a maximum size for the cache
     * </p>
     */
    public ConcurrentCache() {
        super();
        this.cache = new ConcurrentHashMap<K,V>();
    }

    
    /**
     * <p>
     * Clear the cache.
     * </p>
     */
    public void clear() {
        this.cache.clear();
    }
    
    
    /**
     * <p>
     * Get the value for a specific key
     * </p>
     * 
     * @param key the key
     * @return the value, or null if not found
     */
    public V get(final K key) {
        return this.cache.get(key);
    }
    
    /**
     * <p>
     * Puts a value into the cache and returns it. If a value already
     * existed for the same key, the existing value is not modified and is
     * returned instead of the one passed as parameter. This ensures only one
     * object for each key exists at a time. 
     * </p>
     * 
     * @param key the key to which the value will be assigned
     * @param value the value which will be added to the map
     * @return the value added to the map (or the one already existing at the map)
     */
    public V computeAndGet(final K key, final Supplier<V> value) {
        var res = this.cache.get(key);
        if (res == null) {
            var v = value.get();
            return this.cache.computeIfAbsent(key, k -> v);
        }
        return res;
    }
    
}
