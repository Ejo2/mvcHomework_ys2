<%@page import="kr.or.bit.utils.ConnectionHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<%
      /*
          회원 상세 페이지 (id 컬럼 PK)
          1.권한 검사
          2.id 값 받기 (request.getparameter("id")) >> 한글처리
          3.select id,pwd,name,age,gender,email from koreamember where id=?
          4.id primary key (데이터 1건 보장)
          5.화면 출력 UI 구성
      */
/*  
1.관리자만 접근 가능한 페이지
2.로그인한 일반 회원이 주소값을 외워서 ... 접근불가 
3.그러면  회원에 관련되 모든 페이지 상단에는 아래 코드를 ..... : sessionCheck.jsp >> include 
*/


%>
<!DOCTYPE html>
<html>
<head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
      <style type="text/css">
            table {
                  border: solid 2px black;
                  border-collapse: collapse;
            }
            
            tr {
                  border: solid 1px blue;
                  background-color: white;
                  color: black;
            }
            
            td {
                  border: solid 1px red;
            }
      </style>
</head>
<body>
<c:set var="member" value="${requestScope.member}"></c:set>

<table
        style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
      <tr>
            <td colspan="2">
                  <jsp:include page="/common/Top.jsp"></jsp:include>
            </td>
      </tr>
      <tr>
            <td style="width: 200px">
                  <jsp:include page="/common/Left.jsp"></jsp:include>
            </td>
            <td style="width: 700px">
                  
                  <table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto;">
                        <tr>
                              <td style="width:100px">아이디</td>
                              <td style="width:100px">${member.id}</td>
                        </tr>
                        <tr>
                              <td style="width:100px">비번</td>
                              <td style="width:100px">${member.pwd}</td>
                        </tr>
                        <tr>
                              <td style="width:100px">이름</td>
                              <td style="width:100px">${member.name}</td>
                        </tr>
                        <tr>
                              <td style="width:100px">나이</td>
                              <td style="width:100px">${member.age}</td>
                        </tr>
                        <tr>
                              <td style="width:100px">성별</td>
                              <td style="width:100px">${member.gender}</td>
                        </tr>
                        <tr>
                              <td style="width:100px">이메일</td>
                              <td style="width:100px">${member.email}</td>
                        </tr>
                        <tr>
                              <td colspan="2">
                                    <a href="memberList.do">목록가기</a>
                              </td>
                        </tr>
                  </table>
            
            </td>
      </tr>
      <tr>
            <td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
      </tr>
</table>
</body>
</html>