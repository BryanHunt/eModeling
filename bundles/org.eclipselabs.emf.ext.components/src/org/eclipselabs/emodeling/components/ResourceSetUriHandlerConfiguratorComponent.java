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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipselabs.emodeling.ResourceSetConfigurator;
import org.eclipselabs.emodeling.UriHandlerProvider;
import org.eclipselabs.emodeling.UriMapProvider;

/**
 * This implementation of the ResourceSetConfigurator service will attach
 * all currently bound URI handlers to the ResourceSet. This service is
 * intended to be used with the IResourceSetFactory service.
 * 
 * @author bhunt
 * 
 */
public class ResourceSetUriHandlerConfiguratorComponent implements ResourceSetConfigurator
{
	private Set<UriHandlerProvider> handlerProviders = new HashSet<UriHandlerProvider>();
	private Set<UriMapProvider> mapProviders = new HashSet<UriMapProvider>();
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	@Override
	public void configureResourceSet(ResourceSet resourceSet)
	{
		URIConverter uriConverter = resourceSet.getURIConverter();
		EList<URIHandler> uriHandlers = uriConverter.getURIHandlers();
		Map<URI, URI> uriMap = uriConverter.getURIMap();

		lock.readLock().lock();

		try
		{
			for (UriHandlerProvider handlerProvider : handlerProviders)
				uriHandlers.add(0, handlerProvider.getURIHandler());

			for (UriMapProvider mapProvider : mapProviders)
				uriMap.putAll(mapProvider.getUriMap());
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
			handlerProviders.add(handlerProvider);
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
			handlerProviders.remove(handlerProvider);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}

	public void bindUriMapProvider(UriMapProvider mapProvider)
	{
		lock.writeLock().lock();

		try
		{
			mapProviders.add(mapProvider);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}

	public void unbindUriMapProvider(UriMapProvider mapProvider)
	{
		lock.writeLock().lock();

		try
		{
			mapProviders.remove(mapProvider);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}
}
