<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp"%>
<body>

	<%@ include file="/WEB-INF/include-nav.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/include-sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
					<li><a href="admin/to/main/page.html">首页</a></li>
					<li><a href="member/get/page.html">数据列表</a></li>
					<li class="active">更新</li>
				</ol>
				<div class="panel panel-default">
					<div class="panel-heading">
						表单数据
						<div style="float: right; cursor: pointer;" data-toggle="modal"
							data-target="#myModal">
							<i class="glyphicon glyphicon-question-sign"></i>
						</div>
					</div>
					<div class="panel-body">
						<form action="member/update.html" method="post" role="form">
							<input type="hidden" name="id" value="${requestScope.member.id }" />
							<input type="hidden" name="pageNum" value="${param.pageNum }" />
							<input type="hidden" name="keyword" value="${param.keyword }" />
							<p>${requestScope.exception.message }</p>
							<div class="form-group">
								<label for="exampleInputPassword1">账号</label> <input
									name="loginAcct" value="${requestScope.member.loginacct }"
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="请输入账号">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">名称</label> <input
									name="userName" value="${requestScope.member.username }"
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="请输入名称">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">邮箱地址</label> <input type="email"
									name="email" value="${requestScope.member.email }"
									class="form-control" id="exampleInputEmail1"
									placeholder="请输入邮箱地址">
								<p class="help-block label label-warning">请输入合法的邮箱地址, 格式为：
									xxxx@xxxx.com</p>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">用户类型</label>
								<div class="radio">
									<label style="width: 100px"><input name="usertype"
										value="0" type="radio" id="exampleInputUsertype1">个人 </label>
									<label style="width: 100px"><input name="usertype"
										value="1" type="radio" id="exampleInputUsertype1">企业 </label>
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputAccttype1">账户主体</label>
								<div class="radio">
									<label style="width: 100px"><input name="accttype"
										value="0" type="radio" id="exampleInputAccttype1">企业 </label>
									<label style="width: 100px"><input name="accttype"
										value="1" type="radio" id="exampleInputAccttype1">个体 </label>
									<label style="width: 100px"><input name="accttype"
										value="2" type="radio" id="exampleInputAccttype1">个人 </label>
									<label style="width: 100px"><input name="accttype"
										value="3" type="radio" id="exampleInputAccttype1">政府 </label>
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">实名</label> <input
									name="realname" value="${requestScope.member.realname }"
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="暂未完成实名认证" readonly="readonly">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">身份证号</label> <input
									name="cardnum" value="${requestScope.member.cardnum }"
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="暂未完成实名认证" " readonly="readonly">
							</div>
							<button type="submit" class="btn btn-success">
								<i class="glyphicon glyphicon-edit"></i> 更新
							</button>
							<button type="reset" class="btn btn-danger">
								<i class="glyphicon glyphicon-refresh"></i> 重置
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>