<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/Left.jsp"></jsp:include>

<jsp:include page="/common/Top.jsp"></jsp:include>
<!-- 지혜지혜 -->
<style>
      
      #mainimg {
            width       : 50%;
            margin      : 0 auto;
            padding-top : 30px;
            
      }
      
      #mainimg > img {
            width  : 100%;
            margin : 0 auto;
      }

</style>
<div class="content">
      <div class="container-fluid" id="mainimg">
            <img src="images/main.png">
            <p style="text-align: center; padding-top: 10px">Hello Welcome to 2조 Homepage</p>
                  <c:if test="${sessionScope.userid !=null}">
                        ${sessionScope.userid}회원님 안녕하세요^^<br>
                        <c:if test="${sessionScope.userid=='admin'}">
                              <a href='memberList.do'>회원관리</a>
                        </c:if>

                  </c:if>
      </div>
</div>

<div>
      <jsp:include page="/common/Bottom.jsp"></jsp:include>
</div>
