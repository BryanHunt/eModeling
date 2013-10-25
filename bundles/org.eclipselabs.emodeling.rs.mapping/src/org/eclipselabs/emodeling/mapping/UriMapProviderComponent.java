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

package org.eclipselabs.emodeling.mapping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.emodeling.UriMapProvider;

/**
 * @author bhunt
 * 
 */
public class UriMapProviderComponent implements UriMapProvider
{
	private Map<URI, URI> uriMap = new HashMap<URI, URI>();

	@Override
	public Map<URI, URI> getUriMap()
	{
		return uriMap;
	}

	public void configure(Map<String, Object> properties)
	{
		URI src = URI.createURI((String) properties.get("src"));
		URI dest = URI.createURI((String) properties.get("dest"));
		uriMap.put(src, dest);
	}
}
