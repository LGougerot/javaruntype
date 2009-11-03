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
package org.javaruntype.exceptions;

import org.apache.commons.lang.exception.NestableRuntimeException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class TypeValidationException 
        extends NestableRuntimeException {

    private static final long serialVersionUID = -7104333842847446754L;

    public TypeValidationException(String message) {
        super(message);
    }
    
    public TypeValidationException(String message, Throwable t) {
        super(message, t);
    }
    
}
