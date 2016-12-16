var index_layout;
var index_tabs;
var index_tabsMenu;
var layout_west_tree;
var layout_west_tree_url = '/functionTree';
var EDIT_PASSD_URL  = '/user/changePwdForm';

$(function() {
	index_layout = $('#index_layout').layout({
		fit : true
	});

	index_tabs = $('#index_tabs').tabs(
			{
				fit : true,
				border : false,
				tabHeight : 30,
				tools : [
						{
							iconCls : 'icon-home',
							handler : function() {
								index_tabs.tabs('select', 0);
							}
						}, 
						
//							  { iconCls : 'icon-refresh', handler : function() {
//							  var index = index_tabs.tabs('getTabIndex',
//							  index_tabs.tabs('getSelected'));
//							  index_tabs.tabs('getTab',
//							  index).panel('open').panel('refresh');
//							  index_tabs.tabs('getTab',
//							  index).panel('refresh'); //alert(index); 
//							  } },
							 
						{
							iconCls : 'icon-refresh',
							handler : function() {
								refreshTab();
							}
						},
						{
							iconCls : 'icon-del',
							handler : function() {
								closeTab();
							}
						}]
			});

	layout_west_tree = $('#layout_west_tree').tree({
		url : layout_west_tree_url,
		parentField : 'pid',
		lines : true,
		onClick : function(node) {
			if(layout_west_tree.tree("isLeaf",node.target)){
				var url = '' + node.attributes.url;
				addTab({
					url : url,
					title : node.text,
					iconCls : node.iconCls,
				});
			}else{
				layout_west_tree.tree("toggle",node.target);
			}
		}
	});

});

function addTab(params,refresh) {
	var iframe = '<iframe 	 src="'
			+ params.url
			+ '" frameborder="0" style="border:0;width:100%;height:99.5%;"></iframe>';
	var t = $('#index_tabs');
	var opts = {
		title : params.title,
		closable : true,
		iconCls : params.iconCls,
		content : iframe,
		border : false,
		fit : true
	};
	if (t.tabs('exists', opts.title)) {
		if(refresh){
			closeTab(opts.title)
			t.tabs('add', opts);
		}else{
			t.tabs('select', opts.title);
		}
	} else {
		t.tabs('add', opts);
	}
}

function logout() {
	$.messager.confirm('提示', '确定要退出?', function(r) {
		if (r) {
			$.post('/logout', function(result) {
				location.reload();
			});
		}
	});
}

function directLogout() {
	$.post('/logout', function(result) {
		location.reload();
	});
}

function editUserPwd() {
	parent.$.modalDialog({
	    title: '修改密码',
	    width: 400,
	    height: 200,
	    closed: false,
	    cache: false,
	    href: EDIT_PASSD_URL,
	    modal: true,
	    buttons : [ {
			text : '确定',
			handler : function() {
				var f = parent.$.modalDialog.handler.find('#editUserPwdForm');
				f.submit();
			}
		} 
		]
	});
	
}

function clearcache(){
	$.ajax({
		url: '/clearCache',
		success: function(result){
			progressClose();
			if (result.success) {
				parent.$.messager.alert('提示', result.msg, 'warning');
			} else {
				parent.$.messager.alert('提示', result.msg, 'warning');
			}
		},
		error: function(){
			progressClose();
			alert("系统错误");
		}
	});
}


//切换主题
changeTheme = function (themeName) {
    var $easyuiTheme = $('#easyuiTheme');
    var url = $easyuiTheme.attr('href');
    var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
    $easyuiTheme.attr('href', href);
    var $iframe = $('iframe');
    if ($iframe.length > 0) {
        for (var i = 0; i < $iframe.length; i++) {
            var ifr = $iframe[i];
            $(ifr).contents().find('#easyuiTheme').attr('href', href);
        }
    }
    setCookie("themeName", themeName, 7)
    //友情提示
    topCenter("当前主题：" + themeName, 1000);
};

function closeTab(title){
	var t = $('#index_tabs');
	var index = t.tabs('getTabIndex',t.tabs('getSelected'));
	if(title){
		if(t.tabs('exists', title)){
			index = t.tabs('getTabIndex',t.tabs("getTab",title));
		}
	}else{
		index = t.tabs('getTabIndex',t.tabs('getSelected'));
	}

	console.log(title);
	var tab = t.tabs('getTab', index);
	if (tab.panel('options').closable) {
		t.tabs('close', index);
	}
}



function refreshTab(title) {
	var t = $('#index_tabs');
	if(title){
		if(t.tabs('exists', title)){
			t.tabs('select', title);
		}
	}
	var index = t.tabs('getTabIndex', t.tabs('getSelected'));
	var tab = t.tabs('getSelected');
	var options = tab.panel("options");
	t.tabs("update",{tab:tab,options:{
		content:options.content
	}});
}



