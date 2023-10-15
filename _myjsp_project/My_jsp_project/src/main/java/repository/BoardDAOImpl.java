package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	private final String NS = "BoardMapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql=DatabaseBuilder.getFactory().openSession();
	}
	
	

	@Override
	public int insert(BoardVO bvo) {
		int isOk = sql.insert(NS+"add",bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}



	@Override
	public List<BoardVO> getList() {
		log.info("board list >>>> DAO");
		return sql.selectList(NS+"list");
	}



	@Override
	public BoardVO selectOne(int bno) {
		log.info("board detail >>>> DAO");
		sql.update(NS+"view", bno);
		sql.commit();
		return sql.selectOne(NS+"detail", bno);
	}



	@Override
	public int modify(BoardVO bvo) {
		log.info("board modify >>>> DAO");
		int isOk = sql.update(NS+"modify", bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}



	@Override
	public String getFileName(int bno) {
		log.info("board file remove >>>> DAO");
		return sql.selectOne(NS+"fileName", bno);
	}



	@Override
	public int remove(int bno) {
		log.info("board remove >>>> DAO");
		int isOk = sql.delete(NS+"delete", bno);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}



	@Override
	public int getTotalCount(PagingVO pgvo) {
		log.info("board total count >>>> DAO");
		return sql.selectOne(NS+"totalCount", pgvo);
	}



	@Override
	public List<BoardVO> getPageList(PagingVO pgvo) {
		log.info("board page list >>>> DAO");
		return sql.selectList(NS+"page", pgvo);
	}

}
