/**
 * 
 */

package org.eclipselabs.emodeling.rs.mapping.junit.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.emodeling.mapping.UriMapProviderComponent;
import org.junit.Before;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestUriMapProviderComponent
{
	private UriMapProviderComponent uriMapProviderComponent;

	@Before
	public void setUp()
	{
		uriMapProviderComponent = new UriMapProviderComponent();
	}

	@Test
	public void testConfigure()
	{
		URI src = URI.createURI("http://host/src");
		URI dest = URI.createURI("http://host/dest");
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("src", src.toString());
		properties.put("dest", dest.toString());

		uriMapProviderComponent.configure(properties);

		assertThat(uriMapProviderComponent.getUriMap().size(), is(1));
		assertTrue(uriMapProviderComponent.getUriMap().keySet().iterator().next().equals(src));
		assertTrue(uriMapProviderComponent.getUriMap().values().iterator().next().equals(dest));
	}
}
