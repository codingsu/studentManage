<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.2.0
Version: 3.2.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>Metronic | Pages - User Profile</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/metronic/assets/global/plugins/uniform/css/uniform.default.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/metronic/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link
	href="<c:url value="/metronic/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/metronic/assets/admin/pages/css/profile.css"/>"
	rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="<c:url value="/metronic/assets/global/css/components.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/metronic/assets/global/css/plugins.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/metronic/assets/admin/layout/css/layout.css"/>"
	rel="stylesheet" type="text/css" />
<link id="style_color"
	href="<c:url value="/metronic/assets/admin/layout/css/themes/default.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/metronic/assets/admin/layout/css/custom.css"/>"
	rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-header-fixed page-quick-sidebar-over-content ">
	<!-- BEGIN HEADER -->
	<div class="page-header navbar navbar-fixed-top">
		<!-- BEGIN HEADER INNER -->
		<div class="page-header-inner">
			<!-- BEGIN LOGO -->
			<div class="page-logo">
				<a href="index.html"> <img
					src="../../assets/admin/layout/img/logo.png" alt="logo"
					class="logo-default" />
				</a>
				<div class="menu-toggler sidebar-toggler hide">
					<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
				</div>
			</div>
			<!-- END LOGO -->
			<!-- BEGIN RESPONSIVE MENU TOGGLER -->
			<a href="javascript:;" class="menu-toggler responsive-toggler"
				data-toggle="collapse" data-target=".navbar-collapse"> </a>
			<!-- END RESPONSIVE MENU TOGGLER -->
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<!-- BEGIN NOTIFICATION DROPDOWN -->

					<!-- END TODO DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown dropdown-user"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						data-hover="dropdown" data-close-others="true"> <img alt=""
							class="img-circle hide1"
							src="../../assets/admin/layout/img/avatar3_small.jpg" /> <span
							class="username username-hide-on-mobile"> 用户名 </span> <i
							class="fa fa-angle-down"></i>
					</a></li>
					<!-- END USER LOGIN DROPDOWN -->
					<!-- BEGIN QUICK SIDEBAR TOGGLER -->
					<li class="dropdown dropdown-quick-sidebar-toggler"><a
						href="/StudentInformationSystem/logout" class="dropdown-toggle">
							<i class="icon-logout"></i>
					</a></li>
					<!-- END QUICK SIDEBAR TOGGLER -->
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END HEADER INNER -->
	</div>
	<!-- END HEADER -->
	<div class="clearfix"></div>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<ul class="page-sidebar-menu " data-auto-scroll="true"
					data-slide-speed="200">
					<!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
					<li class="sidebar-toggler-wrapper">
						<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
						<div class="sidebar-toggler"></div> <!-- END SIDEBAR TOGGLER BUTTON -->
					</li>
					<!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->

					
					<li><a href="<c:url value='/allStudent'/>" id="allstudent">
							<i class="icon-rocket"></i> <span class="title">学生列表</span> <span
							class="arrow "></span>
					</a> <!-- BEGIN FRONTEND THEME LINKS --></li>
					<c:if test="${sessionScope.ROLE== '1'}">
						<li><a href="<c:url value='/add'/>"> <i
								class="icon-star"></i> <span class="title">添加用户</span> <span
								class="arrow"> </span>
						</a></li>
					</c:if>
					<li class="start active open"><c:if
							test="${sessionScope.ROLE== '1'}">
							<a
								href="<c:url value='/personal-${sessionScope.ADMIN_CONTEXT}'/>">
						</c:if> <c:if test="${sessionScope.ROLE== '0'}">
							<a
								href="<c:url value='/personal-${sessionScope.STUDENT_CONTEXT}'/>">
						</c:if> <i class="icon-puzzle"></i> <span class="title">个人面板</span> <span
						class="arrow "></span> </a></li>

					<li><a href="<c:url value='help'/>"> <i
							class="icon-diamond"></i> <span class="title">帮助</span>
					</a></li>
					<li><a href="<c:url value='/about'/>"> <i
							class="icon-puzzle"></i> <span class="title">关于</span>
					</a></li>
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<div class="modal fade" id="portlet-config" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title">Modal title</h4>
							</div>
							<div class="modal-body">Widget settings form goes here</div>
							<div class="modal-footer">
								<button type="button" class="btn blue">Save changes</button>
								<button type="button" class="btn default" data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<!-- BEGIN STYLE CUSTOMIZER -->

				<!-- END STYLE CUSTOMIZER -->
				<!-- BEGIN PAGE HEADER-->
				<h3 class="page-title">
					个人信息 <small>个人信息概览</small>
				</h3>

				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row profile">
					<div class="col-md-12">
						<!--BEGIN TABS-->
						<div class="tabbable tabbable-custom tabbable-full-width">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#tab_1_3" data-toggle="tab">概览
								</a></li>
							</ul>
							<div class="tab-content">

								<!--tab_1_2-->
								<div class="tab-pane active" id="tab_1_3">
									<div class="row profile-account">
										<div class="col-md-3">
											<ul class="ver-inline-menu tabbable margin-bottom-10">
												<li><img src="<c:url value="${student.imagePath }"/>"
													class="img-responsive" alt="" /></li>
												<li class="active"><a data-toggle="tab" href="#tab_1-1">
														<i class="fa fa-cog"></i> 个人信息
												</a> <span class="after"> </span></li>
												<c:if test="${sessionScope.ROLE== '1' || sessionScope.STUDENT_CONTEXT == student.studentID}">
												<li><a data-toggle="tab" href="#tab_2-2"> <i
														class="fa fa-picture-o"></i> 更改头像
												</a></li>
												
												<li><a data-toggle="tab" href="#tab_3-3"> <i
														class="fa fa-lock"></i> 修改密码
												</a></li>
                                                </c:if>
											</ul>
										</div>
										<div class="col-md-9">
											<div class="tab-content">
												<div id="tab_1-1" class="tab-pane active">
													<form role="form" id="changePersonInfForm" action="#"
														onsubmit="return checkPersonProfileForm();">
														<div class="form-group">
															<label class="control-label">姓名</label> <input
																type="text" id="name" class="form-control"
																value="${student.name}" disabled />
														</div>
														<div class="form-group">
															<label class="control-label">性别</label>
															<div class="form-group">
																<select id="sex" class="bs-select form-control" disabled>
																	<option value="man">男</option>
																	<option value="women">女</option>
																</select>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label">年级</label> <input
																type="text" id="age" class="form-control" disabled
																value="${student.grade}" />
														</div>
														<div class="form-group">
															<label class="control-label">学号</label> <input
																type="text" id="student_id" class="form-control"
																value="${student.studentID}" disabled />
														</div>
														<div class="form-group">
															<label class="control-label">联系电话</label> <input
																type="text" id="phone" class="form-control"
																value="${student.phone}" disabled />
														</div>
														<div class="form-group">
															<label class="control-label">邮箱</label> <input
																type="text" id="email" class="form-control"
																value="${student.mail}" disabled />
														</div>


														<div class="margiv-top-10">
															<c:if
																test="${sessionScope.ROLE== '1' || sessionScope.STUDENT_CONTEXT == student.studentID}">
																<button id="edit" type="button" class="btn green"
																	style="block" onclick="doclick();">编辑</button>
															</c:if>
															<button id="infoCommit" type="button" class="btn green"
																disabled="disabled" onclick="checkPersonProfileForm();">提交</button>
															<button id="infoCancel" type="button" class="btn default"
																disabled="disabled">取消</button>
														</div>
													</form>
												</div>
												<div id="tab_2-2" class="tab-pane">

													<form action="#"  role="form" id = "formid" enctype ="multipart/form-data">
														<div class="form-group">
															<div class="fileinput fileinput-new"
																data-provides="fileinput">
																<div class="fileinput-new thumbnail"
																	style="width: 200px; height: 150px;">
																	<img
																		src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image"
																		alt="" id = "photo"/>
																</div>
																<div
																	class="fileinput-preview fileinput-exists thumbnail"
																	style="max-width: 200px; max-height: 150px;"></div>
																<div>
																	<span class="btn default btn-file"> <span
																		class="fileinput-new"> 选择图片 </span> <span
																		class="fileinput-exists"> 更改 </span> <input
																		type="file" name="file" id="file">
																	</span> <a href="#" class="btn default fileinput-exists"
																		data-dismiss="fileinput"> 移除 </a>
																</div>
															</div>
															<div class="clearfix margin-top-10">
																<span class="label label-danger"> 注意! </span> <span>
																	上传图片大小请控制在1M以内</span>
															</div>
														</div>
														<div class="margin-top-10">
														<input type="button" class="btn green" class="btn default"  value = '提交' onclick="upLoadImage();"/>
															
															<a href="#"
																class="btn default"> 取消 </a>
														</div>
													</form>
												</div>
												<div id="tab_3-3" class="tab-pane">
													<form id="changePwdForm" action="changepwd">
														<c:if test="${sessionScope.ROLE== '0'}">
															<div id="nowpwd" class="form-group"
																style="visibility:visible">
																<label class="control-label">当前密码</label> <input
																	type="password" id="pwd" class="form-control" />
															</div>
															<div class="form-group">
																<label class="control-label">新密码</label> <input
																	type="password" id="onepwd" class="form-control" />
															</div>
															<div class="form-group">
																<label class="control-label">再次输入新密码</label> <input
																	type="password" id="twopwd" class="form-control" />
															</div>
															<div class="margin-top-10">
																<button type="button" class="btn green"
																	id="changepwd_btn" onclick="changePwd();">提交</button>
																
															</div>
														</c:if>
														<c:if test="${sessionScope.ROLE== '1'}">
															<div id="newpassword" class="form-group"
																style="visibility:visible">
																<label class="control-label">新密码</label> <input
																	type="password" id="newpwd" class="form-control" />
															</div>
															<div class="margin-top-10">
																<button type="button" class="btn green"
																	id="adminchangestupwd" onclick="admchangestupwd();">提交</button>
																
															</div>
														</c:if>


													</form>
												</div>

											</div>
										</div>
										<!--end col-md-9-->
									</div>
								</div>
								<!--end tab-pane-->

								<!--end tab-pane-->

								<!--end tab-pane-->
							</div>
						</div>
						<!--END TABS-->
					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
		</div>
		<!-- END CONTENT -->

	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="page-footer">
		<div class="page-footer-inner">2016 &copy; 软件安全小组yk.</div>
		<div class="scroll-to-top">
			<i class="icon-arrow-up"></i>
		</div>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<!--[if lt IE 9]>
