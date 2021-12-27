<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<form method="post" enctype="multipart/form-data">

<div class="container-400 container-center">
	<div class="row center">
		<h1>회원가입</h1>
	</div>
	<div class="row">
		<label>이메일</label>
		<input type="email" name="email" required class="form-input">
	</div>
	<div class="row">
		<label>비밀번호</label>
		<input type="password" name="pw" required class="form-input">
	</div>
	<div class="row">
		<label>비밀번호 확인</label>
		<input type="password" class="form-input">
	</div>
	<div class="row">
		<label>닉네임</label>
		<input type="text" name="nick" required class="form-input">
	</div>
	<div class="row">
		<label>연락처</label>
		<input type="tel" name="phone" class="form-input">
	</div>
	<div class="row">
		<label class="form-block">생년월일</label>
		<input type="date" name="birth" required class="form-input form-inline">
	</div>
	
	<div class="row">
		<label>프로필 이미지</label>
		<input type="file" name="attach" accept="image/*" class="form-input">
	</div>
	<div class="row">
		<input type="submit" value="가입" class="form-btn">
	</div>
	<div class="row" >
			<label>성별</label>
			<br>
			<select name="gender" style="width:22%">
				<option value="남자" selected align="center">남자</option>
				<option value="여자" align="center">여자</option>
				<option value="기타" align="center">기타</option>
			</select>
		</div>
		<div class="row">
		<textarea rows="10" cols="50">자기소개</textarea>
		</div>
		<div class="row" >
			<label>MBTI</label>
			<br>
			<select name="mbti" style="width:22%">
				<option value="남" selected align="center">INFP<option>
			</select>
		</div>
		<div class="row">
		<label>백신접종상태</label>
		<input type="file" name="attach" accept="image/*" class="form-input">
	</div>
	
</div>
	
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>