<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>Modal Window - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="jquery/jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery/jquery-easyui-1.3.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery/jquery-easyui-1.3.3/demo/demo.css">
	<script type="text/javascript" src="jquery/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

	<h2>模态窗口</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>点击下面按钮打开模态窗口.</div>
	</div>
	<div style="margin:100px 100px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('open')">打开</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')">关闭</a>
	</div>
	<div id="w" class="easyui-window" title="模态窗口" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
		窗体内容

	
	
	
	
	
	<h2>加载面板内容</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>点击面板右上角按钮加载内容.</div>
	</div><a href="javascript:reload()">click</a>
	<div style="margin:10px 0;"></div>
	<div id="p" class="easyui-panel" title="加载面板内容" style="width:500px;height:200px;padding:10px;"
			data-options="
				tools:[{
					iconCls:'icon-reload',
					handler:function(){
						$('#p').panel('refresh', 'testAction.action');
					}
				}]
			">
	</div>
	
	<script type="text/javascript">
		function reload(){
			$('#p').panel('refresh', 'testAction.action');
		}
	</script>
	

	<div class="easyui-panel" title="Ajax表单" style="width:230px;padding:10px;">  
        <form id="ff" action="testAction.action" method="post">  
            <table>  
                <tr>  
                    <td>姓名:</td>  
                    <td><input name="name" type="text"></input></td>  
                </tr>  
                <tr>  
                    <td>Email:</td>  
                    <td><input name="email" type="text"></input></td>  
                </tr>  
                <tr>  
                    <td>电话</td>  
                    <td><input name="phone" type="text"></input></td>  
                </tr>  
                <tr>  
                    <td></td>  
                    <td><input type="submit" value="提交"></input></td>  
                </tr>  
            </table>  
        </form>  
    </div>  
    <script type="text/javascript">  
        $(function(){  
            $('#ff').form({  
                success:function(data){  
                    $.messager.alert('系统提示', data, 'info');  
                }  
            });  
        });  
    </script>  
	</div>

</body>
</html>
