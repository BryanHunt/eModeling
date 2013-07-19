/**
 */
package org.eclipselabs.emodeling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.emodeling.EmodelingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel suppressInterfaces='true' containmentProxies='true' basePackage='org.eclipselabs'"
 * @generated
 */
public class EmodelingPackage extends EPackageImpl
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNAME = "emodeling";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_URI = "org.eclipselabs.emodeling";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_PREFIX = "emodeling";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final EmodelingPackage eINSTANCE = org.eclipselabs.emodeling.EmodelingPackage.init();

  /**
   * The meta object id for the '{@link org.eclipselabs.emodeling.ECollection <em>ECollection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.emodeling.ECollection
   * @see org.eclipselabs.emodeling.EmodelingPackage#getECollection()
   * @generated
   */
  public static final int ECOLLECTION = 0;

  /**
   * The number of structural features of the '<em>ECollection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ECOLLECTION_FEATURE_COUNT = 0;

  /**
   * The operation id for the '<em>Get Values</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ECOLLECTION___GET_VALUES = 0;

  /**
   * The number of operations of the '<em>ECollection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ECOLLECTION_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.emodeling.EContainmentCollection <em>EContainment Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.emodeling.EContainmentCollection
   * @see org.eclipselabs.emodeling.EmodelingPackage#getEContainmentCollection()
   * @generated
   */
  public static final int ECONTAINMENT_COLLECTION = 1;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ECONTAINMENT_COLLECTION__VALUES = ECOLLECTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EContainment Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ECONTAINMENT_COLLECTION_FEATURE_COUNT = ECOLLECTION_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Values</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ECONTAINMENT_COLLECTION___GET_VALUES = ECOLLECTION___GET_VALUES;

  /**
   * The number of operations of the '<em>EContainment Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ECONTAINMENT_COLLECTION_OPERATION_COUNT = ECOLLECTION_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.emodeling.EReferenceCollection <em>EReference Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.emodeling.EReferenceCollection
   * @see org.eclipselabs.emodeling.EmodelingPackage#getEReferenceCollection()
   * @generated
   */
  public static final int EREFERENCE_COLLECTION = 2;

  /**
   * The feature id for the '<em><b>Values</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int EREFERENCE_COLLECTION__VALUES = ECOLLECTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EReference Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int EREFERENCE_COLLECTION_FEATURE_COUNT = ECOLLECTION_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Values</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int EREFERENCE_COLLECTION___GET_VALUES = ECOLLECTION___GET_VALUES;

  /**
   * The number of operations of the '<em>EReference Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int EREFERENCE_COLLECTION_OPERATION_COUNT = ECOLLECTION_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '<em>EList</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.EList
   * @see org.eclipselabs.emodeling.EmodelingPackage#getEList()
   * @generated
   */
  public static final int ELIST = 3;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eContainmentCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eReferenceCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType eListEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipselabs.emodeling.EmodelingPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EmodelingPackage()
  {
    super(eNS_URI, EmodelingFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link EmodelingPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EmodelingPackage init()
  {
    if (isInited) return (EmodelingPackage)EPackage.Registry.INSTANCE.getEPackage(EmodelingPackage.eNS_URI);

    // Obtain or create and register package
    EmodelingPackage theEmodelingPackage = (EmodelingPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EmodelingPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EmodelingPackage());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theEmodelingPackage.createPackageContents();

    // Initialize created meta-data
    theEmodelingPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEmodelingPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EmodelingPackage.eNS_URI, theEmodelingPackage);
    return theEmodelingPackage;
  }


  /**
   * Returns the meta object for class '{@link org.eclipselabs.emodeling.ECollection <em>ECollection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ECollection</em>'.
   * @see org.eclipselabs.emodeling.ECollection
   * @generated
   */
  public EClass getECollection()
  {
    return eCollectionEClass;
  }

  /**
   * Returns the meta object for the '{@link org.eclipselabs.emodeling.ECollection#getValues() <em>Get Values</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Values</em>' operation.
   * @see org.eclipselabs.emodeling.ECollection#getValues()
   * @generated
   */
  public EOperation getECollection__GetValues()
  {
    return eCollectionEClass.getEOperations().get(0);
  }

  /**
   * Returns the meta object for class '{@link org.eclipselabs.emodeling.EContainmentCollection <em>EContainment Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EContainment Collection</em>'.
   * @see org.eclipselabs.emodeling.EContainmentCollection
   * @generated
   */
  public EClass getEContainmentCollection()
  {
    return eContainmentCollectionEClass;
  }

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.emodeling.EContainmentCollection#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipselabs.emodeling.EContainmentCollection#getValues()
   * @see #getEContainmentCollection()
   * @generated
   */
  public EReference getEContainmentCollection_Values()
  {
    return (EReference)eContainmentCollectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for class '{@link org.eclipselabs.emodeling.EReferenceCollection <em>EReference Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EReference Collection</em>'.
   * @see org.eclipselabs.emodeling.EReferenceCollection
   * @generated
   */
  public EClass getEReferenceCollection()
  {
    return eReferenceCollectionEClass;
  }

  /**
   * Returns the meta object for the reference list '{@link org.eclipselabs.emodeling.EReferenceCollection#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Values</em>'.
   * @see org.eclipselabs.emodeling.EReferenceCollection#getValues()
   * @see #getEReferenceCollection()
   * @generated
   */
  public EReference getEReferenceCollection_Values()
  {
    return (EReference)eReferenceCollectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for data type '{@link org.eclipse.emf.common.util.EList <em>EList</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>EList</em>'.
   * @see org.eclipse.emf.common.util.EList
   * @model instanceClass="org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject>"
   * @generated
   */
  public EDataType getEList()
  {
    return eListEDataType;
  }

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  public EmodelingFactory getEmodelingFactory()
  {
    return (EmodelingFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    eCollectionEClass = createEClass(ECOLLECTION);
    createEOperation(eCollectionEClass, ECOLLECTION___GET_VALUES);

    eContainmentCollectionEClass = createEClass(ECONTAINMENT_COLLECTION);
    createEReference(eContainmentCollectionEClass, ECONTAINMENT_COLLECTION__VALUES);

    eReferenceCollectionEClass = createEClass(EREFERENCE_COLLECTION);
    createEReference(eReferenceCollectionEClass, EREFERENCE_COLLECTION__VALUES);

    // Create data types
    eListEDataType = createEDataType(ELIST);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    eContainmentCollectionEClass.getESuperTypes().add(this.getECollection());
    eReferenceCollectionEClass.getESuperTypes().add(this.getECollection());

    // Initialize classes, features, and operations; add parameters
    initEClass(eCollectionEClass, ECollection.class, "ECollection", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getECollection__GetValues(), this.getEList(), "getValues", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(eContainmentCollectionEClass, EContainmentCollection.class, "EContainmentCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEContainmentCollection_Values(), theEcorePackage.getEObject(), null, "values", null, 0, -1, EContainmentCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eReferenceCollectionEClass, EReferenceCollection.class, "EReferenceCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEReferenceCollection_Values(), theEcorePackage.getEObject(), null, "values", null, 0, -1, EReferenceCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(eListEDataType, EList.class, "EList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject>");

    // Create resource
    createResource(eNS_URI);
  }

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  public interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipselabs.emodeling.ECollection <em>ECollection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.emodeling.ECollection
     * @see org.eclipselabs.emodeling.EmodelingPackage#getECollection()
     * @generated
     */
    public static final EClass ECOLLECTION = eINSTANCE.getECollection();

    /**
     * The meta object literal for the '<em><b>Get Values</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation ECOLLECTION___GET_VALUES = eINSTANCE.getECollection__GetValues();

    /**
     * The meta object literal for the '{@link org.eclipselabs.emodeling.EContainmentCollection <em>EContainment Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.emodeling.EContainmentCollection
     * @see org.eclipselabs.emodeling.EmodelingPackage#getEContainmentCollection()
     * @generated
     */
    public static final EClass ECONTAINMENT_COLLECTION = eINSTANCE.getEContainmentCollection();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference ECONTAINMENT_COLLECTION__VALUES = eINSTANCE.getEContainmentCollection_Values();

    /**
     * The meta object literal for the '{@link org.eclipselabs.emodeling.EReferenceCollection <em>EReference Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.emodeling.EReferenceCollection
     * @see org.eclipselabs.emodeling.EmodelingPackage#getEReferenceCollection()
     * @generated
     */
    public static final EClass EREFERENCE_COLLECTION = eINSTANCE.getEReferenceCollection();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference EREFERENCE_COLLECTION__VALUES = eINSTANCE.getEReferenceCollection_Values();

    /**
     * The meta object literal for the '<em>EList</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.EList
     * @see org.eclipselabs.emodeling.EmodelingPackage#getEList()
     * @generated
     */
    public static final EDataType ELIST = eINSTANCE.getEList();

  }

} //EmodelingPackage
