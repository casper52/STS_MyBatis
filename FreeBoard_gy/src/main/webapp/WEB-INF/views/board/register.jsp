<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">



<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/register" method="post">
                                        <div class="form-group">
                                            <label>Title</label>
                                            <input class="form-control" name="title">
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                          <div class="form-group">
                                            <label>Writer</label>
                                            <input class="form-control" name="writer">
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        
                                       
                                        <div class="form-group">
                                            <label>Content</label>
                                            <textarea class="form-control" rows="3" name="content"></textarea>
                                        </div>
                                        
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>

	<div class="dataTables_paginate paging_simple_numbers"
		id="dataTables-example_paginate">
		<ul class="pagination">
			<li class="paginate_button previous disabled"
				aria-controls="dataTables-example" tabindex="0"
				id="dataTables-example_previous"><a href="#">Previous</a></li>
			<li class="paginate_button active" aria-controls="dataTables-example"
				tabindex="0"><a href="#">1</a></li>
			
			<li class="paginate_button next" aria-controls="dataTables-example"
				tabindex="0" id="dataTables-example_next"><a href="#">Next</a></li>
		</ul>
	</div>
	<%@include file="../includes/footer.jsp"%>
	</body>
</html>