<script src="<c:url value="/metronic/assets/global/plugins/respond.min.js"/>"></script>
<script src="<c:url value="/metronic/assets/global/plugins/excanvas.min.js"/>"></script> 
<![endif]-->
	<script
		src="<c:url value="/metronic/assets/global/plugins/jquery-1.11.0.min.js"/>"
		type="text/javascript"></script>
		<script
		src="<c:url value="js/uploadimage.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/global/plugins/jquery-migrate-1.2.1.min.js"/>"
		type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="<c:url value="/metronic/assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/global/plugins/jquery.blockui.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/global/plugins/jquery.cokie.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/global/plugins/uniform/jquery.uniform.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"/>"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript"
		src="<c:url value="/metronic/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js"/>"></script>
	<script src="<c:url value="js/person_profile_check.js"/>"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script
		src="<c:url value="/metronic/assets/global/scripts/metronic.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/admin/layout/scripts/layout.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/admin/layout/scripts/quick-sidebar.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/metronic/assets/admin/layout/scripts/demo.js"/>"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>

jQuery(document).ready(function() {       
	   // initiate layout and plugins
	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
});
$(function() {
	
    role = '<%=session.getAttribute("ROLE")%>';
	if('1' == role)
	{// 管理员
		var nowpwd = document.getElementById("nowpwd")
		// console.log(nowpwd);
		//nowpwd.style.visibility="hidden";// 隐藏
	//	nowpwd.css('display','none');
		user = '<%=session.getAttribute("ADMIN_CONTEXT")%>';
	} else {
		user = '<%=session.getAttribute("STUDENT_CONTEXT")%>';
			}
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>