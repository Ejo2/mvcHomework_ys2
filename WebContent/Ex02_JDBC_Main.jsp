<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <jsp:include page="/common/Left.jsp"></jsp:include>

      <jsp:include page="/common/Top.jsp"></jsp:include>

<style>

	#mainimg{
		width: 50%;
		margin : 0 auto;
		padding-top: 30px; 
		
	}
	#mainimg  > img{
		width: 100%;
		margin: 0 auto;
	}
</style>
 <div class="content">
    <div class="container-fluid" id="mainimg">
    	<img src="images/main.png">
    	<p style="text-align: center; padding-top: 10px">Hello Welcome to 2조 Homepage</p>
        <%
            String id = null;
            id = (String)session.getAttribute("userid");

            if(id != null){
                //회원
                out.print(id + " 회원님 방가방가^^<br>");
                if(id.equals("admin")){
                    out.print("<a href='Ex03_Memberlist.jsp'>회원관리</a>");
                }
            }else{
                //로그인 하지 않은 사용자
                //메인 페이지는 회원만 볼수 있어요 (강제 링크 추가)
                out.print("사이트 방문을 환영합니다 ^^ <br>회원가입 좀 하지 ...");
            }
        %>
    </div>
</div>

 <div>
    <jsp:include page="/common/Bottom.jsp"></jsp:include>
 </div>