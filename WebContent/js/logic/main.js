$(document).ready(function() {
	myTarget();
	setInterval("searchTable()",60000);
});
function myTarget(){
	$('#resultHideInput').val("1");
	searchTable();
}
function chaoshi(){
	$('#resultHideInput').val("2");
	searchTable();
}
function stress(){
	$('#resultHideInput').val("3");
	searchTable();
}
function standard(){
	$('#resultHideInput').val("4");
	searchTable();
}
function searchTable() {
	$("#tblResult").bootstrapTable('destroy');
	$("#tblResult").bootstrapTable({
		url : 'logic/searchMyTarget.do',
		method : 'post',
		queryParams : function(params) {
			return {
				mark : $('#resultHideInput').val()
			}
		},
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		pagination : true, // 开启分页
		pageNumber : 1,// 默认加载页
		pageSize : 6,// 每页数据
		pageList : [ 3, 6, 9 ]
	// 可选的每页数据
	});
}
var xuhao = function(value, row, index) {
	return index+1;
}
var daojishi = function(value, row, index) {
	return row.days+"天"+row.hours+"时"+row.minutes+"分";
}
var dacheng = function(value, row, index) {
	$('#finishTimeHide').val(row.objectiveFinishdatetime);
	var finishDate = new Date($('#finishTimeHide').val().replace(/-/g,"/"));
	var nowDate=new Date();
	if(finishDate <= nowDate){
		return "<button type='button' class='btn btn-danger' onclick='deleteTask(\""+row.objectiveId+"\")'><span class='glyphicon glyphicon-remove' aria-hidden='true'></span></button>";
	}else{
		return "<button type='button' class='btn btn-success' onclick='completeTask(\""+row.objectiveId+"\")'><span class='glyphicon glyphicon-ok' aria-hidden='true'></span></button>";
	}
}
var bianji = function(value, row, index) {
	return "<button type='button' class='btn btn-info'  onclick='openTargetEditModal(\""+row.objectiveId+"\")'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>";
}
var qiangdiao = function(value, row, index) {
	if(value=="1"){
		return "√";
	}else{
		return "×";
	}
}

