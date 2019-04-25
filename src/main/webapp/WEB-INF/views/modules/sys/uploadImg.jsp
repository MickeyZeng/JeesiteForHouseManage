<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>上传图片</title>
</head>
<script type="text/javascript" src="${ctxStatic}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<body>
<div class="control-group">
    <label class="control-label">头像:</label>
    <div class="controls">
        <form:hidden id="nameImage" path="photo" htmlEscape="false" maxlength="255" class="input-xlarge"/>
        <sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100"
                      maxHeight="100"/>
    </div>
</div>
</body>

</html>