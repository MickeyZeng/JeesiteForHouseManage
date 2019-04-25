<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>Duties管理</title>
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
		<li class="active"><a href="${ctx}/dut/sysEnterpriseDuties/">Duties列表</a></li>
		<shiro:hasPermission name="dut:sysEnterpriseDuties:edit"><li><a href="${ctx}/dut/sysEnterpriseDuties/form">Duties添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysEnterpriseDuties" action="${ctx}/dut/sysEnterpriseDuties/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>职务编号：</label>
				<form:input path="enterpriseDutiesId" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>职务名称：</label>
				<form:input path="dutiesName" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>底薪：</label>
				<form:input path="basicSalary" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>职务编号</th>
				<th>职务名称</th>
				<th>底薪</th>
				<th>职务属性（业务，管理等）</th>
				<shiro:hasPermission name="dut:sysEnterpriseDuties:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysEnterpriseDuties">
			<tr>
				<td><a href="${ctx}/dut/sysEnterpriseDuties/form?id=${sysEnterpriseDuties.id}">
					${sysEnterpriseDuties.enterpriseDutiesId}
				</a></td>
				<td>
					${sysEnterpriseDuties.dutiesName}
				</td>
				<td>
					${sysEnterpriseDuties.basicSalary}
				</td>
				<td>
					${sysEnterpriseDuties.jobAttributes}
				</td>
				<shiro:hasPermission name="dut:sysEnterpriseDuties:edit"><td>
    				<a href="${ctx}/dut/sysEnterpriseDuties/form?id=${sysEnterpriseDuties.id}">修改</a>
					<a href="${ctx}/dut/sysEnterpriseDuties/delete?id=${sysEnterpriseDuties.id}" onclick="return confirmx('确认要删除该Duties吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>