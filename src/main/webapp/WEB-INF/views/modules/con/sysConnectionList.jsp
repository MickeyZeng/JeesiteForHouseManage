<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>Connection管理</title>
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
		<li class="active"><a href="${ctx}/con/sysConnection/">Connection列表</a></li>
		<shiro:hasPermission name="con:sysConnection:edit"><li><a href="${ctx}/con/sysConnection/form">Connection添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysConnection" action="${ctx}/con/sysConnection/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>联系方式：</label>
				<form:input path="connection" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>联系人：</label>
				<form:input path="connectionUser" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>联系方式</th>
				<th>联系人</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="con:sysConnection:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysConnection">
			<tr>
				<td><a href="${ctx}/con/sysConnection/form?id=${sysConnection.id}">
					${sysConnection.connection}
				</a></td>
				<td>
					${sysConnection.connectionUser}
				</td>
				<td>
					<fmt:formatDate value="${sysConnection.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sysConnection.remarks}
				</td>
				<shiro:hasPermission name="con:sysConnection:edit"><td>
    				<a href="${ctx}/con/sysConnection/form?id=${sysConnection.id}">修改</a>
					<a href="${ctx}/con/sysConnection/delete?id=${sysConnection.id}" onclick="return confirmx('确认要删除该Connection吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>