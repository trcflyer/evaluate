<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <table class="easyui-datagrid" title="管理员信息" 
			data-options="singleSelect:true,collapsible:true,pagination:true,url:'admin/list',method:'get',pageSize:20">
		<thead>
			<tr>
				<th data-options="field:'username',width:120,align:'center'">用户名</th>
				<th data-options="field:'remark',width:120,align:'center'">昵称</th>
				<th data-options="field:'role',width:120,align:'center'">角色</th>
			</tr>
		</thead>
	</table>