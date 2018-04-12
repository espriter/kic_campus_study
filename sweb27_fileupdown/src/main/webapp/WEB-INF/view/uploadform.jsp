<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 파일 업로드/다운로드 ** <br>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<form:form enctype="multipart/form-data" modelAttribute="uploadFile">
업로드할 파일 선택 : <br>
<input type="file" name="file">
<form:errors path="file" cssStyle="color:red" />
<br><Br>
<input type="submit" value="전송">
</form:form>
</body>
</html>