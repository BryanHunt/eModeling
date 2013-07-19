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

package org.eclipselabs.emodeling.example;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emodeling.ResourceSetFactory;
import org.eclipselabs.emodeling.example.model.ModelFactory;
import org.eclipselabs.emodeling.example.model.Person;

/**
 * @author bhunt
 * 
 */
public class ExampleComponent
{
	private volatile ResourceSetFactory resourceSetFactory;

	public void activate() throws IOException
	{
		System.out.println("ExampleComponent.activate()");
		Person person = ModelFactory.eINSTANCE.createPerson();
		person.setFirstName("Ed");
		person.setLastName("Merks");

		ResourceSet resourceSet = resourceSetFactory.createResourceSet();
		Resource resource = resourceSet.createResource(URI.createFileURI("/tmp/model.xml"));
		resource.getContents().add(person);
		resource.save(null);
		System.out.println("ExampleComponent saved model to /tmp/model.xml");
	}

	public void bindResourceSetFactory(ResourceSetFactory resourceSetFactory)
	{
		this.resourceSetFactory = resourceSetFactory;
	}
}
