$(function(){
	$(function() {
		/*$('#form').form({
			url: 'formData',
			submit:function(){
				var rs=$('#form').form('validate');
				return rs;
			},
			success:function(date){
				console.info(date);
				alert(data);
			}
				
		});*/
		$('#name').validatebox({
			required: true,
			validType:['length[0,20]']
		});
		$('#email').validatebox({
			required: true,
			validType:['email','length[0,20]']
		});
		$('#password').validatebox({
			required: true,
			validType:'length[6,32]'
		});
		
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
					$('#form').form('submit',{
					url: 'formData',
					submit:function(){
						var rs=$('#form').form('validate');
						return rs;
					},
					success:function(data){
						var data=eval('('+data+')');
						/*data = JSON.parse(data);*/
						alert(data.email);
					}
				});
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
});