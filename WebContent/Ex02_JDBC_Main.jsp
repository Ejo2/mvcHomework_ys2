<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<jsp:include page="common/Left.jsp"></jsp:include>

<jsp:include page="common/Top.jsp"></jsp:include>
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
    </div>
</div>

 <div>
    <jsp:include page="common/Bottom.jsp"></jsp:include>
 </div>