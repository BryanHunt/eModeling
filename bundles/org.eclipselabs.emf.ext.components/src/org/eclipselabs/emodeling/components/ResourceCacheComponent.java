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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emodeling.ResourceCache;
import org.eclipselabs.emodeling.ResourceSetFactory;

/**
 * @author bhunt
 * 
 */
public class ResourceCacheComponent implements ResourceCache
{
	private volatile ResourceSetFactory resourceSetFactory;
	private ResourceSet resourceSet;

	@Override
	public ResourceSet getResourceSet()
	{
		if (resourceSet == null)
		{
			ResourceSetFactory factory = resourceSetFactory;

			if (factory != null)
				resourceSet = factory.createResourceSet();
		}

		return resourceSet;
	}

	public void bindResourceSetFactory(ResourceSetFactory resourceSetFactory)
	{
		this.resourceSetFactory = resourceSetFactory;
	}

	public void unbindResourceSetFactory(ResourceSetFactory resourceSetFactory)
	{
		if (resourceSetFactory == this.resourceSetFactory)
			this.resourceSetFactory = null;
	}
}
