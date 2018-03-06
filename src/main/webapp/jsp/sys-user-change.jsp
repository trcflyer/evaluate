<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding:3px 2px;border-bottom:1px solid #ccc">修改密码</div>
	<form id="ff" action="admin/change" method="post">
		<table>
			<tr>
				<td width="40%">原密码:</td>
				<td width="60%"><input name="oldpassword" type="password" class='input'></input></td>
			</tr>
			<tr>
				<td width="40%">新密码:</td>
				<td width="60%"><input name="newpassword" type="password" class='input'></input></td>
			</tr>
			<tr>
				<td width="40%">再次输入:</td>
				<td width="60%"><input name="againpassword" type="password" class='input'></input></td>
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
			$('#msgTip').html("密码修改成功");
			
		}else{
			$('#msgTip').html("密码修改失败");

		}
		$(".input").val("");
	}
});
</script>