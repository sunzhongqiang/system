//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    var shippingFee;
    var shippingId;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/shipping/gridData',
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
                width : '120',
                title : '配送方式名称',
                field : 'shippingName',
            },
                    {
                width : '100',
                title : '是否可用',
                field : 'enabled',
                formatter : function(value, row, index) {
					switch (value) {
					case 1:
						return '可用';
					case 2:
						return '禁用';
					}
				}
            },
//                    {
//                width : '150',
//                title : '最后更新时间',
//                field : 'lastUpdateTime',
//                formatter: formatDatebox,
//            },
            {
                field : 'action',
                title : '操作',
                width : 200,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    if(row.enabled == "1"){
                    	str += $.formatString('<a href="javascript:void(0)" onclick="disable(\'{0}\');" class="btn_lock" >禁用</a>', row.id);
                	}else{
                		str += $.formatString('<a href="javascript:void(0)" onclick="disable(\'{0}\');" class="btn_unlock" >启用</a>', row.id);
                	}
//                    str += $.formatString('<a href="javascript:void(0)" onclick="setting(\'{0}\');" class="btn_setting" >设置运费/a>', row.id);
                    str += '&nbsp;|&nbsp;';
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
            	$('.btn_lock').linkbutton({text:'禁用',plain:true,iconCls:'icon-lock'});
            	$('.btn_unlock').linkbutton({text:'启用',plain:true,iconCls:'icon-unlock'});
            	$('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_setting').linkbutton({text:'设置运费',plain:true,iconCls:'icon-setting'});
                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            },
            //点击快递设置快递费用
        onSelect: function(index,row) {
        	console.log(row);
        	shippingFee.datagrid('load',{"shippingId":row.id});
    	}
        });
    });
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 700,
            height : 300,
            href : '/shipping/add',
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
        parent.$.messager.confirm('询问', '您是否要删除物流管理？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/shipping/delete', {
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
            width : 700,
            height : 300,
            href : '/shipping/edit?id=' + id,
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
    
    
    
    
    
    
    
    
    
    // 禁用
    function disable(id) {
    	  if (id == undefined) {//点击右键菜单才会触发这个
              var rows = dataGrid.datagrid('getSelections');
              id = rows[0].id;
          } else {//点击操作里面的删除图标会触发这个
              dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
          }
    	  parent.$.messager.confirm('询问', '您是否要禁用此角色？', function(b) {
              if (b) {
                  progressLoad();
                      $.post('/shipping/enable', {
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
    
 // 启用
    function enable(id) {
    	  if (id == undefined) {//点击右键菜单才会触发这个
              var rows = dataGrid.datagrid('getSelections');
              id = rows[0].id;
          } else {//点击操作里面的删除图标会触发这个
              dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
          }
    	  parent.$.messager.confirm('询问', '您是否要启用此角色？', function(b) {
              if (b) {
                  progressLoad();
                      $.post('/shipping/enable', {
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
    
    
    
    
    
    
    
    
    //运费设置
    
    
    $(function() {
    	shippingFee = $('#shippingFee').datagrid({
            url : '/shippingFee/gridData',
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
                title : '主键',
                field : 'id',
            },
                    {
                width : '80',
                title : '配送方式',
                field : 'shippingId',
            },
                    {
                width : '80',
                title : '地区主键',
                field : 'regionId',
            },
                    {
                width : '80',
                title : '首重',
                field : 'initStart',
            },
                    {
                width : '80',
                title : '首费',
                field : 'initFee',
            },
                    {
                width : '80',
                title : '续重',
                field : 'addStart',
            },
                    {
                width : '80',
                title : '续费',
                field : 'addFee',
            },
            {
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="editFee(\'{0}\');" class="btn_edit" >编辑</a>', row.id);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFee(\'{0}\');" class="btn_delete" >删除</a>', row.id);
                    return str;
                }
            }] ],
           toolbar :  [{
	            iconCls: 'icon-add',
	            text:'新增',
	            handler: function(){addFee();}
            }],
            onLoadSuccess : function(data){
                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
        });
    });
    
    //添加运费
    
    function addFee() {
        parent.$.modalDialog({
            title : '添加',
            width : 600,
            height : 450,
            href : '/shippingFee/add',
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = shippingFee;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } ]
        });
    }
    
    //删除运费
    
    function deleteFee(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = shippingFee.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
        	shippingFee.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除快递地区运费？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/shippingFee/delete', {
                        id : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            shippingFee.datagrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
        });
    }
    
    //修改运费
    function editFee(id) {
        if (id == undefined) {
            var rows = shippingFee.datagrid('getSelections');
            id = rows[0].id;
        } else {
        	shippingFee.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 600,
            height : 450,
            href : '/shippingFee/edit?id=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = shippingFee;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } 
            ]
        });
    }
    
    
    
    
    
    
    
    
    
    
    