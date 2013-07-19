/**
 */
package org.eclipselabs.emodeling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ECollection</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipselabs.emodeling.EmodelingPackage#getECollection()
 * @model kind="class" interface="true" abstract="true"
 * @generated
 */
public interface ECollection extends EObject
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" dataType="org.eclipselabs.emodeling.EList" unique="false"
   * @generated
   */
  EList<EObject> getValues();

} // ECollection
