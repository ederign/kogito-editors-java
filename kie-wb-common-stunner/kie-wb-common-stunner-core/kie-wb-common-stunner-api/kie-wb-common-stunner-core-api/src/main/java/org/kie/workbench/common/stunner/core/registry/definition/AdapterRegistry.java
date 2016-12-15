/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.stunner.core.registry.definition;

import org.kie.workbench.common.stunner.core.definition.adapter.*;
import org.kie.workbench.common.stunner.core.registry.Registry;

/**
 * The registry for the adapters of type <code>org.kie.workbench.common.stunner.core.definition.adapter.Adapter</code>.
 * It provides some lookup specific methods for different adapter types.
 */
public interface AdapterRegistry extends Registry<Adapter> {

    /**
     * Returns the Definition Set adapter instance for the given type.
     */
    <T> DefinitionSetAdapter<T> getDefinitionSetAdapter( Class<?> type );

    /**
     * Returns the Definition Set rules adapter instance for the given type.
     */
    <T> DefinitionSetRuleAdapter<T> getDefinitionSetRuleAdapter( Class<?> type );

    /**
     * Returns the Definition adapter instance for the given type.
     */
    <T> DefinitionAdapter<T> getDefinitionAdapter( Class<?> type );

    /**
     * Returns the Property Set adapter instance for the given property set's type.
     */
    <T> PropertySetAdapter<T> getPropertySetAdapter( Class<?> type );

    /**
     * Returns the Property adapter instance for the given property's type.
     */
    <T> PropertyAdapter<T, ?> getPropertyAdapter( Class<?> type );

    /**
     * Returns the Morphing adapter instance for a given Definition type.
     */
    <T> MorphAdapter<T> getMorphAdapter( Class<?> type );

}
