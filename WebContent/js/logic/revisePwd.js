function validateEmail() {
	var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
	if($('#email').val().trim() ==""){
		alert("电子邮件不能为空！");
		$('#email').val("").focus();
		return false;
	}else if(!myReg.test($('#email').val().trim())){
		alert("电子邮件格式错误重新输入！");
		$('#email').focus();
		return false;
	}else {
		var email=$('#email').val().trim();
		var url = "user/validateEmail.do"
		$.post(url, {
			mail : email
		}, function(data) {
			if (data.status == "200") {
				alert(data.msg);
			} else {
				alert(data.msg);
			}
		});
	}

}