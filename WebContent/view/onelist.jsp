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
	function update_go(f) {
		f.action="/0208_MVC_Board/MyController?cmd=update";
		f.submit();
	}
	function delete_go(f) {
		f.action="/0208_MVC_Board/MyController?cmd=delete";
		f.submit();
	}
	function ans_write(f) {
		f.action="/0208_MVC_Board/MyController?cmd=ans_write";
		f.submit();
	}
</script>
</head>
<body>
	<h2>Board 상세보기</h2>
	<form method="post">
		<table width="700">
			<tbody>
			<tr>
				<th bgcolor="#B2EBF4">작성자</th>
				<td> ${vo.writer}</td>
			</tr>
			
			<tr>
				<th bgcolor="#B2EBF4">제목</th>
				<td> ${vo.title }</td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">날짜</th>
				<td> ${vo.regdate.substring(0,10)} </td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">첨부파일</th>
				<c:choose>
					<c:when test="${empty vo.file_name}">
						<td><b> 첨부파일없음 </b></td>
					</c:when>
					<c:otherwise>
						<td>
							<img src="upload/${vo.file_name}" style="width: 100px">
							<a href="view/download.jsp?path=upload&file_name=${vo.file_name}">${vo.file_name }</a>
						</td>
					</c:otherwise>
				</c:choose> 
			</tr>
			
			<tr>
				<th bgcolor="#B2EBF4">내용</th>
				<td>
					<script src="https://cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
					<textarea name="content" readonly><pre>${vo.content}</pre></textarea>
					<script>
                    	CKEDITOR.replace( 'content' );
                	</script>
				</td>
			</tr>
			</tbody>
		<tfoot>
		<tr>
	     <td colspan="2">
	        <input type="button" value="목록" onclick="list_go(this.form)" />
	        <input type="button" value="답글" onclick="ans_write(this.form)" />
	        <input type="button" value="수정" onclick="update_go(this.form)" />
	        <input type="button" value="삭제" onclick="delete_go(this.form)" />
		    <input type="hidden" name="cPage" value="${cPage}" />
	     </td>
		</tr>
		</tfoot>
		</table>
	</form>
</body>
</html>