//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    var groupData;
    $(function() {
        dataGrid = $('#goodsGrid').datagrid({
            url : '/goods/gridData',
            fit : true,
            fitColumns : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            nowrap :false,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
                    {
                width : '60',
                title : '商品ID',
                field : 'id',
                align: 'center',
            },
//            		{
//                width : '80',
//                title : '商品主图',
//                field : 'goodsMainImg',
//                formatter:function(value,row,index)
//                {return '<img src='+value+'>';}
//            },
                    {
                width : '400',
                title : '商品名称',
                field : 'goodsName',
            },
                    {
                width : '80',
                title : '商品原价',
                field : 'goodsOriginalPrice',
                align: 'center',
            },
                    {
                width : '80',
                title : '商品是否在售',
                field : 'isOnsale',
                align: 'center',
                formatter : function(value, row, index) {
					if(value) {
						return '上架中';
					}else{
						return '已下架';
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
                    str += $.formatString('<a href="javascript:void(0)" onclick="groupSetting(\'{0}\');" class="btn_edit" >拼团设置</a>', row.id);
                    return str;
                }
            }] ],
//           toolbar :  [{
//	            iconCls: 'icon-add',
//	            text:'新增',
//	            handler: function(){
//	            	addFun();
//	            }
//            }],
            onLoadSuccess : function(data){
                $('.btn_edit').linkbutton({text:'拼团设置',plain:true,iconCls:'icon-edit'});
                $(this).datagrid('fixRowHeight');
            },
            //点击左侧位置推荐商品
            onSelect: function(index,row) {
            	groupData.datagrid('load',{"goodsId":row.id});
        	},
        });
        
        
        groupData = $('#groupGoods').datagrid({
            url : '/goodsGroup/loadByGoods',
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
                title : '拼团类型',
                field : 'type',
                formatter : function(value, row, index) {
					switch (value) {
					case 0:
						return '一元购';
					case 1:
						return '拼团';
					}
				}
            },
                    {
                width : '80',
                title : '拼团数量',
                field : 'num',
            },
                    {
                width : '80',
                title : '拼团价',
                field : 'groupPrice',
            },
                    {
                width : '130',
                title : '拼团开始时间',
                field : 'startTime',
                formatter: formatDatebox,
            },
                    {
                width : '130',
                title : '拼团结束时间',
                field : 'endTime',
                formatter: formatDatebox,
            },
                    {
                width : '100',
                title : '持续时间（天）',
                field : 'duration',
            },
            {
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="editGroupFun(\'{0}\');" class="btn_edit_group" >编辑</a>', row.id);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteGroupFun(\'{0}\');" class="btn_delete_group" >删除</a>', row.id);
                    return str;
                }
            }
            ] ],
            onLoadSuccess : function(data){
                $('.btn_edit_group').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete_group').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    
    function deleteGroupFun(id) {
    	 if (id == undefined) {//点击右键菜单才会触发这个
             var rows = groupData.datagrid('getSelections');
             id = rows[0].id;
         } else {//点击操作里面的删除图标会触发这个
        	 groupData.datagrid('unselectAll').datagrid('uncheckAll');
         }
         parent.$.messager.confirm('询问', '您是否要删除商品拼团管理？', function(b) {
             if (b) {
                 progressLoad();
                     $.post('/goodsGroup/delete', {
                         id : id
                     }, function(result) {
                         if (result.success) {
                             parent.$.messager.alert('提示', result.msg, 'info');
                             groupData.datagrid('reload');
                         }
                         progressClose();
                     }, 'JSON');
                 }
         });
    }
    
    function editGroupFun(id){
    	parent.$.modalDialog({
            title : '拼团设置',
            width : 800,
            height : 500,
            href : '/goodsGroup/edit?id=' + id,
            buttons : [ {
                text : '保存',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = groupData;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } 
            ]
        });
    }
    
    function groupSetting(id) {
        parent.$.modalDialog({
            title : '拼团设置',
            width : 800,
            height : 500,
            href : '/goodsGroup/add?goodsId=' + id,
            buttons : [ {
                text : '保存',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = groupData;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
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
    
    