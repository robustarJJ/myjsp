package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import repository.CommentDAO;
import repository.CommentDAOImpl;

public class CommentServiceImpl implements CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDAO cdao;
	
	public CommentServiceImpl() {
		cdao = new CommentDAOImpl();
	}

	@Override
	public int post(CommentVO cvo) {
		
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info("comment list >>>> service");
		return cdao.getList(bno);
	}

	@Override
	public int modify(CommentVO cvo) {
		log.info("comment modify >>>> service");
		return cdao.update(cvo);
	}

	@Override
	public int remove(int cno) {
		log.info("comment remove >>>> service");
		return cdao.delete(cno);
	}

	public int deleteAll(int bno) {
		log.info("comment deleteAll >>>> service");
		return cdao.deleteAll(bno);
	}
}
