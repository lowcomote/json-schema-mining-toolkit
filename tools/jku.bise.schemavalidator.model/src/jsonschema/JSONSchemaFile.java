/**
 */
package jsonschema;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JSON Schema File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.JSONSchemaFile#getDuplicates <em>Duplicates</em>}</li>
 *   <li>{@link jsonschema.JSONSchemaFile#getFileName <em>File Name</em>}</li>
 *   <li>{@link jsonschema.JSONSchemaFile#getVersion <em>Version</em>}</li>
 *   <li>{@link jsonschema.JSONSchemaFile#getErrors <em>Errors</em>}</li>
 *   <li>{@link jsonschema.JSONSchemaFile#getMeasures <em>Measures</em>}</li>
 *   <li>{@link jsonschema.JSONSchemaFile#getGithubRepoFullname <em>Github Repo Fullname</em>}</li>
 *   <li>{@link jsonschema.JSONSchemaFile#getGithubFilePath <em>Github File Path</em>}</li>
 * </ul>
 *
 * @see jsonschema.jsonschemaPackage#getJSONSchemaFile()
 * @model
 * @generated
 */
public interface JSONSchemaFile extends EObject {
	/**
	 * Returns the value of the '<em><b>Duplicates</b></em>' reference list.
	 * The list contents are of type {@link jsonschema.JSONSchemaFile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duplicates</em>' reference list.
	 * @see jsonschema.jsonschemaPackage#getJSONSchemaFile_Duplicates()
	 * @model
	 * @generated
	 */
	EList<JSONSchemaFile> getDuplicates();

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see jsonschema.jsonschemaPackage#getJSONSchemaFile_FileName()
	 * @model required="true"
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link jsonschema.JSONSchemaFile#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' reference.
	 * @see #setVersion(JSONSchemaVersion)
	 * @see jsonschema.jsonschemaPackage#getJSONSchemaFile_Version()
	 * @model
	 * @generated
	 */
	JSONSchemaVersion getVersion();

	/**
	 * Sets the value of the '{@link jsonschema.JSONSchemaFile#getVersion <em>Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(JSONSchemaVersion value);

	/**
	 * Returns the value of the '<em><b>Errors</b></em>' containment reference list.
	 * The list contents are of type {@link jsonschema.Error}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' containment reference list.
	 * @see jsonschema.jsonschemaPackage#getJSONSchemaFile_Errors()
	 * @model containment="true"
	 * @generated
	 */
	EList<jsonschema.Error> getErrors();

	/**
	 * Returns the value of the '<em><b>Measures</b></em>' containment reference list.
	 * The list contents are of type {@link jsonschema.Measure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measures</em>' containment reference list.
	 * @see jsonschema.jsonschemaPackage#getJSONSchemaFile_Measures()
	 * @model containment="true"
	 * @generated
	 */
	EList<Measure> getMeasures();

	/**
	 * Returns the value of the '<em><b>Github Repo Fullname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Github Repo Fullname</em>' attribute.
	 * @see #setGithubRepoFullname(String)
	 * @see jsonschema.jsonschemaPackage#getJSONSchemaFile_GithubRepoFullname()
	 * @model
	 * @generated
	 */
	String getGithubRepoFullname();

	/**
	 * Sets the value of the '{@link jsonschema.JSONSchemaFile#getGithubRepoFullname <em>Github Repo Fullname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Github Repo Fullname</em>' attribute.
	 * @see #getGithubRepoFullname()
	 * @generated
	 */
	void setGithubRepoFullname(String value);

	/**
	 * Returns the value of the '<em><b>Github File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Github File Path</em>' attribute.
	 * @see #setGithubFilePath(String)
	 * @see jsonschema.jsonschemaPackage#getJSONSchemaFile_GithubFilePath()
	 * @model
	 * @generated
	 */
	String getGithubFilePath();

	/**
	 * Sets the value of the '{@link jsonschema.JSONSchemaFile#getGithubFilePath <em>Github File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Github File Path</em>' attribute.
	 * @see #getGithubFilePath()
	 * @generated
	 */
	void setGithubFilePath(String value);

} // JSONSchemaFile
