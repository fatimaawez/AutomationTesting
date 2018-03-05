import java.util.ArrayList;
import java.util.List;

public class VXStringList {
    List<VXString> vXStrings = new ArrayList<VXString>();

    public VXStringList() {
	super();
    }

    public VXStringList(List<VXString> objList) {
	this.vXStrings = objList;
    }

    /**
     * @return the vXStrings
     */
    public List<VXString> getVXStrings() {
	return vXStrings;
    }

    /**
     * @param vXStrings
     *            the vXStrings to set
     */
    public void setVXStrings(List<VXString> vXStrings) {
	this.vXStrings = vXStrings;
    }


    /**
     * Start index for the result
     */
    protected int startIndex;
    /**
     * Page size used for the result
     */
    protected int pageSize;
    /**
     * Total records in the database for the given search conditions
     */
    protected long totalCount;
    /**
     * Number of rows returned for the search condition
     */
    protected int resultSize;
    /**
     * Sort type. Either desc or asc
     */
    protected String sortType;
    /**
     * Comma seperated list of the fields for sorting
     */
    protected String sortBy;

    protected long queryTimeMS = System.currentTimeMillis();

    /**
     * This method sets the value to the member attribute <b>startIndex</b>. You
     * cannot set null to the attribute.
     *
     * @param startIndex
     *            Value to set member attribute <b>startIndex</b>
     */
    public void setStartIndex(int startIndex) {
	this.startIndex = startIndex;
    }
    public int getStartIndex() { return startIndex; }


    /**
     * This method sets the value to the member attribute <b>pageSize</b>. You
     * cannot set null to the attribute.
     *
     * @param pageSize
     *            Value to set member attribute <b>pageSize</b>
     */
    public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
    }
    public int getPageSize() { return pageSize; }

    /**
     * This method sets the value to the member attribute <b>totalCount</b>. You
     * cannot set null to the attribute.
     *
     * @param totalCount
     *            Value to set member attribute <b>totalCount</b>
     */
    public void setTotalCount(long totalCount) {
	this.totalCount = totalCount;
    }
    public long getTotalCount() { return totalCount; }



    /**
     * This method sets the value to the member attribute <b>resultSize</b>. You
     * cannot set null to the attribute.
     *
     * @param resultSize
     *            Value to set member attribute <b>resultSize</b>
     */
    public void setResultSize(int resultSize) {
	this.resultSize = resultSize;
    }

 
    public void setSortType(String sortType) {
	this.sortType = sortType;
    }
    public String getSortType() { return sortType; }


    /**
     * This method sets the value to the member attribute <b>sortBy</b>. You
     * cannot set null to the attribute.
     *
     * @param sortBy
     *            Value to set member attribute <b>sortBy</b>
     */
    public void setSortBy(String sortBy) {
	this.sortBy = sortBy;
    }
    public String getSortBy() { return sortBy; }







    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "VList [startIndex=" + startIndex + ", pageSize="
		+ pageSize + ", totalCount=" + totalCount
		+ ", resultSize=" + resultSize + ", sortType="
		+ sortType + ", sortBy=" + sortBy + ", queryTimeMS="
		+ queryTimeMS + "]";
    }
}
