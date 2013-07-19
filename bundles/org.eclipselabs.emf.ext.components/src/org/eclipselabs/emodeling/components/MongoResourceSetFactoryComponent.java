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

package org.eclipselabs.emodeling.components;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
	private Set<ResourceSetConfigurator> configurators = new HashSet<ResourceSetConfigurator>();
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	@Override
	public ResourceSet createResourceSet()
	{
		MongoResourceSetImpl resourceSet = new MongoResourceSetImpl();
		lock.readLock().lock();

		try
		{
			for (ResourceSetConfigurator configurator : configurators)
				configurator.configureResourceSet(resourceSet);
		}
		finally
		{
			lock.readLock().unlock();
		}

		return resourceSet;
	}

	@Override
	public Collection<ResourceSetConfigurator> getResourceSetConfigurators()
	{
		lock.readLock().lock();

		try
		{
			return Collections.unmodifiableCollection(configurators);
		}
		finally
		{
			lock.readLock().unlock();
		}
	}

	public void bindResourceSetConfigurator(ResourceSetConfigurator resourceSetConfigurator)
	{
		lock.writeLock().lock();

		try
		{
			configurators.add(resourceSetConfigurator);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}

	public void unbindResourceSetConfigurator(ResourceSetConfigurator resourceSetConfigurator)
	{
		lock.writeLock().lock();

		try
		{
			configurators.remove(resourceSetConfigurator);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}
}
