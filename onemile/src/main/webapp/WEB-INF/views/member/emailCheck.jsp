<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>인증번호 입력</h1>

<form action="emailCheck" method="post">
	이메일 : <input type="text" name="email" value="${email}" required readonly="readonly">
	<br><br>
	인증번호 : <input type="text" name="serial" required>
	<br><br>
	<input type="submit" value="인증완료">
</form>