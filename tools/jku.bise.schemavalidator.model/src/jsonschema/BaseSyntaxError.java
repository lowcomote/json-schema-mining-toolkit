/**
 */
package jsonschema;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Syntax Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.BaseSyntaxError#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see jsonschema.jsonschemaPackage#getBaseSyntaxError()
 * @model
 * @generated
 */
public interface BaseSyntaxError extends jsonschema.Error {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link jsonschema.BaseSyntaxErrorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see jsonschema.BaseSyntaxErrorType
	 * @see #setType(BaseSyntaxErrorType)
	 * @see jsonschema.jsonschemaPackage#getBaseSyntaxError_Type()
	 * @model
	 * @generated
	 */
	BaseSyntaxErrorType getType();

	/**
	 * Sets the value of the '{@link jsonschema.BaseSyntaxError#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see jsonschema.BaseSyntaxErrorType
	 * @see #getType()
	 * @generated
	 */
	void setType(BaseSyntaxErrorType value);

} // BaseSyntaxError
