$(function() {

	$('#box').draggable({
		handle : '#fox',
		/*
		 * proxy: function(source){ var p = $('<div style="border:1px solid
		 * #ccc;width:80px"></div>');
		 * p.html($(source).html()).appendTo('body'); return p; },
		 */
		revert : false,
		cursor : 'move',
		deltaX : 100,
		deltaY : 100,
		edge : 100,
		axis : 'h'
	});
	
	$('#fox').panel({
		title : '面板',
		width : 600,
		height : 500,
		doSize : true
	});
	
	$('#fox').resizable({

	});
	
	$('#search').searchbox({
		menu : '#menu',
		width : 200,
		prompt : '请输入搜索条件',
		searcher : function(value, name) {
			alert(value + "----------" + name);
		}
	});
	$('#progress').progressbar({
		width : 200,
		value : 30,
		text : '{value}%。',
		onChange : function(newValue, oldValue) {
			// alert(newValue+"----"+oldValue);
		}
	});
	$('#tabs').tabs({
		width : 200,
		height : 300,
		plain : false,
		fit : true,
		border : false,
		scrolllncrement : 12333,
		scrollDuration : 111111,
		tools : [ {
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				alert(123);
			}
		}, {
			text : '搜索',
			iconCls : 'icon-search',
			handler : function() {
				alert(123);
			}
		} ]

	});
	$('#tabs').tabs('add', {
		title : '选项卡',
		content : '内容',
		// href: 'www.baidu.com',
		closable : true
	});
	$('#tabs').tabs('add', {
		title : '选项卡',
		href : '../../ee.html',
		content : '内容',
		collapsible : true,
		// href: 'www.baidu.com',
		closable : true
	});
	$('#mm').menu({
		onClick : function(item) {
			console.log(item);
		}
	});
	$(document).bind('contextmenu', function(e) {
		e.preventDefault();
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});
	});
	$("#button1").menubutton({
		menu : '#mm',
		iconCls : 'icon-edit'
	});
	$("#button2").splitbutton({
		menu : '#mm',
		iconCls : 'icon-edit'
	});

	obj = {
		k : '工作',
		adc : function() {
			for (var i = 0; i < 100; i += 10) {
				$('#progress').progressbar('setValue', i);
			}
			return 1;
		},
		add : function() {
			alert(obj.k);
		}
	};
	alert(obj.adc());
});