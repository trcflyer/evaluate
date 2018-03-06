<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding:3px 2px;border-bottom:1px solid #ccc">添加管理员</div>
	<form id="ff" action="admin/add" method="post">
		<table>
			<tr>
				<td width="40%">登录名:</td>
				<td width="60%"><input name="username" type="text" class='input'></input></td>
			</tr>
			<tr>
				<td width="40%">密码:</td>
				<td width="60%"><input name="password" type="password" class='input'></input></td>
			</tr>
			<tr>
				<td width="40%">再次确认密码:</td>
				<td width="60%"><input name="againpassword" type="password" class='input'></input></td>
			</tr>
			<tr>
				<td width="40%">昵称:</td>
				<td width="60%"><input name="remark" type="text" class='input'></input></td>
			</tr>
			<tr>
				<td width="40%">角色:</td>
				<td width="60%"><input name="role"  class='easyui-combobox' data-options="
				valueField: 'value',
				textField: 'label',
				data: [{
					label: '超级管理员',
					value: '1'
				},{
					label: '普通管理员',
					value: '2',
					selected:true
				}]" ></input></td>
			</tr>
			<tr>
				<td width="20%"></td>
				<td width="60%"><span id="msgTip" style='color:red;font-size:13px;'></span></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></input></td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
$('#ff').form({
	success:function(data){
		data = JSON.parse(data);
		console.info(data);
		if(data.state === "1"){
			$('#msgTip').html("添加管理员成功");
			
		}else{
			$('#msgTip').html("添加管理员失败");

		}
		$(".input").val("");
	}
});
</script>