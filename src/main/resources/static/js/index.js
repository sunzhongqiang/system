var index_layout;
var index_tabs;
var index_tabsMenu;
var layout_west_tree;
var layout_west_tree_url = '/functionTree';

$(function() {
	index_layout = $('#index_layout').layout({
		fit : true
	});

	index_tabs = $('#index_tabs').tabs(
			{
				fit : true,
				border : false,
				tools : [
						{
							iconCls : 'icon-home',
							handler : function() {
								index_tabs.tabs('select', 0);
							}
						}, /*
							 * { iconCls : 'icon-refresh', handler : function() {
							 * var index = index_tabs.tabs('getTabIndex',
							 * index_tabs.tabs('getSelected'));
							 * index_tabs.tabs('getTab',
							 * index).panel('open').panel('refresh');
							 * //index_tabs.tabs('getTab',
							 * index).panel('refresh'); //alert(index); } },
							 */
						{
							iconCls : 'icon-del',
							handler : function() {
								var index = index_tabs.tabs('getTabIndex',
										index_tabs.tabs('getSelected'));
								var tab = index_tabs.tabs('getTab', index);
								if (tab.panel('options').closable) {
									index_tabs.tabs('close', index);
								}
							}
						} ]
			});

	layout_west_tree = $('#layout_west_tree').tree({
		url : layout_west_tree_url,
		parentField : 'pid',
		lines : true,
		onClick : function(node) {
			if (node.attributes && node.attributes.url) {
				var url = '' + node.attributes.url;
				addTab({
					url : url,
					title : node.text,
					iconCls : node.iconCls
				});
			}
		}
	});
	
});

function addTab(params) {
	var iframe = '<iframe src="'
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
		t.tabs('select', opts.title);
	} else {
		t.tabs('add', opts);
	}
}

function logout() {
	$.messager.confirm('提示', '确定要退出?', function(r) {
		if (r) {
			$.post('/logout', function(result) {
				progressLoad();
				location.reload();
			});
		}
	});
}

function directLogout() {
	$.post('/logout', function(result) {
		progressLoad();
		location.reload();
	});
}

function editUserPwd() {
	parent.$.modalDialog({
		title : '修改密码',
		width : 300,
		height : 250,
		href : '/adminUser/editPwdPage',
		buttons : [ {
			text : '修改',
			handler : function() {
				var f = parent.$.modalDialog.handler.find('#editUserPwdForm');
				f.submit();
			}
		} ]
	});
}