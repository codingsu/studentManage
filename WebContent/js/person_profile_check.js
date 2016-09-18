function checkPersonProfileForm() {
	// 校验姓名
	var name = document.getElementById("name").value;
	if (name == "" || name == null) {
		alert("姓名不能为空！");
		return false;
	}

	// 校验年龄
	var grade = document.getElementById("age").value;

	// 校验学号
	var id = document.getElementById("student_id").value;
	if (id == null || id == "") {
		alert("学号不能为空！");
		return false;
	} else if (id.length < 4) {
		alert("学号长度不能小于4个字符！");
		return false;
	} else if (id.length > 15) {
		alert("学号长度不能大于15个字符！");
		return false;
	}

	// 校验电话
	var phone = document.getElementById("phone").value;
	if (phone == null || phone == "") {
		alert("手机号不能为空！");
		return false;
	} else if (!isPhone(phone)) {
		alert("输入的手机号有误！");
		return false;
	}

	// 校验邮箱
	var email = document.getElementById("email").value;
	if (!isEmail(email)) {
		alert("输入的邮箱地址有误！");
		return false;
	}

	var studentid = document.getElementById("student_id").value;
	var sex = document.getElementById("sex").value;
	var phone = document.getElementById("phone").value;
	var mail = document.getElementById("email").value;
	
	$.ajax({
		type : "GET",
		contentType : 'application/json',
		url : "updatestudent",
		dataType : "json",
	    async:true,
		data : {
			'name' : name,
			'sex' : sex,
			'grade' : grade,
			'studentid' : studentid,
			'phone' : phone,
			'mail' : email
		},

		success : function(msg) {// msg为返回的数据，在这里做数据绑定
			// alert(msg)
			var data = msg.updateResult;
		//	alert(data)
			if (data === 'ok') {// 成功修改分组
				alert("编辑成功！！！");
				location.reload();
			} else if (data === 'error') {// 访问数据出错了
				alert("编辑失败！！");
				// window.location.href="../logout";
			}
			location.reload();
		},
		error : function() {
			alert("成功！！！");
			// location.reload()
			// window.location.href="logout";
		},

	});
}

function isAge(str) {
	var reg = /[0-9]{1,3}/;
	return reg.test(str);
}

function isPhone(str) {
	var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
	return reg.test(str);
}

function isEmail(str) {
	var reg = /[a-z0-9-]{1,30}@[a-z0-9-]{1,65}.[a-z]{3}/;
	return reg.test(str);
}

function checkPassword() {
	// 校验密码
	// 获得密码的值
	var pwd = document.getElementById("pwd").value;
	var onepwd = document.getElementById("onepwd").value;
	var twopwd = document.getElementById("twopwd").value;
	var divStatus = document.getElementById("nowpwd").style.visibility;
	console.log(divStatus)
	console.log(pwd)
	if (divStatus != "hidden" && (pwd == null || pwd == '')) {
		alert("当前密码不能为空");
		return false;
	} else if (onepwd == null || onepwd == "") {
		alert("新密码不能为空！");
		return false;
	} else if (onepwd !== twopwd) {
		alert("两次输入密码不一致！");
		return false;
	}
}

//document.getElementById('changepwd_btn').onclick = function() {
//	var xmlhttp;
//	var newpwd = document.getElementById("onepwd").value;
//	
//	
//
//	$.ajax({
//		type : "GET",
//		url : "adminChangeStuPwd",
//		dataType : "json",
//		data : {
//			userId : user,
//			newPassword : newpwd
//		},
//		success : function(msg) {
//			alert("success");
//			location.reload();
//		},
//		error : function(msg) {
//			alert("error");
//		}
//	})
//
//	
//
//}
function doclick() {
	// document.getElementById("edit").style.display = "none";
	document.getElementById("edit").disabled = true;
	document.getElementById("infoCommit").disabled = false;
	document.getElementById("infoCancel").disabled = false;
	document.getElementById("name").disabled = false;
//	document.getElementById("sex").disabled = false;
//	document.getElementById("age").disabled = false;
	//document.getElementById("student_id").disabled = false;
	document.getElementById("phone").disabled = false;
	document.getElementById("email").disabled = false;
}

function changePwd()
{
	var pwd = document.getElementById("pwd").value;
	var onepwd = document.getElementById("onepwd").value;
	var adminid = $('#student_id').val();

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

function admchangestupwd(){
	var newPassword = document.getElementById("newpwd").value;
	var userid = $('#student_id').val();
	
	$.ajax({
        type: "GET",
        contentType: 'application/json',
        url: "adminChangeStuPwd",
        dataType: "json",
//        async:true,
        data:{'newPassword':newPassword,'userId': userid},
        
        success: function(msg){// msg为返回的数据，在这里做数据绑定
       	// alert(msg)
            var data = msg.adminChangePWResult;
            if(data === 'ok'){//成功修改分组
            	alert("密码修改成功！！！");
            	location.reload();
            }else if(data === 'Permission error'){//访问数据出错了
            	alert("又有权限！！");
            	window.location.href="logout"; 
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
