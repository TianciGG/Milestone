$(document).ready(function(){
        //记住密码功能
        var str = getCookie("loginInfo");
        str = str.substring(0,str.length);
        var username = str;
        //var password = str.split(",")[1];
        if (str != null && str != ""){
        	//自动填充用户名和密码
        	$("#username").val(username);
        	//$("#password").val(password);
        	$("input[id='remember']").prop('checked',true);
        }
});
//获取cookie
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}
//记住密码功能
function rememberMe(){
    var remFlag = $("input[id='remember']").is(':checked');
    if(remFlag==true){ //如果选中设置remFlag为1
        //cookie存用户名和密码,回显的是真实的用户名和密码,存在安全问题.
        var conFlag = confirm("记录密码功能不宜在公共场所(如网吧等)使用,以防密码泄露.您确定要使用此功能吗?");
        if(conFlag){ //确认标志
        	$("input[id='remember']").prop('checked',true);
            $("#remFlag").val("1");
        }else{
            $("input[id='remember']").prop('checked',false);
            $("#remFlag").val("");
        }
    }else{ //如果没选中设置remFlag为""
        $("#remFlag").val("");
    }
}
function loginUser(){
	if($('#username').val().trim() == ""){
		alert("用户名不能为空");
		$("#username").val("").focus();
		return false;
	}else if ($('#password').val().trim() == "") {
		alert("密码不能为空");
		$('#password').val("").focus();
		return false;
	}else {
		var name = $('#username').val();
		var password = $('#password').val();
		var remember=$("#remFlag").val();
		var url = "user/loginUser.do";
		$.post(url,{userName:name,userPassword:password,remFlag:remember},function(data){
			if(data.status=="200"){
				window.location.href='goToMainPage.do';
			}else{
				$("input[type='checkbox']").removeAttr('checked');
				$("#remFlag").val("");
				alert("用户名或密码错误");
			}
		},"json")
	}
}
//键盘enter建登录的事件
function KeyDown() {
	if (event.keyCode == 13) {
		event.returnValue = false;
		event.cancel = true;
		loginUser();
	}
}