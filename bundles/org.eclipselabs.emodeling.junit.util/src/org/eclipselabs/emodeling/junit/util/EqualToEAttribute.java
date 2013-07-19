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

package org.eclipselabs.emodeling.junit.util;

import static org.hamcrest.CoreMatchers.equalTo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * @author bhunt
 * 
 */
public class EqualToEAttribute extends TypeSafeDiagnosingMatcher<EObject>
{
	private EObject eObject;
	private EAttribute attribute;

	public static Matcher<? super EObject> equalToEAttribute(EObject eObject, EAttribute attribute)
	{
		return new EqualToEAttribute(eObject, attribute);
	}

	public EqualToEAttribute(EObject eObject, EAttribute attribute)
	{
		this.eObject = eObject;
		this.attribute = attribute;
	}

	@Override
	public void describeTo(Description description)
	{
		Object value = eObject.eGet(attribute);
		description.appendText(attribute.getName()).appendText(" : ").appendText(value != null ? value.toString() : "null");
	}

	@Override
	protected boolean matchesSafely(EObject expected, Description description)
	{
		if (!equalTo(eObject.eGet(attribute)).matches(expected.eGet(attribute)))
		{
			description.appendDescriptionOf(new EqualToEAttribute(expected, attribute));
			return false;
		}

		return true;
	}
}