function openPersonalSenterModal() {
	$.post("logic/selectPersonalInfo.do", {
		id : ""
	}, function(data) {
		$('#personalUserId').val(data.userId);
		$('#personalUserName').val(data.userName);
		$('#personalNickName').val(data.userNickName);
		$('#personalEmail').val(data.userMail);
	});
	$("#ffAdd")[0].reset();
	$('#myModal2').modal('show');
}
function openTargetEditModal(objectiveId){
	$.post("logic/selectObjectiveInfoById.do", {
		objectiveId : objectiveId
	}, function(data) {
		$('#editObjectiveIdHide').val(data.objectiveId);
		$('#editTargetTitle').val(data.objectiveTitle);
		$('#editFinishTime').val(data.objectiveFinishdatetime);
		$('#editRemarkInfo').val(data.objectiveRemark);
		if(data.objectiveEmphasize == "1"){
			$('#editEmphasize').prop('checked',true);
		}else if(data.objectiveEmphasize == "0"){
			$("#editEmphasize").prop('checked',false);
		}
	});
	$("#ffAdd1")[0].reset();
	$('#myModal5').modal('show');
}
function confirmEdit(){
	var finishDate = new Date($("#editFinishTime").val().replace(/-/g,"/"));
	var nowDate=new Date();
	if ($("#editTargetTitle").val().trim() == "") {
		alert("目标标题不能为空");
		$("#editTargetTitle").val("").focus();
		return false;
	}else if($("#editFinishTime").val().trim() == ""){
		alert("目标完成时间不能为空");
		$("#editFinishTime").val("").focus();
		return false;
	}else if($("#editFinishTime").val().length != 16 &&  $("#editFinishTime").val().length != 19){
		alert("目标完成时间格式错误");
		$("#editFinishTime").val("").focus();
		return false;
	}else if($('input[id="editEmphasize"]:checked').val() ==""){
		alert("强调复选框值有问题！");
		return false;
	}else if($('#editRemarkInfo').val().trim() ==""){
		alert("备注信息不能为空！");
		$('#editRemarkInfo').val("").focus();
		return false;
	}else if(finishDate <= nowDate){
		alert("目标完成时间不能小于当前时间！");
		$('#editFinishTime').val("").focus();
		return false;
	}else{
		$.ajax({
			type : "POST",
			url : "logic/updateObjectiveTableInfo.do",
			data : {
				objectiveId : $('#editObjectiveIdHide').val().trim(),
				objectiveTitle : $('#editTargetTitle').val().trim(),
				objectiveFinishdatetime : $('#editFinishTime').val().trim(),
				objectiveEmphasize : $('input[id="editEmphasize"]:checked').val(),
				objectiveRemark : $("#editRemarkInfo").val().trim()
			},
			async : false,
			success : function(data) {
				if (data == true) {
					$('#myModal5').modal('hide');
					searchTable();
					alert("修改目标成功，请在页面中进行查看！");
				} else {
					$('#myModal5').modal('hide');
					searchTable();
					alert("修改目标失败，正在返回！");
				}
			}
		});
	}
}
function saveChange(){
	var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
	if ($("#personalUserName").val().trim() == "") {
		alert("用户名不能为空");
		return false;
	}else if($("#personalNickName").val().trim() == ""){
		alert("昵称不能为空");
		$("#personalNickName").val("").focus();
		return false;
	}else if($('#personalNickName').val().trim().length >40){
		alert("昵称长度过长！");
		$('#personalNickName').focus();
		return false;
	}else if($('#personalEmail').val().trim() ==""){
		alert("邮箱不能为空！");
		$('#personalEmail').val("").focus();
		return false;
	}else if(!myReg.test($('#personalEmail').val().trim())){
		alert("邮箱格式错误重新输入！");
		$('#personalEmail').focus();
		return false;
	}else if($('#personalPassword1').val().trim() ==""){
		alert("密码不能为空！");
		$('#personalPassword1').val("").focus();
		return false;
	}else if($('#personalPassword2').val().trim() ==""){
		alert("确认密码不能为空！");
		$('#personalPassword2').val("").focus();
		return false;
	} else if ($("#personalPassword1").val() != $("#personalPassword2").val()) {
		alert("两次新密码输入不一致！");
		$('#personalPassword1').val("").focus();
		$('#personalPassword2').val("");
		return false;
	}else{
		$.ajax({
			type : "POST",
			url : "logic/savePersonalInfo.do",
			data : {
				userId : $('#personalUserId').val().trim(),
				userName : $('#personalUserName').val().trim(),
				userPassword : $("#personalPassword2").val().trim(),
				userMail : $("#personalEmail").val().trim(),
				userNickName : $("#personalNickName").val().trim()
			},
			async : false,
			success : function(data) {
				if (data == true) {
					alert("保存更改成功！");
				} else {
					alert("保存更改失败，正在返回！");
					$('#myModal2').modal('hide');
				}
			}
		});
	}
}
function confirmCreation(){
	var finishDate = new Date($("#saveFinishTime").val().replace(/-/g,"/"));
	var nowDate=new Date();
	if ($("#saveTargetTitle").val().trim() == "") {
		alert("目标标题不能为空");
		$("#saveTargetTitle").val("").focus();
		return false;
	}else if($("#saveFinishTime").val().trim() == ""){
		alert("目标完成时间不能为空");
		$("#saveFinishTime").val("").focus();
		return false;
	}else if($("#saveFinishTime").val().length != 16 &&  $("#saveFinishTime").val().length != 19){
		alert("目标完成时间格式错误");
		$("#saveFinishTime").val("").focus();
		return false;
	}else if($('input[id="saveEmphasize"]:checked').val() ==""){
		alert("强调复选框值有问题！");
		return false;
	}else if($('#saveRemarkInfo').val().trim() ==""){
		alert("备注信息不能为空！");
		$('#saveRemarkInfo').val("").focus();
		return false;
	}else if(finishDate <= nowDate){
		alert("目标完成时间不能小于当前时间！");
		$('#saveFinishTime').val("").focus();
		return false;
	}else{
		$.ajax({
			type : "POST",
			url : "logic/createTarget.do",
			data : {
				objectiveTitle : $('#saveTargetTitle').val().trim(),
				objectiveFinishdatetime : $('#saveFinishTime').val().trim(),
				objectiveEmphasize : $('input[id="saveEmphasize"]:checked').val(),
				objectiveRemark : $("#saveRemarkInfo").val().trim()
			},
			async : false,
			success : function(data) {
				if (data == true) {
					$('#myModal').modal('hide');
					searchTable();
					alert("创建目标成功，请在页面中进行查看！");
				} else {
					$('#myModal').modal('hide');
					searchTable();
					alert("创建目标失败，正在返回！");
				}
			}
		});
	}
}
function completeTask(objectiveId){
	$.ajax({
		type : "POST",
		url : "logic/updateObjectiveTableInfo.do",
		data : {
			objectiveId : objectiveId,
			objectiveStatus : '1'
		},
		async : false,
		success : function(data) {
			if (data == true) {
				alert("目标已达成，请在里程碑中进行查看！");
				searchTable();
			} else {
				alert("目标达成失败，正在返回！");
				searchTable();
			}
		}
	});
}
function deleteTask(objectiveId){
	$.ajax({
		type : "POST",
		url : "logic/deleteObjectiveTableInfo.do",
		data : {
			objectiveId : objectiveId
		},
		async : false,
		success : function(data) {
			if (data == true) {
				searchTable();
				alert("目标已删除！");
			} else {
				searchTable();
				alert("目标删除失败！");
			}
		}
	});
}

