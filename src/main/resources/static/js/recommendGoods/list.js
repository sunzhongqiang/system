//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
//所有商品列表
    var dataGrid;
    var positionId;
    var tuiList;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/goods/gridData',
            fit : true,
            fitColumns : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            nowrap : false,
            singleSelect : true,
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
                width : '200',
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
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="tuiPos(\'{0}\');" class="btn_edit1" >推荐</a>', row.id);
//                    str += '&nbsp;|&nbsp;';
//                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" class="btn_delete" >删除</a>', row.id);
                    return str;
                }
            }] ],
//           toolbar :  [{
//	            iconCls: 'icon-add',
//	            text:'新增',
//	            handler: function(){
//	            	
//	            	addFun();
//	            	}
//            }],
            onLoadSuccess : function(data){
                $('.btn_edit1').linkbutton({text:'推荐	',plain:true,iconCls:'icon-edit'});
//                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    function tuiPos(id){
    	if(positionId == undefined){
    		alert("请选择推荐位置！");
    		return;
    	}else{
    		
             $.post('/recommendGoods/addRecomm', {
            	 goodsId : id,
                 positionId:positionId,
             }, function(result) {
                 if (result.success) {
//                     parent.$.messager.alert('提示', result.msg, 'info');
                     tuiList.datagrid('reload');
                 }else{
                	 parent.$.messager.alert('提示', result.msg, 'info');
                 }
                 progressClose();
             }, 'JSON');
         }
    	
    	
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  //商品位置管理
    var positionGrid;
    $(function() {
    	positionGrid = $('#positionGrid').datagrid({
            url : '/recommendPosition/gridData',
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
//                    {
//                width : '80',
//                title : 'id',
//                field : 'id',
//            },
					{
                width : '80',
                title : '位置编码',
                field : 'code',
            },
                    {
                width : '140',
                title : '位置名称',
                field : 'positionName',
            },
                   
            {
                field : 'action',
                title : '操作',
                width : 100,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="editPosFun(\'{0}\');" class="btn_edit2" >编辑</a>', row.id);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="deletePosFun(\'{0}\');" class="btn_delete2" >删除</a>', row.id);
                    return str;
                }
            }] ],
           toolbar :  [{
	            iconCls: 'icon-add',
	            text:'新增推荐位置',
	            handler: function(){addPosFun();}
            }],
            
            //点击左侧位置推荐商品
            onSelect: function(index,row) {
            	positionId=row.id;
            	tuiList.datagrid('load',{positionId:positionId});
        	},
            onLoadSuccess : function(data){
                $('.btn_edit2').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete2').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    function addPosFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/recommendPosition/add',
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = positionGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } ]
        });
    }
    
    function deletePosFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = positionGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
        	positionGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除位置表？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/recommendPosition/delete', {
                        id : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            positionGrid.datagrid('reload');
                            tuiList.datagrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
        });
    }
    
    function editPosFun(id) {
        if (id == undefined) {
            var rows = positionGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
        	positionGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 300,
            href : '/recommendPosition/edit?id=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = positionGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } 
            ]
        });
    }
    
    
    
    
    
    //推荐商品列表
    
    $(function() {
    	tuiList = $('#tuiList').datagrid({
            url : '/goods/goodsList',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : false,
            singleSelect : true,
            nowrap : false,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
//                    {
//                width : '80',
//                title : '主键',
//                field : 'id',
//            },
                    {
                width : '80',
                title : '商品id',
                field : 'id',
                formatter : function(value, row, index) {
                    return row.goods.id;
                }
            },
                    {
                width : '180',
                title : '商品名称',
                field : 'goodsName',
                formatter : function(value, row, index) {
                    return row.goods.goodsName;
                }
            },
                    {
                width : '80',
                title : '该商原价',
                field : 'goodsOriginalPrice',
                formatter : function(value, row, index) {
                    return row.goods.goodsOriginalPrice;
                }
            },

		            {
		        width : '80',
		        title : '排序',
		        field : 'orderby',
		        editor:'numberbox',
		        formatter : function(value, row, index) {
                    return row.recommend.orderby;
                }
		      
		    },
            {
                field : 'action',
                title : '操作',
                width : 200,
                align : 'center',
                formatter : function(value, row, index) {
                	console.log(row);
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="editOrder(\'{0}\');" class="btn_delete" >编辑排序</a>', row.recommend.id);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="cancleTui(\'{0}\');" class="btn_edit" >取消推荐</a>', row.recommend.goodsId);
//                  
//                   
                    return str;
                }
            }] ],
//           toolbar :  [{
//	            iconCls: 'icon-add',
//	            text:'新增',
//	            handler: function(){addFun();}
//            }],
            onLoadSuccess : function(data){
            	$('.btn_delete').linkbutton({text:'编辑排序',plain:true,iconCls:'icon-edit'});
                $('.btn_edit').linkbutton({text:'取消推荐',plain:true,iconCls:'icon-edit'});
               
                $(this).datagrid('fixRowHeight');
            }
            
//            onClickCell: function(index,field,value){
//            	console.log(index);
//            	console.log(field);
//            	console.log(value);
//                $(this).datagrid('beginEdit', index);
//                var ed = $(this).datagrid('getEditor', {index:index,field:field});
//                $(ed.target).focus();
//              },
        });
    });
    
    
    
 //编辑排序
    function editOrder(id) {
        if (id == undefined) {
            var rows = tuiList.datagrid('getSelections');
            id = rows[0].id;
        } else {
        	tuiList.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑排序',
            width : 500,
            height : 300,
            href : '/recommendGoods/editOrder?id=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = tuiList;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } 
            ]
        });
    }
    
    
    
    
    
    
//取消推荐
    
    function cancleTui(id){
    	if(id == undefined){
    		alert("错误！");
    		return;
    	}else{
    		
             $.post('/recommendGoods/cancleRecomm', {
            	 goodsId : id,
            	 positionId:positionId,
             }, function(result) {
                 if (result.success) {
//                     parent.$.messager.alert('提示', result.msg, 'info');
                     tuiList.datagrid('reload');
                 }else{
                	 parent.$.messager.alert('提示', result.msg, 'info');
                 }
                 progressClose();
             }, 'JSON');
         }
    	
    }
    
       
    
   