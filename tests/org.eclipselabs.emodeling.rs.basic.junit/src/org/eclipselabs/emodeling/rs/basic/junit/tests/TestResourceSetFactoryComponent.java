/**
 * 
 */

package org.eclipselabs.emodeling.rs.basic.junit.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emodeling.ResourceSetConfigurator;
import org.eclipselabs.emodeling.rs.basic.ResourceSetFactoryComponent;
import org.junit.Before;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestResourceSetFactoryComponent
{
	private ResourceSetFactoryComponent resourceSetFactory;

	@Before
	public void setUp()
	{
		resourceSetFactory = new ResourceSetFactoryComponent();
	}

	@Test
	public void testCreateResourceSet()
	{
		ResourceSet resourceSet = resourceSetFactory.createResourceSet();
		assertThat(resourceSet, is(notNullValue()));
		assertThat(resourceSetFactory.createResourceSet(), is(not(sameInstance(resourceSet))));
	}

	@Test
	public void testBindResourceSetConfigurator()
	{
		ResourceSetConfigurator resourceSetConfigurator = mock(ResourceSetConfigurator.class);
		resourceSetFactory.bindResourceSetConfigurator(resourceSetConfigurator);
		ResourceSet resourceSet = resourceSetFactory.createResourceSet();
		assertThat(resourceSet, is(notNullValue()));
		assertThat(resourceSetFactory.getResourceSetConfigurators().size(), is(1));
		verify(resourceSetConfigurator).configureResourceSet(resourceSet);
	}

	@Test
	public void testUnbindResourceSetConfigurator()
	{
		ResourceSetConfigurator resourceSetConfigurator = mock(ResourceSetConfigurator.class);
		resourceSetFactory.bindResourceSetConfigurator(resourceSetConfigurator);
		resourceSetFactory.unbindResourceSetConfigurator(resourceSetConfigurator);
		ResourceSet resourceSet = resourceSetFactory.createResourceSet();
		assertThat(resourceSet, is(notNullValue()));
		verifyNoMoreInteractions(resourceSetConfigurator);
	}
}
