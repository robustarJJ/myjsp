package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	int register(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO getDetail(int bno);

	int modify(BoardVO bvo);

	String getFileName(int bno);

	int remove(int bno);

	int getTotalCount(PagingVO pgvo);

	List<BoardVO> getPageList(PagingVO pgvo);



}
