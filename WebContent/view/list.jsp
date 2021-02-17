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
	text-align: center;
	padding: 4px 10px;
	background-color: #F6F6F6;
}

th {
	text-align: center;
	padding: 4px 10px;
	background-color: #B2CCFF;
}
h2{text-align: center;}
table{width: 800px; margin: 0px auto;}
</style>
<script type="text/javascript">
	function write_go() {
		location.href = "/0208_MVC_Board/MyController?cmd=write";
	}
</script>
</head>
<body>
	<h2>Board 리스트</h2>
	<table width="700">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty list}">
				   <tr>
				   		<td colspan="5"><h3>원하시는 자료는 존재하지 않습니다.</h3></td>
				   </tr> 
				</c:when>
				<c:otherwise>
					<c:forEach var="k" items="${list}" varStatus="vs">
						<tr>
							<td>${paging.totalRecored-((paging.nowPage-1)*paging.numPerpage+vs.index)}</td>
							<td style="width: 50%; text-align: left;">
								<c:forEach begin="1" end="${k.step}">
									&nbsp;&nbsp;[RE]
								</c:forEach>
							<a href="/0208_MVC_Board/MyController?cmd=onelist&idx=${k.idx}&cPage=${paging.nowPage}">${k.title }</a></td>
							<td>${k.writer }</td>
							<td>${k.regdate.substring(0,10)}</td>
							<td>${k.hit}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<!-- 이전 -->
					<c:choose>
						<c:when test="${paging.beginBlock <= paging.pagePerBlock}"><span style="color: gray;">이전으로</span></c:when>
						<c:otherwise><a href="/0208_MVC_Board/MyController?cmd=list&cPage=${paging.beginBlock-paging.pagePerBlock}"><b>이전으로</b></a></c:otherwise>
					</c:choose>
					<!-- 페이지번호 -->
					<c:forEach begin="${paging.beginBlock }" end="${paging.endBlock }" step="1" var="k">
					<%-- 현재 페이지와 현재 페이지 아닌 것으로 나눈다. --%>
					<c:choose>
						<c:when test="${k==paging.nowPage}"><span style="color: gray;"><b>${k}</b></span></c:when>
						<c:otherwise><a href="/0208_MVC_Board/MyController?cmd=list&cPage=${k}"><b>${k}</b></a></c:otherwise>
					</c:choose>
					</c:forEach>
					<!-- 다음 -->
					<c:choose>
						<c:when test="${paging.endBlock >= paging.totalPage}"><span style="color: gray;">다음으로</span></c:when>
						<c:otherwise><a href="/0208_MVC_Board/MyController?cmd=list&cPage=${paging.beginBlock+paging.pagePerBlock}"><b>다음으로</b></a></c:otherwise>
					</c:choose>
				</td>
				<td>
					<button onclick="write_go()">글쓰기</button>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>