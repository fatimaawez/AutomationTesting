import java.util.ArrayList;
import java.util.List;

public class XUserInfo {
	private String id;
	private String name;
	private String 	description;
	
	private List<String>  	groupNameList = new ArrayList<String>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setGroupNameList(List<String> groupNameList) {
		this.groupNameList = groupNameList;
	}
	
	public List<String> getGroupNameList() {
		return groupNameList;
	}

	public List<String> getGroups() {
		return groupNameList;
	}
	
}
