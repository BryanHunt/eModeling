/*******************************************************************************
 * Copyright (c) 2013 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.emodeling.matchers;

import static org.eclipselabs.emodeling.matchers.EqualToEAttribute.equalToEAttribute;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * This is a Hamcrest matcher that compares two instances of EObject. All structural features
 * are compared.
 * 
 * @author bhunt
 */
public class EqualToEObject extends TypeSafeDiagnosingMatcher<EObject>
{
	private EObject expectedObject;
	private Set<EStructuralFeature> excludeFeatures;

	/**
	 * Factory function for creating a new matcher.
	 * 
	 * @param eObject the object to match against
	 * @return an instance of the matcher
	 */
	public static Matcher<? super EObject> equalToEObject(EObject eObject)
	{
		return new EqualToEObject(eObject);
	}

	/**
	 * Factory function for creating a new matcher.
	 * 
	 * @param eObject the object to match against
	 * @param excludeFeatures the structural features to exclude from matching
	 * @return an instance of the matcher
	 */
	public static Matcher<? super EObject> equalToEObject(EObject eObject, Set<EStructuralFeature> excludeFeatures)
	{
		return new EqualToEObject(eObject, excludeFeatures);
	}

	public EqualToEObject(EObject expected)
	{
		this(expected, new HashSet<EStructuralFeature>());
	}

	public EqualToEObject(EObject expected, Set<EStructuralFeature> excludeFeatures)
	{
		this.expectedObject = expected;
		this.excludeFeatures = excludeFeatures;
	}

	@Override
	public void describeTo(Description description)
	{
		describeObject(expectedObject, description, new HashSet<EObject>());
	}

	private void describeObject(EObject eObject, Description description, Set<EObject> visited)
	{
		if (eObject == null)
			return;

		description.appendText("{");

		if (visited.contains(eObject))
		{
			description.appendText("@see").appendText(eObject.eClass().getName()).appendText("}");
			return;
		}

		visited.add(eObject);
		boolean firstFeature = true;

		for (EAttribute attribute : eObject.eClass().getEAllAttributes())
		{

			if (!excludeFeatures.contains(attribute))
			{
				if (firstFeature)
					firstFeature = false;
				else
					description.appendText(", ");

				description.appendText(attribute.getName());
				description.appendText(" : ");
				description.appendText(eObject.eGet(attribute).toString());
			}
		}

		for (EReference reference : eObject.eClass().getEAllReferences())
		{
			if (excludeFeatures.contains(reference))
				continue;

			if (firstFeature)
				firstFeature = false;
			else
				description.appendText(", ");

			description.appendText(reference.getName()).appendText(" : ");

			if (reference.isMany())
			{
				@SuppressWarnings("unchecked")
				EList<EObject> values = (EList<EObject>) eObject.eGet(reference);

				for (EObject target : values)
					describeObject(target, description, visited);
			}
			else
				describeObject((EObject) eObject.eGet(reference), description, visited);
		}

		description.appendText("}");
	}

	@Override
	protected boolean matchesSafely(EObject actual, Description description)
	{
		return checkObject(expectedObject, actual, new HashSet<EObject>(), description);
	}

	private boolean checkObject(EObject expected, EObject actual, Set<EObject> visited, Description mismatchDescription)
	{
		if (expected == null && actual == null)
			return true;

		if (expected == null)
		{
			mismatchDescription.appendText("expected must not be null");
			return false;
		}

		if (actual == null)
		{
			mismatchDescription.appendText("actual must not be null");
			return false;
		}

		if (visited.contains(expected))
			return true;

		visited.add(expected);
		boolean matches = true;
		boolean firstFeature = true;

		mismatchDescription.appendText("{");

		for (EAttribute attribute : expected.eClass().getEAllAttributes())
		{
			if (!excludeFeatures.contains(attribute))
			{
				Matcher<? super EObject> matcher = equalToEAttribute(actual, attribute);

				if (firstFeature)
					firstFeature = false;
				else
					mismatchDescription.appendText(", ");

				mismatchDescription.appendDescriptionOf(matcher);

				if (!matcher.matches(expected))
					matches = false;
			}
		}

		for (EReference reference : expected.eClass().getEAllReferences())
		{
			if (excludeFeatures.contains(reference))
				continue;

			if (firstFeature)
				firstFeature = false;
			else
				mismatchDescription.appendText(", ");

			mismatchDescription.appendText(reference.getName()).appendText(" : ");

			if (reference.isMany())
			{
				@SuppressWarnings("unchecked")
				EList<EObject> expectedObjects = (EList<EObject>) expected.eGet(reference);
				@SuppressWarnings("unchecked")
				EList<EObject> actualObjects = (EList<EObject>) actual.eGet(reference);

				Matcher<? super Integer> sizeMatcher = equalTo(expectedObjects.size());

				if (!sizeMatcher.matches(actualObjects.size()))
				{
					sizeMatcher.describeMismatch(actualObjects.size(), mismatchDescription);
					matches = false;
				}
				else
				{
					for (int i = 0; i < expectedObjects.size(); i++)
					{
						if (!checkObject(expectedObjects.get(i), actualObjects.get(i), visited, mismatchDescription))
							matches = false;
					}
				}
			}
			else if (!checkObject((EObject) expected.eGet(reference), (EObject) actual.eGet(reference), visited, mismatchDescription))
				matches = false;
		}

		mismatchDescription.appendText("}");

		return matches;
	}
}
