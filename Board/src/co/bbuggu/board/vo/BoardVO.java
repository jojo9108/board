package co.bbuggu.board.vo;

import java.sql.Date;

public class BoardVO {
	private String boardId;
	private String writer;
	private String title;
	private String subject;
	private Date enterdate;
	private int hit;
	
	public BoardVO() {
		
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getEnterdate() {
		return enterdate;
	}

	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return " | boardNo | " + boardId + " | writer | " + writer + " | title | " + title + " | subject | " + subject
				+ " | enterdate | " + enterdate + " | hit | " + hit ;
	}
	
	
	
}
