/**
 * 
 */

package org.eclipselabs.emodeling.matchers.junit.tests;

import static org.eclipselabs.emodeling.matchers.EqualToEAttribute.equalToEAttribute;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.eclipselabs.emodeling.matchers.junit.model.Child;
import org.eclipselabs.emodeling.matchers.junit.model.ModelFactory;
import org.eclipselabs.emodeling.matchers.junit.model.ModelPackage;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestEqualToEAttributeMatcher
{
	@Test
	public void testMatches()
	{
		Child child1 = ModelFactory.eINSTANCE.createChild();
		child1.setName("junit");

		Child child2 = ModelFactory.eINSTANCE.createChild();
		child2.setName("junit");

		assertThat(child1, is(equalToEAttribute(child2, ModelPackage.Literals.CHILD__NAME)));
	}

	@Test
	public void testNotMatches()
	{
		Child child1 = ModelFactory.eINSTANCE.createChild();
		child1.setName("");

		Child child2 = ModelFactory.eINSTANCE.createChild();
		child2.setName("junit");

		assertThat(child1, is(not(equalToEAttribute(child2, ModelPackage.Literals.CHILD__NAME))));
	}
}
