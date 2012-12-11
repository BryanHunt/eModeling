/**
 * 
 */

package org.eclipselabs.emf.ext;

import java.util.Map;

import org.eclipse.emf.common.util.URI;

/**
 * @author bhunt
 * 
 */
public interface UriMapProvider
{
	Map<URI, URI> getUriMap();
}
