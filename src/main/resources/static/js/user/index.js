//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '/user/gridData',
			fit : true,
			fitColumns : true,
			striped : true,
			rownumbers : false,
			pagination : true,
			singleSelect : true,
			idField : 'id',
			pageSize : 50,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [ 
                    {
				width : '100',
				title : '主键',
				field : 'id',
				align:'center'
			},
			 {
				width : '100',
				title : '所在部门',
				field : 'organization',
				formatter:function(value, row, index) {
					if(row['organization']){
						return row['organization'].name;
					}
					return "";
				}
				
			},
            {
				width : '100',
				title : '用户名',
				field : 'username',
				align:'center'
			},
                    {
				width : '250',
				title : '真实姓名',
				field : 'realname',
				align:'center'
			}
             ,
             {
				width : '120',
				title : '状态',
				field : 'status',
				align:'center',
				formatter : function(value, row, index) {
					switch (value) {
					case 'disable':
						return '禁用';
					case 'enable':
						return '启用';
					}
				}
			},
            {
				width : '200',
				title : '创建时间',
				field : 'createTime',
				align:'center',
				formatter: formatDatebox
			},
            {
				width : '200',
				title : '修改时间',
				field : 'modifiedTime',
				align:'center',
				formatter: formatDatebox
			},
			{
				field : 'action',
				title : '操作',
				width : 140,
				align : 'center',
				formatter : function(value, row, index) {
					var str = '';
					str += $.formatString('<a href="javascript:void(0)" onclick="editUserPwd(\'{0}\');" class="btn_mima" >修改密码</a>', row.id);
					str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" class="btn_edit" >编辑</a>', row.id);
					str += '&nbsp;|&nbsp;';
					str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" class="btn_delete" >删除</a>', row.id);
					return str;
				}
			}] ],
			toolbar :  [{
				iconCls: 'icon-add',
				text:'新增',
				handler: function(){addFun();}
				}],
			onLoadSuccess : function(data){
				$('.btn_mima').linkbutton({text:'修改密码',plain:true,iconCls:'icon-lock'});
		 		$('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
		 		$('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
		 		$(this).datagrid('fixRowHeight');
		 		
		 	}
		});
	});
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 500,
			height : 300,
			href : '/user/add',
			buttons : [ {
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#modelForm');
					f.submit();
				}
			} ]
		});
	}
	
	function deleteFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除系统用户？', function(b) {
			if (b) {
				progressLoad();
					$.post('/user/delete', {
						id : id
					}, function(result) {
						if (result.success) {
							parent.$.messager.alert('提示', result.msg, 'info');
							dataGrid.datagrid('reload');
						}
						progressClose();
					}, 'JSON');
				}
		});
	}
	
	function editFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '编辑',
			width : 500,
			height : 300,
			href : '/user/form?id=' + id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#modelForm');
					f.submit();
				}
			} 
			]
		});
	}
	
	function searchFun() {
		////将searchForm表单内的元素序列为对象传递到后台
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	function cleanFun() {
		//找到form表单下的所有input标签并清空
		$('#searchForm input').val('');
		//重新加载数据，无填写数据，向后台传递值则为空
		dataGrid.datagrid('load', {});
	}
	
	function editUserPwd(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
		    title: '修改密码',
		    width: 400,
		    height: 200,
		    href: '/user/editPwdForm?id=' + id,
		    buttons : [ {
				text : '确定',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#editUserPwdForm');
					f.submit();
				}
			} 
			]
		});
		
	}
	
	
	