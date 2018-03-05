import java.util.Date;


public class VXDataObject {
	/**
	 * Id of the data
	 */
	protected Long id;
	/**
	 * Date when this data was created
	 */

	protected Date createDate;
	/**
	 * Date when this data was updated
	 */
	
	protected Date updateDate;
	/**
	 * Owner
	 */
	protected String owner;
	/**
	 * Updated By
	 */
	protected String updatedBy;

	/**
	 * Default constructor. This will set all the attributes to default value.
	 */
	public VXDataObject ( ) {
	}

	/**
	 * This method sets the value to the member attribute <b>id</b>.
	 * You cannot set null to the attribute.
	 * @param id Value to set member attribute <b>id</b>
	 */
	public void setId( Long id ) {
		this.id = id;
	}

	/**
	 * Returns the value for the member attribute <b>id</b>
	 * @return Long - value of member attribute <b>id</b>.
	 */
	public Long getId( ) {
		return this.id;
	}

	/**
	 * This method sets the value to the member attribute <b>createDate</b>.
	 * You cannot set null to the attribute.
	 * @param createDate Value to set member attribute <b>createDate</b>
	 */
	public void setCreateDate( Date createDate ) {
		this.createDate = createDate;
	}

	/**
	 * Returns the value for the member attribute <b>createDate</b>
	 * @return Date - value of member attribute <b>createDate</b>.
	 */
	public Date getCreateDate( ) {
		return this.createDate;
	}

	/**
	 * This method sets the value to the member attribute <b>updateDate</b>.
	 * You cannot set null to the attribute.
	 * @param updateDate Value to set member attribute <b>updateDate</b>
	 */
	public void setUpdateDate( Date updateDate ) {
		this.updateDate = updateDate;
	}

	/**
	 * Returns the value for the member attribute <b>updateDate</b>
	 * @return Date - value of member attribute <b>updateDate</b>.
	 */
	public Date getUpdateDate( ) {
		return this.updateDate;
	}

	/**
	 * This method sets the value to the member attribute <b>owner</b>.
	 * You cannot set null to the attribute.
	 * @param owner Value to set member attribute <b>owner</b>
	 */
	public void setOwner( String owner ) {
		this.owner = owner;
	}

	/**
	 * Returns the value for the member attribute <b>owner</b>
	 * @return String - value of member attribute <b>owner</b>.
	 */
	public String getOwner( ) {
		return this.owner;
	}

	/**
	 * This method sets the value to the member attribute <b>updatedBy</b>.
	 * You cannot set null to the attribute.
	 * @param updatedBy Value to set member attribute <b>updatedBy</b>
	 */
	public void setUpdatedBy( String updatedBy ) {
		this.updatedBy = updatedBy;
	}

	/**
	 * Returns the value for the member attribute <b>updatedBy</b>
	 * @return String - value of member attribute <b>updatedBy</b>.
	 */
	public String getUpdatedBy( ) {
		return this.updatedBy;
	}

	
	/**
	 * This return the bean content in string format
	 * @return formatedStr
	*/
	public String toString( ) {
		String str = "VXDataObject={";
		str += super.toString();
		str += "id={" + id + "} ";
		str += "createDate={" + createDate + "} ";
		str += "updateDate={" + updateDate + "} ";
		str += "owner={" + owner + "} ";
		str += "updatedBy={" + updatedBy + "} ";
		str += "}";
		return str;
	}

	public int getMyClassType() {
		// TODO Auto-generated method stub
		return 0;
	}
}
