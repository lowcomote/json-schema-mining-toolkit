/**
 */
package jsonschema;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.Measure#getValue <em>Value</em>}</li>
 *   <li>{@link jsonschema.Measure#getMetric <em>Metric</em>}</li>
 * </ul>
 *
 * @see jsonschema.jsonschemaPackage#getMeasure()
 * @model
 * @generated
 */
public interface Measure extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(float)
	 * @see jsonschema.jsonschemaPackage#getMeasure_Value()
	 * @model
	 * @generated
	 */
	float getValue();

	/**
	 * Sets the value of the '{@link jsonschema.Measure#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(float value);

	/**
	 * Returns the value of the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric</em>' reference.
	 * @see #setMetric(Metric)
	 * @see jsonschema.jsonschemaPackage#getMeasure_Metric()
	 * @model required="true"
	 * @generated
	 */
	Metric getMetric();

	/**
	 * Sets the value of the '{@link jsonschema.Measure#getMetric <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric</em>' reference.
	 * @see #getMetric()
	 * @generated
	 */
	void setMetric(Metric value);

} // Measure
