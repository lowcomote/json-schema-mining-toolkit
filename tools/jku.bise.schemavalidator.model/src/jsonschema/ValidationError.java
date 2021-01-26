/**
 */
package jsonschema;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validation Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.ValidationError#getKeyword <em>Keyword</em>}</li>
 *   <li>{@link jsonschema.ValidationError#getPointer <em>Pointer</em>}</li>
 *   <li>{@link jsonschema.ValidationError#getLevel <em>Level</em>}</li>
 *   <li>{@link jsonschema.ValidationError#getMessage <em>Message</em>}</li>
 *   <li>{@link jsonschema.ValidationError#getExtendedMessage <em>Extended Message</em>}</li>
 * </ul>
 *
 * @see jsonschema.jsonschemaPackage#getValidationError()
 * @model
 * @generated
 */
public interface ValidationError extends jsonschema.Error {
	/**
	 * Returns the value of the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keyword</em>' attribute.
	 * @see #setKeyword(String)
	 * @see jsonschema.jsonschemaPackage#getValidationError_Keyword()
	 * @model
	 * @generated
	 */
	String getKeyword();

	/**
	 * Sets the value of the '{@link jsonschema.ValidationError#getKeyword <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keyword</em>' attribute.
	 * @see #getKeyword()
	 * @generated
	 */
	void setKeyword(String value);

	/**
	 * Returns the value of the '<em><b>Pointer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pointer</em>' attribute.
	 * @see #setPointer(String)
	 * @see jsonschema.jsonschemaPackage#getValidationError_Pointer()
	 * @model
	 * @generated
	 */
	String getPointer();

	/**
	 * Sets the value of the '{@link jsonschema.ValidationError#getPointer <em>Pointer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pointer</em>' attribute.
	 * @see #getPointer()
	 * @generated
	 */
	void setPointer(String value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(String)
	 * @see jsonschema.jsonschemaPackage#getValidationError_Level()
	 * @model
	 * @generated
	 */
	String getLevel();

	/**
	 * Sets the value of the '{@link jsonschema.ValidationError#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(String value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see jsonschema.jsonschemaPackage#getValidationError_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link jsonschema.ValidationError#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Extended Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Message</em>' attribute.
	 * @see #setExtendedMessage(String)
	 * @see jsonschema.jsonschemaPackage#getValidationError_ExtendedMessage()
	 * @model
	 * @generated
	 */
	String getExtendedMessage();

	/**
	 * Sets the value of the '{@link jsonschema.ValidationError#getExtendedMessage <em>Extended Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Message</em>' attribute.
	 * @see #getExtendedMessage()
	 * @generated
	 */
	void setExtendedMessage(String value);

} // ValidationError
