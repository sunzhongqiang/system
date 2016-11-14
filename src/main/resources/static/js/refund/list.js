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
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
                    {
                width : '80',
                title : 'ID',
                field : 'id',
            },
                    {
                width : '80',
                title : '订单主键',
                field : 'tid',
            },
                    {
                width : '80',
                title : '订单编号',
                field : 'orderSn',
            },
                    {
                width : '80',
                title : '退款时的订单状态',
                field : 'orderStatus',
            },
                    {
                width : '80',
                title : '订单总金额',
                field : 'totalFee',
            },
                    {
                width : '80',
                title : '商品编号',
                field : 'goodsId',
            },
                    {
                width : '80',
                title : '商品价格',
                field : 'goodsPrice',
            },
                    {
                width : '80',
                title : '商品数量',
                field : 'goodsNum',
            },
                    {
                width : '80',
                title : '货物状态',
                field : 'goodsStatus',
            },
                    {
                width : '80',
                title : '用户id',
                field : 'userId',
            },
                    {
                width : '80',
                title : '用户名',
                field : 'username',
            },
                    {
                width : '80',
                title : '退款编号',
                field : 'refundNo',
            },
                    {
                width : '80',
                title : '退款账户信息',
                field : 'refundMsg',
            },
                    {
                width : '80',
                title : '申请时间',
                field : 'refundCreateTime',
            },
                    {
                width : '80',
                title : '退款完成时间',
                field : 'refundCompleteTime',
            },
                    {
                width : '80',
                title : '退款状态',
                field : 'refundStatus',
            },
                    {
                width : '80',
                title : '退款退货类型0-退款1-退货',
                field : 'hasGoodsReturn',
            },
                    {
                width : '80',
                title : '退款金额',
                field : 'applyRefundFee',
            },
                    {
                width : '80',
                title : '剩余金额',
                field : 'payment',
            },
                    {
                width : '80',
                title : '退款原因',
                field : 'reason',
            },
                    {
                width : '80',
                title : '退款说明',
                field : 'description',
            },
                    {
                width : '80',
                title : '退货地址',
                field : 'refundAddress',
            },
                    {
                width : '80',
                title : '实际退款金额',
                field : 'realRefundFee',
            },
                    {
                width : '80',
                title : '拒绝原因',
                field : 'refuseReason',
            },
                    {
                width : '80',
                title : '拒绝备注',
                field : 'refuseDesc',
            },
                    {
                width : '80',
                title : '凭证1',
                field : 'photo1',
            },
                    {
                width : '80',
                title : '凭证2',
                field : 'photo2',
            },
                    {
                width : '80',
                title : '凭证3',
                field : 'photo3',
            },
                    {
                width : '80',
                title : '凭证4',
                field : 'photo4',
            },
                    {
                width : '80',
                title : '凭证5',
                field : 'photo5',
            },
                    {
                width : '80',
                title : '物流单号',
                field : 'sid',
            },
                    {
                width : '80',
                title : '物流公司名称',
                field : 'companyName',
            },
            {
                field : 'action',
                title : '操作',
                width : 140,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
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
                $('.btn_edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.btn_delete').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $(this).datagrid('fixRowHeight');
            }
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
    