<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户个人信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/pms/sysPersonalInformation/">用户个人信息列表</a></li>
		<shiro:hasPermission name="pms:sysPersonalInformation:edit"><li><a href="${ctx}/pms/sysPersonalInformation/form">用户个人信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysPersonalInformation" action="${ctx}/pms/sysPersonalInformation/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>个人信息编号：</label>
				<form:input path="personId" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>身份证号：</label>
				<form:input path="idCard" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>个人信息编号</th>
				<th>身份证号</th>
				<th>电子邮件</th>
				<th>联系电话</th>
				<shiro:hasPermission name="pms:sysPersonalInformation:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysPersonalInformation">
			<tr>
				<td><a href="${ctx}/pms/sysPersonalInformation/form?id=${sysPersonalInformation.id}">
					${sysPersonalInformation.personId}
				</a></td>
				<td>
					${sysPersonalInformation.idCard}
				</td>
				<td>
					${sysPersonalInformation.email}
				</td>
				<td>
					${sysPersonalInformation.address}
				</td>
				<shiro:hasPermission name="pms:sysPersonalInformation:edit"><td>
    				<a href="${ctx}/pms/sysPersonalInformation/form?id=${sysPersonalInformation.id}">修改</a>
					<a href="${ctx}/pms/sysPersonalInformation/delete?id=${sysPersonalInformation.id}" onclick="return confirmx('确认要删除该用户个人信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>