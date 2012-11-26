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

package org.eclipselabs.emf.ext.components;

import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipselabs.emf.ext.ResourceSetConfigurator;
import org.eclipselabs.emf.ext.UriHandlerProvider;

/**
 * This implementation of the ResourceSetConfigurator service will attach
 * all currently bound URI handlers to the ResourceSet. This service is
 * intended to be used with the IResourceSetFactory service.
 * 
 * @author bhunt
 * 
 */
public class ResourceSetUriHandlerConfigurator implements ResourceSetConfigurator
{
	@Override
	public void configureResourceSet(ResourceSet resourceSet)
	{
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		lock.readLock().lock();

		try
		{
			for (UriHandlerProvider provider : providers)
				uriHandlers.add(0, provider.getURIHandler());
		}
		finally
		{
			lock.readLock().unlock();
		}
	}

	public void bindUriHandlerProvider(UriHandlerProvider handlerProvider)
	{
		lock.writeLock().lock();

		try
		{
			providers.add(handlerProvider);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}

	public void unbindUriHandlerProvider(UriHandlerProvider handlerProvider)
	{
		lock.writeLock().lock();

		try
		{
			providers.remove(handlerProvider);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}

	private HashSet<UriHandlerProvider> providers = new HashSet<UriHandlerProvider>();
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
}
