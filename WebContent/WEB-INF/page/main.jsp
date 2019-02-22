<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="base.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人生里程碑管理系统</title>
<%@include file="mainHeader.jsp"%>
</head>
<body>
	<div class="container">
		<br />
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-8">
					<div class="row">
						<div class="col-lg-2" style="padding: 0px 0px 0px 55px;">
							<img src="images/icons8-记分牌-64.png" class="img-responsive" />
						</div>
						<div class="col-lg-10">
							<br />
							<h3 class="text-success" style="padding-top: 0px">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								人生里程碑管理系统</h3>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="row">
						<div class="col-lg-5">
							<a class="btn-info"  href="javascript:void(0)" onclick="openPersonalSenterModal();">
								<h6 class="text-success"
									style="padding-top: 38px; cursor: pointer; font-size: 13px; font-weight: bold;">
									个人中心</h6>
							</a>
						</div>
						<div class="col-lg-7" style="padding-top: 35px">
							<a class="btn btn-warning btn-sm" href="index.jsp" role="button">退出登录</a>
						</div>
					</div>
				</div>
				<!--分割线-->
				<div
					style="height: 2px; width: 100%; background: #00CCFF; overflow: hidden;"></div>
			</div>
			<div class="container">
				<div class="row">
					<!--左侧页面开始↓-->
					<div class="col-lg-2">
						<div class="row">
							<!--左侧页面按钮开始↓-->
							<div class="col-lg-12" style="padding: 130px 0px 0px 50px;">
								<div class="row">
									<div>
										<img data-toggle="modal" data-target="#myModal"
											; style="padding: 0px 0px 0px 20px;"
											src="images/icons8-加-96.png" />
										<h4 style="padding: 10px 0px 0px 30px;">创建目标</h4>
									</div>
									<div>
										<img  style="padding: 50px 0px 0px 20px;"
											src="images/icons8-谷歌地图-100.png" onclick="openMilestoneModal()" />
										<h4 style="padding: 10px 0px 0px 30px;">&nbsp;里 程 碑</h4>
									</div>
								</div>
							</div>
							<!--左侧页面按钮结束↑-->

						</div>
					</div>
					<!--左侧页面结束↑-->
					<!--工作区开始↓-->
					<div class="col-lg-8"
						style="padding: 60px 0px 0px 70px; height: 530px;">
						<!-- 标签页开始↓ -->
						<div>
							<!-- Nav tabs -->
							<ul class="nav nav-tabs nav-justified" role="tablist">
								<li id="MyTarget" role="presentation" class="active"><a
									href="javascript:void(0)" aria-controls="home" role="tab"
									data-toggle="tab"
									style="background-image: url(images/bg_2.jpg); color: #46B8DA;" onclick="myTarget()">我的目标</a>
								</li>
								<li id="OverTime" role="presentation"><a
									href="javascript:void(0)" aria-controls="profile" role="tab"
									data-toggle="tab" style="background-color: tomato" onclick="chaoshi()">超时</a></li>
								<li id="Stress" role="presentation"><a
									href="javascript:void(0)" aria-controls="messages" role="tab"
									data-toggle="tab" style="background-color: orange" onclick="stress()">强调</a></li>
								<li id="Standard" role="presentation"><a href="javascript:void(0)"
									aria-controls="settings" role="tab" data-toggle="tab"
									style="background-color: lightgreen" onclick="standard()">标准</a></li>
							</ul>

							<!-- Tab panes -->
							<div id="result" class="tab-content">
								<input type="hidden" id="resultHideInput"> 
								<div class="tab-pane active" id="tblResultDiv">
									<input type="hidden" id="finishTimeHide">
									<table id="tblResult" class="table table-striped">
										<thead>
											<tr>
												<th class=" text-center" data-formatter="xuhao">编号</th>
												<th class=" text-center" data-field="objectiveTitle">标题</th>
												<th class=" text-center" data-field="objectiveFinishdatetime">完成时间</th>
												<th class=" text-center" data-formatter="daojishi">倒计时</th>
												<th class=" text-center" data-field="objectiveRemark">备注</th>
												<th class=" text-center" data-field="objectiveEmphasize" data-formatter="qiangdiao">强调</th>
												<th class=" text-center" data-formatter="dacheng">达成</th>
												<th class=" text-center" data-formatter="bianji">编辑</th>
											</tr>
										</thead>
										<tbody id="tableResult">
											<!-- <tr>
													<th scope="row">1</th>
													<td>Markdfa法水电费第三方司法所范德萨发放大</td>
													<td>2018/10/01</td>
													<td>23:54</td>
													<td>222天22:44</td>
													<td><button type="button" class="btn btn-success">
															<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
														</button></td>
													<td><button type="button" class="btn btn-info"
															data-toggle="modal" href="#myModal5">
															<span class="glyphicon glyphicon-pencil"
																aria-hidden="true"></span>
														</button></td>
												</tr> -->
										</tbody>
									</table>
								</div>

								<!-- <div class="tab-pane" id="tblResultDiv2">
									<table id="tblResult2" class="table table-striped">
										<thead>
											<tr>
												<th class=" text-center" data-formatter="xuhao">编号</th>
												<th class=" text-center" data-field="objectiveTitle">标题</th>
												<th class=" text-center" data-field="objectiveTitle">完成时间</th>
												<th class=" text-center" data-field="objectiveTitle">倒计时</th>
												<th class=" text-center" data-field="objectiveRemark">备注</th>
												<th class=" text-center" data-field="objectiveEmphasize" data-formatter="qiangdiao">强调</th>
												<th class=" text-center" data-formatter="weiwancheng">达成</th>
												<th class=" text-center" data-formatter="bianji">编辑</th>
											</tr>
										</thead>
										<tbody id="tableResult2"></tbody>
									</table>
								</div> -->

								<!-- <div class="tab-pane" id="tblResultDiv3">
									<table id="tblResult3" class="table table-striped">
										<thead>
											<tr>
												<th class=" text-center" data-formatter="xuhao">编号</th>
												<th class=" text-center" data-field="objectiveTitle">标题</th>
												<th class=" text-center" data-field="objectiveTitle">完成时间</th>
												<th class=" text-center" data-field="objectiveTitle">倒计时</th>
												<th class=" text-center" data-field="objectiveRemark">备注</th>
												<th class=" text-center" data-field="objectiveEmphasize" data-formatter="qiangdiao">强调</th>
												<th class=" text-center" data-formatter="dacheng">达成</th>
												<th class=" text-center" data-formatter="bianji">编辑</th>
											</tr>
										</thead>
										<tbody id="tableResult3"></tbody>
									</table>
								</div> -->

								<!-- <div class="tab-pane" id="tblResultDiv4">
									<table id="tblResult4" class="table table-striped">
										<thead>
											<tr>
												<th class=" text-center" data-formatter="xuhao">编号</th>
												<th class=" text-center" data-field="objectiveTitle">标题</th>
												<th class=" text-center" data-field="objectiveTitle">完成时间</th>
												<th class=" text-center" data-field="objectiveTitle">倒计时</th>
												<th class=" text-center" data-field="objectiveRemark">备注</th>
												<th class=" text-center" data-field="objectiveEmphasize" data-formatter="qiangdiao">强调</th>
												<th class=" text-center" data-formatter="dacheng">达成</th>
												<th class=" text-center" data-formatter="bianji">编辑</th>
											</tr>
										</thead>
										<tbody id="tableResult4"></tbody>
									</table>
								</div> -->
							</div>
						</div>
						<!--标签页结束↑-->
					</div>
					<!--工作区结束↑-->
					<!--右侧↓-->
					<div class="col-lg-2"></div>
					<!--右侧↑-->
					<!--下面↓-->
					<!--分割线-->
					<div
						style="height: 3px; width: 100%; background: #00CCFF; overflow: hidden;"></div>
				</div>
				<br />
				<div class="col-md-12 text-center">
					<p>
						<small>&copy; All Rights Reserved.<a
							href="goToMainPage.do">恒诚科技</a> - System is <a
							href="goToMainPage.do">人生里程碑管理系统</a></small>
					</p>
				</div>
				<!--下面↑-->
			</div>
		</div>
	</div>
	</div>
	<!-- 模态1 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="padding-top: 100px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">个人中心</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="ffAdd">
						<input type="hidden" id="personalUserId">
						<div class="form-group">
							<label for="inputPassword" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input class="form-control" id="personalUserName" type="text"
									placeholder="用户名" disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-2 control-label">昵称</label>
							<div class="col-sm-10">
								<input class="form-control" id="personalNickName" type="text"
									placeholder="昵称">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input class="form-control" id="personalEmail" type="text"
									placeholder="邮箱">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input class="form-control" id="personalPassword1" type="password"
									placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input class="form-control" id="personalPassword2" type="password"
									placeholder="再次输入">
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<!-- <button type="button" class="btn btn-primary">修改</button> -->
					<!--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
					<button type="button" class="btn btn-primary" onclick="saveChange();">保存更改</button>
				</div>

			</div>
		</div>
	</div>
	<!-- 模态2 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog" role="document" style="padding-top: 56px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">创建目标</h4>
				</div>

				<div class="modal-body">
					<form>
						<h5>目标标题</h5>
						<input type="text" class="form-control" placeholder="请输入目标标题" id="saveTargetTitle">
						<br />
						<h5>设定目标完成时间</h5>

						<a class='input-group date' id='datetimepicker1'> <input
							type='text' class="form-control" id='saveFinishTime'
							style="width: 150px; height: 30px;" />
						</a>

						<script>
							$('#saveFinishTime').datetimepicker({
								language : 'zh-CN'
							});
						</script>

						<!-- 时间选择器↑ -->

						<label class="checkbox-inline"
							style="padding: 20px 0px 20px 30px;"> <input
							type="checkbox" id="saveEmphasize" value="1">强调

						</label>

						<h5>请输入备注信息</h5>
						<textarea id="saveRemarkInfo" class="form-control" rows="3" placeholder="请输入备注信息"></textarea>
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
					<button type="button" class="btn btn-primary" onclick="confirmCreation();">确认创建</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 模态3 -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog" role="document"
			style="padding-top: 10px; width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<form class="navbar-form navbar-left">
						<div class="form-group">
							<input id="titleContent" type="text" class="form-control" placeholder="输入标题关键字" onkeydown="KeyDown()">
						</div>
						<button type="button" class="btn btn-default"
							style="background-color: lightgreen" onclick="queryMilestoneInfo();">查询</button>
					</form>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body" style="height: 500px; overflow: auto;">
					<form>
						<table id="tblResult1" class="table table-striped">
							<div>
								<thead>
									<tr>
										<th class=" text-center" data-formatter="xuhao">编号</th>
										<th class=" text-center" data-field="objectiveTitle">标题</th>
										<th class=" text-center" data-field="objectiveBegindatetime">开始时间</th>
										<th class=" text-center" data-field="objectiveEnddatetime">完成时间</th>
										<th class=" text-center" data-field="objectiveEmphasize" data-formatter="qiangdiao">是否强调</th>
										<th class=" text-center" data-formatter="details">详情</th>
										<th class=" text-center" data-formatter="editRemarkInfo">编辑</th>
									</tr>
								</thead>
								<tbody id="tableResult1">
									<!-- <tr>
										<th scope="row">1</th>
										<td>Markdfa法水电费第三方司法所范德萨发放大</td>
										<td>2018/10/01 12/11 23:11</td>
										<td>2018/10/01 12/11 23:40</td>
										<td>√</td>
										<td><button type="button" class="btn btn-success"
												data-toggle="modal" href="#myModal4">
												<span class="glyphicon glyphicon-list-alt"
													aria-hidden="true"></span>
											</button></td>
										<td><button type="button" class="btn btn-info"
												data-toggle="modal" href="#myModal3">
												<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											</button></td>

									</tr> -->
									

								</tbody>
							</div>
						</table>

					</form>
				</div>
			</div>
		</div>
	</div>
	<!--模态框5 里程碑里的查看 -->
	<div class="modal fade rotate" id="myModal4"
		style="padding-top: 100px;">
		<div class="modal-content"
			style="width: 800px; margin: auto; margin-top: 50px; background-color: #B2DBA1">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看备注记录</h4>
			</div>

			<div class="modal-body">
				<form id="ffAdd2">
					<textarea class="form-control" rows="8"
						id="viewRemark" disabled="disabled"></textarea>
				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
			</div>
		</div>
	</div>
	<!--模态框6 里程碑里的编辑-->
	<div class="modal fade rotate" id="myModal3"
		style="padding-top: 100px;">
		<div class="modal-content"
			style="width: 800px; margin: auto; margin-top: 50px; background-color: lightskyblue;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改备注记录</h4>
			</div>

			<div class="modal-body">
				<form id="ffAdd3">
					<textarea class="form-control" rows="8"
						id="editMark"></textarea>
				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
				<button type="button" class="btn btn-primary" onclick="confirmEditRemarkInfo();">确认修改</button>
			</div>
		</div>
	</div>
	<!--主页编辑模态框-->
	<div class="modal fade" id="myModal5" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog" role="document" style="padding-top: 56px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">编辑目标</h4>
				</div>

				<div class="modal-body">
					<form id="ffAdd1">
						<input type="hidden" id="editObjectiveIdHide">
						<h5>目标标题</h5>
						<input type="text" class="form-control" id="editTargetTitle">
						<br />
						<h5>设定目标完成时间</h5>

						<a class='input-group date' id='datetimepicker1'> <input
							type='text' class="form-control" id='editFinishTime'
							style="width: 150px; height: 30px;" />
						</a>

						<script>
															$('#editFinishTime')
																	.datetimepicker(
																			{
																				language : 'zh-CN',
																			});
														</script>

						<!-- 时间选择器↑ -->

						<label class="checkbox-inline"
							style="padding: 20px 0px 20px 30px;"> <input
							type="checkbox" id="editEmphasize" value="1">强调

						</label>

						<h5>请输入备注信息</h5>
						<textarea class="form-control" rows="3"
							id="editRemarkInfo"></textarea>
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
					<button type="button" class="btn btn-primary" onclick="confirmEdit();">确认修改</button>
				</div>
			</div>
		</div>
	</div>
	<!--主页修改模态框-->
</body>
</html>