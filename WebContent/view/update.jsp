<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr {
		
	    text-align:center;
	    padding:4px 10px;
	    background-color: #F6F6F6;
	}
	
th {
		width:120px;
	    text-align:center;
	    padding:4px 10px;
	    background-color: #B2CCFF;
	}
h2{text-align: center;}
table{width: 800px; margin: 0px auto;}	
</style>
<script type="text/javascript">
	function list_go(f) {
		f.action="/0208_MVC_Board/MyController?cmd=list";
		f.submit();
	}
	function update_ok(f) {
		// 비밀번호 체크 
		if("${vo.pwd}"==f.pwd.value){
			f.action="/0208_MVC_Board/MyController?cmd=update_ok";
			f.submit();
		}else{
			alert("비빌번호 틀림\n다시 입력 주세요");
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
	}
</script>
</head>
<body>
	<h2>Board 수정하기</h2>
	<form method="post"  enctype="multipart/form-data">
		<table width="700">
			<tbody>
			<tr>
				<th bgcolor="#B2EBF4">작성자</th>
				<td> ${vo.writer} </td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">제목</th>
				<td> <input type="text" name="title" value="${vo.title }"></td>
			</tr>
			
			<tr>
				<th bgcolor="#B2EBF4">첨부파일</th>
				<td>
					<input type="file" name="file_name">${vo.file_name}<br>
					<input type="radio" name="f_name" value=""> 파일없음
					<input type="radio" name="f_name" value="${vo.file_name}" checked> 이전파일	
				</td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">내용</th>
				<td>
					<script src="https://cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
					<textarea name="content" >${vo.content}</textarea>
					<script>
                    	CKEDITOR.replace( 'content' );
                	</script>
				</td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			</tbody>
		<tfoot>
		<tr>
	     <td colspan="2">
	        <input type="button" value="저장" onclick="update_ok(this.form)" >
	        <input type="button" value="목록" onclick="list_go(this.form)" >
	        <input type="reset" value="취소" >
		    <input type="hidden" name="cPage" value="${cPage}" >
		    <input type="hidden" name="idx" value="${vo.idx}" >
	     </td>
		</tr>
		</tfoot>
		</table>
	</form>
</body>
</html>