<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<div>
				<a class="navbar-brand" style="font-size: 32px;"
					href="http://localhost:8080/print02-webui/">校园智能文印平台</a>
			</div>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li style="padding-top: 8px;">
					<div class="btn-group">
						<button type="button"
							class="btn btn-default btn-success dropdown-toggle"
							data-toggle="dropdown">
							<i class="glyphicon glyphicon-user"></i>
							${sessionScope.merchant.merchantName }
						</button>
					</div>
				</li>
				<li style="margin-left: 10px; padding-top: 8px;">
					<div class="btn-group">
						<a class="btn btn-primary btn-default btn-danger"
							href="merchant/loginout.html" role="button"><i
							class="glyphicon glyphicon-off"></i> 退出</a>
					</div>
				</li>
				<li style="margin-left: 10px; padding-top: 8px;"></li>
			</ul>
		</div>
	</div>
</nav>