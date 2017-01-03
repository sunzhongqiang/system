 var combotree;
    $(function() {
    	combotree = $('#parentTree').combotree({
            url : '/region/loadRegionByParentId',
            singleSelect : true,
            idField : 'regionId',
            parentField:'parentId',
            textField : 'regionName',
            valueField : 'regionId',
            text:'regionName',
            pageSize : 100,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            onBeforeLoad: function(row,param){
                if (!row) {    // load top level rows
                    param.parentId = 1;    // set id=0, indicate to load new page rows
                }else{
                	param.parentId = row.regionId;
                }
            },	
            loadFilter:comboTreeLoadFilter,
            required:true
        });
    });