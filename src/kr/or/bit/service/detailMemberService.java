package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;

public class detailMemberService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = null;
		ActionForward forward = null;
		KoreaMember m = null; 
		MemberDao dao = new MemberDao();
		System.out.println(request.getParameter("id"));

		try {			
			forward = new ActionForward();
			forward.setRedirect(false); //forward
			 //세션 다르면은 ㅃㅃㅇ 
			if (session.getAttribute("userid") == null ||
	    		!session.getAttribute("userid").equals("admin")) {
	    		//강제로 다른 페이지 이동
				//forward.setPath("/WEB-INF/views/memoview.jsp");
	    		//out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	    		forward.setPath("Ex02_JDBC_Login.jsp"); //TODO 로그인뷰 Path 넣어야  
	    	}else {
	    		m= dao.getMemoListById(request.getParameter("id"));
				request.setAttribute("member", m);
				forward.setPath("Ex03_Memberlist.jsp");
	    	}
						 
		}catch (Exception e) {
			System.out.println("detailMemberService " + e.getMessage());
		}
		return forward;
	}

}
