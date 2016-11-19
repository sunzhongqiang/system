//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/goods/gridData',
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
                    {
                width : '80',
                title : '商品ID',
                field : 'id',
                align: 'center',
            },
                    {
                width : '80',
                title : '商品分类',
                field : 'goodsCat',
                align: 'center',
                formatter : function(value, row, index) {
					switch (value) {
					case 0:
						return '一元购';
					case 1:
						return '拼团';
					}
				}
                
            },
//            		{
//                width : '80',
//                title : '商品主图',
//                field : 'goodsMainImg',
//                formatter:function(value,row,index)
//                {return '<img src='+value+'>';}
//            },
                    {
                width : '200',
                title : '商品名称',
                field : 'goodsName',
            },
                    {
                width : '80',
                title : '商品数量',
                field : 'goodsNumber',
                align: 'center',
            },
                    {
                width : '80',
                title : '商品原价',
                field : 'goodsOriginalPrice',
                align: 'center',
            },
                    {
                width : '80',
                title : '团购价',
                field : 'promotePrice',
                align: 'center',
            },
                    {
                width : '150',
                title : '促销开始时间',
                field : 'promoteStartDate',
                formatter: formatDatebox,
                align: 'center',
            },
                    {
                width : '150',
                title : '促销结束时间',
                field : 'promoteEndDate',
                formatter: formatDatebox,
                align: 'center',
            },
                    {
                width : '80',
                title : '促销数量',
                field : 'promoteNumber',
                align: 'center',
            },
//                    {
//                width : '80',
//                title : '已售数量',
//                field : 'saledNumber',
//            },
//                    {
//                width : '80',
//                title : '商品相册',
//                field : 'goodsThumb',
//            },
//                    {
//                width : '80',
//                title : '商品原图',
//                field : 'goodsOriginalImg',
//            },
                    {
                width : '80',
                title : '商品是否下架',
                field : 'isDelete',
                align: 'center',
                formatter : function(value, row, index) {
					switch (value) {
					case 0:
						return '上架';
					case 1:
						return '下架';
					}
				}
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
	            text:'发布商品',
	            handler: function(){
	            	
	            	addFun();
	            	}
            }],
            onLoadSuccess : function(data){
                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    function addFun() {
    	 parent.addTab({
			url : '/goods/add',
			title : '添加商品',
		},true);
//        parent.$.modalDialog({
//            title : '添加',
//            width : 500,
//            height : 300,
//            href : '/goods/add',
//            buttons : [ {
//                text : '添加',
//                handler : function() {
//                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
//                    var f = parent.$.modalDialog.handler.find('#modelForm');
//                    f.submit();
//                }
//            } ]
//        });
    }
    
    function deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除商品活动？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/goods/delete', {
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
        
        parent.addTab({
			url : '/goods/edit?id=' + id,
			title : '修改商品',
		},true);
//        parent.$.modalDialog({
//            title : '编辑',
//            width : 500,
//            height : 300,
//            href : '/goods/edit?id=' + id,
//            buttons : [ {
//                text : '编辑',
//                handler : function() {
//                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
//                    var f = parent.$.modalDialog.handler.find('#modelForm');
//                    f.submit();
//                }
//            } 
//            ]
//        });
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
    