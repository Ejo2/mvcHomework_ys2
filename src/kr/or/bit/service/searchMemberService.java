package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

/*
 
 */
public class searchMemberService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
        ActionForward forward = null;
        try{
            MemberDao dao = new MemberDao();
            KoreaMember dto = dao.searchMemberByName(request.getParameter("name"));
            request.setAttribute("member", dto);
    
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("/Ex03_MemberSearch.jsp");
        }catch (Exception e){
            System.out.println(e.getMessage());
            
        }
        return forward;
    }
    
}

























