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

package org.kie.workbench.common.stunner.core.definition.adapter;

/**
 * Adapters provide a way to bind a given domain object of any class with the app-specific domain model .
 */
public interface Adapter {

    /**
     * Check if the adapter instance supports the pojo's given type.
     */
    boolean accepts( Class<?> type );

    /**
     * Returns if the adapter targets Java POJO domain classes or targets other kind of soft models.
     */
    boolean isPojoModel();

}
