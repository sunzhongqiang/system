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
                title : '团ID',
                field : 'tuanCode',
            },
                    {
                width : '80',
                title : '订单分类：1，一元购；2，拼团',
                field : 'orderSort',
            },
                    {
                width : '80',
                title : '团状态：0，全部订单；1，待成团；2，已成团；3，拼团失败',
                field : 'tuanStatus',
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
            pagination : true,
            singleSelect : true,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
                    {
                width : '80',
                title : '团ID',
                field : 'id',
            },
                    {
                width : '80',
                title : '商品ID',
                field : 'goodId',
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
                width : '80',
                title : '团开始时间',
                field : 'tuanStartDate',
            },
                    {
                width : '80',
                title : '团结束时间',
                field : 'tuanEndDate',
            },
                    {
                width : '80',
                title : '订单分类：1，一元购；2，拼团',
                field : 'orderSort',
            },
                    {
                width : '80',
                title : '商品图片',
                field : 'goodImg',
            },
                    {
                width : '80',
                title : '商品名称',
                field : 'goodName',
            },
                    {
                width : '80',
                title : '商品编码',
                field : 'goodCode',
            },
                    {
                width : '80',
                title : '商品金额',
                field : 'goodPrice',
            },
                    {
                width : '80',
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
                title : '团状态：0，全部订单；1，待成团；2，已成团；3，拼团失败',
                field : 'tuanStatus',
            }] ],
        });
    });
    
    
    
    
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
    