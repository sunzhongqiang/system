//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    var organizationTree;
    $(function() {
    
        dataGrid = $('#dataGrid').datagrid({
            url : '/role/gridData',
            fit : true,
            fitColumns :true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
                    {
                width : '180',
                title : '角色主键',
                field : 'id',
            },
                    {
                width : '180',
                title : '角色编码',
                field : 'code',
            },
                    {
                width : '180',
                title : '角色名称',
                field : 'name',
            },
                    {
                width : '180',
                title : '状态',
                field : 'status',
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
                field : 'action',
                title : '操作',
                width : 240,
                align : 'center',
                formatter : function(value, row, index) {
                	
                    var str = '';
                    if(row.status == "enable"){
                    	str += $.formatString('<a href="javascript:void(0)" onclick="disable(\'{0}\');" class="btn_lock" >禁用</a>', row.id);
                	}else{
                		str += $.formatString('<a href="javascript:void(0)" onclick="enable(\'{0}\');" class="btn_unlock" >启用</a>', row.id);
                	}
                    
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
            	$('.btn_lock').linkbutton({text:'禁用',plain:true,iconCls:'icon-lock'});
            	$('.btn_unlock').linkbutton({text:'启用',plain:true,iconCls:'icon-unlock'});
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
            href : '/role/add',
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
        parent.$.messager.confirm('询问', '您是否要删除系统角色？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/role/delete', {
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
            href : '/role/edit?id=' + id,
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
    
    
    // 禁用
    function disable(id) {
    	  if (id == undefined) {//点击右键菜单才会触发这个
              var rows = dataGrid.datagrid('getSelections');
              id = rows[0].id;
          } else {//点击操作里面的删除图标会触发这个
              dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
          }
    	  parent.$.messager.confirm('询问', '您是否要禁用此角色？', function(b) {
              if (b) {
                  progressLoad();
                      $.post('/role/disable', {
                          id : id
                      }, function(result) {
                          if (result.success) {
                              dataGrid.datagrid('reload');
                          }
                          progressClose();
                      }, 'JSON');
                  }
          });
    }
    
 // 启用
    function enable(id) {
    	  if (id == undefined) {//点击右键菜单才会触发这个
              var rows = dataGrid.datagrid('getSelections');
              id = rows[0].id;
          } else {//点击操作里面的删除图标会触发这个
              dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
          }
    	  parent.$.messager.confirm('询问', '您是否要启用此角色？', function(b) {
              if (b) {
                  progressLoad();
                      $.post('/role/enable', {
                          id : id
                      }, function(result) {
                          if (result.success) {
                              dataGrid.datagrid('reload');
                          }
                          progressClose();
                      }, 'JSON');
                  }
          });
    }
    