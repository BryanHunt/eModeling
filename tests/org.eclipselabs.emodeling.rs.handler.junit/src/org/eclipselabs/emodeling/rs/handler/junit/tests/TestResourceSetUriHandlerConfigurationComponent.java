/**
 * 
 */

package org.eclipselabs.emodeling.rs.handler.junit.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipselabs.emodeling.UriHandlerProvider;
import org.eclipselabs.emodeling.UriMapProvider;
import org.eclipselabs.emodeling.rs.handler.ResourceSetUriHandlerConfiguratorComponent;
import org.junit.Before;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestResourceSetUriHandlerConfigurationComponent
{
	private ResourceSetUriHandlerConfiguratorComponent resourceSetUriHandlerConfiguratorComponent;

	@Before
	public void setUp()
	{
		resourceSetUriHandlerConfiguratorComponent = new ResourceSetUriHandlerConfiguratorComponent();
	}

	@Test
	public void testConfigureResourceSet()
	{
		ResourceSet resourceSet = mock(ResourceSet.class);
		URIConverter uriConverter = mock(URIConverter.class);

		when(resourceSet.getURIConverter()).thenReturn(uriConverter);
		when(uriConverter.getURIHandlers()).thenReturn(null);
		when(uriConverter.getURIMap()).thenReturn(null);
		resourceSetUriHandlerConfiguratorComponent.configureResourceSet(resourceSet);
		verify(resourceSet).getURIConverter();
		verify(uriConverter).getURIHandlers();
		verify(uriConverter).getURIMap();
		verifyNoMoreInteractions(resourceSet, uriConverter);
	}

	@Test
	public void testConfigureResourceWithUriHandlerProvider()
	{
		ResourceSet resourceSet = mock(ResourceSet.class);
		URIConverter uriConverter = mock(URIConverter.class);
		URIHandler uriHandler = mock(URIHandler.class);
		UriHandlerProvider handlerProvider = mock(UriHandlerProvider.class);
		EList<URIHandler> uriHandlers = new BasicEList<URIHandler>();
		uriHandlers.add(mock(URIHandler.class));

		when(resourceSet.getURIConverter()).thenReturn(uriConverter);
		when(uriConverter.getURIHandlers()).thenReturn(uriHandlers);
		when(uriConverter.getURIMap()).thenReturn(null);
		when(handlerProvider.getURIHandler()).thenReturn(uriHandler);

		resourceSetUriHandlerConfiguratorComponent.bindUriHandlerProvider(handlerProvider);
		resourceSetUriHandlerConfiguratorComponent.configureResourceSet(resourceSet);
		verify(resourceSet).getURIConverter();
		verify(uriConverter).getURIHandlers();
		verify(handlerProvider).getURIHandler();
		verify(uriConverter).getURIMap();
		verifyNoMoreInteractions(resourceSet, uriConverter);
		assertThat(uriHandlers.size(), is(2));
		assertThat(uriHandlers.get(0), is(sameInstance(uriHandler)));
	}

	@Test
	public void testConfigureResourceWithUriMap()
	{
		ResourceSet resourceSet = mock(ResourceSet.class);
		URIConverter uriConverter = mock(URIConverter.class);
		UriMapProvider mapProvider = mock(UriMapProvider.class);
		Map<URI, URI> expectedUriMap = new HashMap<URI, URI>();
		Map<URI, URI> actualUriMap = new HashMap<URI, URI>();

		expectedUriMap.put(URI.createURI("http://host/key1"), URI.createURI("http://host/value1"));
		expectedUriMap.put(URI.createURI("http://host/key2"), URI.createURI("http://host/value2"));

		when(resourceSet.getURIConverter()).thenReturn(uriConverter);
		when(uriConverter.getURIMap()).thenReturn(actualUriMap);
		when(mapProvider.getUriMap()).thenReturn(expectedUriMap);

		resourceSetUriHandlerConfiguratorComponent.bindUriMapProvider(mapProvider);
		resourceSetUriHandlerConfiguratorComponent.configureResourceSet(resourceSet);
		verify(resourceSet).getURIConverter();
		verify(uriConverter).getURIHandlers();
		verify(mapProvider).getUriMap();
		verify(uriConverter).getURIMap();
		verifyNoMoreInteractions(resourceSet, uriConverter);
		assertThat(actualUriMap.size(), is(2));
	}
}
