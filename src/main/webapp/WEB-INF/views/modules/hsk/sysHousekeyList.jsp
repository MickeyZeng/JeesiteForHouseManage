<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>房屋钥匙管理</title>
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
		<li class="active"><a href="${ctx}/hsk/sysHousekey/">房屋钥匙列表</a></li>
		<shiro:hasPermission name="hsk:sysHousekey:edit"><li><a href="${ctx}/hsk/sysHousekey/form">房屋钥匙添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysHousekey" action="${ctx}/hsk/sysHousekey/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>钥匙编号：</label>
				<form:input path="id" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>房屋ID：</label>
				<form:input path="houseId" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>钥匙名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>员工id：</label>
				<form:input path="userid" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>钥匙编号</th>
				<th>房屋ID</th>
				<th>钥匙名称</th>
				<th>员工id</th>
				<shiro:hasPermission name="hsk:sysHousekey:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysHousekey">
			<tr>
				<td><a href="${ctx}/hsk/sysHousekey/form?id=${sysHousekey.id}">
					${sysHousekey.id}
				</a></td>
				<td>
					${sysHousekey.houseId}
				</td>
				<td>
					${sysHousekey.name}
				</td>
				<td>
					${sysHousekey.userid}
				</td>
				<shiro:hasPermission name="hsk:sysHousekey:edit"><td>
    				<a href="${ctx}/hsk/sysHousekey/form?id=${sysHousekey.id}">修改</a>
					<a href="${ctx}/hsk/sysHousekey/delete?id=${sysHousekey.id}" onclick="return confirmx('确认要删除该房屋钥匙吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>