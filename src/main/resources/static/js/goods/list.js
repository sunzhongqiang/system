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
                sortable:true
            },
          {
                width : '80',
                title : '商品主图',
                field : 'goodsMainImg',
                formatter:function(value,row,index)
                {return '<img src='+value+'>';}
            },
                    {
                width : '600',
                title : '商品名称',
                field : 'goodsName',
                sortable:true
            },
                    {
                width : '80',
                title : '商品数量',
                field : 'goodsNumber',
                align: 'center',
                sortable:true
            },
                    {
                width : '80',
                title : '商品原价',
                field : 'goodsOriginalPrice',
                align: 'center',
                sortable:true
            },
                    {
                width : '80',
                title : '团购价',
                field : 'promotePrice',
                align: 'center',
                sortable:true
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
                field : 'isOnsale',
                align: 'center',
                sortable:true,
                formatter : function(value, row, index) {
					if (value) {
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
                    if(row.isOnsale){
                    	str += $.formatString('<a href="javascript:void(0)" onclick="sale(\'{0}\');" class="btn_onsale" >下架</a>', row.id);
                        str += '&nbsp;|&nbsp;';
                    }else{
                    	str += $.formatString('<a href="javascript:void(0)" onclick="sale(\'{0}\');" class="btn_inventory" >上架</a>', row.id);
                        str += '&nbsp;|&nbsp;';
                    }
                    str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" class="btn_edit" >编辑</a>', row.id);
//                    str += '&nbsp;|&nbsp;';
//                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" class="btn_delete" >删除</a>', row.id);
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
            	$('.btn_onsale').linkbutton({text:'下架',plain:true,iconCls:'icon-unlock'});
            	$('.btn_inventory').linkbutton({text:'上架',plain:true,iconCls:'icon-lock'});
                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
//                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    function addFun() {
    	 parent.addTab({
			url : '/goods/add',
			title : '商品发布',
		},true);
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
			title : '商品发布',
		},true);
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
    
    
    
    
    
    // 商品上下架
    function sale(id) {
    	  if (id == undefined) {//点击右键菜单才会触发这个
              var rows = dataGrid.datagrid('getSelections');
              id = rows[0].id;
          } else {//点击操作里面的删除图标会触发这个
              dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
          }
    	  parent.$.messager.confirm('询问', '确认改动商品上下架？', function(b) {
              if (b) {
                  progressLoad();
                      $.post('/goods/toggleOnSale', {
                          id : id
                      }, function(result) {
                          if (result.success) {
                              dataGrid.datagrid('reload');
                          }
                          progressClose();
                      }, 'JSON');
                  }
          });
    }
    