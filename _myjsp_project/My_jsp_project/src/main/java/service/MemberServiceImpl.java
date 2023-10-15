package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public int register(MemberVO mvo) {
		log.info("join >>>> service");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info("login >>>> service");
		return mdao.login(mvo);
	}

	@Override
	public int logout(String id) {
		log.info("logout >>>> service");
		return mdao.logout(id);
	}

	@Override
	public List<MemberVO> getList() {
		log.info("Member list >>>> service");
		return mdao.getList();
	}

	@Override
	public int update(MemberVO mvo) {
		log.info("Member update >>>> service");
		return mdao.memberUpdate(mvo);
	}

	@Override
	public int remove(String id) {
		log.info("Member remove >>>> service");
		return mdao.deleteMember(id);
	}

}
