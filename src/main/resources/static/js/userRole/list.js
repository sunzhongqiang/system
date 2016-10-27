//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
	var userId;
    var userGrid;
    $(function() {
    	userGrid = $('#userGrid').datagrid({
            url : '/user/loadByOrgId',
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
                title : '用户主键',
                field : 'userId',
            },
                    {
                width : '80',
                title : '用户名称',
                field : 'name',
            }] ],
            onSelect: function(index,row) {
            	userId=row.id;
            	roleList.datalist('load',{userId:row.id});
            	
//            	roleList = $('#roleList').datalist({
//                    url : '/role/',
//            	});
            	
        	}
          
        });
    });
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/userRole/add',
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
        parent.$.messager.confirm('询问', '您是否要删除系统用户角色？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/userRole/delete', {
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
            href : '/userRole/edit?id=' + id,
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
    
    
    
    
    
    
    
    //组织
    
    var organizationTree;
    $(function() {
    
    	organizationTree = $('#organizationTree').tree({
            url : '/organization/tree',
            fit : true,
            fitColumns: true,
            striped : true,
            rownumbers : false,
            pagination : false,
            singleSelect : true,
            idField : 'id',
            treeField : 'name',
            animate: true,  
            cascadeCheck:true,//层叠选中  
            lines:true,//显示虚线效果  
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
                          {
                width : '200',
                title : '资源名称',
                field : 'name',
            }] ],
            onSelect: function(row) {
            	userGrid.datagrid('load',{orgId:row.id});
            }
        });
    });
    
    
  //角色列表
    var roleList;
    var organizationTree;
    $(function() {
    	roleList = $('#roleList').datalist({
            url : '/userRole/roleList',
            fit : true,
            striped : true,
            pagination : false,
            checkbox: true,
            singleSelect : false,
            idField : 'roleID',
            valueField : 'roleID',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [
                         
                    {
                width : '180',
                title : '角色名称',
                field : 'roleName',
                formatter:function(value,row,index){
                	if(row.userId){
                		roleList.datalist('checkRow',index);
                	}else{
                		roleList.datalist('uncheckRow',index);
                	}
                	return value;
                }
                   
            }] ],
            onCheck: function(row,checked) {
            	if(!roleId){
            		alert("请指定角色！");
            		return false;
            	}
            	 $.ajax({
                     url: '',
                    data:{userId:userId,roleID:row.id,checked:checked},
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
    });
    
    
    
    
    
    
    
    
    