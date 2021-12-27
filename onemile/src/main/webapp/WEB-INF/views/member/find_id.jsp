<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<form action="${root}/member/find_id" method = "post">
	<div class="container-400 container-center">
	<div class="row center">
        	<h2>아이디 찾기</h2>
    </div>
    
    
	<label>이름</label>
	<div class="row">
		<input type="text" name="nick" class="form-input"  placeholder="이름을 입력하세요." required autocomplete="off">
	</div>
	<!-- <label>생년월일</label>
	<div class="row">
		<input type="text" name="phone" class="form-input" placeholder="생년월일 8자리를 입력하세요(예 20201010)" required autocomplete="off">
	</div> -->
	<label>전화번호</label>
	<div class="row">
		<input type="tel" name="phone" class="form-input" placeholder="휴대전화 입력(-포함)" required autocomplete="off">
	</div>
	<div class ="row">
		<input type="submit" value="아이디찾기" class="form-btn form-inline">
	</div>
</div>
</form>

<%if(request.getParameter("error") != null){ %>
	<div class="row center">
		<h4 class="error">존재하지 않는 회원입니다.</h4>
	</div>
<%}%>	

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>