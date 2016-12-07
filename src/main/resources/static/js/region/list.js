//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    $(function() {
        dataGrid = $('#dataGrid').treegrid({
            url : '/region/loadRegionByParentId',
            fit : true,
            striped : true,
            rownumbers : true,
            singleSelect : true,
            idField : 'regionId',
            parentField:'parentId',
            treeField : 'regionName',
            pageSize : 100,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            onBeforeLoad: function(row,param){
                if (!row) {    // load top level rows
                    param.parentId = 1;    // set id=0, indicate to load new page rows
                }else{
                	param.parentId = row.regionId;
                }
            },	
            columns : [ [ 
            {
                width : '220',
                title : '区域名称',
                field : 'regionName',
            },
//                    {
//                width : '80',
//                title : '是否显示1-显示',
//                field : 'isDisplay',
//            },
                    {
                width : '120',
                title : '所属大区',
                field : 'belongsBigregion',
            },
                    {
                width : '150',
                title : '区域全地址',
                field : 'fullRegionName',
            },
            {
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" class="btn_edit" >编辑</a>', row.regionId);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" class="btn_delete" >删除</a>', row.regionId);
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
            height : 300,
            href : '/region/add',
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
        parent.$.messager.confirm('询问', '您是否要删除区域管理？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/region/delete', {
                    	regionId : id
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
            href : '/region/edit?regionId=' + id,
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
    