<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>Client管理</title>
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
		<li class="active"><a href="${ctx}/cus/sysClient/">Client列表</a></li>
		<shiro:hasPermission name="cus:sysClient:edit"><li><a href="${ctx}/cus/sysClient/form">Client添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysClient" action="${ctx}/cus/sysClient/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>客源编号：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>状态：</label>
				<form:input path="status" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>面积：</label>
				<form:input path="area" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>价格：</label>
				<form:input path="purchasingPrice" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>客源编号</th>
				<th>交易</th>
				<th>用途</th>
				<th>意向地址</th>
				<th>状态</th>
				<th>面积</th>
				<th>属性</th>
				<th>价格</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="cus:sysClient:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysClient">
			<tr>
				<td><a href="${ctx}/cus/sysClient/form?id=${sysClient.id}">
					${sysClient.id}
				</a></td>
				<td>
					${sysClient.transaction}
				</td>
				<td>
					${sysClient.application}
				</td>
				<td>
					${sysClient.willingAddress}
				</td>
				<td>
					${sysClient.status}
				</td>
				<td>
					${sysClient.area}
				</td>
				<td>
					${sysClient.attribute}
				</td>
				<td>
					${sysClient.purchasingPrice}
				</td>
				<td>
					<fmt:formatDate value="${sysClient.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sysClient.remarks}
				</td>
				<shiro:hasPermission name="cus:sysClient:edit"><td>
    				<a href="${ctx}/cus/sysClient/form?id=${sysClient.id}">修改</a>
					<a href="${ctx}/cus/sysClient/delete?id=${sysClient.id}" onclick="return confirmx('确认要删除该Client吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>