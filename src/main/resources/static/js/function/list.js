//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var treegrid;
    $(function() {
    
        treegrid = $('#dataGrid').treegrid({
            url : '/function/tree',
            fit : true,
            fitColumns: true,
            striped : true,
            rownumbers : false,
            pagination : false,
            singleSelect : true,
            idField : 'id',
            treeField : 'name',
            animate: true,  
            checkbox: false,  
            cascadeCheck:true,//层叠选中  
            lines:true,//显示虚线效果  
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
                          {
                width : '200',
                title : '资源名称',
                field : 'name',
            },{
                width : '180',
                title : '功能主键',
                field : 'id',
            },
                    {
                width : '180',
                title : '权限地址',
                field : 'uri',
            },
              
                    {
                width : '180',
                title : '资源类型',
                field : 'type',
                formatter : function(value, row, index) {
					switch (value) {
					case 'menu':
						return '菜单';
					case 'function':
						return '功能';
					case 'module':
						return '模块';
					}
				}
                
            },
                    {
                width : '180',
                title : '描述',
                field : 'description',
            },
		            {
		        width : '180',
		        title : '排序',
		        field : 'sort',
		    },
		            {
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
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
                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).treegrid('fixRowHeight');
            }
        });
    });
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 500,
            href : '/function/add',
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_datagrid = treegrid;//因为添加成功之后，需要刷新这个treegrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                    $('#dataGrid').treegrid('reload');
                }
            } ]
        });
    }
    
    function deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = treegrid.treegrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
        	treegrid.treegrid('unselectAll').treegrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除系统功能？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/function/delete', {
                        id : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            treegrid.treegrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
        });
    }
    
    function editFun(id) {
        if (id == undefined) {
            var rows = treegrid.treegrid('getSelections');
            id = rows[0].id;
        } else {
        	treegrid.treegrid('unselectAll').treegrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 500,
            href : '/function/edit?id=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_datagrid = treegrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                    
                }
            } 
            ]
        });
    }
    
    function searchFun() {
        ////将searchForm表单内的元素序列为对象传递到后台
    	treegrid.treegrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        //找到form表单下的所有input标签并清空
        $('#searchForm input').val('');
        //重新加载数据，无填写数据，向后台传递值则为空
        treegrid.treegrid('load', {});
    }
    