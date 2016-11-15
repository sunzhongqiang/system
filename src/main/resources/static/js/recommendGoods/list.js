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
           toolbar :  [{
	            iconCls: 'icon-add',
	            text:'新增',
	            handler: function(){
	            	
	            	addFun();
	            	}
            }],
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
            	 goodId : id,
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
                width : '50',
                title : '位置编码',
                field : 'code',
            },
                    {
                width : '120',
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
	            text:'新增',
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
            },
                    {
                width : '80',
                title : '商品名称',
                field : 'goodsName',
            },
                    {
                width : '80',
                title : '该商原价',
                field : 'goodsOriginalPrice',
            },
            {
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="cancleTui(\'{0}\');" class="btn_edit" >取消推荐</a>', row.id);
//                    str += '&nbsp;|&nbsp;';
//                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" class="btn_delete" >删除</a>', row.id);
                    return str;
                }
            }] ],
//           toolbar :  [{
//	            iconCls: 'icon-add',
//	            text:'新增',
//	            handler: function(){addFun();}
//            }],
            onLoadSuccess : function(data){
                $('.btn_edit').linkbutton({text:'取消推荐',plain:true,iconCls:'icon-edit'});
//                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
//取消推荐
    
    function cancleTui(id){
    	if(id == undefined){
    		alert("错误！");
    		return;
    	}else{
    		
             $.post('/recommendGoods/cancleRecomm', {
            	 id : id,
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
    
       
    
   