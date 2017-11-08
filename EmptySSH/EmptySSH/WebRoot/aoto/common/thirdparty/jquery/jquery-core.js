$(document).ready(function(){
		$("#add").click(function(){
			var name = $("#name").val();
			var age =$("#age").val();
			var user = {name:name,age:age};
			$.ajax({
				url:"user/ajax",
				type:"post",
				data:user,
				success:function(a){
					$("#d01").html(a.name);
					$("#d02").html(a.age);
				}
			});
		});
	});