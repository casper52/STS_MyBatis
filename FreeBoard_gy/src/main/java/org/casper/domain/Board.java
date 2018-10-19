package org.casper.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Board {

	public Integer bno;
	public String title, content, writer;
	public Date regdate, updatedate;
}
