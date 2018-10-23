package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageParam {

	private static final double PER = 10.0;
	private int page;
	private int display;
	
	private int total, start, end, bno;
	
	private boolean prev, next;
	
	private String type;
	private String keyword;
	
	private String types[];
	
	public PageParam() {
		this.page = 1;
		this.display = 10;
	}
	
	public void setType(String type) {
		this.type = type;
		if(type == null || type.trim().length() == 0) {
			this.types = null;
			return;
		}
		this.types = type.split("");
	}
	
	//계산을 미리 한다
	public int getSkip() {
		return (this.page - 1) * 10;	
	}
	
	public void setTotal(int total) {
		this.total = total;
		
		this.end = (int)(Math.ceil(this.page/PER)) * 10;
		this.start = this.end - 9;
		
		if((this.end * 10) >= total) {
			this.end = (int)(Math.ceil(total / 10.0));
			this.next = false;
		}else {
			this.next = true;
		}
		this.prev = this.start != 1;	
	}
	
	public String getLink(String path) {
		
		return UriComponentsBuilder.fromPath(path)
				.queryParam("bno", this.bno)
				.queryParam("page", this.page)
				.toUriString();
	}

	

	public static void main(String[] args) {
		
		PageParam obj = new PageParam();
		obj.setPage(123);
		obj.setTotal(7);
		
		System.out.println(obj.getLink("redirect:/board/read"));
		System.out.println(obj);
	}
}
