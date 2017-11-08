$(function() {
	$('#box').dialog({
		title : 'My Dialog',
		iconCls:'icon-ok',
		width : 600,
		height : 500,
		colsed : true,
		model : true,
		collapsible : true,
		minimizable : true,
		maximizable : true,
		resizable : true,
		toolbar : [ {
			text : '编辑',
			iconCls : 'icon-edit',
			handler : function() {
				alert('edit button');
			}
		}, {
			text : '帮助',
			iconCls : 'icon-help',
			handler : function() {
				alert('help button');
			}
		} ],
		buttons: [{
			text:'保存',
			plain: true,
			iconCls:'icon-save',
			handler:function(){
				alert('保存');
			}
		},{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){
				alert('删除');
			}
		}]
	});
});