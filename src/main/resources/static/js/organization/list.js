//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    $(function() {
    
        dataGrid = $('#dataGrid').treegrid({
            url : '/organization/treeGrid',
            fit : true,
            fitColumns: true,
            striped : true,
            rownumbers : false,
            singleSelect : true,
            idField : 'id',
            treeField : 'name',
            animate: true,  
            checkbox: false,  
            cascadeCheck:true,//层叠选中  
            lines:true,//显示虚线效果  
            pageSize : 50,
            columns : [ [ 
                   
                    {
                width : '200',
                title : '机构名称',
                field : 'name',
            },
            {
                width : '180',
                title : '组织主键',
                field : 'id',
            },
                    {
                width : '180',
                title : '机构编码',
                field : 'code',
            },
                    {
                width : '180',
                title : '父类Id',
                field : 'parentId',
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
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/organization/add',
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
            var rows = dataGrid.treegrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            dataGrid.treegrid('unselectAll').treegrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除组织机构？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/organization/delete', {
                        id : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            dataGrid.treegrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
        });
    }
    
    function editFun(id) {
        if (id == undefined) {
            var rows = dataGrid.treegrid('getSelections');
            id = rows[0].id;
        } else {
            dataGrid.treegrid('unselectAll').treegrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 300,
            href : '/organization/edit?id=' + id,
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
    	
        dataGrid.treegrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        //找到form表单下的所有input标签并清空
        $('#searchForm input').val('');
        //重新加载数据，无填写数据，向后台传递值则为空
        dataGrid.treegrid('load', {});
    }
    