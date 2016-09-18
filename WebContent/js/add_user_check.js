function checkForm(){
	//校验学号
	
	var id = document.getElementById("studentid").value;
	if(id == null || id == "")
	{
		alert("学号不能为空！");
		return false;
	}
	else if(id.length<4)
	{
		alert("学号长度不能小于4个字符！");
		return false;
	}
	else if(id.length>15)
	{
		alert("学号长度不能大于15个字符！");
		return false;
	}
	
	//校验姓名
	var name = document.getElementById("name").value;
	if(name == "" || name == null)
	{
		alert("姓名不能为空！");
		return false;
	}
 
    //校验密码
    //获得密码的值
    var password=document.getElementById("password").value;
    if(password==null || password==''){
        alert("密码不能为空");
        return false;
    }
	else if(password.length<6)
	{
		alert("密码长度不能小于6个字符");
        return false;
	}
	else if(password.length>30)
	{
		alert("密码长度不能大于30个字符");
		return false;
	}else{
		var studentid = $('#studentid').val();
		var name =  $('#name').val();
		var sex = $('#sex').val();
		var grade = $('#grade').val();
		var password = $('#password').val();
		 $.ajax({
	         type: "GET",
	         contentType: 'application/json',
	         url: "addstudent",
	         dataType: "json",
	         async:true,
	         data:{'studentid':studentid,'name':name,'sex': sex,'grade':grade,'password':password},
	         
	         success: function(msg){// msg为返回的数据，在这里做数据绑定
	        	// alert(msg)
	             var data = msg.addResult;
	             if(data === 'ok'){//成功修改分组
	             	alert("添加成功！");
	             }else if(data === 'error'){//访问数据出错了
	             	alert("添加失败！！！");
	            // 	window.location.href="../logout"; 
	             }else if(data === 'Permission error')
	             {
	             	alert("你没有删除权限");
	             	window.location.href="logout";
	             }
	             
	             location.reload();
	         },error: function(){
	             alert("服务器链接错误！！！");
	             console.log(msg)
	             window.location.href="../logout"; 
	         },
	         
	     });
	}
    
   
  
}

function reloadForm()
{
	 location.reload();
}