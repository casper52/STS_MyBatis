<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">List</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board List</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>TNO</th>
								<th>TITLE</th>
								<th>WRITER</th>
								<th>REGDATE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="board">
								<tr>
									<td><c:out value="${board.bno}" /></td>
									<td><a href='${board.bno}' class = 'board' ><c:out value="${board.title}" /></a></td>
									<td><c:out value="${board.writer}" /></td>
									<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss "/> </td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<button type="button" class="btn btn-outline btn-primary btn-lg" onclick="location.href='/board/register'">글쓰기</button>

	<div class="col-sm-12">
		  <div>
		    <select name="type">
		      <option value=""
		       <c:out value="${pageObj.type == null?'selected':'' }"/>>--</option>
		      <option value="t" <c:out value="${pageObj.type == 't'?'selected':'' }"/> >제목</option>
		      <option value="c" <c:out value="${pageObj.type == 'c'?'selected':'' }"/> >내용</option>
		      <option value="w" <c:out value="${pageObj.type == 'w'?'selected':'' }"/> >작성자</option>
		      <option value="tc" <c:out value="${pageObj.type == 'tc'?'selected':'' }"/> >제목 + 내용</option>
		      <option value="tcw" <c:out value="${pageObj.type == 'tcw'?'selected':'' }"/> >제목 + 내용 + 작성자</option>
		    </select>
		    <input type='text' name='keyword' value="${pageObj.keyword}">
		    <button id="searchBtn">Search</button>
		  </div>
		</div>

	<!-- /.col-lg-6 -->
<div class="col-sm-12">
	<div class="dataTables_paginate paging_simple_numbers"
		id="dataTables-example_paginate">
		<ul class="pagination">
		<c:if test="${pageObj.prev}">
			<li class="paginate_button previous"
				aria-controls="dataTables-example" tabindex="0"
				id="dataTables-example_previous"><a href="${pageObj.start-1}">Previous</a></li>
		</c:if>
		<c:forEach begin="${pageObj.start}" end="${pageObj.end}" var="num">
			<li class="paginate_button" data-page='${num}' aria-controls="dataTables-example"
				tabindex="0"><a href="${num}"><c:out value="${num}"/></a></li>
		</c:forEach>
		<c:if test="${pageObj.next}">
			<li class="paginate_button next" aria-controls="dataTables-example"
				tabindex="0" id="dataTables-example_next"><a href="${pageObj.end+1}">Next</a></li>
		</c:if>
		</ul>
	</div>
</div>


<!-- /#page-wrapper -->

<form id='actionForm'>
	<input type='hidden' name='page' id='page' value='${pageObj.page}'>
	<input type='hidden' name='type' value='${pageObj.type}'>
  	<input type='hidden' name='keyword' value='${pageObj.keyword}'>
</form>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<%@include file="../includes/footer.jsp"%>


<script>
	$(document).ready(function() {
		
		var actionForm = $("#actionForm");
		var pageNum = ${pageObj.page};
		
		console.log( $(".boardClass"));
		
		$(".board").on("click", function(e){
			
			e.preventDefault();
			
			var bno = $(this).attr("href");
			
			console.log("bno: " + bno);
			
			actionForm.append("<input type='hidden' name='bno' value='"+bno+"'>");
			actionForm.attr("action","/board/read").attr("method","get").submit();
		});
		
		$('.pagination li[data-page='+pageNum+']').addClass("active");	// 속성으로 찾을 수 있다
		
		$('.pagination li a').on("click",function(e){
			
			e.preventDefault(); //기본동작을 막아버림
			var target = $(this).attr("href");
			$("#page").val(target);
			console.log(target);
			actionForm.attr("action","/board/list").attr("method","get").submit();
			
			
	
		});
		
			$("#searchBtn").on("click", function(e){
			
			var searchTypeValue = $("select[name='type'] option:selected").val();
			console.log(searchTypeValue);
			
			var searchKeyword = $("input[name='keyword']").val();
			console.log(searchKeyword);
			
			if(searchKeyword.trim().length == 0 ){
				alert("검색어 없음");
				return;
			}
			
			
			actionForm.attr("action","/board/list");
			actionForm.find("input[name='type']").val(searchTypeValue);
			actionForm.find("input[name='keyword']").val(searchKeyword);
			$("#page").val(1);
			
			actionForm.submit();
			
			
		});

		var msg = $("#myModal");
		var result = '<c:out value="${result}"/>';

		checkModal(result);
		
		history.replaceState({},null,null);
		
		function checkModal(result){
			
			if(result === ''||history.state){
				return;
			}
		
		if (result === 'SUCCESS') {
			$(".modal-body").html("성공하였습니다.");
			msg.modal("show");
			
			}
		}
	});
</script>
</body>

</html>
