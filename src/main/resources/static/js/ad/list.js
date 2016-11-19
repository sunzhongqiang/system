//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    var PositionGrid;
    var positionId;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/ad/gridData',
            fit : true,
            fitColumns : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            nowrap : false,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
//                    {
//                width : '80',
//                title : '广告ID',
//                field : 'adId',
//            },
                    {
                width : '80',
                title : '位置ID',
                field : 'positionId',
                align: 'center',
            },
                    {
                width : '180',
                title : '广告名称',
                field : 'adName',
                align: 'center',
            },
//                    {
//                width : '80',
//                title : '广告编码',
//                field : 'adCode',
//            },
            		{
                width : '180',
                title : '广告图片',
                field : 'adImg',
                formatter:function(value,row,index)
                {return '<img src='+value+'  />';}
            },
            	{
                width : '300',
                title : '广告链接',
                field : 'adLink',
                align: 'center',
            },

//    		{
//                width : '300',
//                title : '图片地址',
//                field : 'adImgLink',
//                align: 'center',
//            },
                    {
                width : '150',
                title : '开始时间',
                field : 'startTime',
                formatter: formatDatebox,
                align: 'center',
            },
                    {
                width : '150',
                title : '结束时间',
                field : 'endTime',
                formatter: formatDatebox,
                align: 'center',
            },
//                    {
//                width : '80',
//                title : '点击次数',
//                field : 'clickCount',
//                
//            },
//                    {
//                width : '80',
//                title : '描述',
//                field : 'description',
//            },
            {
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" class="btn_edit" >编辑</a>', row.adId);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" class="btn_delete" >删除</a>', row.adId);
                    return str;
                }
            }] ],
           toolbar :  [{
	            iconCls: 'icon-add',
	            text:'新增广告',
	            handler: function(){addFun(positionId);}
            }],
            onLoadSuccess : function(data){
                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    function addFun(positionId) {
    		if(positionId == undefined){
         		alert("请选择广告位置！");
         		return false;
         	}
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 550,
            resizable:true,
            href : '/ad/add?positionId='+positionId,
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
        parent.$.messager.confirm('询问', '您是否要删除广告？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/ad/delete', {
                        adId : id
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
            height : 550,
            href : '/ad/edit?adId=' + id,
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
    
    
    
    
    //
    
    
    $(function() {
    	PositionGrid = $('#PositionGrid').datagrid({
            url : '/adPosition/gridData',
            fit : true,
            fitColumns : true,
            striped : true,
            rownumbers : true,
            pagination : false,
            singleSelect : true,
            selectOnCheck: true,
            idField : 'id',
            //pagination: false,//显示分页工具栏
            pageSize : 100,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
//                    {
//                width : '80',
//                title : '广告位ID',
//                field : 'positionId',
//            },
//                    {
//                width : '80',
//                title : '广告位宽度',
//                field : 'adWidth',
//            },
//                    {
//                width : '80',
//                title : '广告位高度',
//                field : 'adHeight',
//            },
					{
					    width : '30',
					    title : '',
					    field : 'ck',
					    checkbox: true,
					},
					{
		        width : '200',
		        title : '广告位名称',
		        field : 'positionName',
		   },
//                    {
//                width : '150',
//                title : '广告位描述',
//                field : 'positionDesc',
//            },
            {
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="editFun1(\'{0}\');" class="btn_edit" >编辑</a>', row.positionId);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun1(\'{0}\');" class="btn_delete" >删除</a>', row.positionId);
                    return str;
                }
            }] ],
            
            onSelect: function(index,row) {
            	positionId = row.positionId;
            	dataGrid = $('#dataGrid').datagrid('reload',{positionId: positionId});
         },
            
            
            
           toolbar :  [{
	            iconCls: 'icon-add',
	            text:'新增广告位置',
	            handler: function(){addFun1();}
            }],
            onLoadSuccess : function(data){
                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    function addFun1() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/adPosition/add',
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_PositionGrid = PositionGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm1');
                    f.submit();
                }
            } ]
        });
    }
    
    function deleteFun1(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = PositionGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
        	PositionGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除广告位置？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/adPosition/delete', {
                        positionId : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            PositionGrid.datagrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
        });
    }
    
    function editFun1(id) {
        if (id == undefined) {
            var rows = PositionGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
        	PositionGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 300,
            href : '/adPosition/edit?positionId=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_PositionGrid = PositionGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm1');
                    f.submit();
                }
            } 
            ]
        });
    }
    
    function searchFun() {
        ////将searchForm表单内的元素序列为对象传递到后台
    	PositionGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        //找到form表单下的所有input标签并清空
        $('#searchForm input').val('');
        //重新加载数据，无填写数据，向后台传递值则为空
        PositionGrid.datagrid('load', {});
    }
    