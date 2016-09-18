function checkAdminProfileForm()
{	//校验ID
	var id = document.getElementById("adminId").value;
	
	var email = document.getElementById("email").value;
//	if(!isEmail(email))
//	{
//		alert("输入的邮箱地址有误！");
//		return false;
//	}
	//校验电话
	var phone = document.getElementById("phone").value;
	if(phone == null || phone == "")
	{
		alert("手机号不能为空！");
		return false;
	}
	else if(!isPhone(phone))
	{
		alert("输入的手机号有误！");
		return false;
	}else{
		var adminid = $('#adminId').val();
		var phone =  $('#phone').val();
		var mail = $('#email').val();
		
		 $.ajax({
	        type: "GET",
	        contentType: 'application/json',
	        url: "updateadmin",
	        dataType: "json",
//	        async:true,
	        data:{'adminId':adminid,'phone':phone,'mail': mail},
	        
	        success: function(msg){// msg为返回的数据，在这里做数据绑定
	       	// alert(msg)
	            var data = msg.editResult;
	            if(data === 'ok'){//成功修改分组
	            	alert("编辑成功！");
	            	location.reload();
	            }else if(data === 'error'){//访问数据出错了
	            	alert("编辑失败！！！");
	           // 	window.location.href="../logout"; 
	            }else if(data === 'Permission error')
	            {
	            	alert("你没有编辑权限");
	            	window.location.href="logout";
	            }
	            
	            location.reload();
	        },error: function(){
	            alert("成功！！！");
	            location.reload()
	           // window.location.href="logout"; 
	        },
	        
	    });
	}
	
	//校验邮箱

	
	

}

function isPhone(str)
{
	var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
	return reg.test(str);
}

function isEmail(str){  
    var reg = /[a-z0-9-]{1,30}@[a-z0-9-]{1,65}.[a-z]{3}/;  
    return reg.test(str);  
}  

function checkPassword()
{
	//校验密码
    //获得密码的值
	var pwd = document.getElementById("pwd").value;
	var onepwd = document.getElementById("onepwd").value;
	var twopwd = document.getElementById("twopwd").value;
	if(pwd == null || pwd == ""){
        alert("当前密码不能为空");
        return false;
    }
	else if(onepwd == null || onepwd == "")
	{
		alert("新密码不能为空！");
        return false;
	}
	else if(onepwd !== twopwd)
	{
		alert("两次输入密码不一致！");
		return false;
	}

}
function changePwd()
{
	var pwd = document.getElementById("pwd").value;
	var onepwd = document.getElementById("onepwd").value;
	var adminid = $('#adminId').val();
	$.ajax({
        type: "GET",
        contentType: 'application/json',
        url: "changepwd",
        dataType: "json",
//        async:true,
        data:{'oldPassword':pwd,'newPassword':onepwd,'userId': adminid},
        
        success: function(msg){// msg为返回的数据，在这里做数据绑定
       	// alert(msg)
            var data = msg.changeResult;
            if(data === 'ok'){//成功修改分组
            	alert("密码修改成功！！！");
            	location.reload();
            }else if(data === 'oldPasswordError'){//访问数据出错了
            	alert("原密码错误！！");
           // 	window.location.href="../logout"; 
            }else if(data === 'error')
            {
            	alert("服务器出错");
            	window.location.href="logout";
            }
            
            location.reload();
        },error: function(){
            alert("成功！！！");
       //     location.reload()
           // window.location.href="logout"; 
        },
        
    });
}