function openMilestoneModal(){
	queryMilestoneInfo();
	$('#myModal1').modal('show');
}
function queryMilestoneInfo() {
	$("#tblResult1").bootstrapTable('destroy');
	$("#tblResult1").bootstrapTable({
		url : 'logic/searchMyMilestoneInfo.do',
		method : 'post',
		queryParams : function(params) {
			return {
				objectiveTitle : $('#titleContent').val().trim()
			}
		},
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		pagination : true, // 开启分页
		pageNumber : 1,// 默认加载页
		pageSize : 6,// 每页数据
		pageList : [ 3, 6, 9 ]
	// 可选的每页数据
	});
}
var details = function(value, row, index) {
	return "<button type='button' class='btn btn-success' onclick='openRemarkViewModal(\""+row.objectiveId+"\")'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span></button>";
}
var editRemarkInfo = function(value, row, index) {
	return "<button type='button' class='btn btn-info'  onclick='openRemarkEditModal(\""+row.objectiveId+"\")'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>";
}
function openRemarkViewModal(objectiveId){
	$.post("logic/selectObjectiveInfoById.do", {
		objectiveId : objectiveId
	}, function(data) {
		$('#editObjectiveIdHide').val(data.objectiveId);
		$('#viewRemark').val(data.objectiveRemark);
	});
	$("#ffAdd2")[0].reset();
	$('#myModal4').modal('show');
}
function openRemarkEditModal(objectiveId){
	$.post("logic/selectObjectiveInfoById.do", {
		objectiveId : objectiveId
	}, function(data) {
		$('#editObjectiveIdHide').val(data.objectiveId);
		$('#editMark').val(data.objectiveRemark);
	});
	$("#ffAdd3")[0].reset();
	$('#myModal3').modal('show');
}
function confirmEditRemarkInfo(){
	if( $('#editMark').val().trim() ==""){
		alert("备注信息不能为空！");
		$('#editMark').val("").focus();
		return false;
	}else{
		$.ajax({
			type : "POST",
			url : "logic/updateObjectiveTableInfo.do",
			data : {
				objectiveId : $('#editObjectiveIdHide').val().trim(),
				objectiveRemark : $('#editMark').val().trim()
			},
			async : false,
			success : function(data) {
				if (data == true) {
					$('#myModal3').modal('hide');
					queryMilestoneInfo();
					alert("备注修改成功，请在里程碑中进行查看！");
				} else {
					$('#myModal3').modal('hide');
					queryMilestoneInfo();
					alert("备注修改失败，正在返回里程碑！");
				}
			}
		});
	}
}
//键盘enter建登录的事件
function KeyDown() {
	if (event.keyCode == 13) {
		event.returnValue = false;
		event.cancel = true;
		queryMilestoneInfo();
	}
}