//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            fit : false,
            fitColumns : true,
            striped : true,
            rownumbers : true,
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
                    str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" class="btn_edit" >编辑</a>', index);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" class="btn_delete" >删除</a>', index);
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
    
    var store = {
    		data:{"total":0,"rows":[]},
    		remove:function(index){
    			 this.data.rows.splice(index,1);
    	    	 dataGrid.datagrid("loadData",this.data);
    		},
    		add:function(item){
    			this.data.rows.push(item);
    			this.data.total = this.data.rows.length;
    			dataGrid.datagrid("loadData",this.data);
    		},
    		update:function(index,item){
    			this.data.rows.splice(index,1,item);
    			this.data.total = this.data.rows.length;
    			dataGrid.datagrid("loadData",this.data);
    		},
    		get:function(index){
    			return this.data.rows.slice(index)[0];
    		}
    };
    
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
                	store.add(object);
                	parent.$.modalDialog.handler.dialog('close');
                }
            } ]
        });
    }
    
    function deleteFun(id) {
    	var item = store.get(id);
    	console.log(item);
    	if(item.id){
    		$.get("/goodsSku/delete?id="+item.id,function(data){
    			store.remove(id);
    		});
    	}else{
    		store.remove(id);
    	}
    }
    
    function editFun(id) {
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
                text : '编辑',
                handler : function() {
                	var f = parent.$.modalDialog.handler.find('#skuForm');
                  	var object = getFormJson(f);
                  	store.update(id,object);
                  	parent.$.modalDialog.handler.dialog('close');
                }
            } ],
            onLoad:function(){
            	var item = store.get(id);
                var f = parent.$.modalDialog.handler.find('#skuForm');
                f.form("load",item);
            }
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
    