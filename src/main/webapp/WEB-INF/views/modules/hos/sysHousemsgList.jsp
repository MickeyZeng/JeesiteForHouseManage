<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>HouseMsg管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {

        });

        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/hos/sysHousemsg/">HouseMsg列表</a></li>
    <shiro:hasPermission name="hos:sysHousemsg:edit">
        <li><a href="${ctx}/hos/sysHousemsg/form">HouseMsg添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="sysHousemsg" action="${ctx}/hos/sysHousemsg/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>房源用途：</label>
            <form:input path="application" htmlEscape="false" maxlength="45" class="input-medium"/>
        </li>
        <li><label>房源地址：</label>
            <form:input path="address" htmlEscape="false" maxlength="100" class="input-medium"/>
        </li>
        <li><label>面积：</label>
            <form:input path="area" htmlEscape="false" maxlength="45" class="input-medium"/>
        </li>
        <li><label>相关员工：</label>
            <sys:treeselect id="user" name="user.id" value="${sysHousemsg.user.id}" labelName="user.name"
                            labelValue="${sysHousemsg.user.name}"
                            title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true"
                            notAllowSelectParent="true"/>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>房屋ID</th>
        <th>房源用途</th>
        <th>房源地址</th>
        <th>面积</th>
        <th>房型：房/厅/卫/阳台</th>
        <th>相关员工</th>
        <shiro:hasPermission name="hos:sysHousemsg:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="sysHousemsg">
        <tr>
            <td><a href="${ctx}/hos/sysHousemsg/form?id=${sysHousemsg.id}">
                    ${sysHousemsg.id}
            </a></td>
            <td>
                    ${sysHousemsg.application}
            </td>
            <td>
                    ${sysHousemsg.address}
            </td>
            <td>
                    ${sysHousemsg.area}
            </td>
            <td>
                    ${sysHousemsg.houseType}
            </td>
            <td>
                    ${sysHousemsg.user.name}
            </td>
            <shiro:hasPermission name="hos:sysHousemsg:edit">
                <td>
                    <a href="${ctx}/hos/sysHousemsg/form?id=${sysHousemsg.id}">修改</a>
                    <a href="${ctx}/hos/sysHousemsg/delete?id=${sysHousemsg.id}"
                       onclick="return confirmx('确认要删除该HouseMsg吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>