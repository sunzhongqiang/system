//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/order/gridData',
            fit : true,
            fitColumns : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            view : cardview,
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
//            columns : [ [ 
//                    {
//                width : '80',
//                title : '团订单ID',
//                field : 'id',
//            },
//                    {
//                width : '80',
//                title : '团ID',
//                field : 'tuanId',
//            },
//                    {
//                width : '80',
//                title : '用户ID',
//                field : 'userId',
//            },
//                    {
//                width : '80',
//                title : '商品ID',
//                field : 'goodsId',
//            },
//                    {
//                width : '80',
//                title : '用户名',
//                field : 'userName',
//            },
//                    {
//                width : '80',
//                title : '订单编号',
//                field : 'orderCode',
//            },
//                    {
//                width : '120',
//                title : '下单时间',
//                field : 'orderTime',
//                formatter: formatDatebox,
//            },
//                    {
//                width : '80',
//                title : '支付时间',
//                field : 'payTime',
//                formatter: formatDatebox,
//            },
//                    {
//                width : '80',
//                title : '订单分类',
//                field : 'orderSort',
//                formatter : function(value, row, index) {
//					switch (value) {
//					case 0:
//						return '一元购';
//					case 1:
//						return '拼团';
//						
//					}
//				}
//            },
//                    {
//                width : '80',
//                title : '商品图片',
//                field : 'goodImg',
//            },
//                    {
//                width : '80',
//                title : '商品描述',
//                field : 'goodDes',
//            },
//                    {
//                width : '80',
//                title : '商品编码',
//                field : 'goodCode',
//            },
//                    {
//                width : '80',
//                title : '商品价格',
//                field : 'goodPrice',
//            },
//                    {
//                width : '80',
//                title : '订单价格',
//                field : 'orderPrice',
//            },
//                    {
//                width : '80',
//                title : '订单状态',
//                field : 'orderStatus',
//                formatter : function(value, row, index) {
//					switch (value) {
//					case 1:
//						return '待付款';
//					case 2:
//						return '拼团中';
//					case 3:
//						return '代发货';
//					case 4:
//						return '待收货';
//					case 5:
//						return '已成功';
//					case 6:
//						return '已关闭';
//						
//					}
//				}
//            },
//                    {
//                width : '80',
//                title : '收获地址',
//                field : 'address',
//            },
//            {
//                field : 'action',
//                title : '操作',
//                width : 140,
//                align : 'center',
//                formatter : function(value, row, index) {
//                    var str = '';
//                    if(row.orderStatus == 1){
//                    	str += $.formatString('<a href="javascript:void(0)" onclick="disable(\'{0}\');" class="btn_lock" >发货</a>', row.id);
//                	}
//                    if(row.orderStatus == 2){
//                		str += $.formatString('<a href="javascript:void(0)" onclick="enable(\'{0}\');" class="btn_unlock" >2222</a>', row.id);
//                	}
//                    if(row.orderStatus == 3){
//                		str += $.formatString('<a href="javascript:void(0)" onclick="enable(\'{0}\');" class="btn_unlock" >3333</a>', row.id);
//                	}
//                    if(row.orderStatus == 4){
//                		str += $.formatString('<a href="javascript:void(0)" onclick="enable(\'{0}\');" class="btn_unlock" >4444</a>', row.id);
//                	}
//                    if(row.orderStatus == 5){
//                		str += $.formatString('<a href="javascript:void(0)" onclick="enable(\'{0}\');" class="btn_unlock" >5555</a>', row.id);
//                	}
//                    
//                    str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" class="btn_edit" >编辑</a>', row.id);
//                    str += '&nbsp;|&nbsp;';
//                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" class="btn_delete" >删除</a>', row.id);
//                    return str;
//                }
//            }
//        ] ],
//           toolbar :  [{
//	            iconCls: 'icon-add',
//	            text:'新增',
//	            handler: function(){addFun();}
//            }],
//            onLoadSuccess : function(data){
//                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
//                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
//                $(this).datagrid('fixRowHeight');
//            }
        });
    });
    
  
    function formatType(type){
    	switch(type){
		    case   0:
		    	return '一元购';
	    	case   1:
	    		return '拼团';
	    	case   2:
	    		return '抽奖';
    	}
    }
    
    
    var cardview = $.extend({}, $.fn.datagrid.defaults.view, {
        renderRow: function (target, fields, frozen, rowIndex, rowData) {
        	
            var cc = [];
            cc.push('<td colspan=' + fields.length + ' style="padding:10px 5px;border:0;">');
            if (!frozen) {
                cc.push('<div class="order_detail">');
                cc.push('<ul class="order-sn">');	
                cc.push('<li class="us_name"><span>用户名：</span><p>'+rowData.userName+'</p></li>');
                cc.push('<li><span>订单编号：</span><p>'+rowData.orderCode+'</p></li>')
                cc.push('<li><span>下单时间：</span><p>'+dateFormat(rowData.orderTime,'yyyy-MM-dd hh:mm:ss')+'</p></li>');
                cc.push('<li><span>支付时间：</span><p>'+dateFormat(rowData.payTime,'yyyy-MM-dd hh:mm:ss')+'</p></li>');
                cc.push('</ul>');
                cc.push('<table width="100%" cellspacing="0" cellpadding="5" border="0" bgcolor=""><tbody>');
                cc.push('<tr class="orders">');
                cc.push('<td rowspan="1" colspan="1" width="25%"><div class="goods-form">');
                cc.push('<span class="is_02 is_00">'+formatType(rowData.orderSort)+'</span>');
                cc.push('<a><img name="goodsImg" src="'+rowData.goodsImg+'"></a>');
                cc.push('<div class="goods-all"><p class="goods-name">'+rowData.goodsName+'</p></div>');
                cc.push('</div></td>');
                
                cc.push('<td class="order-one"  width="10%">商品原价：<span class="red bold">'+rowData.goodsPrice+'元</span></td>');
                cc.push(' <td class="order-one" rowspan="1" colspan="1" width="8%">订单金额：<span class="red bold">'+rowData.orderPrice+'元</span>');
                cc.push('<p><a class="blue" onclick="orderDetail(\''+rowData.id+'\')">查看详情&gt;&gt;</a> </p></td>');
                cc.push('<td rowspan="1" colspan="1" width="13%">');
                if(rowData.orderStatus == 'WAIT_PAY'){
                	cc.push('<p class="red bold">待付款</p>');
                }
                if(rowData.orderStatus == 'WAIT_JOIN'){
                	cc.push('<p class="red bold">待成团</p>');
                }
                if(rowData.orderStatus == 'WAIT_SHIPPING'){
                	cc.push('<p class="red bold">待发货</p><a  class="btn_send1" onclick="addFun(\''+rowData.id+'\')">发货</a>');
            	}
                if(rowData.orderStatus == 'WAIT_CHOOSE'){
                	cc.push('<p class="red bold">待抽奖</p>');
                }
                if(rowData.orderStatus == 'WAIT_RECEIVE'){
                	cc.push('<p class="green bold">已发货</p>');
            	}
                if(rowData.orderStatus == 'WAIT_COMMENT'){
                	cc.push('<p class="red bold">等待买家评价</p>');
                }
                if(rowData.orderStatus == 'SUCCESSED'){
                	cc.push('<a class="green" >已成功</a>');
            	}
                if(rowData.orderStatus == 'WAIT_REFUND_GOODS'){
                	cc.push('<a class="green" >等待买家退货</a>');
            	}
                if(rowData.orderStatus == 'WAIT_REFUND_MONEY'){
                	cc.push('<a class="green" >等待卖家退款</a>');
            	}
                if(rowData.orderStatus == 'CLOSED'){
                	cc.push('<a class="green" >交易已关闭</a>');
            	}

                cc.push('</td>');
                cc.push('</div></td></tr>');
                
                cc.push('<tr class="orders_info"><td colspan="8" rowspan="1">');
                cc.push('<span class="order_address">收货地址：'+rowData.address+'</span></td></tr>');

                        
                    
                
                
                cc.push('</tbody></table>');
                
                cc.push('</div>');
                
                
            }
            cc.push('</td>');
            return cc.join('');
        }
    });
    
    
    
    
    function addFun(id) {
        parent.$.modalDialog({
            title : '商品发货',
            width : 400,
            height : 250,
            href : '/order/shippingpage?id='+id,
            buttons : [ {
                text : '确认发货',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } ]
        });
    }
    
