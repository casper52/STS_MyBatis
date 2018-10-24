<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">



<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">List</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading">Board</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>No</th>
								<th>Title</th>
								<th>Writer</th>
								<th>Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="board">
								<tr>
									<td><c:out value="${board.bno}" /></td>
									<td><c:out value="${board.title}" /></td>
									<td><c:out value="${board.writer}" /></td>
									<td><c:out value="${board.regdate}" /></td>
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
</div>
<button type="button" class="btn btn-outline btn-primary btn-lg"
	onclick="location.href='/board/register'">글쓰기</button>

<div class="dataTables_paginate paging_simple_numbers"
	id="dataTables-example_paginate">
	<ul class="pagination">
	<c:if test="${pageObj.prev}">
		<li class="paginate_button previous disabled"
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

<form id='actionForm'>
	<input type = 'hidden' name='page' id='page'>
</form>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
</div>
	
	<%@include file="../includes/footer.jsp"%>

	<script>
		$(document).ready(function() {
			
			//페이징
			var actionForm = $("#actionForm");
			var pageNum = ${pageObj.page};
			
			$('.pagination li[data-page='+pageNum+']').addClass("active");
			
			$('.pagination li a').on("click",function(e){
				
				e.preventDefault();
				var target = $(this).attr("href");
				$("#page").val(target);
				console.log(target);
				actionForm.attr("action","/board/list").attr("method","get").submit();
			})
			
			//모달
			var msg = $("#myModal");
			var result = '<c:out value="${result}"/>';

			if (result === 'SUCCESS') {
				$(".modal-body").html("작업 성공");
				msg.modal("show");
			}
		});
	</script>
	</body>
</html>
