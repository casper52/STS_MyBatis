<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>To do List Board</h1>
<form method=post>
<input type=text id=register name='title' placeholder="내용을 입력하세요."></input>
<button id=add>Add</button>
</form>
<ul id=sub></ul>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  <script>
  var result = '${result}';
  if(result === 'SUCCESS'){
	  alert("등록에 성공했습니다.");
  }
  </script>
  
 <script>

	 $.getJSON("/todo/list2", function(data){
		console.log(data); 
		
		var str="";
		
		$(data).each(function(idx,obj){
			str += "<li>" + "글번호: "+obj.tno + " 내용: "+ obj.title +"</li>";
		});
		
		$("#sub").html(str);
	 });

 </script>
</body>
</html>