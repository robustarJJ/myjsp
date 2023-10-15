package domain;

public class BoardVO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String moddate;
	private int viewCount;
	private String imgFile;
	
	public BoardVO() {}
	
	//insert
	public BoardVO(String title, String writer, String content) {
		this.title=title;
		this.writer=writer;
		this.content=content;
	}
	
	//list
	public BoardVO(int bno, String title, String writer, String regdate, int viewCount) {
		this.bno=bno;
		this.title=title;
		this.writer=writer;
		this.regdate=regdate;
		this.viewCount=viewCount;
	}
	
	//update
	public BoardVO(int bno, String title, String content) {
		this.bno=bno;
		this.title=title;
		this.content=content;
	}

	//detail
	public BoardVO(int bno, String title, String writer, String content, String regdate, String moddate, int viewCount,
			String imgFile) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.moddate = moddate;
		this.viewCount = viewCount;
		this.imgFile = imgFile;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getImgFile() {
		return imgFile;
	}

	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", moddate=" + moddate + ", viewCount=" + viewCount + ", imgFile=" + imgFile + "]";
	}
	
	

	
	
	
}
