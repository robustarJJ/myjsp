package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO selectOne(int bno);

	int modify(BoardVO bvo);

	String getFileName(int bno);

	int remove(int bno);

	int getTotalCount(PagingVO pgvo);

	List<BoardVO> getPageList(PagingVO pgvo);



}
