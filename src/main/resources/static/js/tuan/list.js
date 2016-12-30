//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    var tuanGrid;
    var tuanuCode;
    $(function() {
    	taunGrid = $('#taunGrid').datagrid({
            url : '/tuan/gridData',
            fit : true,
            fitColumns : true,
            striped : true,
            rownumbers : false,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
                    {
			    width : '30',
			    title : '',
			    field : 'ck',
			    checkbox: true,
			},
                    {
                width : '80',
                title : '团编码',
                field : 'tuanCode',
            },
            {
                width : '80',
                title : '成团人数',
                field : 'peopleNum',
            },
                    {
                width : '150',
                title : '团开始时间',
                field : 'tuanStartDate',
                formatter: formatDatebox,
            },
                    {
                width : '150',
                title : '团结束时间',
                field : 'tuanEndDate',
                formatter: formatDatebox,
            },
                    {
                width : '80',
                title : '订单分类',
                field : 'orderSort',
                align : 'center',
                formatter : function(value, row, index) {
					switch (value) {
					case 0:
						return '一元购';
					case 1:
						return '拼团';
					case 2:
						return '抽奖';
						
					}
				}
            },
                    {
                width : '80',
                title : '团状态',
                field : 'tuanStatus',
                align : 'center',
                formatter : function(value, row, index) {
					switch (value) {
					case 'WAIT_PAY':
						return '待付款';
					case 'WAIT_JOIN':
						return '待成团';
					case 'SUCCESSED':
						return '完成';
					case 'FAIL':
						return '拼团失败';
					case 'CLOSED':
						return '已关闭';
						
					}
				}
            }] ],
            onSelect: function(index,row) {
            	console.log(row);
            	
            	tuanCode = row.tuanCode;
            	console.log(tuanCode);
            	dataGrid = $('#dataGrid').datagrid('reload',{tuanCode: tuanCode});
            	
         },
        });
    });
    
    
    $(function() {
        dataGrid = $('#dataGrid').datagrid({
            url : '/order/gridData',
            fit : true,
            fitColumns : true,
            striped : true,
            rownumbers : true,
            pagination : false,
            singleSelect : true,
            nowrap :false,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
//                    {
//                width : '80',
//                title : '团ID',
//                field : 'id',
//            },
//            		{
//                width : '80',
//                title : '团编码',
//                field : 'tuanCode',
//            },
            		{
                width : '80',
                title : '订单分类',
                field : 'orderSort',
                formatter : function(value, row, index) {
					switch (value) {
					case 0:
						return '一元购';
					case 1:
						return '拼团';
					case 2:
						return '抽奖';
						
					}
				},
				align: 'center',
            },
                    {
                width : '80',
                title : '商品ID',
                field : 'goodsId',
            },
                    {
                width : '100',
                title : '商品图片',
                field : 'goodsImg',
                formatter:function(value,row,index)
                {return '<img src='+value+'  />';}
            },
                    {
                width : '300',
                title : '商品名称',
                field : 'goodsName',
            },
//                    {
//                width : '80',
//                title : '商品编码',
//                field : 'goodsCode',
//            },
                    {
                width : '80',
                title : '商品金额',
                field : 'goodsPrice',
            },
                    {
                width : '180',
                title : '订单编码',
                field : 'orderCode',
            },
                    {
                width : '80',
                title : '用户名',
                field : 'userName',
            },
                    {
                width : '80',
                title : '订单状态',
                field : 'orderStatus',
                formatter : function(value, row, index) {
    					switch (value) {
    					case 'WAIT_PAY':
    						return '待付款';
    					case 'WAIT_JOIN':
    						return '待成团';
    					case 'WAIT_SHIPPING':
    						return '待发货';
    					case 'WAIT_CHOOSE':
    						return '待抽奖';
    					case 'WAIT_RECEIVE':
    						return '已发货';
    					case 'WAIT_COMMENT':
    						return '等待买家评价';
    					case 'SUCCESSED':
    						return '已成功';
    					case 'WAIT_REFUND_GOODS':
    						return '等待买家退货';
    					case 'WAIT_REFUND_MONEY':
    						return '等待卖家退款';
    					case 'CLOSED':
    						return '交易已关闭';
    						
    					}
    				},
    			align: 'center',
            }
            ] ],
        });
    });
    
    
    
    
    function searchFun() {
        ////将searchForm表单内的元素序列为对象传递到后台
    	taunGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        //找到form表单下的所有input标签并清空
        $('#searchForm input').val('');
        //重新加载数据，无填写数据，向后台传递值则为空
        taunGrid.datagrid('load', {});
    }
    