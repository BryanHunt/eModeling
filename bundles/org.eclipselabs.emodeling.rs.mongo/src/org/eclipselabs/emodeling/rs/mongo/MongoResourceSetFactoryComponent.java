/*******************************************************************************
 * Copyright (c) 2012 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.emodeling.rs.mongo;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emodeling.ResourceSetConfigurator;
import org.eclipselabs.emodeling.ResourceSetFactory;

/**
 * This implementation of the IResourceSetFactory applies all currently
 * bound ResourceSetConfigurator services to the resource set after
 * construction.
 * 
 * @author bhunt
 * 
 */
public class MongoResourceSetFactoryComponent implements ResourceSetFactory
{
	private Set<ResourceSetConfigurator> configurators = new CopyOnWriteArraySet<ResourceSetConfigurator>();

	@Override
	public ResourceSet createResourceSet()
	{
		MongoResourceSetImpl resourceSet = new MongoResourceSetImpl();

		for (ResourceSetConfigurator configurator : configurators)
			configurator.configureResourceSet(resourceSet);

		return resourceSet;
	}

	@Override
	public Collection<ResourceSetConfigurator> getResourceSetConfigurators()
	{
		return Collections.unmodifiableCollection(configurators);
	}

	public void bindResourceSetConfigurator(ResourceSetConfigurator resourceSetConfigurator)
	{
		configurators.add(resourceSetConfigurator);
	}

	public void unbindResourceSetConfigurator(ResourceSetConfigurator resourceSetConfigurator)
	{
		configurators.remove(resourceSetConfigurator);
	}
}
