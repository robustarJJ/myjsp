package domain;

public class PagingVO {
	private int pageNo; //현재 화면에 출력되는 페이지네이션 번호
	private int qty; //한페이지당 보여질 게시글수
	private String type; //검색대상	
	private String keyword; //검색어
	
	public PagingVO() {
		this(1,10);
	}
	
	public PagingVO(int pageNo, int qty) {
		this.pageNo=pageNo;
		this.qty=qty;
	}
	
	public int getPageStart() {
		return (pageNo-1) * qty;
	}
	
	public String[] getTypeToArray() {
		return this.type==null? new String[] {} : this.type.split("");
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
}
