function upLoadImage()
{
	var userid = $('#student_id').val();
	var formData = new FormData();
    formData.append('file',$("#file")[0].files[0]); 
    formData.append('studentid', userid);
	$.ajax({
		type:"post",
        url:"uploadImage",
		async:false,
        contentType: false,    //这个一定要写
        processData: false, //这个也一定要写，不然会报错
        data:formData,  
        success: function(msg){// msg为返回的数据，在这里做数据绑定
            var data = msg.uploadResult;
            if(data === 'ok'){//成功修改分组
            	alert("图片修改成功！！！");
            }else if(data === 'studentid error'){//访问数据出错了
            	alert("学生信息错误！！");
           // 	window.location.href="../logout"; 
            }else if(data === 'imagename error'){//访问数据出错了
            	alert("图片格式错误！！");
                // 	window.location.href="../logout"; 
            }else if(data === 'user error'){//访问数据出错了
            	alert("用户信息错误！！");
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