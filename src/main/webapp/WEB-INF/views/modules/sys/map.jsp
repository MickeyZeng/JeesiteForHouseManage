<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>百度地图javascript</title>
	<script type="text/javascript">
        function initialize() {
            var mp = new BMap.Map('map');
            mp.centerAndZoom(new BMap.Point(121.2134, 31.0576), 15);
            mp.enableScrollWheelZoom();                //激活滚轮调整大小功能
            mp.addControl(new BMap.NavigationControl());    //添加控件：缩放地图的控件，默认在左上角；
            mp.addControl(new BMap.MapTypeControl());        //添加控件：地图类型控件，默认在右上方；
            mp.addControl(new BMap.ScaleControl());        //添加控件：地图显示比例的控件，默认在左下方；
            mp.addControl(new BMap.OverviewMapControl());  //添加控件：地图的缩略图的控件，默认在右下方； TrafficControl
        }

        function loadScript() {
            var script = document.createElement("script");
            script.src = "http://api.map.baidu.com/api?v=1.4&callback=initialize";
            document.body.appendChild(script);
        }

        //设置城市的函数
        function setCity(){
            search(document.getElementById("cityName").value);
        }
        //初始化显示的城市
//        search.search(document.getElementById("cityName").value);

        window.onload = loadScript;
	</script>
</head>
<body>
<div id="map" style="width: 1500px; height: 1000px"></div>
</body>
</html>