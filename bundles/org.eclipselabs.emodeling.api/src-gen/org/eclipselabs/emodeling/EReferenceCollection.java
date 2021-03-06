/**
 */
package org.eclipselabs.emodeling;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EReference Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emodeling.EReferenceCollection#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emodeling.EmodelingPackage#getEReferenceCollection()
 * @model kind="class"
 * @generated
 */
public class EReferenceCollection extends MinimalEObjectImpl.Container implements ECollection
{
  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<EObject> values;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EReferenceCollection()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EmodelingPackage.Literals.EREFERENCE_COLLECTION;
  }

  /**
   * Returns the value of the '<em><b>Values</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' reference list.
   * @see org.eclipselabs.emodeling.EmodelingPackage#getEReferenceCollection_Values()
   * @model
   * @generated
   */
  public EList<EObject> getValues()
  {
    if (values == null)
    {
      values = new EObjectResolvingEList<EObject>(EObject.class, this, EmodelingPackage.EREFERENCE_COLLECTION__VALUES);
    }
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EmodelingPackage.EREFERENCE_COLLECTION__VALUES:
        return getValues();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EmodelingPackage.EREFERENCE_COLLECTION__VALUES:
        getValues().clear();
        getValues().addAll((Collection<? extends EObject>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EmodelingPackage.EREFERENCE_COLLECTION__VALUES:
        getValues().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EmodelingPackage.EREFERENCE_COLLECTION__VALUES:
        return values != null && !values.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // EReferenceCollection
