//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/goodsSku/gridData',
            fit : false,
            fitColumns : true,
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
                title : '商品属性ID',
                field : 'id',
            },
                    {
                width : '80',
                title : '商品id',
                field : 'goodId',
            },
                    {
                width : '80',
                title : '属性值',
                field : 'skuName',
            },
                    {
                width : '80',
                title : '商品价格',
                field : 'price',
            },
                    {
                width : '80',
                title : '该sku库存',
                field : 'stock',
            },
                    {
                width : '80',
                title : '商品条形码',
                field : 'code',
            },
                    {
                width : '80',
                title : '商品重量',
                field : 'weight',
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
	            text:'添加销售属性',
	            handler: function(){addFun();}
            }],
            onLoadSuccess : function(data){
                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    var data = {"total":0,"rows":[]};
    
    function addFun(id) {
    	var url = '/goodsSku/add';
    	if(id){
    		url = '/goodsSku/add?goodsId='+id;
    	}
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : url,
            buttons : [ {
                text : '添加',
                handler : function() {
                    var f = parent.$.modalDialog.handler.find('#skuForm');
                	 var object = getFormJson(f);
                	data.rows.push(object);
                	data.total = data.rows.length;
                	dataGrid.datagrid("loadData",data);
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
        parent.$.messager.confirm('询问', '您是否要删除商品SKU？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/goodsSku/delete', {
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
            href : '/goodsSku/edit?id=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#skuForm');
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
    