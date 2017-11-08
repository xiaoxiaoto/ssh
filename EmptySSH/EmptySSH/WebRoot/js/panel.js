$(function (){
	$('#box').panel({
		title : '面板',
		width : 600,
		height : 500,
		iconCls: 'icon-edit',
		cls: ' position: absolute',
		headerCls:  '{background:#f2f2f2}',
		bobyCls:  '{background:#f2f2f2}',
		style: {borderWidth:20},
		fit: false,
		border: true,
		doSize: true,
		left: 100,
		top: 100,
		noheader: false,
		content: '面板内容',
		collapsible:true,
		minimizable: true,
		maximizable :true,
		closable: true,
		tools: [{
			iconCls: 'icon-ok',
			handler: function(){
				alert('确认');
			}
		},{
			iconCls: 'icon-save',
			handler: function(){
				alert('保存');
			}
		}],
		href:'print',
		cache: true,
		loadingMessage: '加载中。。。',
		onBeforeLoad: function(){
			alert('加载之前。。。');
		},
		onLoad: function(){
			alert('加载时。。。');
		},
		onLoadError: function(){
			alert('加载出现错误时。。。');
		},
		onBeforeOpen: function(){
			alert('面板打开前触发。。。');
		},
		onOpen: function(){
			alert('面板打开时触发。。。');
		},
		onBeforeClose: function(){
			alert('面板关闭之前触发。。。');
		},
		onClose: function(){
			alert('面板关闭时触发。。。');
		},
		onBeforeDestroy: function(){
			alert('面板组件销毁之前触发。。。');
		},
		onDestroy: function(){
			alert('面板组件');
		},
		onBeforeCollapse: function(){
			alert('面板伸缩之前触发。。。');
		},
		onCollapse: function(){
			alert('面板伸缩时触发。。。');
		},
		onBeforeExpand: function(){
			alert('面板伸展之前触发。。。');
		},
		onExpand: function(){
			alert('面板伸展时触发。。。');
		},
		onResize: function(){
			alert('面板重置大小时触发。。。');
		},
		onMove: function(){
			alert('面板移动时触发。。。');
		},
		onMaximize: function(){
			alert('面板最大化时触发。。。');
		},
		onRestore: function(){
			alert('面板恢复原始设置时触发。。。');
		},
		onMinimize: function(){
			alert('面板最小化时触发。。。');
		}
		
	});
	/*返回panel面板所有设置的属性*/
	alert($('#box').panel('options'));
	/*返回panel面板本身*/
	$('#box').panel('panel').css('position','absolute');
	/*返回面板头*/
	$('#box').panel('header');
	
});
function add(){
	alert(123);
}