package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import handler.FileHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	private RequestDispatcher rdp;
	private BoardService bsv;
	private String destPage;
	private int isOk;
	private String savePath; //파일경로를 저장할 변수
	    
    public BoardController() {
    	bsv = new BoardServiceImpl(); 
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info("경로>> "+path);
		
		
		
		switch(path) {
		case "register":
			destPage="/board/register.jsp";
			log.info("글쓰기 페이지로 이동");
			break;
		
			
		case "insert":
			try {
				savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				log.info("파일저장위치 : "+savePath);
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(10*1024*1024);
				
				BoardVO bvo = new BoardVO();
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				List<FileItem> itemList = fileUpload.parseRequest(request);
				for(FileItem item : itemList) {
					switch(item.getFieldName()) {
					case "title":
						bvo.setTitle(item.getString("utf-8"));
						break;
					case "writer":	
						bvo.setWriter(item.getString("utf-8"));
						break;
					case "content":	
						bvo.setContent(item.getString("utf-8"));
						break;
					case "imgFile":
						if(item.getSize()>0) {
							String fileName = item.getName().substring(item.getName().lastIndexOf("/")+1);
							fileName = System.currentTimeMillis()+"_"+fileName;
							File uploadFilePath = new File(fileDir+File.separator+fileName);
							log.info("파일경로+이름"+uploadFilePath);
							try {
								item.write(uploadFilePath);
								bvo.setImgFile(fileName);
								Thumbnails.of(uploadFilePath).size(60, 60)
								.toFile(new File(fileDir+File.separator+"_th_"+fileName));
							} catch (Exception e) {
								log.info("file disk error!!!!!");
								e.printStackTrace();
							}
						}
						break;
											
					}
				}
				
				isOk = bsv.register(bvo);
				log.info("Board insert >>>> "+(isOk>0? "OK":"Fail"));
				destPage="pageList";
				
			} catch (Exception e) {
				log.info("Board insert error!!!!!");
				e.printStackTrace();
			}
			break;
		
			
		case "list":
			try {
				List<BoardVO> list = bsv.getList();
				log.info(list.get(0).toString());
				request.setAttribute("list", list);
				destPage="/board/list.jsp";
			} catch (Exception e) {
				log.info("Board list error!!!!!");
				e.printStackTrace();
			}
			break;
			
			
		case "pageList":
			try {
				PagingVO pgvo = new PagingVO();
				if(request.getParameter("pageNo") != null) {
					int pageNo = Integer.parseInt(request.getParameter("pageNo"));
					int qty = Integer.parseInt(request.getParameter("qty"));
					pgvo = new PagingVO(pageNo, qty);
				}
				String type = request.getParameter("type");
				String keyword = request.getParameter("keyword");
				pgvo.setType(type);
				pgvo.setKeyword(keyword);
				log.info("type: "+pgvo.getType()+", "+"keyword: "+pgvo.getKeyword());
				int totalCount = bsv.getTotalCount(pgvo);
				log.info("전체게시글수: "+totalCount);
				List<BoardVO> list = bsv.getPageList(pgvo);
				request.setAttribute("list", list);
				PagingHandler ph = new PagingHandler(pgvo, totalCount);
				request.setAttribute("ph", ph);
				log.info(">>>>paging 성공");
				destPage="/board/list.jsp";
			} catch (Exception e) {
				log.info("Board paging error!!!!!");
				e.printStackTrace();
			}
			break;
			
			
		case "detail":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = bsv.getDetail(bno);
				log.info("board bvo >>>> "+bvo);
				request.setAttribute("bvo", bvo);
				destPage="/board/detail.jsp";
			} catch (Exception e) {
				log.info("Board detail error!!!!!");
				e.printStackTrace();
			}
			break;
			
			
		case "modify":
			try {
				int bno =Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = bsv.getDetail(bno);
				request.setAttribute("bvo", bvo);
				destPage="/board/modify.jsp";
			} catch (Exception e) {
				log.info("Board modify error!!!!!");
				e.printStackTrace();
			}
			break;
			
			
		case "edit":
			try {
				savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(10*1024*1024);
				
				BoardVO bvo = new BoardVO();
				
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				log.info("Board Modify update >>>> check 1");
				
				List<FileItem> itemList = fileUpload.parseRequest(request);
				
				String old_file = null;
				
				for(FileItem item : itemList) {
					switch(item.getFieldName()) {
					case "bno":
						bvo.setBno(Integer.parseInt(item.getString("utf-8")));
						break;
					case "title":
						bvo.setTitle(item.getString("utf-8"));
						break;
					case "content":
						bvo.setContent(item.getString("utf-8"));
						break;
					case "imgFile":
						old_file = item.getString("utf-8");
						break;
					case "new_file":
						if(item.getSize()>0) {
							if(old_file != null) {
								FileHandler fileHandler = new FileHandler();
								isOk = fileHandler.deleteFile(old_file, savePath);
							}
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
							log.info("new_fileName"+fileName);
							
							fileName = System.currentTimeMillis()+"_"+fileName;
							
							File uploadFilePath = new File(fileDir+File.separator+fileName);
							try {
								item.write(uploadFilePath);
								bvo.setImgFile(fileName);
								//썸네일
								Thumbnails.of(uploadFilePath)
								.size(60, 60)
								.toFile(new File(fileDir+File.separator+"_th_"+fileName));
							} catch (Exception e) {
								log.info("new File save error!!!!!");
								e.printStackTrace();
							}
							
						}else {
							bvo.setImgFile(old_file);
						}
						break;
					}
				}
				
				isOk = bsv.modify(bvo);
				log.info("Board modify >>>> "+(isOk>0? "OK":"Fail"));
				destPage="pageList";
				
			} catch (Exception e) {
				log.info("Board edit error!!!!!");
				e.printStackTrace();
			}
			break;
			
			
		case "remove":	
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				String fileName = bsv.getFileName(bno);
				savePath = getServletContext().getRealPath("/_fileUpload");
				FileHandler filehandler = new FileHandler();
				isOk = filehandler.deleteFile(fileName, savePath);
				log.info((isOk > 0)? "file remove OK" : "file remove fail");
				
				isOk = bsv.remove(bno);
				log.info("Board remove >>>> "+((isOk>0)? "Ok": "Fail"));
				destPage="pageList";
				
			} catch (Exception e) {
				log.info("remove error");
				e.printStackTrace();
			}
			break;
		
		}
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request, response);
	}

}
