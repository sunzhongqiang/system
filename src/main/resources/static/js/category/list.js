//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var treeGrid;
    $(function() {
        treeGrid = $('#treeGrid').treegrid({
            url : '/category/treeGrid',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            treeField : 'name',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
           
            {
                width : '180',
                title : '分类名称',
                field : 'name',
            }, 
            {
                width : '80',
                title : '分类id',
                field : 'id',
            },
            {
                width : '280',
                title : '分类路径',
                field : 'path',
            },
            {
                width : '80',
                title : '排序',
                field : 'sortOrder',
            },
            {
                width : '80',
                title : '是否显示',
                field : 'isShow',
                formatter : function(value, row, index) {
                	return value == 0 ? '隐藏' : '显示' ; 
                }
            },
            {
                width : '80',
                title : '分类标志',
                field : 'catIco',
            },
            {
                width : '80',
                title : '分类LOGO',
                field : 'catLogo',
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
            href : '/category/add',
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_treeGrid = treeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } ]
        });
    }
    
    function deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = treeGrid.treegrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            treeGrid.treegrid('unselectAll').treegrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除商品分类？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/category/delete', {
                        id : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            treeGrid.treegrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
        });
    }
    
    function editFun(id) {
        if (id == undefined) {
            var rows = treeGrid.treegrid('getSelections');
            id = rows[0].id;
        } else {
            treeGrid.treegrid('unselectAll').treegrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 500,
            href : '/category/edit?id=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_treeGrid = treeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } 
            ]
        });
    }
    
    function searchFun() {
        ////将searchForm表单内的元素序列为对象传递到后台
        treeGrid.treegrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        //找到form表单下的所有input标签并清空
        $('#searchForm input').val('');
        //重新加载数据，无填写数据，向后台传递值则为空
        treeGrid.treegrid('load', {});
    }