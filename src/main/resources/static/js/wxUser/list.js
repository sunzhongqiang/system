//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/wxUser/gridData',
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
                title : '用户id',
                field : 'id',
                align: 'center',
            },
                    {
                width : '200',
                title : '昵称',
                field : 'nickname',
                align: 'center',
            },
                    {
                width : '100',
                title : '头像路径',
                field : 'headimgurl',
                align: 'center',
                formatter:function(value,row,index){
                	return '<img src="'+value+'" width="70px">';}
            },
                    {
                width : '100',
                title : '真实姓名',
                field : 'realname',
                align: 'center',
            },
                    {
                width : '80',
                title : '性别',
                field : 'sex',
                align: 'center',
                formatter : function(value, row, index) {
					switch (value) {
					case '0':
						return '女';
					case '1':
						return '男';
					case '2':
						return '保密';
					}
				}
            },
                    {
                width : '120',
                title : '国家',
                field : 'country',
                align: 'center',
            },
            		{
                width : '120',
                title : '省份',
                field : 'province',
                align: 'center',
            },
                    {
                width : '120',
                title : '城市',
                field : 'city',
                align: 'center',
            }] ],
        });
    });
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/wxUser/add',
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
        parent.$.messager.confirm('询问', '您是否要删除微信用户？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/wxUser/delete', {
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
            href : '/wxUser/edit?id=' + id,
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
    