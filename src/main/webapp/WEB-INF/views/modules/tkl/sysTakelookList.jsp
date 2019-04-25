<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>带看房源管理</title>
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
		<li class="active"><a href="${ctx}/tkl/sysTakelook/">带看房源列表</a></li>
		<shiro:hasPermission name="tkl:sysTakelook:edit"><li><a href="${ctx}/tkl/sysTakelook/form">带看房源添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysTakelook" action="${ctx}/tkl/sysTakelook/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>房源id：</label>
				<form:input path="houseid" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>套数：</label>
				<form:input path="houseNumber" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>带看次数</th>
				<th>房源id</th>
				<th>带看编号</th>
				<th>套数</th>
				<shiro:hasPermission name="tkl:sysTakelook:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysTakelook">
			<tr>
				<td><a href="${ctx}/tkl/sysTakelook/form?id=${sysTakelook.id}">
					${sysTakelook.lookTimes}
				</a></td>
				<td>
					${sysTakelook.houseid}
				</td>
				<td>
					${sysTakelook.takeNumber}
				</td>
				<td>
					${sysTakelook.houseNumber}
				</td>
				<shiro:hasPermission name="tkl:sysTakelook:edit"><td>
    				<a href="${ctx}/tkl/sysTakelook/form?id=${sysTakelook.id}">修改</a>
					<a href="${ctx}/tkl/sysTakelook/delete?id=${sysTakelook.id}" onclick="return confirmx('确认要删除该带看房源吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>