function register() {
	var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
	if ($('#name').val().trim() == "") {
		alert("用户名不能为空");
		$("#name").val("").focus();
		return false;
	} else if($('#email').val().trim() ==""){
		alert("电子邮件不能为空！");
		$('#email').val("").focus();
		return false;
	}else if(!myReg.test($('#email').val().trim())){
		alert("电子邮件格式错误重新输入！");
		$('#email').focus();
		return false;
	}else if ($('#password1').val().trim() == "") {
		alert("密码不能为空");
		$('#password1').val("").focus();
		return false;
	} else if ($('#password2').val().trim() == "") {
		alert("再次输入不能为空");
		$('#password2').val("").focus();
		return false;
	} else if ($('#password1').val().trim() != $('#password2').val().trim()) {
		alert("两次输入密码不同");
		$('#password1').val("").focus();
		$('#password2').val("");
		return false;
	} else {
		var name = $('#name').val().trim();
		var email=$('#email').val().trim();
		var password = $('#password2').val().trim();
		var url = "user/registerUser.do"
		$.post(url, {
			userName : name,
			userMail : email,
			userPassword : password
		}, function(data) {
			if (data.status == "200") {
				alert(data.msg);
				window.location.href = 'index.jsp';
			} else {
				alert(data.msg);
			}
		});
	}

}