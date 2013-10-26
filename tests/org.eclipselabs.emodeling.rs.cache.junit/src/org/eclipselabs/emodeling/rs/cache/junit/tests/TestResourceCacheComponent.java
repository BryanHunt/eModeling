/**
 * 
 */

package org.eclipselabs.emodeling.rs.cache.junit.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emodeling.ResourceSetFactory;
import org.eclipselabs.emodeling.rs.cache.ResourceCacheComponent;
import org.junit.Before;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestResourceCacheComponent
{
	private ResourceCacheComponent resourceCacheComponent;

	@Before
	public void setUp()
	{
		resourceCacheComponent = new ResourceCacheComponent();
	}

	@Test
	public void testGetResourceSet()
	{
		ResourceSetFactory resourceSetFactory = mock(ResourceSetFactory.class);
		ResourceSet resourceSet = mock(ResourceSet.class);

		resourceCacheComponent.bindResourceSetFactory(resourceSetFactory);
		when(resourceSetFactory.createResourceSet()).thenReturn(resourceSet);
		assertThat(resourceCacheComponent.getResourceSet(), is(sameInstance(resourceSet)));
		verify(resourceSetFactory).createResourceSet();
		assertThat(resourceCacheComponent.getResourceSet(), is(sameInstance(resourceSet)));
		verifyNoMoreInteractions(resourceSetFactory);
	}

	@Test
	public void testGetResourceSetWithoutFactory()
	{
		assertThat(resourceCacheComponent.getResourceSet(), is(nullValue()));
	}

	@Test
	public void testGetResourceAfterUnbind()
	{
		ResourceSetFactory resourceSetFactory = mock(ResourceSetFactory.class);
		ResourceSet resourceSet = mock(ResourceSet.class);

		resourceCacheComponent.bindResourceSetFactory(resourceSetFactory);
		when(resourceSetFactory.createResourceSet()).thenReturn(resourceSet);
		resourceCacheComponent.getResourceSet();
		resourceCacheComponent.unbindResourceSetFactory(resourceSetFactory);
		assertThat(resourceCacheComponent.getResourceSet(), is(sameInstance(resourceSet)));
	}
}
