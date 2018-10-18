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
									<td><c:out value="${board.title}" /></td>
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

	<!-- /.col-lg-6 -->
	<div class="dataTables_paginate paging_simple_numbers"
		id="dataTables-example_paginate">
		<ul class="pagination">
			<li class="paginate_button previous disabled"
				aria-controls="dataTables-example" tabindex="0"
				id="dataTables-example_previous"><a href="#">Previous</a></li>
			<li class="paginate_button active" aria-controls="dataTables-example"
				tabindex="0"><a href="#">1</a></li>
			<li class="paginate_button " aria-controls="dataTables-example"
				tabindex="0"><a href="#">2</a></li>
			<li class="paginate_button " aria-controls="dataTables-example"
				tabindex="0"><a href="#">3</a></li>
			<li class="paginate_button " aria-controls="dataTables-example"
				tabindex="0"><a href="#">4</a></li>
			<li class="paginate_button " aria-controls="dataTables-example"
				tabindex="0"><a href="#">5</a></li>
			<li class="paginate_button " aria-controls="dataTables-example"
				tabindex="0"><a href="#">6</a></li>
			<li class="paginate_button next" aria-controls="dataTables-example"
				tabindex="0" id="dataTables-example_next"><a href="#">Next</a></li>
		</ul>
	</div>
</div>

</div>
<!-- /#page-wrapper -->
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

		var msg = $("#myModal");
		var result = '<c:out value="${result}"/>';

		if (result === 'SUCCESS') {
			$(".modal-body").html("글 등록에 성공하였습니다.");
			msg.modal("show");
			
		}
	});
</script>
</body>

</html>
