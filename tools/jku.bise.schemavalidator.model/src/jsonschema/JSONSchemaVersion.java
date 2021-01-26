/**
 */
package jsonschema;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JSON Schema Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.JSONSchemaVersion#getDraftName <em>Draft Name</em>}</li>
 *   <li>{@link jsonschema.JSONSchemaVersion#getDraftURL <em>Draft URL</em>}</li>
 * </ul>
 *
 * @see jsonschema.jsonschemaPackage#getJSONSchemaVersion()
 * @model
 * @generated
 */
public interface JSONSchemaVersion extends EObject {
	/**
	 * Returns the value of the '<em><b>Draft Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Draft Name</em>' attribute.
	 * @see #setDraftName(String)
	 * @see jsonschema.jsonschemaPackage#getJSONSchemaVersion_DraftName()
	 * @model
	 * @generated
	 */
	String getDraftName();

	/**
	 * Sets the value of the '{@link jsonschema.JSONSchemaVersion#getDraftName <em>Draft Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Draft Name</em>' attribute.
	 * @see #getDraftName()
	 * @generated
	 */
	void setDraftName(String value);

	/**
	 * Returns the value of the '<em><b>Draft URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Draft URL</em>' attribute.
	 * @see #setDraftURL(String)
	 * @see jsonschema.jsonschemaPackage#getJSONSchemaVersion_DraftURL()
	 * @model
	 * @generated
	 */
	String getDraftURL();

	/**
	 * Sets the value of the '{@link jsonschema.JSONSchemaVersion#getDraftURL <em>Draft URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Draft URL</em>' attribute.
	 * @see #getDraftURL()
	 * @generated
	 */
	void setDraftURL(String value);

} // JSONSchemaVersion
