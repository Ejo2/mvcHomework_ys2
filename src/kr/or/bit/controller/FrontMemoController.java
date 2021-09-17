package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.deleteMemberService;
import kr.or.bit.service.detailMemberService;
import kr.or.bit.service.joinMemberService;
import kr.or.bit.service.loginMemberService;
import kr.or.bit.service.logoutMemberService;


@WebServlet("*.do")
public class FrontMemoController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    
    public FrontMemoController(){
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url_Command = requestURI.substring(contextPath.length());
        
        Action action = null;
        ActionForward forward = null;
        
        if(url_Command.equals("/JoinMember.do")) { //글쓰기 처리
    		//UI+로직
    		action = new joinMemberService();
    		forward = action.execute(request, response);
    	////////////서정
    	}else if(url_Command.equals("/login_page.do")) {
            response.sendRedirect("Ex02_JDBC_Login.jsp");
        }else if (url_Command.equals("/login.do")){ //
            action = new loginMemberService();
            forward = action.execute(request, response);
            System.out.println("로그인 실행");
        }else if(url_Command.equals("/logout.do")){
            action = new logoutMemberService();
            forward = action.execute(request, response);
            System.out.println("로그아웃 실행");
        //지혜
    	}else if (url_Command.equals("/deleteMember.do")){ 
            action = new deleteMemberService(); 
            forward = action.execute(request, response);
            System.out.println("deleteMemberService 실행");
        }else if(url_Command.equals("/detailMemberView.do")){
            action = new detailMemberService();
            forward = action.execute(request, response);
            System.out.println("detailMemberService 실행");
        }
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 
    			response.sendRedirect(forward.getPath());
    		}else { //false (모든 자원 ) 사용
    			//UI
    			//UI + 로직
    			//forward url 주소 변환 없어 View 내용을 받을 수 있다
    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
    	
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doProcess(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doProcess(request, response);
    }
    
}
