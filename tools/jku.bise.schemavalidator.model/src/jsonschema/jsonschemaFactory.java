/**
 */
package jsonschema;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see jsonschema.jsonschemaPackage
 * @generated
 */
public interface jsonschemaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	jsonschemaFactory eINSTANCE = jsonschema.impl.jsonschemaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>JSON Schema File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JSON Schema File</em>'.
	 * @generated
	 */
	JSONSchemaFile createJSONSchemaFile();

	/**
	 * Returns a new object of class '<em>JSON Schema Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JSON Schema Version</em>'.
	 * @generated
	 */
	JSONSchemaVersion createJSONSchemaVersion();

	/**
	 * Returns a new object of class '<em>Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error</em>'.
	 * @generated
	 */
	Error createError();

	/**
	 * Returns a new object of class '<em>Base Syntax Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Syntax Error</em>'.
	 * @generated
	 */
	BaseSyntaxError createBaseSyntaxError();

	/**
	 * Returns a new object of class '<em>Validation Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validation Error</em>'.
	 * @generated
	 */
	ValidationError createValidationError();

	/**
	 * Returns a new object of class '<em>Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measure</em>'.
	 * @generated
	 */
	Measure createMeasure();

	/**
	 * Returns a new object of class '<em>Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric</em>'.
	 * @generated
	 */
	Metric createMetric();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	jsonschemaPackage getjsonschemaPackage();

} //jsonschemaFactory
