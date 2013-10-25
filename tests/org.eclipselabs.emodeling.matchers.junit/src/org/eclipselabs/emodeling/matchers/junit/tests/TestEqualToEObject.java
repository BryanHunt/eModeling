/**
 * 
 */

package org.eclipselabs.emodeling.matchers.junit.tests;

import static org.eclipselabs.emodeling.matchers.EqualToEObject.equalToEObject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.emodeling.matchers.junit.model.Child;
import org.eclipselabs.emodeling.matchers.junit.model.ModelFactory;
import org.eclipselabs.emodeling.matchers.junit.model.ModelPackage;
import org.eclipselabs.emodeling.matchers.junit.model.Parent;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestEqualToEObject
{
	@Test
	public void testMatchesChild()
	{
		Child child1 = ModelFactory.eINSTANCE.createChild();
		child1.setName("junit");
		child1.setAge(10);

		Child child2 = ModelFactory.eINSTANCE.createChild();
		child2.setName("junit");
		child2.setAge(10);

		assertThat(child1, is(equalToEObject(child2)));
	}

	@Test
	public void testMatchesParent()
	{
		Parent parent1 = ModelFactory.eINSTANCE.createParent();
		parent1.setName("parent");

		Parent parent2 = ModelFactory.eINSTANCE.createParent();
		parent2.setName("parent");

		assertThat(parent1, is(equalToEObject(parent2)));
	}

	@Test
	public void testMatchesParentChild()
	{
		Parent parent1 = ModelFactory.eINSTANCE.createParent();
		parent1.setName("parent");

		Parent parent2 = ModelFactory.eINSTANCE.createParent();
		parent2.setName("parent");

		Child child1 = ModelFactory.eINSTANCE.createChild();
		child1.setName("junit");
		child1.setAge(10);

		Child child2 = ModelFactory.eINSTANCE.createChild();
		child2.setName("junit");
		child2.setAge(10);

		parent1.getChildren().add(child1);
		parent2.getChildren().add(child2);
		assertThat(parent1, is(equalToEObject(parent2)));
	}

	@Test
	public void testNotMatchesChild()
	{
		Child child1 = ModelFactory.eINSTANCE.createChild();
		child1.setName("junit");
		child1.setAge(10);

		Child child2 = ModelFactory.eINSTANCE.createChild();
		child2.setName("junit");
		child2.setAge(11);

		assertThat(child1, is(not(equalToEObject(child2))));
	}

	@Test
	public void testNotMatchesParent()
	{
		Parent parent1 = ModelFactory.eINSTANCE.createParent();
		parent1.setName("");

		Parent parent2 = ModelFactory.eINSTANCE.createParent();
		parent2.setName("parent");

		assertThat(parent1, is(not(equalToEObject(parent2))));
	}

	@Test
	public void testNotMatchesParentChild1()
	{
		Parent parent1 = ModelFactory.eINSTANCE.createParent();
		parent1.setName("parent");

		Parent parent2 = ModelFactory.eINSTANCE.createParent();
		parent2.setName("parent");

		Child child1 = ModelFactory.eINSTANCE.createChild();
		child1.setName("junit");
		child1.setAge(10);

		Child child2 = ModelFactory.eINSTANCE.createChild();
		child2.setName("junit");
		child2.setAge(10);

		parent1.getChildren().add(child1);

		assertThat(parent1, is(not(equalToEObject(parent2))));
	}

	@Test
	public void testNotMatchesParentChild2()
	{
		Parent parent1 = ModelFactory.eINSTANCE.createParent();
		parent1.setName("parent");

		Parent parent2 = ModelFactory.eINSTANCE.createParent();
		parent2.setName("parent");

		Child child1 = ModelFactory.eINSTANCE.createChild();
		child1.setName("junit");
		child1.setAge(10);

		Child child2 = ModelFactory.eINSTANCE.createChild();
		child2.setName("junit");
		child2.setAge(10);

		parent2.getChildren().add(child2);

		assertThat(parent1, is(not(equalToEObject(parent2))));
	}

	@Test
	public void testNotMatchesParentChild3()
	{
		Parent parent1 = ModelFactory.eINSTANCE.createParent();
		parent1.setName("parent");

		Parent parent2 = ModelFactory.eINSTANCE.createParent();
		parent2.setName("parent");

		Child child1 = ModelFactory.eINSTANCE.createChild();
		child1.setName("junit");
		child1.setAge(10);

		Child child2 = ModelFactory.eINSTANCE.createChild();
		child2.setName("junit");
		child2.setAge(11);

		parent1.getChildren().add(child1);
		parent2.getChildren().add(child2);

		assertThat(parent1, is(not(equalToEObject(parent2))));
	}

	@Test
	public void testMatchesWithExclusion()
	{
		Parent parent1 = ModelFactory.eINSTANCE.createParent();
		parent1.setName("parent");

		Parent parent2 = ModelFactory.eINSTANCE.createParent();
		parent2.setName("parent");

		Child child1 = ModelFactory.eINSTANCE.createChild();
		child1.setName("junit");
		child1.setAge(10);

		Child child2 = ModelFactory.eINSTANCE.createChild();
		child2.setName("junit");
		child2.setAge(11);

		parent1.getChildren().add(child1);
		parent2.getChildren().add(child2);

		Set<EStructuralFeature> excludedFeatures = new HashSet<EStructuralFeature>();
		excludedFeatures.add(ModelPackage.Literals.CHILD__AGE);

		assertThat(parent1, is(equalToEObject(parent2, excludedFeatures)));
	}

}
