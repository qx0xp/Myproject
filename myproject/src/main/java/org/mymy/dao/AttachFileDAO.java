package org.mymy.dao;

import org.mymy.model.AttachFileDTO;

public interface AttachFileDAO {
	// tbl_attach insert
	public void addBoardAttach(AttachFileDTO adto);
	
	// tbl_attch delete
	public void removeBoardAttach(AttachFileDTO adto);
}
