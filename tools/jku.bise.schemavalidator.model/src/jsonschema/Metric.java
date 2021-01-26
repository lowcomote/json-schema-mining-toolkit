/**
 */
package jsonschema;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.Metric#getType <em>Type</em>}</li>
 *   <li>{@link jsonschema.Metric#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see jsonschema.jsonschemaPackage#getMetric()
 * @model
 * @generated
 */
public interface Metric extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link jsonschema.MetricType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see jsonschema.MetricType
	 * @see #setType(MetricType)
	 * @see jsonschema.jsonschemaPackage#getMetric_Type()
	 * @model
	 * @generated
	 */
	MetricType getType();

	/**
	 * Sets the value of the '{@link jsonschema.Metric#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see jsonschema.MetricType
	 * @see #getType()
	 * @generated
	 */
	void setType(MetricType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jsonschema.jsonschemaPackage#getMetric_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jsonschema.Metric#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Metric
