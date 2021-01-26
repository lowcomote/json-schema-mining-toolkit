/**
 */
package jsonschema;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see jsonschema.jsonschemaFactory
 * @model kind="package"
 * @generated
 */
public interface jsonschemaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jsonschema";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://jku.bise.scemavalidator/jsonschema";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jsonschema";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	jsonschemaPackage eINSTANCE = jsonschema.impl.jsonschemaPackageImpl.init();

	/**
	 * The meta object id for the '{@link jsonschema.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.impl.ModelImpl
	 * @see jsonschema.impl.jsonschemaPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Json Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__JSON_FILES = 0;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__METRICS = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jsonschema.impl.JSONSchemaFileImpl <em>JSON Schema File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.impl.JSONSchemaFileImpl
	 * @see jsonschema.impl.jsonschemaPackageImpl#getJSONSchemaFile()
	 * @generated
	 */
	int JSON_SCHEMA_FILE = 1;

	/**
	 * The feature id for the '<em><b>Duplicates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_FILE__DUPLICATES = 0;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_FILE__FILE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_FILE__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_FILE__ERRORS = 3;

	/**
	 * The feature id for the '<em><b>Measures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_FILE__MEASURES = 4;

	/**
	 * The feature id for the '<em><b>Github Repo Fullname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_FILE__GITHUB_REPO_FULLNAME = 5;

	/**
	 * The feature id for the '<em><b>Github File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_FILE__GITHUB_FILE_PATH = 6;

	/**
	 * The number of structural features of the '<em>JSON Schema File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_FILE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>JSON Schema File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_FILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jsonschema.impl.JSONSchemaVersionImpl <em>JSON Schema Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.impl.JSONSchemaVersionImpl
	 * @see jsonschema.impl.jsonschemaPackageImpl#getJSONSchemaVersion()
	 * @generated
	 */
	int JSON_SCHEMA_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Draft Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_VERSION__DRAFT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Draft URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_VERSION__DRAFT_URL = 1;

	/**
	 * The number of structural features of the '<em>JSON Schema Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_VERSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>JSON Schema Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_SCHEMA_VERSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jsonschema.impl.ErrorImpl <em>Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.impl.ErrorImpl
	 * @see jsonschema.impl.jsonschemaPackageImpl#getError()
	 * @generated
	 */
	int ERROR = 3;

	/**
	 * The number of structural features of the '<em>Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jsonschema.impl.BaseSyntaxErrorImpl <em>Base Syntax Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.impl.BaseSyntaxErrorImpl
	 * @see jsonschema.impl.jsonschemaPackageImpl#getBaseSyntaxError()
	 * @generated
	 */
	int BASE_SYNTAX_ERROR = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_SYNTAX_ERROR__TYPE = ERROR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Base Syntax Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_SYNTAX_ERROR_FEATURE_COUNT = ERROR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Base Syntax Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_SYNTAX_ERROR_OPERATION_COUNT = ERROR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jsonschema.impl.ValidationErrorImpl <em>Validation Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.impl.ValidationErrorImpl
	 * @see jsonschema.impl.jsonschemaPackageImpl#getValidationError()
	 * @generated
	 */
	int VALIDATION_ERROR = 5;

	/**
	 * The feature id for the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__KEYWORD = ERROR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pointer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__POINTER = ERROR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__LEVEL = ERROR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__MESSAGE = ERROR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extended Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__EXTENDED_MESSAGE = ERROR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Validation Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR_FEATURE_COUNT = ERROR_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Validation Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR_OPERATION_COUNT = ERROR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jsonschema.impl.MeasureImpl <em>Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.impl.MeasureImpl
	 * @see jsonschema.impl.jsonschemaPackageImpl#getMeasure()
	 * @generated
	 */
	int MEASURE = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__METRIC = 1;

	/**
	 * The number of structural features of the '<em>Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jsonschema.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.impl.MetricImpl
	 * @see jsonschema.impl.jsonschemaPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = 1;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jsonschema.MetricType <em>Metric Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.MetricType
	 * @see jsonschema.impl.jsonschemaPackageImpl#getMetricType()
	 * @generated
	 */
	int METRIC_TYPE = 8;

	/**
	 * The meta object id for the '{@link jsonschema.BaseSyntaxErrorType <em>Base Syntax Error Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsonschema.BaseSyntaxErrorType
	 * @see jsonschema.impl.jsonschemaPackageImpl#getBaseSyntaxErrorType()
	 * @generated
	 */
	int BASE_SYNTAX_ERROR_TYPE = 9;


	/**
	 * Returns the meta object for class '{@link jsonschema.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see jsonschema.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link jsonschema.Model#getJsonFiles <em>Json Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Json Files</em>'.
	 * @see jsonschema.Model#getJsonFiles()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_JsonFiles();

	/**
	 * Returns the meta object for the containment reference list '{@link jsonschema.Model#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metrics</em>'.
	 * @see jsonschema.Model#getMetrics()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Metrics();

	/**
	 * Returns the meta object for class '{@link jsonschema.JSONSchemaFile <em>JSON Schema File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JSON Schema File</em>'.
	 * @see jsonschema.JSONSchemaFile
	 * @generated
	 */
	EClass getJSONSchemaFile();

	/**
	 * Returns the meta object for the reference list '{@link jsonschema.JSONSchemaFile#getDuplicates <em>Duplicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Duplicates</em>'.
	 * @see jsonschema.JSONSchemaFile#getDuplicates()
	 * @see #getJSONSchemaFile()
	 * @generated
	 */
	EReference getJSONSchemaFile_Duplicates();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.JSONSchemaFile#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see jsonschema.JSONSchemaFile#getFileName()
	 * @see #getJSONSchemaFile()
	 * @generated
	 */
	EAttribute getJSONSchemaFile_FileName();

	/**
	 * Returns the meta object for the containment reference '{@link jsonschema.JSONSchemaFile#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Version</em>'.
	 * @see jsonschema.JSONSchemaFile#getVersion()
	 * @see #getJSONSchemaFile()
	 * @generated
	 */
	EReference getJSONSchemaFile_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link jsonschema.JSONSchemaFile#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Errors</em>'.
	 * @see jsonschema.JSONSchemaFile#getErrors()
	 * @see #getJSONSchemaFile()
	 * @generated
	 */
	EReference getJSONSchemaFile_Errors();

	/**
	 * Returns the meta object for the containment reference list '{@link jsonschema.JSONSchemaFile#getMeasures <em>Measures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measures</em>'.
	 * @see jsonschema.JSONSchemaFile#getMeasures()
	 * @see #getJSONSchemaFile()
	 * @generated
	 */
	EReference getJSONSchemaFile_Measures();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.JSONSchemaFile#getGithubRepoFullname <em>Github Repo Fullname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Github Repo Fullname</em>'.
	 * @see jsonschema.JSONSchemaFile#getGithubRepoFullname()
	 * @see #getJSONSchemaFile()
	 * @generated
	 */
	EAttribute getJSONSchemaFile_GithubRepoFullname();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.JSONSchemaFile#getGithubFilePath <em>Github File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Github File Path</em>'.
	 * @see jsonschema.JSONSchemaFile#getGithubFilePath()
	 * @see #getJSONSchemaFile()
	 * @generated
	 */
	EAttribute getJSONSchemaFile_GithubFilePath();

	/**
	 * Returns the meta object for class '{@link jsonschema.JSONSchemaVersion <em>JSON Schema Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JSON Schema Version</em>'.
	 * @see jsonschema.JSONSchemaVersion
	 * @generated
	 */
	EClass getJSONSchemaVersion();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.JSONSchemaVersion#getDraftName <em>Draft Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Draft Name</em>'.
	 * @see jsonschema.JSONSchemaVersion#getDraftName()
	 * @see #getJSONSchemaVersion()
	 * @generated
	 */
	EAttribute getJSONSchemaVersion_DraftName();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.JSONSchemaVersion#getDraftURL <em>Draft URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Draft URL</em>'.
	 * @see jsonschema.JSONSchemaVersion#getDraftURL()
	 * @see #getJSONSchemaVersion()
	 * @generated
	 */
	EAttribute getJSONSchemaVersion_DraftURL();

	/**
	 * Returns the meta object for class '{@link jsonschema.Error <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error</em>'.
	 * @see jsonschema.Error
	 * @generated
	 */
	EClass getError();

	/**
	 * Returns the meta object for class '{@link jsonschema.BaseSyntaxError <em>Base Syntax Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Syntax Error</em>'.
	 * @see jsonschema.BaseSyntaxError
	 * @generated
	 */
	EClass getBaseSyntaxError();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.BaseSyntaxError#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see jsonschema.BaseSyntaxError#getType()
	 * @see #getBaseSyntaxError()
	 * @generated
	 */
	EAttribute getBaseSyntaxError_Type();

	/**
	 * Returns the meta object for class '{@link jsonschema.ValidationError <em>Validation Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validation Error</em>'.
	 * @see jsonschema.ValidationError
	 * @generated
	 */
	EClass getValidationError();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.ValidationError#getKeyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keyword</em>'.
	 * @see jsonschema.ValidationError#getKeyword()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Keyword();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.ValidationError#getPointer <em>Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pointer</em>'.
	 * @see jsonschema.ValidationError#getPointer()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Pointer();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.ValidationError#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see jsonschema.ValidationError#getLevel()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Level();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.ValidationError#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see jsonschema.ValidationError#getMessage()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Message();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.ValidationError#getExtendedMessage <em>Extended Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extended Message</em>'.
	 * @see jsonschema.ValidationError#getExtendedMessage()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_ExtendedMessage();

	/**
	 * Returns the meta object for class '{@link jsonschema.Measure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure</em>'.
	 * @see jsonschema.Measure
	 * @generated
	 */
	EClass getMeasure();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.Measure#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see jsonschema.Measure#getValue()
	 * @see #getMeasure()
	 * @generated
	 */
	EAttribute getMeasure_Value();

	/**
	 * Returns the meta object for the reference '{@link jsonschema.Measure#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric</em>'.
	 * @see jsonschema.Measure#getMetric()
	 * @see #getMeasure()
	 * @generated
	 */
	EReference getMeasure_Metric();

	/**
	 * Returns the meta object for class '{@link jsonschema.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see jsonschema.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.Metric#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see jsonschema.Metric#getType()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Type();

	/**
	 * Returns the meta object for the attribute '{@link jsonschema.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jsonschema.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for enum '{@link jsonschema.MetricType <em>Metric Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Metric Type</em>'.
	 * @see jsonschema.MetricType
	 * @generated
	 */
	EEnum getMetricType();

	/**
	 * Returns the meta object for enum '{@link jsonschema.BaseSyntaxErrorType <em>Base Syntax Error Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Base Syntax Error Type</em>'.
	 * @see jsonschema.BaseSyntaxErrorType
	 * @generated
	 */
	EEnum getBaseSyntaxErrorType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	jsonschemaFactory getjsonschemaFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link jsonschema.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.impl.ModelImpl
		 * @see jsonschema.impl.jsonschemaPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Json Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__JSON_FILES = eINSTANCE.getModel_JsonFiles();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__METRICS = eINSTANCE.getModel_Metrics();

		/**
		 * The meta object literal for the '{@link jsonschema.impl.JSONSchemaFileImpl <em>JSON Schema File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.impl.JSONSchemaFileImpl
		 * @see jsonschema.impl.jsonschemaPackageImpl#getJSONSchemaFile()
		 * @generated
		 */
		EClass JSON_SCHEMA_FILE = eINSTANCE.getJSONSchemaFile();

		/**
		 * The meta object literal for the '<em><b>Duplicates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON_SCHEMA_FILE__DUPLICATES = eINSTANCE.getJSONSchemaFile_Duplicates();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON_SCHEMA_FILE__FILE_NAME = eINSTANCE.getJSONSchemaFile_FileName();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON_SCHEMA_FILE__VERSION = eINSTANCE.getJSONSchemaFile_Version();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON_SCHEMA_FILE__ERRORS = eINSTANCE.getJSONSchemaFile_Errors();

		/**
		 * The meta object literal for the '<em><b>Measures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON_SCHEMA_FILE__MEASURES = eINSTANCE.getJSONSchemaFile_Measures();

		/**
		 * The meta object literal for the '<em><b>Github Repo Fullname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON_SCHEMA_FILE__GITHUB_REPO_FULLNAME = eINSTANCE.getJSONSchemaFile_GithubRepoFullname();

		/**
		 * The meta object literal for the '<em><b>Github File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON_SCHEMA_FILE__GITHUB_FILE_PATH = eINSTANCE.getJSONSchemaFile_GithubFilePath();

		/**
		 * The meta object literal for the '{@link jsonschema.impl.JSONSchemaVersionImpl <em>JSON Schema Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.impl.JSONSchemaVersionImpl
		 * @see jsonschema.impl.jsonschemaPackageImpl#getJSONSchemaVersion()
		 * @generated
		 */
		EClass JSON_SCHEMA_VERSION = eINSTANCE.getJSONSchemaVersion();

		/**
		 * The meta object literal for the '<em><b>Draft Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON_SCHEMA_VERSION__DRAFT_NAME = eINSTANCE.getJSONSchemaVersion_DraftName();

		/**
		 * The meta object literal for the '<em><b>Draft URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON_SCHEMA_VERSION__DRAFT_URL = eINSTANCE.getJSONSchemaVersion_DraftURL();

		/**
		 * The meta object literal for the '{@link jsonschema.impl.ErrorImpl <em>Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.impl.ErrorImpl
		 * @see jsonschema.impl.jsonschemaPackageImpl#getError()
		 * @generated
		 */
		EClass ERROR = eINSTANCE.getError();

		/**
		 * The meta object literal for the '{@link jsonschema.impl.BaseSyntaxErrorImpl <em>Base Syntax Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.impl.BaseSyntaxErrorImpl
		 * @see jsonschema.impl.jsonschemaPackageImpl#getBaseSyntaxError()
		 * @generated
		 */
		EClass BASE_SYNTAX_ERROR = eINSTANCE.getBaseSyntaxError();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_SYNTAX_ERROR__TYPE = eINSTANCE.getBaseSyntaxError_Type();

		/**
		 * The meta object literal for the '{@link jsonschema.impl.ValidationErrorImpl <em>Validation Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.impl.ValidationErrorImpl
		 * @see jsonschema.impl.jsonschemaPackageImpl#getValidationError()
		 * @generated
		 */
		EClass VALIDATION_ERROR = eINSTANCE.getValidationError();

		/**
		 * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__KEYWORD = eINSTANCE.getValidationError_Keyword();

		/**
		 * The meta object literal for the '<em><b>Pointer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__POINTER = eINSTANCE.getValidationError_Pointer();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__LEVEL = eINSTANCE.getValidationError_Level();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__MESSAGE = eINSTANCE.getValidationError_Message();

		/**
		 * The meta object literal for the '<em><b>Extended Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__EXTENDED_MESSAGE = eINSTANCE.getValidationError_ExtendedMessage();

		/**
		 * The meta object literal for the '{@link jsonschema.impl.MeasureImpl <em>Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.impl.MeasureImpl
		 * @see jsonschema.impl.jsonschemaPackageImpl#getMeasure()
		 * @generated
		 */
		EClass MEASURE = eINSTANCE.getMeasure();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE__VALUE = eINSTANCE.getMeasure_Value();

		/**
		 * The meta object literal for the '<em><b>Metric</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE__METRIC = eINSTANCE.getMeasure_Metric();

		/**
		 * The meta object literal for the '{@link jsonschema.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.impl.MetricImpl
		 * @see jsonschema.impl.jsonschemaPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__TYPE = eINSTANCE.getMetric_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__NAME = eINSTANCE.getMetric_Name();

		/**
		 * The meta object literal for the '{@link jsonschema.MetricType <em>Metric Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.MetricType
		 * @see jsonschema.impl.jsonschemaPackageImpl#getMetricType()
		 * @generated
		 */
		EEnum METRIC_TYPE = eINSTANCE.getMetricType();

		/**
		 * The meta object literal for the '{@link jsonschema.BaseSyntaxErrorType <em>Base Syntax Error Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsonschema.BaseSyntaxErrorType
		 * @see jsonschema.impl.jsonschemaPackageImpl#getBaseSyntaxErrorType()
		 * @generated
		 */
		EEnum BASE_SYNTAX_ERROR_TYPE = eINSTANCE.getBaseSyntaxErrorType();

	}

} //jsonschemaPackage
