//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var payGrid;
    var configGrid;
    var paymentId;
    $(function() {
        payGrid = $('#payGrid').datagrid({
            url : '/payment/gridData',
            fit : true,
            fitColumns : true,
            striped : true,
            rownumbers : true,
            pagination : false,
            singleSelect : true,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
            {
                width : '100',
                title : '编码',
                field : 'code',
            },
            {
                width : '100',
                title : '支付名称',
                field : 'name',
            },
//            {
//                width : '80',
//                title : '支付类型：online,offline,bank,cod',
//                field : 'type',
//            },
//            {
//                width : '80',
//                title : '备注',
//                field : 'remark',
//            },
//            {
//                width : '80',
//                title : '排序',
//                field : 'orderSort',
//            },
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
            },
            onSelect: function(index,row) {
            	paymentId = row.id;
            	configGrid.datagrid('load',{paymentId: paymentId});
        	}
        });
    });
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/payment/add',
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_payGrid = payGrid;//因为添加成功之后，需要刷新这个payGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } ]
        });
    }
    
    function deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = payGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            payGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除支付方式？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/payment/delete', {
                        id : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            payGrid.datagrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
        });
    }
    
    function editFun(id) {
        if (id == undefined) {
            var rows = payGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            payGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 300,
            href : '/payment/edit?id=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_payGrid = payGrid;//因为添加成功之后，需要刷新这个payGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } 
            ]
        });
    }
    
    function searchFun() {
        ////将searchForm表单内的元素序列为对象传递到后台
        payGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        //找到form表单下的所有input标签并清空
        $('#searchForm input').val('');
        //重新加载数据，无填写数据，向后台传递值则为空
        payGrid.datagrid('load', {});
    }
    
    
    
    
    
    //
    
    $(function() {
    	configGrid = $('#configGrid').datagrid({
            url : '/paymentConfig/loadByPaymentId',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
            {
                width : '100',
                title : '参数名',
                field : 'code',
            },
            {
                width : '380',
                title : '参数值',
                field : 'value',
            },
            {
                width : '380',
                title : '参数说明',
                field : 'remark',
            },
            {
                width : '40',
                title : '排序',
                field : 'orderSort',
                align : 'center',
            },
            {
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="editFun1(\'{0}\');" class="btn_edit" >编辑</a>', row.id);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun1(\'{0}\');" class="btn_delete" >删除</a>', row.id);
                    return str;
                }
            }] ],
           toolbar :  [{
	            iconCls: 'icon-add',
	            text:'新增',
	            handler: function(){addFun1(paymentId);}
            }],
            onLoadSuccess : function(data){
                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    function addFun1(paymentId) {
    	if(paymentId == undefined){
     		alert("请选择支付方式！");
     		return false;
     	}
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/paymentConfig/add?paymentId='+paymentId,
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = configGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } ]
        });
    }
    
    function deleteFun1(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = configGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
        	configGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除支付配置参数？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/paymentConfig/delete', {
                        id : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            configGrid.datagrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
        });
    }
    
    function editFun1(id) {
        if (id == undefined) {
            var rows = configGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
        	configGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 300,
            href : '/paymentConfig/edit?id=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = configGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } 
            ]
        });
    }
    