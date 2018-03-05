
public class VXString {


	/**
	 * Value
	 */
	protected String value;

	/**
	 * Default constructor. This will set all the attributes to default value.
	 */
	public VXString ( ) {
	}

	/**
	 * This method sets the value to the member attribute <b>value</b>.
	 * You cannot set null to the attribute.
	 * @param value Value to set member attribute <b>value</b>
	 */
	public void setValue( String value ) {
		this.value = value;
	}

	/**
	 * Returns the value for the member attribute <b>value</b>
	 * @return String - value of member attribute <b>value</b>.
	 */
	public String getValue( ) {
		return this.value;
	}


	/**
	 * This return the bean content in string format
	 * @return formatedStr
	*/
	public String toString( ) {
		String str = "VXString={";
		str += super.toString();
		str += "value={" + value + "} ";
		str += "}";
		return str;
	}
}
