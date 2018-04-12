$( function() {
	tabClose();
	tabCloseEven();
})

var menu = [];
$( function() {
	$.ajaxSettings.async = false;
	$.getJSON('/function/rootFunction',{}, function(data) {
		if (data) {
			menu = data.rows;
		}
	});
	for ( var i = 0; i < menu.length; i++) {
		var menuId = menu[i].functionId;
		var titleName = menu[i].funcname;
		var idName = "subFunc" + menuId;
		$('#main').accordion('add', {
			title :titleName,
			content :"<ul id=" + idName + "></ul>"
		});
		loadsubFunction(menuId, '');
	}

	if (menu.length > 0) {
		var titleName = menu[0].funcname;
		$('#main').accordion('select', titleName);
	}

});

function loadsubFunction(funcid, parentid) {
	$('#subFunc' + funcid).addClass("easyui-tree");
	$('#subFunc' + funcid).tree(
			{
				checkbox :false,
				url :'/function/list?type=2&parentId=' + funcid
						+ '&c=' + Math.round(Math.random() * 10000) + '',
				onClick : function(node) {
					$(this).tree('toggle', node.target);
				}
			});
}

function addTab(title, href, funcid) {
	if (href != '#') {
		var tt = $('#main-center');
		var tabTitle = title + '<span aid="f' + funcid + '"></span>';
		if (tabTitle != null && tabTitle != '') {
			tabTitle = tabTitle.toLowerCase();
		}
		if (tt.tabs('exists', tabTitle)) {
			tt.tabs('select', tabTitle);
		} else {
			var content = '';
			if (href) {
				content = '<iframe scrolling="auto" frameborder="0"  src="' + href + '" style="width:100%;height:100%;"></iframe>';
			} else {
				content = '未实现';
			}
			tt.tabs('add', {
				title :tabTitle,
				closable :true,
				content :content
			});
		}
		tabClose();
	}
}

function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick( function() {
		var subtitle = $(this).children(".tabs-closable").html();
		if (subtitle != null && subtitle != '') {
			subtitle = subtitle.toLowerCase();
		}
		$('#main-center').tabs('close', subtitle);
	})
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left :e.pageX,
			top :e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").html();
		if (subtitle != null && subtitle != '') {
			subtitle = subtitle.toLowerCase();
		}
		$('#mm').data("currtab", subtitle);
		$('#main-center').tabs('select', subtitle);
		return false;
	});
}

// 绑定右键菜单事件
function tabCloseEven() {
	// 关闭当前
	$('#mm-tabclose').click( function() {
		var currtab_title = $('#mm').data("currtab");
		if (currtab_title != null && currtab_title != '') {
			currtab_title = currtab_title.toLowerCase();
		}
		$('#main-center').tabs('close', currtab_title);
	})
	// 全部关闭
	$('#mm-tabcloseall').click( function() {
		$('.tabs-inner span').each( function(i, n) {
			var t = $(n).html();
			if (t != null && t != '') {
				t = t.toLowerCase();
			}
			$('#main-center').tabs('close', t);
		});
	});
	// 关闭除当前之外的TAB
	$('#mm-tabcloseother').click( function() {
		var currtab_title = $('#mm').data("currtab");
		$('.tabs-inner span').each( function(i, n) {
			var t = $(n).html();
			if (t != null && t != '') {
				t = t.toLowerCase();
			}
			if (t != currtab_title) {
				$('#main-center').tabs('close', t);
			}
		});
	});
	// 关闭当前右侧的TAB
	$('#mm-tabcloseright').click( function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			return false;
		}
		nextall.each( function(i, n) {
			var t = $('a:eq(0) span', $(n)).html();
			if (t != null && t != '') {
				t = t.toLowerCase();
			}
			$('#main-center').tabs('close', t);
		});
		return false;
	});
	// 关闭当前左侧的TAB
	$('#mm-tabcloseleft').click( function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 0) {
			return false;
		}
		prevall.each( function(i, n) {
			var t = $('a:eq(0) span', $(n)).html();
			if (t != null && t != '') {
				t = t.toLowerCase();
			}
			$('#main-center').tabs('close', t);
		});
		return false;
	});

	// 退出
	$("#mm-exit").click( function() {
		$('#mm').menu('hide');
	})
}
