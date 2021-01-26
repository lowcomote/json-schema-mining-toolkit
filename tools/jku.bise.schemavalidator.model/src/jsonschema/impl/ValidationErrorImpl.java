/**
 */
package jsonschema.impl;

import jsonschema.ValidationError;
import jsonschema.jsonschemaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validation Error</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jsonschema.impl.ValidationErrorImpl#getKeyword <em>Keyword</em>}</li>
 *   <li>{@link jsonschema.impl.ValidationErrorImpl#getPointer <em>Pointer</em>}</li>
 *   <li>{@link jsonschema.impl.ValidationErrorImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link jsonschema.impl.ValidationErrorImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link jsonschema.impl.ValidationErrorImpl#getExtendedMessage <em>Extended Message</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValidationErrorImpl extends ErrorImpl implements ValidationError {
	/**
	 * The default value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyword()
	 * @generated
	 * @ordered
	 */
	protected static final String KEYWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyword()
	 * @generated
	 * @ordered
	 */
	protected String keyword = KEYWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPointer() <em>Pointer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointer()
	 * @generated
	 * @ordered
	 */
	protected static final String POINTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPointer() <em>Pointer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointer()
	 * @generated
	 * @ordered
	 */
	protected String pointer = POINTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected String level = LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtendedMessage() <em>Extended Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENDED_MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtendedMessage() <em>Extended Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedMessage()
	 * @generated
	 * @ordered
	 */
	protected String extendedMessage = EXTENDED_MESSAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValidationErrorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return jsonschemaPackage.Literals.VALIDATION_ERROR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKeyword() {
		return keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKeyword(String newKeyword) {
		String oldKeyword = keyword;
		keyword = newKeyword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.VALIDATION_ERROR__KEYWORD, oldKeyword, keyword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPointer() {
		return pointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPointer(String newPointer) {
		String oldPointer = pointer;
		pointer = newPointer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.VALIDATION_ERROR__POINTER, oldPointer, pointer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLevel(String newLevel) {
		String oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.VALIDATION_ERROR__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.VALIDATION_ERROR__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExtendedMessage() {
		return extendedMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtendedMessage(String newExtendedMessage) {
		String oldExtendedMessage = extendedMessage;
		extendedMessage = newExtendedMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, jsonschemaPackage.VALIDATION_ERROR__EXTENDED_MESSAGE, oldExtendedMessage, extendedMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case jsonschemaPackage.VALIDATION_ERROR__KEYWORD:
				return getKeyword();
			case jsonschemaPackage.VALIDATION_ERROR__POINTER:
				return getPointer();
			case jsonschemaPackage.VALIDATION_ERROR__LEVEL:
				return getLevel();
			case jsonschemaPackage.VALIDATION_ERROR__MESSAGE:
				return getMessage();
			case jsonschemaPackage.VALIDATION_ERROR__EXTENDED_MESSAGE:
				return getExtendedMessage();
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
			case jsonschemaPackage.VALIDATION_ERROR__KEYWORD:
				setKeyword((String)newValue);
				return;
			case jsonschemaPackage.VALIDATION_ERROR__POINTER:
				setPointer((String)newValue);
				return;
			case jsonschemaPackage.VALIDATION_ERROR__LEVEL:
				setLevel((String)newValue);
				return;
			case jsonschemaPackage.VALIDATION_ERROR__MESSAGE:
				setMessage((String)newValue);
				return;
			case jsonschemaPackage.VALIDATION_ERROR__EXTENDED_MESSAGE:
				setExtendedMessage((String)newValue);
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
			case jsonschemaPackage.VALIDATION_ERROR__KEYWORD:
				setKeyword(KEYWORD_EDEFAULT);
				return;
			case jsonschemaPackage.VALIDATION_ERROR__POINTER:
				setPointer(POINTER_EDEFAULT);
				return;
			case jsonschemaPackage.VALIDATION_ERROR__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case jsonschemaPackage.VALIDATION_ERROR__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case jsonschemaPackage.VALIDATION_ERROR__EXTENDED_MESSAGE:
				setExtendedMessage(EXTENDED_MESSAGE_EDEFAULT);
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
			case jsonschemaPackage.VALIDATION_ERROR__KEYWORD:
				return KEYWORD_EDEFAULT == null ? keyword != null : !KEYWORD_EDEFAULT.equals(keyword);
			case jsonschemaPackage.VALIDATION_ERROR__POINTER:
				return POINTER_EDEFAULT == null ? pointer != null : !POINTER_EDEFAULT.equals(pointer);
			case jsonschemaPackage.VALIDATION_ERROR__LEVEL:
				return LEVEL_EDEFAULT == null ? level != null : !LEVEL_EDEFAULT.equals(level);
			case jsonschemaPackage.VALIDATION_ERROR__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case jsonschemaPackage.VALIDATION_ERROR__EXTENDED_MESSAGE:
				return EXTENDED_MESSAGE_EDEFAULT == null ? extendedMessage != null : !EXTENDED_MESSAGE_EDEFAULT.equals(extendedMessage);
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
		result.append(" (keyword: ");
		result.append(keyword);
		result.append(", pointer: ");
		result.append(pointer);
		result.append(", level: ");
		result.append(level);
		result.append(", message: ");
		result.append(message);
		result.append(", extendedMessage: ");
		result.append(extendedMessage);
		result.append(')');
		return result.toString();
	}

} //ValidationErrorImpl
