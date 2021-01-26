/**
 */
package jsonschema.impl;

import jsonschema.JSONSchemaVersion;
import jsonschema.jsonschemaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JSON Schema Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.impl.JSONSchemaVersionImpl#getDraftName <em>Draft Name</em>}</li>
 *   <li>{@link jsonschema.impl.JSONSchemaVersionImpl#getDraftURL <em>Draft URL</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JSONSchemaVersionImpl extends MinimalEObjectImpl.Container implements JSONSchemaVersion {
	/**
	 * The default value of the '{@link #getDraftName() <em>Draft Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDraftName()
	 * @generated
	 * @ordered
	 */
	protected static final String DRAFT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDraftName() <em>Draft Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDraftName()
	 * @generated
	 * @ordered
	 */
	protected String draftName = DRAFT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDraftURL() <em>Draft URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDraftURL()
	 * @generated
	 * @ordered
	 */
	protected static final String DRAFT_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDraftURL() <em>Draft URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDraftURL()
	 * @generated
	 * @ordered
	 */
	protected String draftURL = DRAFT_URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JSONSchemaVersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return jsonschemaPackage.Literals.JSON_SCHEMA_VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDraftName() {
		return draftName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDraftName(String newDraftName) {
		String oldDraftName = draftName;
		draftName = newDraftName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_NAME, oldDraftName, draftName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDraftURL() {
		return draftURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDraftURL(String newDraftURL) {
		String oldDraftURL = draftURL;
		draftURL = newDraftURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_URL, oldDraftURL, draftURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_NAME:
				return getDraftName();
			case jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_URL:
				return getDraftURL();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_NAME:
				setDraftName((String)newValue);
				return;
			case jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_URL:
				setDraftURL((String)newValue);
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
			case jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_NAME:
				setDraftName(DRAFT_NAME_EDEFAULT);
				return;
			case jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_URL:
				setDraftURL(DRAFT_URL_EDEFAULT);
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
			case jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_NAME:
				return DRAFT_NAME_EDEFAULT == null ? draftName != null : !DRAFT_NAME_EDEFAULT.equals(draftName);
			case jsonschemaPackage.JSON_SCHEMA_VERSION__DRAFT_URL:
				return DRAFT_URL_EDEFAULT == null ? draftURL != null : !DRAFT_URL_EDEFAULT.equals(draftURL);
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
		result.append(" (draftName: ");
		result.append(draftName);
		result.append(", draftURL: ");
		result.append(draftURL);
		result.append(')');
		return result.toString();
	}

} //JSONSchemaVersionImpl
