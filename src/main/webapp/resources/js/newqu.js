$(document).ready(function(){
	$(".write_btn").on("click", function(e){
	if($("#question").val().length == 0){
		alert('질문을 입력해주세요.');
		e.preventdefault();
	} else if($("#answer").val().length ==0){
		alert("답변을 입력해주세요.")
		e.preventdefault();
	} else{		
	var formObj = $("form[name='writeform']");
	var cnoObj = $("input[name='cno']");
	var nameObj = $("input[name='name']");
	nameObj.attr("value", $("#category option:selected").attr('value'));
	cnoObj.attr("value", $("#category option:selected").attr('value2'));
	formObj.attr("action", "/board/newqu");
	formObj.attr("method", "post");
	formObj.submit();	
	}
	})
	
	
	$(".cancel_btn").on("click", function(){
		location.href= '/board/list?cno=1000';
	})
	
	
})