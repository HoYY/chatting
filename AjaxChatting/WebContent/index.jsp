<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%; overflow:100%;">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"	>
	<title>Ajax Chatting</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		//$(document).ready( function(){ setInterval( function(){ update(); }, 1000 ); });
		function chsubmit() {
			var msg = $("#msg").val();
			$.ajax({
				url: "./ChattingServlet",
				type: "POST",
				data:{
					name: name,
					msg: msg,
					index: "submit"
				},
				success: function(data){
					if(data == "0"){
						alert('공백 노노해');
					} else {
						$('#chatList').html(data); 
						$('#scrolltop').scrollTop($('#scrolltop').prop('scrollHeight'));
						console.log(data);
					}
				},
				complete: function(){
					$("#mag").val("");
				}
			});
		}
		
		function update(){
			$.ajax({
				url:"./ChattingServlet",
				type: "POST",
				data: {
					index: "update"
				},
				success: function(result){
					$('#chatList').html(result);
				}
			});
		}
		
		function name() {
			var name = $("#name").val();
			$.ajax({
				url: "./ChattingServlet",
				type: "POST",
				data:{
					name: name,
					index: "name"
				},
				success: function(data){
					if(data == "0"){
						alert('공백 노노해');
					} else {
						$('#chatList').html(data); 
						$('#scrolltop').scrollTop($('#scrolltop').prop('scrollHeight'));
						console.log(data);
					}
				}
			});
		}
	</script>
</head>
<body>
	<div style="background:gray; position: absolute; left:50%; transform:translateX(-50%); height:550px; padding:0 10px 10px 10px; width:400px; border-radius:1%;"><h2>Ajax Chatting</h2>
		<div id="scrolltop" style="background:white; overflow-y:auto; height:60%; padding:0 10px 0 10px; border-radius:1%;">
			<div id="chatList">
			</div>
			<div id="name" align="center" style="background:white; margin:100px auto; width:200px; height:100px; border:2px solid red; border-radius:5%;">
				<p>닉네임</p>
				<input type="text" id="name"/>
				<input type="button" onclick="name();" value="확인"/>
			</div>
		</div>
		<div height="50px">
			<textarea height="35px" style="width:99%;" id="msg" placeholder="내용"></textarea>
		</div>
		<p>
			<button type="button" id="aa" onclick="chsubmit();">전송</button>
		</p>
	</div>
</body>
</html>