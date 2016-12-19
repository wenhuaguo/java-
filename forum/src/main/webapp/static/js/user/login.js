$(function () {
    $("#loginBtn").click(function () {
        $("#loginForm").submit();
    });
    $("#loginForm").validate({
        errorElement:'span',
        errorClass:'tetx-danger',
        rules:{
            username:{
                required:true,
                minlength:3,
            },
            password:{
                required:true,
                rangelength:[6,18]
            }
        },
        messages:{
            username:{
                required:"请输入账号",
                minlength:"账号长度不能小于3位",
            },
            password:{
                required:"请输入密码",
                rangelength:"密码长度为6到18位"
            }
        },
        submitHandler:function (form) {
            $.ajax({
                url:"/login",
                type:"post",
                data:$(form).serialize(),
                beforeSend:function () {
                  $("#loginBtn").text("登录中...").attr("disabled","disabled");
                },
                success:function (data) {
                    if(data.state == "success"){
                        alert("登录成功");
                        window.location.href = "/home"
                    }else {
                        alert(data.message);
                    }
                },
                complete:function () {
                    $("#loginBtn").text("登录").removeAttr("disabled");
                }
            });
        }
    });
});
