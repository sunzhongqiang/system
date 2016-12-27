//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/refund/gridData',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            view : cardview,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
//            columns : [ [ 
//                    {
//                width : '80',
//                title : 'ID',
//                field : 'id',
//            },
//                    {
//                width : '80',
//                title : '订单主键',
//                field : 'tid',
//            },
//                    {
//                width : '80',
//                title : '订单编号',
//                field : 'orderSn',
//            },
//                    {
//                width : '80',
//                title : '退款时的订单状态',
//                field : 'orderStatus',
//            },
//                    {
//                width : '80',
//                title : '订单总金额',
//                field : 'totalFee',
//            },
//                    {
//                width : '80',
//                title : '商品编号',
//                field : 'goodsId',
//            },
//                    {
//                width : '80',
//                title : '商品价格',
//                field : 'goodsPrice',
//            },
//                    {
//                width : '80',
//                title : '商品数量',
//                field : 'goodsNum',
//            },
//                    {
//                width : '80',
//                title : '货物状态',
//                field : 'goodsStatus',
//            },
//                    {
//                width : '80',
//                title : '用户id',
//                field : 'userId',
//            },
//                    {
//                width : '80',
//                title : '用户名',
//                field : 'username',
//            },
//                    {
//                width : '80',
//                title : '退款编号',
//                field : 'refundNo',
//            },
//                    {
//                width : '80',
//                title : '退款账户信息',
//                field : 'refundMsg',
//            },
//                    {
//                width : '80',
//                title : '申请时间',
//                field : 'refundCreateTime',
//            },
//                    {
//                width : '80',
//                title : '退款完成时间',
//                field : 'refundCompleteTime',
//            },
//                    {
//                width : '80',
//                title : '退款状态',
//                field : 'refundStatus',
//            },
//                    {
//                width : '80',
//                title : '退款退货类型0-退款1-退货',
//                field : 'hasGoodsReturn',
//            },
//                    {
//                width : '80',
//                title : '退款金额',
//                field : 'applyRefundFee',
//            },
//                    {
//                width : '80',
//                title : '剩余金额',
//                field : 'payment',
//            },
//                    {
//                width : '80',
//                title : '退款原因',
//                field : 'reason',
//            },
//                    {
//                width : '80',
//                title : '退款说明',
//                field : 'description',
//            },
//                    {
//                width : '80',
//                title : '退货地址',
//                field : 'refundAddress',
//            },
//                    {
//                width : '80',
//                title : '实际退款金额',
//                field : 'realRefundFee',
//            },
//                    {
//                width : '80',
//                title : '拒绝原因',
//                field : 'refuseReason',
//            },
//                    {
//                width : '80',
//                title : '拒绝备注',
//                field : 'refuseDesc',
//            },
//                    {
//                width : '80',
//                title : '凭证1',
//                field : 'photo1',
//            },
//                    {
//                width : '80',
//                title : '凭证2',
//                field : 'photo2',
//            },
//                    {
//                width : '80',
//                title : '凭证3',
//                field : 'photo3',
//            },
//                    {
//                width : '80',
//                title : '凭证4',
//                field : 'photo4',
//            },
//                    {
//                width : '80',
//                title : '凭证5',
//                field : 'photo5',
//            },
//                    {
//                width : '80',
//                title : '物流单号',
//                field : 'sid',
//            },
//                    {
//                width : '80',
//                title : '物流公司名称',
//                field : 'companyName',
//            },
//            {
//                field : 'action',
//                title : '操作',
//                width : 140,
//                align : 'center',
//                formatter : function(value, row, index) {
//                    var str = '';
//                    str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" class="btn_edit" >编辑</a>', row.id);
//                    str += '&nbsp;|&nbsp;';
//                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" class="btn_delete" >删除</a>', row.id);
//                    return str;
//                }
//            }] ],
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
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/refund/add',
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
        parent.$.messager.confirm('询问', '您是否要删除退款表？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/refund/delete', {
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
            href : '/refund/edit?id=' + id,
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
    
    
    
    
    
    
    
    
    
    
        function formatType(type){
    	switch(type){
		    case '0':
		    	return '仅退款';
	    	case '1':
	    		return '退款退货';
    	}
    }
    
    
    //
    
    var cardview = $.extend({}, $.fn.datagrid.defaults.view, {
        renderRow: function (target, fields, frozen, rowIndex, rowData) {
            var cc = [];
            cc.push('<td colspan=' + fields.length + ' style="padding:10px 5px;border:0;">');
            if (!frozen) {
            	console.log(rowData);
                cc.push('<div class="order_detail">');
                cc.push('<ul class="order-sn">');	
                cc.push('<li class="us_name"><span>用户名：</span><p>'+rowData.userName+'</p></li>');
                cc.push('<li><span>退款编号：</span><p>'+rowData.refundNo+'</p></li>')
                cc.push('<li><span>申请退货时间：</span><p>'+dateFormat(rowData.refundCreateTime,'yyyy-MM-dd hh:mm:ss')+'</p></li>');
                cc.push('<li><span>订单编号：</span><p>'+rowData.orderSn+'</p></li>');
                cc.push('<li><span>联系方式：</span><p>'+rowData.mobile+'</p></li>');
                cc.push('</ul>');
                cc.push('<table width="100%" cellspacing="0" cellpadding="5" border="0" bgcolor=""><tbody>');
                cc.push('<tr class="orders">');
                cc.push('<td rowspan="1" colspan="1" width="25%"><div class="goods-form">');
                cc.push('<a><img name="goodImg" src="'+rowData.goodsImg+'"></a>');
                cc.push('<div class="goods-all"><p class="goods-name">'+rowData.goodsName+'</p></div>');
                cc.push('</div></td>');
                
                cc.push('<td class="order-one"  width="10%">商品原价：<span class="red bold">'+rowData.goodsPrice+'元</span></td>');
                cc.push(' <td class="order-one" rowspan="1" colspan="1" width="8%">订单金额：<span class="red bold">'+rowData.realRefundFee+'元</span>');
                cc.push('<p><a class="blue" onclick="refundDetail(\''+rowData.id+'\')">查看详情&gt;&gt;</a> </p></td>');
                cc.push('<td class="order-one"  width="10%"><span class="blue bold">'+formatType(rowData.hasGoodsReturn)+'</span></td>');
                cc.push(' <td rowspan="1" colspan="1" width="13%">');
                if(rowData.refundStatus == 'WAIT_SELLER_AGREE'){
                	cc.push('<p class="red bold">是否同意退款</p><p class="order_close blue bold">');
                	cc.push('<a class="btn_send1" shape="rect" onclick="refundAgree(\''+rowData.id+'\')">同意</a>');
                	cc.push('<a class="btn_send1" shape="rect" onclick="refundReason(\''+rowData.id+'\')">拒绝</a></p>');
                }
                if(rowData.refundStatus == "WAIT_REFUND_GOODS"){
                	cc.push('<p class="red bold">等待买家退货</p><p class="order_close blue bold"><a class="btn_send1" onclick="confirmGoods(\''+rowData.id+'\')">直接确认收货</a><a class="btn_send1" shape="rect" onclick="refundReason(\''+rowData.id+'\')">拒绝</a></p>');
            	}
                if(rowData.refundStatus == "WAIT_REFUND_MONEY"){
                	cc.push('<a class="btn_send1" onclick="refundMoney(\''+rowData.id+'\')">手动退款</a>');
            	}
                if(rowData.refundStatus == "SUCCESSED"){
                	cc.push('<a class="green" >已成功</a>');
            	}
                if(rowData.refundStatus == "CLOSED"){
                	cc.push('<a class="green" >已成功</a>');
            	}
                cc.push('</td>');
                cc.push('</div></td></tr>');
                cc.push('<tr class="orders_info"><td colspan="8" rowspan="1">');
                cc.push('<span class="order_address">收货地址：'+rowData.provinceName+rowData.cityName+rowData.districtName+rowData.address+'</span></td></tr>');
                cc.push('</tbody></table>');
                
                cc.push('</div>');
                
                
            }
            cc.push('</td>');
            return cc.join('');
        }
    });
    
    
    
  //查看退款详情  
    function refundDetail(id) {
        if (id == undefined) {
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.addTab({
			url : '/refund/refundDetail?id='+id,
			title : '退款退货详情'
		});
    }
    
    
    
    //拒绝退款理由
    function refundReason(id) {
        parent.$.modalDialog({
            title : '拒绝原因',
            width : 400,
            height : 250,
            href : '/refund/refundReason?id='+id,
            buttons : [ {
                text : '拒绝',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } ]
        });
    }
    
    
    //同意退款、退款退货
    function refundAgree(id){
    	if(confirm("确认退款吗？")){
    	$.post('/refund/refundAgree', {
            id : id
        }, function(result) {
            if (result.success) {
                parent.$.messager.alert('提示', result.msg, 'info');
                dataGrid.datagrid('reload');
            }
            progressClose();
        }, 'JSON');
    	}
    }
    
    
  //手动确认退款
    function refundMoney(id){
    	if(confirm("确认退款吗？")){
    	$.post('/refund/refundMoney', {
            id : id
        }, function(result) {
            if (result.success) {
                parent.$.messager.alert('提示', result.msg, 'info');
                dataGrid.datagrid('reload');
            }
            progressClose();
        }, 'JSON');
    	}
    }
    
    
    //确认收货并退款
    function confirmGoods(id){
    	if(confirm("确认收货，并退款？？")){
    	$.post('/refund/confirmGoods', {
            id : id
        }, function(result) {
            if (result.success) {
                parent.$.messager.alert('提示', result.msg, 'info');
                dataGrid.datagrid('reload');
            }
            progressClose();
        }, 'JSON');
    	}
    }    
  
    