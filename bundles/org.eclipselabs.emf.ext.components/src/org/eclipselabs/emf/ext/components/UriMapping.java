/**
 * 
 */

package org.eclipselabs.emf.ext.components;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.emf.ext.UriMapProvider;

/**
 * @author bhunt
 * 
 */
public class UriMapping implements UriMapProvider
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
