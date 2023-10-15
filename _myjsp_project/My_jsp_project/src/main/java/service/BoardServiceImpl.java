package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	public BoardServiceImpl() {
		bdao= new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		log.info("board insert >>>> service");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("board list >>>> service");
		return bdao.getList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("board detail >>>> service");
		return bdao.selectOne(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info("board modify >>>> service");
		return bdao.modify(bvo);
	}

	@Override
	public String getFileName(int bno) {
		log.info("board file remove >>>> service");
		return bdao.getFileName(bno);
	}

	@Override
	public int remove(int bno) {
		CommentServiceImpl csv = new CommentServiceImpl();
		int isOk = csv.deleteAll(bno);
		log.info("board remove >>>> service");
		return bdao.remove(bno);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		log.info("board total count >>>> service");
		return bdao.getTotalCount(pgvo);
	}

	@Override
	public List<BoardVO> getPageList(PagingVO pgvo) {
		log.info("board page list >>>> service");
		return bdao.getPageList(pgvo);
	}

}
