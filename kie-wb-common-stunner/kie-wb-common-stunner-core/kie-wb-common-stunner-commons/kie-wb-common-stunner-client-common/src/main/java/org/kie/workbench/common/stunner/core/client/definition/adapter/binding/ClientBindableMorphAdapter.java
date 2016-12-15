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

package org.kie.workbench.common.stunner.core.client.definition.adapter.binding;

import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ioc.client.container.SyncBeanDef;
import org.jboss.errai.ioc.client.container.SyncBeanManager;
import org.kie.workbench.common.stunner.core.api.FactoryManager;
import org.kie.workbench.common.stunner.core.definition.adapter.BindableMorphAdapter;
import org.kie.workbench.common.stunner.core.definition.morph.MorphDefinitionProvider;
import org.kie.workbench.common.stunner.core.definition.util.DefinitionUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Collection;

@Dependent
public class ClientBindableMorphAdapter<S> extends BindableMorphAdapter<S> {

    SyncBeanManager beanManager;

    @Inject
    public ClientBindableMorphAdapter( final SyncBeanManager beanManager,
                                       final FactoryManager factoryManager,
                                       final DefinitionUtils definitionUtils ) {
        super( definitionUtils, factoryManager );
        this.beanManager = beanManager;
    }

    @PostConstruct
    @SuppressWarnings( "unchecked" )
    public void init() {
        // Morph definitions.
        Collection<SyncBeanDef<MorphDefinitionProvider>> beanMorphAdapters = beanManager.lookupBeans( MorphDefinitionProvider.class );
        for ( SyncBeanDef<MorphDefinitionProvider> morphAdapter : beanMorphAdapters ) {
            MorphDefinitionProvider provider = morphAdapter.getInstance();
            morphDefinitions.addAll( provider.getMorphDefinitions() );
        }
    }

    @Override
    protected <T> T doMerge( final S source,
                             final T result ) {
        return ClientBindingUtils.merge( source, result );

    }

    @Override
    public boolean accepts( final Class<?> type ) {
        try {
            DataBinder.forType( type );
        } catch ( Exception e ) {
            return false;
        }
        return true;
    }

}
