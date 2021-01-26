/**
 */
package jsonschema.impl;

import java.util.Collection;

import jsonschema.JSONSchemaFile;
import jsonschema.JSONSchemaVersion;
import jsonschema.Measure;
import jsonschema.jsonschemaPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JSON Schema File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.impl.JSONSchemaFileImpl#getDuplicates <em>Duplicates</em>}</li>
 *   <li>{@link jsonschema.impl.JSONSchemaFileImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link jsonschema.impl.JSONSchemaFileImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link jsonschema.impl.JSONSchemaFileImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link jsonschema.impl.JSONSchemaFileImpl#getMeasures <em>Measures</em>}</li>
 *   <li>{@link jsonschema.impl.JSONSchemaFileImpl#getGithubRepoFullname <em>Github Repo Fullname</em>}</li>
 *   <li>{@link jsonschema.impl.JSONSchemaFileImpl#getGithubFilePath <em>Github File Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JSONSchemaFileImpl extends MinimalEObjectImpl.Container implements JSONSchemaFile {
	/**
	 * The cached value of the '{@link #getDuplicates() <em>Duplicates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplicates()
	 * @generated
	 * @ordered
	 */
	protected EList<JSONSchemaFile> duplicates;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected JSONSchemaVersion version;

	/**
	 * The cached value of the '{@link #getErrors() <em>Errors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected EList<jsonschema.Error> errors;

	/**
	 * The cached value of the '{@link #getMeasures() <em>Measures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasures()
	 * @generated
	 * @ordered
	 */
	protected EList<Measure> measures;

	/**
	 * The default value of the '{@link #getGithubRepoFullname() <em>Github Repo Fullname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGithubRepoFullname()
	 * @generated
	 * @ordered
	 */
	protected static final String GITHUB_REPO_FULLNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGithubRepoFullname() <em>Github Repo Fullname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGithubRepoFullname()
	 * @generated
	 * @ordered
	 */
	protected String githubRepoFullname = GITHUB_REPO_FULLNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGithubFilePath() <em>Github File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGithubFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String GITHUB_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGithubFilePath() <em>Github File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGithubFilePath()
	 * @generated
	 * @ordered
	 */
	protected String githubFilePath = GITHUB_FILE_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JSONSchemaFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return jsonschemaPackage.Literals.JSON_SCHEMA_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JSONSchemaFile> getDuplicates() {
		if (duplicates == null) {
			duplicates = new EObjectResolvingEList<JSONSchemaFile>(JSONSchemaFile.class, this, jsonschemaPackage.JSON_SCHEMA_FILE__DUPLICATES);
		}
		return duplicates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.JSON_SCHEMA_FILE__FILE_NAME, oldFileName, fileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JSONSchemaVersion getVersion() {
		if (version != null && version.eIsProxy()) {
			InternalEObject oldVersion = (InternalEObject)version;
			version = (JSONSchemaVersion)eResolveProxy(oldVersion);
			if (version != oldVersion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, jsonschemaPackage.JSON_SCHEMA_FILE__VERSION, oldVersion, version));
			}
		}
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSONSchemaVersion basicGetVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(JSONSchemaVersion newVersion) {
		JSONSchemaVersion oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.JSON_SCHEMA_FILE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<jsonschema.Error> getErrors() {
		if (errors == null) {
			errors = new EObjectContainmentEList<jsonschema.Error>(jsonschema.Error.class, this, jsonschemaPackage.JSON_SCHEMA_FILE__ERRORS);
		}
		return errors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Measure> getMeasures() {
		if (measures == null) {
			measures = new EObjectContainmentEList<Measure>(Measure.class, this, jsonschemaPackage.JSON_SCHEMA_FILE__MEASURES);
		}
		return measures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGithubRepoFullname() {
		return githubRepoFullname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGithubRepoFullname(String newGithubRepoFullname) {
		String oldGithubRepoFullname = githubRepoFullname;
		githubRepoFullname = newGithubRepoFullname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_REPO_FULLNAME, oldGithubRepoFullname, githubRepoFullname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGithubFilePath() {
		return githubFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGithubFilePath(String newGithubFilePath) {
		String oldGithubFilePath = githubFilePath;
		githubFilePath = newGithubFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_FILE_PATH, oldGithubFilePath, githubFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case jsonschemaPackage.JSON_SCHEMA_FILE__ERRORS:
				return ((InternalEList<?>)getErrors()).basicRemove(otherEnd, msgs);
			case jsonschemaPackage.JSON_SCHEMA_FILE__MEASURES:
				return ((InternalEList<?>)getMeasures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case jsonschemaPackage.JSON_SCHEMA_FILE__DUPLICATES:
				return getDuplicates();
			case jsonschemaPackage.JSON_SCHEMA_FILE__FILE_NAME:
				return getFileName();
			case jsonschemaPackage.JSON_SCHEMA_FILE__VERSION:
				if (resolve) return getVersion();
				return basicGetVersion();
			case jsonschemaPackage.JSON_SCHEMA_FILE__ERRORS:
				return getErrors();
			case jsonschemaPackage.JSON_SCHEMA_FILE__MEASURES:
				return getMeasures();
			case jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_REPO_FULLNAME:
				return getGithubRepoFullname();
			case jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_FILE_PATH:
				return getGithubFilePath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case jsonschemaPackage.JSON_SCHEMA_FILE__DUPLICATES:
				getDuplicates().clear();
				getDuplicates().addAll((Collection<? extends JSONSchemaFile>)newValue);
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__FILE_NAME:
				setFileName((String)newValue);
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__VERSION:
				setVersion((JSONSchemaVersion)newValue);
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__ERRORS:
				getErrors().clear();
				getErrors().addAll((Collection<? extends jsonschema.Error>)newValue);
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__MEASURES:
				getMeasures().clear();
				getMeasures().addAll((Collection<? extends Measure>)newValue);
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_REPO_FULLNAME:
				setGithubRepoFullname((String)newValue);
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_FILE_PATH:
				setGithubFilePath((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case jsonschemaPackage.JSON_SCHEMA_FILE__DUPLICATES:
				getDuplicates().clear();
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__VERSION:
				setVersion((JSONSchemaVersion)null);
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__ERRORS:
				getErrors().clear();
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__MEASURES:
				getMeasures().clear();
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_REPO_FULLNAME:
				setGithubRepoFullname(GITHUB_REPO_FULLNAME_EDEFAULT);
				return;
			case jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_FILE_PATH:
				setGithubFilePath(GITHUB_FILE_PATH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case jsonschemaPackage.JSON_SCHEMA_FILE__DUPLICATES:
				return duplicates != null && !duplicates.isEmpty();
			case jsonschemaPackage.JSON_SCHEMA_FILE__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case jsonschemaPackage.JSON_SCHEMA_FILE__VERSION:
				return version != null;
			case jsonschemaPackage.JSON_SCHEMA_FILE__ERRORS:
				return errors != null && !errors.isEmpty();
			case jsonschemaPackage.JSON_SCHEMA_FILE__MEASURES:
				return measures != null && !measures.isEmpty();
			case jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_REPO_FULLNAME:
				return GITHUB_REPO_FULLNAME_EDEFAULT == null ? githubRepoFullname != null : !GITHUB_REPO_FULLNAME_EDEFAULT.equals(githubRepoFullname);
			case jsonschemaPackage.JSON_SCHEMA_FILE__GITHUB_FILE_PATH:
				return GITHUB_FILE_PATH_EDEFAULT == null ? githubFilePath != null : !GITHUB_FILE_PATH_EDEFAULT.equals(githubFilePath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (fileName: ");
		result.append(fileName);
		result.append(", githubRepoFullname: ");
		result.append(githubRepoFullname);
		result.append(", githubFilePath: ");
		result.append(githubFilePath);
		result.append(')');
		return result.toString();
	}

} //JSONSchemaFileImpl
