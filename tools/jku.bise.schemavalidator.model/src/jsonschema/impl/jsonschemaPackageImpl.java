/**
 */
package jsonschema.impl;

import jsonschema.BaseSyntaxError;
import jsonschema.BaseSyntaxErrorType;
import jsonschema.JSONSchemaFile;
import jsonschema.JSONSchemaVersion;
import jsonschema.Measure;
import jsonschema.Metric;
import jsonschema.MetricType;
import jsonschema.Model;
import jsonschema.ValidationError;
import jsonschema.jsonschemaFactory;
import jsonschema.jsonschemaPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class jsonschemaPackageImpl extends EPackageImpl implements jsonschemaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jsonSchemaFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jsonSchemaVersionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseSyntaxErrorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validationErrorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum metricTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum baseSyntaxErrorTypeEEnum = null;

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
	 * @see jsonschema.jsonschemaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private jsonschemaPackageImpl() {
		super(eNS_URI, jsonschemaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link jsonschemaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static jsonschemaPackage init() {
		if (isInited) return (jsonschemaPackage)EPackage.Registry.INSTANCE.getEPackage(jsonschemaPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredjsonschemaPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		jsonschemaPackageImpl thejsonschemaPackage = registeredjsonschemaPackage instanceof jsonschemaPackageImpl ? (jsonschemaPackageImpl)registeredjsonschemaPackage : new jsonschemaPackageImpl();

		isInited = true;

		// Create package meta-data objects
		thejsonschemaPackage.createPackageContents();

		// Initialize created meta-data
		thejsonschemaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thejsonschemaPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(jsonschemaPackage.eNS_URI, thejsonschemaPackage);
		return thejsonschemaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModel_JsonFiles() {
		return (EReference)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModel_Metrics() {
		return (EReference)modelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModel_Versions() {
		return (EReference)modelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJSONSchemaFile() {
		return jsonSchemaFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJSONSchemaFile_Duplicates() {
		return (EReference)jsonSchemaFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJSONSchemaFile_FileName() {
		return (EAttribute)jsonSchemaFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJSONSchemaFile_Version() {
		return (EReference)jsonSchemaFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJSONSchemaFile_Errors() {
		return (EReference)jsonSchemaFileEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJSONSchemaFile_Measures() {
		return (EReference)jsonSchemaFileEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJSONSchemaFile_GithubRepoFullname() {
		return (EAttribute)jsonSchemaFileEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJSONSchemaFile_GithubFilePath() {
		return (EAttribute)jsonSchemaFileEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJSONSchemaVersion() {
		return jsonSchemaVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJSONSchemaVersion_DraftName() {
		return (EAttribute)jsonSchemaVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJSONSchemaVersion_DraftURL() {
		return (EAttribute)jsonSchemaVersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getError() {
		return errorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBaseSyntaxError() {
		return baseSyntaxErrorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseSyntaxError_Type() {
		return (EAttribute)baseSyntaxErrorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValidationError() {
		return validationErrorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidationError_Keyword() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidationError_Pointer() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidationError_Level() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidationError_Message() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidationError_ExtendedMessage() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMeasure() {
		return measureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMeasure_Value() {
		return (EAttribute)measureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMeasure_Metric() {
		return (EReference)measureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetric() {
		return metricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetric_Type() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetric_Name() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getMetricType() {
		return metricTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getBaseSyntaxErrorType() {
		return baseSyntaxErrorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public jsonschemaFactory getjsonschemaFactory() {
		return (jsonschemaFactory)getEFactoryInstance();
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
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modelEClass = createEClass(MODEL);
		createEReference(modelEClass, MODEL__JSON_FILES);
		createEReference(modelEClass, MODEL__METRICS);
		createEReference(modelEClass, MODEL__VERSIONS);

		jsonSchemaFileEClass = createEClass(JSON_SCHEMA_FILE);
		createEReference(jsonSchemaFileEClass, JSON_SCHEMA_FILE__DUPLICATES);
		createEAttribute(jsonSchemaFileEClass, JSON_SCHEMA_FILE__FILE_NAME);
		createEReference(jsonSchemaFileEClass, JSON_SCHEMA_FILE__VERSION);
		createEReference(jsonSchemaFileEClass, JSON_SCHEMA_FILE__ERRORS);
		createEReference(jsonSchemaFileEClass, JSON_SCHEMA_FILE__MEASURES);
		createEAttribute(jsonSchemaFileEClass, JSON_SCHEMA_FILE__GITHUB_REPO_FULLNAME);
		createEAttribute(jsonSchemaFileEClass, JSON_SCHEMA_FILE__GITHUB_FILE_PATH);

		jsonSchemaVersionEClass = createEClass(JSON_SCHEMA_VERSION);
		createEAttribute(jsonSchemaVersionEClass, JSON_SCHEMA_VERSION__DRAFT_NAME);
		createEAttribute(jsonSchemaVersionEClass, JSON_SCHEMA_VERSION__DRAFT_URL);

		errorEClass = createEClass(ERROR);

		baseSyntaxErrorEClass = createEClass(BASE_SYNTAX_ERROR);
		createEAttribute(baseSyntaxErrorEClass, BASE_SYNTAX_ERROR__TYPE);

		validationErrorEClass = createEClass(VALIDATION_ERROR);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__KEYWORD);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__POINTER);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__LEVEL);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__MESSAGE);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__EXTENDED_MESSAGE);

		measureEClass = createEClass(MEASURE);
		createEAttribute(measureEClass, MEASURE__VALUE);
		createEReference(measureEClass, MEASURE__METRIC);

		metricEClass = createEClass(METRIC);
		createEAttribute(metricEClass, METRIC__TYPE);
		createEAttribute(metricEClass, METRIC__NAME);

		// Create enums
		metricTypeEEnum = createEEnum(METRIC_TYPE);
		baseSyntaxErrorTypeEEnum = createEEnum(BASE_SYNTAX_ERROR_TYPE);
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
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		baseSyntaxErrorEClass.getESuperTypes().add(this.getError());
		validationErrorEClass.getESuperTypes().add(this.getError());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_JsonFiles(), this.getJSONSchemaFile(), null, "jsonFiles", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Metrics(), this.getMetric(), null, "metrics", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Versions(), this.getJSONSchemaVersion(), null, "versions", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jsonSchemaFileEClass, JSONSchemaFile.class, "JSONSchemaFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJSONSchemaFile_Duplicates(), this.getJSONSchemaFile(), null, "duplicates", null, 0, -1, JSONSchemaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJSONSchemaFile_FileName(), ecorePackage.getEString(), "fileName", null, 1, 1, JSONSchemaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJSONSchemaFile_Version(), this.getJSONSchemaVersion(), null, "version", null, 0, 1, JSONSchemaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJSONSchemaFile_Errors(), this.getError(), null, "errors", null, 0, -1, JSONSchemaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJSONSchemaFile_Measures(), this.getMeasure(), null, "measures", null, 0, -1, JSONSchemaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJSONSchemaFile_GithubRepoFullname(), ecorePackage.getEString(), "githubRepoFullname", null, 0, 1, JSONSchemaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJSONSchemaFile_GithubFilePath(), ecorePackage.getEString(), "githubFilePath", null, 0, 1, JSONSchemaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jsonSchemaVersionEClass, JSONSchemaVersion.class, "JSONSchemaVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJSONSchemaVersion_DraftName(), ecorePackage.getEString(), "draftName", null, 0, 1, JSONSchemaVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJSONSchemaVersion_DraftURL(), ecorePackage.getEString(), "draftURL", null, 0, 1, JSONSchemaVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorEClass, jsonschema.Error.class, "Error", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(baseSyntaxErrorEClass, BaseSyntaxError.class, "BaseSyntaxError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBaseSyntaxError_Type(), this.getBaseSyntaxErrorType(), "type", null, 0, 1, BaseSyntaxError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validationErrorEClass, ValidationError.class, "ValidationError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValidationError_Keyword(), ecorePackage.getEString(), "keyword", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_Pointer(), ecorePackage.getEString(), "pointer", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_Level(), ecorePackage.getEString(), "level", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_Message(), ecorePackage.getEString(), "message", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_ExtendedMessage(), ecorePackage.getEString(), "extendedMessage", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(measureEClass, Measure.class, "Measure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasure_Value(), ecorePackage.getEFloat(), "value", null, 0, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMeasure_Metric(), this.getMetric(), null, "metric", null, 1, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricEClass, Metric.class, "Metric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetric_Type(), this.getMetricType(), "type", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Name(), ecorePackage.getEString(), "name", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(metricTypeEEnum, MetricType.class, "MetricType");
		addEEnumLiteral(metricTypeEEnum, MetricType.GRAPH_BASED);
		addEEnumLiteral(metricTypeEEnum, MetricType.KEYWORD_USAGE);
		addEEnumLiteral(metricTypeEEnum, MetricType.TYPE_USAGE);

		initEEnum(baseSyntaxErrorTypeEEnum, BaseSyntaxErrorType.class, "BaseSyntaxErrorType");
		addEEnumLiteral(baseSyntaxErrorTypeEEnum, BaseSyntaxErrorType.SCHEMA_NOT_SUPPORTED);
		addEEnumLiteral(baseSyntaxErrorTypeEEnum, BaseSyntaxErrorType.SCHEMA_NOT_FOUND);
		addEEnumLiteral(baseSyntaxErrorTypeEEnum, BaseSyntaxErrorType.UNPARSABLE_JSON);

		// Create resource
		createResource(eNS_URI);
	}

} //jsonschemaPackageImpl
