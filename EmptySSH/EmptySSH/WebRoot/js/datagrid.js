$(function() {
	$('#da')
			.datagrid(
					{
						title : '数据表格',
						iconCls : 'icon-edit',
						 /*url:'data4datagrid', */
						method : 'get',
						fitColumns : true,
						pagination : true,
						 striped: true, 
						 resizeHandle:'both', 
						noerap : true,
						idField : 'id',
						loadMsg : '正在加载数据。。。',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						selectOnCheck : true,
						pageNumber : 1,
						pageSize : 5,
						pageList : [ 5, 10, 15, 20 ],
						queryParams : {
							name : 'id',
							subject : '1'
						},
						sortName : 'text',
						sortOrder : 'desc',
						multiSort : true,
						remoteSort : true,
						showHeader : true,
						showFooter : true,
						scrollbarSize : 20,
						rowStyler : function(index, row) {
							if (row.id > 1) {
								return 'background-color:#6293BB;color:#fff;';
							}
						},
						
						 loader: function(){ },
						 
						
						loadFilter: function(data){ if(data.d){ return
						  data.d; }else{ return data; } },
						 
						toolbar : [
								{
									text : '新增',
									iconCls : 'icon-add',
									handler : function() {
										$('#da').datagrid('insertRow', {
											index : 0, // 索引从0开始
											row : {}
										});
										$('#da').datagrid('selectRow', 0);
										$('#da').datagrid('beginEdit', 0);
									}
								},
								'-',
								{
									text : '保存',
									iconCls : 'icon-save',
									handler : function() {
										var editData = $('#da')
												.datagrid(
														'getRowIndex',
														$('#da').datagrid(
																'getSelected'));
										$('#da').datagrid('endEdit', editData);
										$('#da').datagrid('uncheckRow', editData);
									}
								},
								'-',
								{
									text : '编辑',
									iconCls : 'icon-edit',
									handler : function() {
										var editData = $('#da')
										.datagrid(
												'getRowIndex',
												$('#da').datagrid(
														'getSelected'));
										$('#da').datagrid('beginEdit',
												editData);
									}
								},
								'-',
								{
									text : '撤销',
									iconCls : 'icon-redo',
									handler : function() {
										var editData = $('#da')
												.datagrid(
														'getRowIndex',
														$('#da').datagrid(
																'getSelected'));
										$('#da').datagrid('cancelEdit',
												editData);
										$('#da').datagrid('uncheckRow',editData);
									}
								} ],
						columns : [ [ {
							title : 'id',
							field : 'id',
							checkbox : true,
							width : 100,
							sortable : true
						}, {
							title : 'text',
							field : 'text',
							width : 100,
							colspan : 1,
							editor : {
								type : 'datebox'
							},
							sortable : true
						}, {
							title : 'state',
							field : 'state',
							width : 100,
							editor : {
								type : 'text'
							},
							sortable : true
						}, {
							title : 'tid',
							field : 'tid',
							width : 100,
							align : 'right',
							editor : {
								type : 'checkbox',
								options : {
									on : 'open',
									off : 'closed'
								}
							},
							sortable : true
						} ] ],
						data : [ {
							id : 1,
							text : 'manager',
							state : 'closed',
							tid : 0
						}, {
							id : 2,
							text : 'date',
							state : 'open',
							tid : 1
						} ],
						onLoadSuccess : function(data) {
							console.log(data);
						},
						onLoadError : function() {
							alert(123);
						},
						onClickRow : function(index, data) {
							obj.edit(index, data);
						},
						onAfterEdit : function(index, data, changes) {
							obj.add(index, data, changes);
						},
						onUnselect : function(index, data) {
							alert(index);
							obj.redo(index, data);
						},
						onDblClickCell : function(index, field, value) {
							if (editIndex != index) {
								if (endEditing()) {
									$('#da').datagrid('selectRow', index)
											.datagrid('beginEdit', index);
									var ed = $('#da').datagrid('getEditor', {
										index : index,
										field : field
									});
									($(ed.target).data('textbox') ? $(ed.target)
											.textbox('textbox')
											: $(ed.target)).focus();
									editIndex = index;
								} else {
									$('#da').datagrid('selectRow', editIndex);
								}
							}
						},

					});
	obj = {
		add : function(index, data, changes) {
			$.ajax({
				type : 'get',
				url : 'add',
				data : data,
				dataType : 'json',
				success : function(json) {
					alert(json);
				}
			});
		},
		edit : function(index, data) {
			
			$('#da').datagrid('beginEdit', index);
			$('#da').datagrid('beginEdit', index);
		},
		redo : function(index, data) {
			$('#da').datagrid('endEdit', index);
		}
	};
	

	
});
