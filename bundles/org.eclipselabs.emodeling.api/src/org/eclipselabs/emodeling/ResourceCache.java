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

package org.eclipselabs.emodeling;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * This OSGi service maintains a singleton ResourceSet created from the ResourceSetFactory service.
 * 
 * The ResourceSet from this service is most likely not thread safe. Please consult the service
 * implementation for thread safety.
 * 
 * @author bhunt
 */
public interface ResourceCache
{
	/**
	 * @return a singleton ResourceSet
	 */
	public ResourceSet getResourceSet();
}