<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>FollowupHouse管理</title>
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
		<li class="active"><a href="${ctx}/flh/sysFollowupHouse/">FollowupHouse列表</a></li>
		<shiro:hasPermission name="flh:sysFollowupHouse:edit"><li><a href="${ctx}/flh/sysFollowupHouse/form">FollowupHouse添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysFollowupHouse" action="${ctx}/flh/sysFollowupHouse/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>员工id：</label>
				<form:input path="userid" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>房源id：</label>
				<form:input path="houseid" htmlEscape="false" maxlength="45" class="input-medium"/>
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
				<th>房源id</th>
				<th>跟进时间</th>
				<th>跟进方式</th>
				<shiro:hasPermission name="flh:sysFollowupHouse:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysFollowupHouse">
			<tr>
				<td><a href="${ctx}/flh/sysFollowupHouse/form?id=${sysFollowupHouse.id}">
					${sysFollowupHouse.content}
				</a></td>
				<td>
					${sysFollowupHouse.userid}
				</td>
				<td>
					${sysFollowupHouse.houseid}
				</td>
				<td>
					<fmt:formatDate value="${sysFollowupHouse.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sysFollowupHouse.method}
				</td>
				<shiro:hasPermission name="flh:sysFollowupHouse:edit"><td>
    				<a href="${ctx}/flh/sysFollowupHouse/form?id=${sysFollowupHouse.id}">修改</a>
					<a href="${ctx}/flh/sysFollowupHouse/delete?id=${sysFollowupHouse.id}" onclick="return confirmx('确认要删除该FollowupHouse吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>