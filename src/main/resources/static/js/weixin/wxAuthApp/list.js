//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/weixin/wxAuthApp/gridData',
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
                width : '80',
                title : '',
                field : 'id',
            },
            {
                width : '80',
                title : '授权方appid',
                field : 'authorizerAppid',
            },
            {
                width : '80',
                title : '令牌',
                field : 'authorizerAccessToken',
            },
            {
                width : '80',
                title : '据刷新令牌',
                field : 'authorizerRefreshToken',
            },
            {
                width : '80',
                title : '有效期',
                field : 'expiresIn',
            },
            {
                width : '80',
                title : '更新时间',
                field : 'modified',
                formatter: formatDatebox,
            },
            {
                width : '80',
                title : '昵称',
                field : 'nickName',
            },
            {
                width : '80',
                title : '授权方头像',
                field : 'headImg',
            },
            {
                width : '80',
                title : '原始ID',
                field : 'userName',
            },
            {
                width : '80',
                title : '主体名称',
                field : 'principalName',
            },
            {
                width : '80',
                title : '所设置的微信号',
                field : 'alias',
            },
            {
                width : '80',
                title : '功能的开通状况',
                field : 'businessInfo',
            },
            {
                width : '80',
                title : '二维码图片的URL',
                field : 'qrcodeUrl',
            },
            {
                width : '80',
                title : '权限集列表',
                field : 'funcInfo',
            },
            {
                width : '80',
                title : '授权信息',
                field : 'authorizationInfo',
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
            href : '/weixin/wxAuthApp/add',
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
        parent.$.messager.confirm('询问', '您是否要删除微信授权APP？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/weixin/wxAuthApp/delete', {
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
            href : '/weixin/wxAuthApp/edit?id=' + id,
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
    