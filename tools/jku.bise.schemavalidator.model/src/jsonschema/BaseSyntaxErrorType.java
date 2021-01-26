/**
 */
package jsonschema;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Base Syntax Error Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see jsonschema.jsonschemaPackage#getBaseSyntaxErrorType()
 * @model
 * @generated
 */
public enum BaseSyntaxErrorType implements Enumerator {
	/**
	 * The '<em><b>SCHEMA NOT SUPPORTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCHEMA_NOT_SUPPORTED_VALUE
	 * @generated
	 * @ordered
	 */
	SCHEMA_NOT_SUPPORTED(0, "SCHEMA_NOT_SUPPORTED", "SCHEMA_NOT_SUPPORTED"),

	/**
	 * The '<em><b>SCHEMA NOT FOUND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCHEMA_NOT_FOUND_VALUE
	 * @generated
	 * @ordered
	 */
	SCHEMA_NOT_FOUND(1, "SCHEMA_NOT_FOUND", "SCHEMA_NOT_FOUND"), /**
	 * The '<em><b>UNPARSABLE JSON</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNPARSABLE_JSON_VALUE
	 * @generated
	 * @ordered
	 */
	UNPARSABLE_JSON(2, "UNPARSABLE_JSON", "UNPARSABLE_JSON");

	/**
	 * The '<em><b>SCHEMA NOT SUPPORTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCHEMA_NOT_SUPPORTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCHEMA_NOT_SUPPORTED_VALUE = 0;

	/**
	 * The '<em><b>SCHEMA NOT FOUND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCHEMA_NOT_FOUND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCHEMA_NOT_FOUND_VALUE = 1;

	/**
	 * The '<em><b>UNPARSABLE JSON</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNPARSABLE_JSON
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNPARSABLE_JSON_VALUE = 2;

	/**
	 * An array of all the '<em><b>Base Syntax Error Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BaseSyntaxErrorType[] VALUES_ARRAY =
		new BaseSyntaxErrorType[] {
			SCHEMA_NOT_SUPPORTED,
			SCHEMA_NOT_FOUND,
			UNPARSABLE_JSON,
		};

	/**
	 * A public read-only list of all the '<em><b>Base Syntax Error Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BaseSyntaxErrorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Base Syntax Error Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BaseSyntaxErrorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BaseSyntaxErrorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Base Syntax Error Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BaseSyntaxErrorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BaseSyntaxErrorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Base Syntax Error Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BaseSyntaxErrorType get(int value) {
		switch (value) {
			case SCHEMA_NOT_SUPPORTED_VALUE: return SCHEMA_NOT_SUPPORTED;
			case SCHEMA_NOT_FOUND_VALUE: return SCHEMA_NOT_FOUND;
			case UNPARSABLE_JSON_VALUE: return UNPARSABLE_JSON;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BaseSyntaxErrorType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //BaseSyntaxErrorType
