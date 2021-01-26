/**
 */
package jsonschema;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Metric Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see jsonschema.jsonschemaPackage#getMetricType()
 * @model
 * @generated
 */
public enum MetricType implements Enumerator {
	/**
	 * The '<em><b>GRAPH BASED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAPH_BASED_VALUE
	 * @generated
	 * @ordered
	 */
	GRAPH_BASED(0, "GRAPH_BASED", "GRAPH_BASED"),

	/**
	 * The '<em><b>KEYWORD USAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KEYWORD_USAGE_VALUE
	 * @generated
	 * @ordered
	 */
	KEYWORD_USAGE(1, "KEYWORD_USAGE", "KEYWORD_USAGE"), /**
	 * The '<em><b>TYPE USAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPE_USAGE_VALUE
	 * @generated
	 * @ordered
	 */
	TYPE_USAGE(2, "TYPE_USAGE", "TYPE_USAGE");

	/**
	 * The '<em><b>GRAPH BASED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAPH_BASED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRAPH_BASED_VALUE = 0;

	/**
	 * The '<em><b>KEYWORD USAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KEYWORD_USAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KEYWORD_USAGE_VALUE = 1;

	/**
	 * The '<em><b>TYPE USAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPE_USAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TYPE_USAGE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Metric Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MetricType[] VALUES_ARRAY =
		new MetricType[] {
			GRAPH_BASED,
			KEYWORD_USAGE,
			TYPE_USAGE,
		};

	/**
	 * A public read-only list of all the '<em><b>Metric Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MetricType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Metric Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MetricType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MetricType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Metric Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MetricType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MetricType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Metric Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MetricType get(int value) {
		switch (value) {
			case GRAPH_BASED_VALUE: return GRAPH_BASED;
			case KEYWORD_USAGE_VALUE: return KEYWORD_USAGE;
			case TYPE_USAGE_VALUE: return TYPE_USAGE;
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
	private MetricType(int value, String name, String literal) {
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
	
} //MetricType
