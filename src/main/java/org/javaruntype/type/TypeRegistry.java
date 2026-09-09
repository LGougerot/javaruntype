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
package org.javaruntype.type;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.javaruntype.cache.ConcurrentCache;


/*
 * (non-javadoc)
 * 
 * This is the registry of types, a synchronized cache which ensures
 * that only one object of each type exists in memory at a time.
 * 
 * This is not for saving CPU cycles (an aspect which would probably be more
 * efficient if new instances were created), but to avoid an excessive
 * memory usage under heavy processing load. 
 * 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class TypeRegistry {

    
    private final ConcurrentCache<String,Type<?>> types = 
        new ConcurrentCache<String,Type<?>>();
    private final ConcurrentCache<String,Type<?>> typesByPossibleNames = 
        new ConcurrentCache<String, Type<?>>();
    private final ConcurrentCache<Class<?>,Type<?>> rawTypesByClass = 
        new ConcurrentCache<Class<?>,Type<?>>();
    private final ConcurrentCache<Type<?>,Set<Type<?>>> extendedTypesByType = 
        new ConcurrentCache<Type<?>, Set<Type<?>>>();
    protected final ConcurrentCache<TypeAssignation, Boolean> typeAssignabilities = 
        new ConcurrentCache<TypeAssignation, Boolean>();
    protected final ConcurrentCache<java.lang.reflect.Type, Type<?>> typesbyJavaLangReflectType = 
        new ConcurrentCache<java.lang.reflect.Type, Type<?>>();
    
    
    private static final TypeRegistry instance = new TypeRegistry(); 
    
    

    static TypeRegistry getInstance() {
        return instance;
    }
    
    
    private TypeRegistry() {
        super();
    }

    
    

    Type<?> forName(final String typeName) {

        return this.typesByPossibleNames.computeAndGet(
                typeName, 
                () -> TypeUtil.forName(typeName));
        
    }
    
    

    
    Type<?> getRawTypeForClass(final Class<?> typeClass) {
        
        return this.rawTypesByClass.computeAndGet(
                typeClass, 
                () -> TypeUtil.getRawTypeForClass(typeClass));
        
    }
    
    
    
    
    Type<?> getType(final Class<?> componentClass, 
            final TypeParameter<?>[] typeParameters, final int arrayDimensions) {

        final String identifier = 
            TypeUtil.createName(componentClass, typeParameters, arrayDimensions);
        return this.types.computeAndGet(
                identifier, 
                () -> Type.createType(componentClass, typeParameters, arrayDimensions));
        
    }

    

    
    Type<?> getTypeWithoutValidation(final Class<?> componentClass, 
            final TypeParameter<?>[] typeParameters, final int arrayDimensions) {

        final String identifier = 
            TypeUtil.createName(componentClass, typeParameters, arrayDimensions);
        final Type<?> type = this.types.get(identifier);
        if (type != null) {
            return type; 
        }
        return Type.createTypeWithoutValidation(componentClass, typeParameters, arrayDimensions);
        
    }
    
    
    
    
    Set<Type<?>> getExtendedTypes(final Type<?> type) {
        
        return this.extendedTypesByType.computeAndGet(
                type, 
                () -> TypeUtil.getExtendedTypes(type));
        
    }

    
    
    @SuppressWarnings("unchecked")
    Type<?> forJavaLangReflectType(final java.lang.reflect.Type javaLangReflectType) {
        return this.typesbyJavaLangReflectType.computeAndGet(
                javaLangReflectType, 
                () -> TypeUtil.createFromJavaLangReflectType(
                        javaLangReflectType, javaLangReflectType, Collections.EMPTY_MAP));
        
    }
    
    
    Type<?> forJavaLangReflectType(final java.lang.reflect.Type javaLangReflectType, final Map<String,Type<?>> variableSubstitutions) {
        
        /*
         * When variable substitutions are specified, including these in the map keys
         * would not be of great help as the amount of equality operations to be performed
         * would be quite high and creating the org.javaruntype.type.Type from the
         * java.lang.reflect.Type is not a too expensive operation.
         */
        return TypeUtil.createFromJavaLangReflectType(
                        javaLangReflectType, javaLangReflectType, variableSubstitutions);
        
    }
    
    
    boolean isAssignableFrom(final Type<?> type, final Type<?> fromType) {

        final TypeAssignation assignation = new TypeAssignation(type, fromType);
        return this.typeAssignabilities.computeAndGet(
                    assignation,  
                    () -> Boolean.valueOf(TypeUtil.isAssignableFrom(type, fromType)))
                .booleanValue();
        
    }
    
    


}
