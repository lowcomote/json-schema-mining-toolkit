/**
 */
package jsonschema;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.Model#getJsonFiles <em>Json Files</em>}</li>
 *   <li>{@link jsonschema.Model#getMetrics <em>Metrics</em>}</li>
 * </ul>
 *
 * @see jsonschema.jsonschemaPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Json Files</b></em>' containment reference list.
	 * The list contents are of type {@link jsonschema.JSONSchemaFile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Json Files</em>' containment reference list.
	 * @see jsonschema.jsonschemaPackage#getModel_JsonFiles()
	 * @model containment="true"
	 * @generated
	 */
	EList<JSONSchemaFile> getJsonFiles();

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link jsonschema.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' containment reference list.
	 * @see jsonschema.jsonschemaPackage#getModel_Metrics()
	 * @model containment="true"
	 * @generated
	 */
	EList<Metric> getMetrics();

} // Model
