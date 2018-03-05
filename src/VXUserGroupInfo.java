import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class VXUserGroupInfo extends VXDataObject implements java.io.Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	VXUser xuserInfo;
	List<VXGroup> xgroupInfo;
	
	public VXUserGroupInfo ( ) {
	}

	public VXUser getXuserInfo() {
		return xuserInfo;
	}

	public void setXuserInfo(VXUser xuserInfo) {
		this.xuserInfo = xuserInfo;
	}

	public List<VXGroup> getXgroupInfo() {
		return xgroupInfo;
	}

	public void setXgroupInfo(List<VXGroup> xgroupInfo) {
		this.xgroupInfo = xgroupInfo;
	}


	
}