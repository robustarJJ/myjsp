package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	private final String NS = "MemberMapper.";
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		log.info("join >>>> DAO");
		int isOk = sql.insert(NS+"add", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info("login >>>> DAO");
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	public int logout(String id) {
		log.info("logout >>>> DAO");
		int isOk = sql.update(NS+"logout", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<MemberVO> getList() {
		log.info("Member list >>>> DAO");
		return sql.selectList(NS+"list");
	}

	@Override
	public int memberUpdate(MemberVO mvo) {
		log.info("Member update >>>> DAO");
		int isOk = sql.update(NS+"member_update", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int deleteMember(String id) {
		log.info("Member remove >>>> DAO");
		int isOk = sql.delete(NS+"remove", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

}
