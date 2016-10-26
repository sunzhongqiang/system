//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    var roleId;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/role/gridData',
            fit : true,
            fitColumns: true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            selectOnCheck: true,
            cascadeCheck:true,//层叠选中  
            lines:true,//显示虚线效果 
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [
					{
					    width : '30',
					    title : '',
					    field : 'ck',
					    checkbox: true
					},
                         {
                     width : '180',
                     title : '角色主键',
                     field : 'id',
                 },
                         {
                     width : '180',
                     title : '角色编码',
                     field : 'code',
                 },
                         {
                     width : '180',
                     title : '角色名称',
                     field : 'name',
                 }] ],
                 
                 onSelect: function(index,row) {
                	 roleId = row.id;
                	 treegrid = $('#function1').tree({
                		
                 		url : '/privilege/authorizeTree?roleId='+roleId,
                 		cascadeCheck:false,
                 		 onCheck: function(row,checked) {
                 			var parent = treegrid.tree("getParent",row.target);
                 			if(checked){
	                 			if(parent){
	                 				if(!parent.checked){
	                 					treegrid.tree("check",parent.target);
	                 				}
	                 			}
                 			}else{
                 				if(row.children){
                 					
                 					for(var i=0; i< row.children.length; i++){
                 						var nodechild =  row.children[i];
                 						if(nodechild.checked){
                 							treegrid.tree("uncheck",row.children[i].target);
                 						}
                 						
                 					}
                 				}
                 				
                 			}
                         	if(!roleId){
                         		alert("请指定角色！");
                         		return false;
                         	}
                         	 $.ajax({
                                  url: '/privilege/authorize',
                                 data:{roleId:roleId,functionId:row.id,checked:checked},
                                  success: function(result){
                                      progressClose();
                                  },
                                  error: function(){
                                      progressClose();
                                      alert("系统错误");
                                  }
                              });
                         	
                         }
                	 });
              },

        });
    });
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/privilege/add',
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
        parent.$.messager.confirm('询问', '您是否要删除系统权限表？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/privilege/delete', {
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
            href : '/privilege/edit?id=' + id,
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
    
    
    
    
    
    
    
    
    
  //获取权限列表  
    
//    var treegrid;
//    $(function() {
//        treegrid = $('#function1').treegrid({
//            url : '/function/tree',
//            fit : true,
//            fitColumns: true,
//            striped : true,
//            rownumbers : false,
//            pagination : false,
//            singleSelect : true,
//            selectOnCheck: true,
//            idField : 'id',
//            treeField : 'name',
//            animate: true,  
//            checkbox: true,  
//            cascadeCheck:true,//层叠选中  
//            lines:true,//显示虚线效果  
//            pageSize : 50,
//            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
//            columns : [ [ 
//                          {
//                width : '200',
//                title : '资源名称',
//                field : 'name',
//            },{
//                width : '180',
//                title : '功能主键',
//                field : 'id',
//            },
//                    {
//                width : '180',
//                title : '标识符',
//                field : 'uri',
//            },
//              
//                    {
//                width : '180',
//                title : '资源类型',
//                field : 'type',
//            },
//                    {
//                width : '180',
//                title : '父类',
//                field : 'parentId',
//            }] ],
//            onCheckNode: function(row,checked) {
//            	if(!roleId){
//            		alert("请指定角色！");
//            		return false;
//            	}
//            	alert();
//            	 $.ajax({
//                     url: '/privilege/authorize',
//                    data:{roleId:roleId,functionId:row.id},
//                     success: function(result){
//                         progressClose();
//                     },
//                     error: function(){
//                         progressClose();
//                         alert("系统错误");
//                     }
//                 });
//            	
//            }
//        });
//    });
    
    var treegrid;
    $(function() {
    	initPrivilege()
    });
    
    
    function initPrivilege(roleId){
    	treegrid = $('#function1').tree({
            url : '/privilege/authorizeTree',
            fit : true,
            fitColumns: true,
            striped : true,
            rownumbers : false,
            pagination : false,
            singleSelect : true,
            selectOnCheck: true,
            idField : 'id',
            treeField : 'name',
            animate: true,  
            checkbox: true,  
            cascadeCheck:true,//层叠选中  
            lines:true,//显示虚线效果  
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
                          {
                width : '200',
                title : '资源名称',
                field : 'name',
            },{
                width : '180',
                title : '功能主键',
                field : 'id',
            },
                    {
                width : '180',
                title : '标识符',
                field : 'uri',
            },
              
                    {
                width : '180',
                title : '资源类型',
                field : 'type',
            },
                    {
                width : '180',
                title : '父类',
                field : 'parentId',
            }] ],
            onCheck: function(row,checked) {
            	if(!roleId){
            		alert("请指定角色！");
            		return false;
            	}
            	 $.ajax({
                     url: '/privilege/authorize',
                    data:{roleId:roleId,functionId:row.id},
                     success: function(result){
                         progressClose();
                     },
                     error: function(){
                         progressClose();
                         alert("系统错误");
                     }
                 });
            	
            }
        });
    }
    
    
