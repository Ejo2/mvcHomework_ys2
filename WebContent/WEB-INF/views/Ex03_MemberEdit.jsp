<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page import="kr.or.bit.utils.Singleton_Helper" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
<%--	/* --%>
<%--	회원정보 수정하기--%>
<%--	1.DB 쿼리 : 2개 (수정정보 : select , 수정정보반영 : update)--%>
<%--	 1.1 : select * from koreamember where id=?--%>
<%--	 1.2 : update koreamember set ename=? where id=?		 --%>
<%--	2.화면 1개(기존에 입력내용 보여주는 것)-> 처리 1개 (수정처리)--%>
<%--	 2.1  DB select 한 결과 화면 출력 --%>
<%--	   <input type="text" value="rs.getString(id)">--%>
<%--	      수정안하고 .. 화면 .. 전송(x) : <td>rs.getString("id")</td>--%>
<%--	      수정안하고 .. 화면 .. 전송   : <input type="text" value="rs.getString(id)" name="id" readonly>--%>
<%--	      수정하고 ..화면  ..전송   :  <input type="text" value="rs.getString(id)"  name="id">--%>
<%--	--%>
<%--	*/--%>
<%--	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin") ){--%>
<%--		//강제로 페이지 이동--%>
<%--		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");--%>
<%--	}--%>
<%--	--%>
<%--    request.setCharacterEncoding("UTF-8");--%>
<%--	String id = request.getParameter("id");--%>
<%--	--%>
<%--	--%>
<%--	--%>
<%--	Connection conn = null;--%>
<%--	PreparedStatement pstmt = null;--%>
<%--	ResultSet rs = null;--%>
<%--	try{--%>
<%--		conn = Singleton_Helper.getConnection("oracle");--%>
<%--		String sql="select id,pwd,name,age,trim(gender),email from koreamember where id=?";--%>
<%--		pstmt = conn.prepareStatement(sql);--%>
<%--		--%>
<%--		pstmt.setString(1,id);--%>
<%--		--%>
<%--		rs = pstmt.executeQuery(); --%>
<%--		--%>
<%--		//while(rs.next())--%>
<%--		rs.next(); //1건 데이터가 있다면 전제조건--%>
<%--%>	--%>

<jsp:include page="/common/Left.jsp"></jsp:include>

<jsp:include page="/common/Top.jsp"></jsp:include>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
      $(function() {
            $('#joinForm').submit(function() {
                  //alert("가입");
                  if ($('#id').val() == "") { // 아이디 검사
                        alert('ID를 입력해 주세요.');
                        $('#id').focus();
                        return false;
                  } else if ($('#pwd').val() == "") { // 비밀번호 검사
                        alert('PWD를 입력해 주세요.');
                        $('#pwd').focus();
                        return false;
                  } else if ($('#mname').val() == "") { // 이름 검사
                        alert('mname를 입력해 주세요.');
                        $('#mname').focus();
                        return false;
                  } else if ($('#age').val() == "") { // 나이 검사
                        alert('age를 입력해 주세요.');
                        $('#age').focus();
                        return false;
                  } else if ($('#email').val() == "") { // 우편번호
                        alert('email를 입력해 주세요.');
                        $('#email').focus();
                        return false;
                  }

            });
      });
</script>

<div class="content">
      <div class="container-fluid">
            <div class="row">
                  <div class="col-md-8">
                        <div class="card">
                              <div class="header">
                                    <h4 class="title">회원수정</h4>
                              </div>
                              <div class="content">
                                    <form action="editMemberOk.do" method="post">
                                          <c:set var="member" value="${requestScope.member}"/>
                                          <div class="row">
                                                <div class="col-md-5">
                                                      <div class="form-group">
                                                            <label>ID</label>
                                                            <input type="text" name="id" value="${member.id}" readonly>
                                                      </div>
                                                </div>
                                          </div>

                                          <div class="row">
                                                <div class="col-md-5">
                                                      <div class="form-group">
                                                            <label>PASSWORD</label>
                                                            <div>${member.pwd}</div>
                                                      </div>
                                                </div>
                                          </div>

                                          <div class="row">
                                                <div class="col-md-4">
                                                      <div class="form-group">
                                                            <label>Name</label>
                                                            <input type="text" name="name" value="${member.name}" >
                                                      </div>
                                                </div>
                                                <div class="col-md-2">
                                                      <div class="form-group">
                                                            <label>AGE</label>
                                                            <input type="text" name="age" value="${member.age}" >
                                                      </div>
                                                </div>
                                          </div>

                                          <div class="row">
                                                <div class="col-md-4">
                                                      <div class="form-group">
                                                            <label>GENDER</label>
                                                            <div>
                                                                  [${member.gender}]
                                                                  &nbsp;
                                                                  <input type="radio" name="gender" id="gender" value="여"
                                                                  <c:if test="${member.gender=='여'}">
                                                                         checked
                                                                  </c:if>>여자
                                                                  &nbsp;



                                                                  <input type="radio" name="gender" id="gender" value="남"
                                                                  <c:if test="${member.gender=='남'}">
                                                                         checked
                                                                  </c:if>>남자


                                                            </div>
                                                      </div>
                                                </div>
                                          </div>

                                          <div class="row">
                                                <div class="col-md-4">
                                                      <div class="form-group">
                                                            <label for="exampleInputEmail1">Email address</label>
                                                            <input type="text" name="email" value="${member.email}" >
                                                      </div>
                                                </div>
                                          </div>

                                          <input class="btn btn-info btn-fill pull-right" type="submit" value="수정하기">

                                          <a href='detailMemberView.do'>리스트이동</a>

                                          <div class="clearfix"></div>
                                    </form>
                              </div>
                        </div>
                  </div>
            </div>
      </div>
</div>

<div>
      <jsp:include page="/common/Bottom.jsp"></jsp:include>
</div>

