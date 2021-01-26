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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class jsonschemaFactoryImpl extends EFactoryImpl implements jsonschemaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static jsonschemaFactory init() {
		try {
			jsonschemaFactory thejsonschemaFactory = (jsonschemaFactory)EPackage.Registry.INSTANCE.getEFactory(jsonschemaPackage.eNS_URI);
			if (thejsonschemaFactory != null) {
				return thejsonschemaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new jsonschemaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public jsonschemaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case jsonschemaPackage.MODEL: return createModel();
			case jsonschemaPackage.JSON_SCHEMA_FILE: return createJSONSchemaFile();
			case jsonschemaPackage.JSON_SCHEMA_VERSION: return createJSONSchemaVersion();
			case jsonschemaPackage.ERROR: return createError();
			case jsonschemaPackage.BASE_SYNTAX_ERROR: return createBaseSyntaxError();
			case jsonschemaPackage.VALIDATION_ERROR: return createValidationError();
			case jsonschemaPackage.MEASURE: return createMeasure();
			case jsonschemaPackage.METRIC: return createMetric();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case jsonschemaPackage.METRIC_TYPE:
				return createMetricTypeFromString(eDataType, initialValue);
			case jsonschemaPackage.BASE_SYNTAX_ERROR_TYPE:
				return createBaseSyntaxErrorTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case jsonschemaPackage.METRIC_TYPE:
				return convertMetricTypeToString(eDataType, instanceValue);
			case jsonschemaPackage.BASE_SYNTAX_ERROR_TYPE:
				return convertBaseSyntaxErrorTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JSONSchemaFile createJSONSchemaFile() {
		JSONSchemaFileImpl jsonSchemaFile = new JSONSchemaFileImpl();
		return jsonSchemaFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JSONSchemaVersion createJSONSchemaVersion() {
		JSONSchemaVersionImpl jsonSchemaVersion = new JSONSchemaVersionImpl();
		return jsonSchemaVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public jsonschema.Error createError() {
		ErrorImpl error = new ErrorImpl();
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BaseSyntaxError createBaseSyntaxError() {
		BaseSyntaxErrorImpl baseSyntaxError = new BaseSyntaxErrorImpl();
		return baseSyntaxError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValidationError createValidationError() {
		ValidationErrorImpl validationError = new ValidationErrorImpl();
		return validationError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Measure createMeasure() {
		MeasureImpl measure = new MeasureImpl();
		return measure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Metric createMetric() {
		MetricImpl metric = new MetricImpl();
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricType createMetricTypeFromString(EDataType eDataType, String initialValue) {
		MetricType result = MetricType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMetricTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseSyntaxErrorType createBaseSyntaxErrorTypeFromString(EDataType eDataType, String initialValue) {
		BaseSyntaxErrorType result = BaseSyntaxErrorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBaseSyntaxErrorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public jsonschemaPackage getjsonschemaPackage() {
		return (jsonschemaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static jsonschemaPackage getPackage() {
		return jsonschemaPackage.eINSTANCE;
	}

} //jsonschemaFactoryImpl
