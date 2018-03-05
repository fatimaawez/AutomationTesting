

public class VXGroup extends VXDataObject implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	protected int groupSource =0;

	/**
	 * Name
	 */
	protected String name;
	/**
	 * Description
	 */
	protected String description;
	/**
	 * Type of group
	 * This attribute is of type enum CommonEnums::XAGroupType
	 */
	/**
	 * Id of the credential store
	 */
	protected Long credStoreId;

	/**
	 * Group visibility
	 */
	protected Integer isVisible;
	
	protected int groupType = 0;
	/**
	 * Default constructor. This will set all the attributes to default value.
	 */
	public VXGroup ( ) {
		groupType = 0;
		isVisible = 1;;
	}

	/**
	 * This method sets the value to the member attribute <b>name</b>.
	 * You cannot set null to the attribute.
	 * @param name Value to set member attribute <b>name</b>
	 */
	public void setName( String name ) {
		this.name = name;
	}

	/**
	 * Returns the value for the member attribute <b>name</b>
	 * @return String - value of member attribute <b>name</b>.
	 */
	public String getName( ) {
		return this.name;
	}

	/**
	 * This method sets the value to the member attribute <b>description</b>.
	 * You cannot set null to the attribute.
	 * @param description Value to set member attribute <b>description</b>
	 */
	public void setDescription( String description ) {
		this.description = description;
	}

	/**
	 * Returns the value for the member attribute <b>description</b>
	 * @return String - value of member attribute <b>description</b>.
	 */
	public String getDescription( ) {
		return this.description;
	}

	/**
	 * This method sets the value to the member attribute <b>groupType</b>.
	 * You cannot set null to the attribute.
	 * @param groupType Value to set member attribute <b>groupType</b>
	 */
	public void setGroupType( int groupType ) {
		this.groupType = groupType;
	}

	/**
	 * Returns the value for the member attribute <b>groupType</b>
	 * @return int - value of member attribute <b>groupType</b>.
	 */
	public int getGroupType( ) {
		return this.groupType;
	}

	/**
	 * This method sets the value to the member attribute <b>credStoreId</b>.
	 * You cannot set null to the attribute.
	 * @param credStoreId Value to set member attribute <b>credStoreId</b>
	 */
	public void setCredStoreId( Long credStoreId ) {
		this.credStoreId = credStoreId;
	}

	/**
	 * Returns the value for the member attribute <b>credStoreId</b>
	 * @return Long - value of member attribute <b>credStoreId</b>.
	 */
	public Long getCredStoreId( ) {
		return this.credStoreId;
	}

	/**
	 * @return the isVisible
	 */
	public Integer getIsVisible() {
		return isVisible;
	}

	/**
	 * @param isVisible the isVisible to set
	 */
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	@Override
	public int getMyClassType( ) {
	    return  1002;
	}

	public int getGroupSource() {
		return groupSource;
	}

	public void setGroupSource(int groupSource) {
		this.groupSource = groupSource;
	}
	/**
	 * This return the bean content in string format
	 * @return formatedStr
	*/
	public String toString( ) {
		String str = "VXGroup={";
		str += super.toString();
		str += "name={" + name + "} ";
		str += "description={" + description + "} ";
		str += "groupType={" + groupType + "} ";
		str += "credStoreId={" + credStoreId + "} ";
		str += "isVisible={" + isVisible + "} ";
		str += "groupSrc={" + groupSource + "} ";
		str += "}";
		return str;
	}
}

