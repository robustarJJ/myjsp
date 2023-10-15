package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;
	private String destPage;
	private int isOk;
	
	private MemberService msv;
	
	public MemberController() {
		msv = new MemberServiceImpl();
	}
   
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info("경로>> "+path);
		
		switch(path) {
		case "join":
			log.info("회원가입 페이지 열기");
			destPage="/member/join.jsp";
			break;
		
		case "register":
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id,pwd,email,age);
				isOk = msv.register(mvo);
				log.info("join >>>> "+(isOk>0? "OK":"Fail"));
				destPage="/index.jsp";				
			} catch (Exception e) {
				log.info("Member register error!!!!!");
				e.printStackTrace();
			}
			break;
			
		case "login":
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				MemberVO mvo = new MemberVO(id,pwd);
				MemberVO loginmvo = msv.login(mvo);
				log.info("login >>>> success!");
				if(loginmvo!=null) {
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginmvo);
					ses.setMaxInactiveInterval(30*60);
				}else {
					request.setAttribute("msg_login", 0);
				}
				destPage="/index.jsp";
				
			} catch (Exception e) {
				log.info("login error!!!!!");
				e.printStackTrace();
			}
			break;
			
		case "logout":
			try {
				HttpSession ses = request.getSession();
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");
				String id = mvo.getId();
				log.info("ses에서 ID추출: "+id);
				isOk=msv.logout(id);
				ses.invalidate();
				log.info("logout >>>> "+(isOk>0? "OK":"Fail"));
				destPage="/index.jsp";
			} catch (Exception e) {
				log.info("logout error!!!!!");
				e.printStackTrace();
			}
			break;
			
		case "list":
			try {
				List<MemberVO> list = msv.getList();
				request.setAttribute("list", list);
				log.info("list >>>> success!");
				destPage="/member/list.jsp";
			} catch (Exception e) {
				log.info("Member list error!!!!!");
				e.printStackTrace();
			}
			break;
		
		case "modify":
			destPage="/member/modify.jsp";
			break;
		
		case "update":
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id,pwd,email,age);
				isOk=msv.update(mvo);
				log.info("Member update >>>> "+(isOk>0? "Ok":"Fail"));
				destPage="/index.jsp";
			} catch (Exception e) {
				log.info("Member modify error!!!!!");
				e.printStackTrace();
			}
			break;
			
		case "remove":
			try {
				HttpSession ses = request.getSession();
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");
				String id = mvo.getId();
				isOk = msv.remove(id);
				ses.invalidate();
				log.info("Member remove >>>> "+(isOk>0?"Ok":"Fail"));
				destPage="/index.jsp";
			} catch (Exception e) {
				log.info("Member remove error!!!!!");
				e.printStackTrace();
			}
			break;
			
		}
		
		
		rdp=request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request,response);
	}

}
