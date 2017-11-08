$(function(){
	$('#box').layout('add',{
		region: 'east',
		title: '广告栏',
		width: 100,
		iconCls: 'icon-edit',
		border: true,
		split: true,
		collapsible: true,
		href: 'print',
		tools: [{
			iconCls: 'icon-print',
			handler: function(){
				alert(123);
			}
		},{
			iconCls:'icon-save',
			handler: function(){
				alert(123);
			}
		}]
	});
});
function add(){
	alert(123);
}