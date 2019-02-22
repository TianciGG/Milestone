// 登录页面，对用户名 、密码、验证码的约束，只有都不能为空时才允许进行登录操作
function validateCode() {
	var inputCode = document.getElementById("inputCode").value;
	if ($("#username").val().trim() == "") {
		alert("用户名不能为空");
		$("#username").val("").focus();
		return false;
	} else if ($("#password").val().trim() == "") {
		alert("密码不能为空");
		$("#password").val("").focus();
		return false;
	}
}


//登录页面，登录按钮事件
function mylogin() {
	if (validateCode()) {
		$.ajax({
			cache : true,
			type : "GET",
			url : "mylogin.do",
			data : {
				userName : $("#username").val(),
				userPwd : $("#password").val()
			},
			async : true,
			success : function(data) {
				if (data == "allok") {
					window.location.href = "goToMainPage.do";
				} else {
					alert("登陆失败");
				}
			}
		});
	}
}


//登录页面，注册按钮事件
function myreg() {
	window.location.href = "goToMyRegPage.do"
}
// 键盘enter建登录的事件
function KeyDown() {
	if (event.keyCode == 13) {
		event.returnValue = false;
		event.cancel = true;
		mylogin();
	}
}
