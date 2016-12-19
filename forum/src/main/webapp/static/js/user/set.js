$(function () {
    $("#changeEmail").click(function () {
        $("#emailForm").submit();
    });
    $("#emailForm").validate({
        errorElement:'span',
        errorClass:'text-danger',
        rules:{
            email:{
                required:true,
                email:true,
                //增加一个邮箱的远程验证
                remote:"/user/validate/email?type=1"
            }

        },
        messages:{
            email:{
                required:"请输入邮箱",
                email:"请输入正确的邮箱格式",
                remote:"邮箱已被占用"
            }
        },
        submitHandler:function (form) {
            $.ajax({
                url:"/set?action=email",
                type:"post",
                data:$(form).serialize(),
                beforeSend:function () {
                    $("#changeEmail").text("保存中...").attr("disabled","disabled");
                },
                success:function(data){
                    if(data.state == "success"){
                        alert("修改成功");
                    }
                },
                error:function(){
                    alert("服务器异常");
                },
                complete:function(){
                    $("#changeEmail").text("保存").removeAttr("disabled");
                }
            });


        }
    });
    $("#resetBtn").click(function () {
        $("#resetpassword").submit();
    });
    $("#resetpassword").validate({
        errorElement:'span',
        errorClass:'text-danger',
        rules:{
            oldpassword:{
                required:true,
                rangelength:[6,18]
            },
            newpassword:{
                required:true,
                rangelength:[6,18]
            },
            repassword:{
                required:true,
                rangelength:[6,18],
                equalTo:"#newpassword"
            }
        },
        messages:{
            oldpassword:{
                required:"请输入密码",
                rangelength:"密码长度必须为6到18位"
            },
            newpassword:{
                required:"请输入新密码",
                rangelength:"密码长度必须为6到18位"
            },
            repassword:{
                required:"请输入确认密码",
                rangelength:"密码长度必须为6到18位",
                equalTo:"两次密码不一致"
            }
        },
        submitHandler:function () {
            $.ajax({
                url:"/set?action=password"
            });
        }
    });
});
