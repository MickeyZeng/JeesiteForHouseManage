<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>followClient管理</title>
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
		<li class="active"><a href="${ctx}/fcl/sysFollowupClient/">followClient列表</a></li>
		<shiro:hasPermission name="fcl:sysFollowupClient:edit"><li><a href="${ctx}/fcl/sysFollowupClient/form">followClient添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysFollowupClient" action="${ctx}/fcl/sysFollowupClient/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>员工id：</label>
				<form:input path="userid" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>客户id：</label>
				<form:input path="clientid" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>跟进内容</th>
				<th>员工id</th>
				<th>跟进时间</th>
				<th>客户id</th>
				<shiro:hasPermission name="fcl:sysFollowupClient:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysFollowupClient">
			<tr>
				<td><a href="${ctx}/fcl/sysFollowupClient/form?id=${sysFollowupClient.id}">
					${sysFollowupClient.contents}
				</a></td>
				<td>
					${sysFollowupClient.userid}
				</td>
				<td>
					<fmt:formatDate value="${sysFollowupClient.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sysFollowupClient.clientid}
				</td>
				<shiro:hasPermission name="fcl:sysFollowupClient:edit"><td>
    				<a href="${ctx}/fcl/sysFollowupClient/form?id=${sysFollowupClient.id}">修改</a>
					<a href="${ctx}/fcl/sysFollowupClient/delete?id=${sysFollowupClient.id}" onclick="return confirmx('确认要删除该followClient吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>