//    function deleteFun(id) {
//        if (id == undefined) {//点击右键菜单才会触发这个
//            var rows = dataGrid.datagrid('getSelections');
//            id = rows[0].id;
//        } else {//点击操作里面的删除图标会触发这个
//            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
//        }
//        parent.$.messager.confirm('询问', '您是否要删除订单管理？', function(b) {
//            if (b) {
//                progressLoad();
//                    $.post('/order/delete', {
//                        id : id
//                    }, function(result) {
//                        if (result.success) {
//                            parent.$.messager.alert('提示', result.msg, 'info');
//                            dataGrid.datagrid('reload');
//                        }
//                        progressClose();
//                    }, 'JSON');
//                }
//        });
//    }
    
//    function editFun(id) {
//        if (id == undefined) {
//            var rows = dataGrid.datagrid('getSelections');
//            id = rows[0].id;
//        } else {
//            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
//        }
//        parent.$.modalDialog({
//            title : '编辑',
//            width : 500,
//            height : 300,
//            href : '/order/edit?id=' + id,
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
//    }
//    
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
    
    
    
    
    
  //查看商品详情  
    function orderDetail(id) {
        if (id == undefined) {
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        
        parent.addTab({
			url : '/order/orderDetail?id=' + id,
			title : '订单详情',
		},true);
    }