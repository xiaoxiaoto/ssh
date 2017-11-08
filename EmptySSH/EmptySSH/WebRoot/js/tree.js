$(function(){
	/*$('#box').tree({
		checkbox: true,
		lines: true,
		method: 'get',
		animate: true,
		onlyLeafCheck: true,
		cascadeCheck: true,
		dnd:true,
		formatter: function(node){
			return '['+node.text+']';
			},
		data: [{
			text: '文件夹',
			state:'closed',
			attributes: {
				url: 'print'
			},
			iconCls: 'icon-print',
			children: [{
				text: '图片',
				iconCls: 'icon-cut'
			},{
				text: '文档',
				iconCls:'icon-reload'
			}]
		},{
			text:'计算机',
			state: 'closed',
			iconCls: 'icon-save'
		}],
		onClick: function(node){
			var url = node.attributes.url;
			alert(url);
			window.location.href=url;
		},
		onDblClick: function(){
			alert(nodel.text);
		}
		onBeforeLoad: function(node,param){
			alert(param);
		}
	});*/
	$('#box').tree({
		url: 'treeData',
		method: 'get'
	});
	
	
});