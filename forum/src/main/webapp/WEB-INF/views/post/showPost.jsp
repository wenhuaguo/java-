<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2016/12/20
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>凯盛IT-${requestScope.post.title}</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/2.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/js/editer/styles/simditor.css">
    <link rel="stylesheet" href="/static/js/highlight/styles/solarized-light.css">
    <style>
        body{
            background-image: url(img/bg.jpg);
        }
        .simditor .simditor-body {
            min-height: 100px;
        }
    </style>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!--header-bar end-->

<div class="container">
    <div class="box">
        <ul class="breadcrumb" style="background-color: #fff;margin-bottom: 0px;">
            <li><a href="/login">首页</a> <span class="divider">/</span></li>
            <li class="active">${requestScope.post.node.nodename}</li>
        </ul>
        <div class="topic-head">
            <img class="img-rounded avatar" src="${requestScope.post.user.avatar}?imageView2/1/w/60/h/60" alt="">
            <h3 class="title">${requestScope.post.title}</h3>
            <p class="topic-msg muted"><a href="/set">${requestScope.post.user.username}</a><span>${requestScope.post.createtime}</span><span id="showTime"></span></p>
        </div>
        <div class="topic-body">
           ${requestScope.post.content}
        <div class="topic-toolbar">
            <ul class="unstyled inline pull-left">
                <li><a href="javascript:;" id="save">加入收藏</a></li>
                <li><a href="javascript:;" id="thank">感谢</a></li>
                <li><a href=""></a></li>
            </ul>
            <ul class="unstyled inline pull-right muted">
                <li>${requestScope.post.clicknum}次点击</li>
                <li id="saveNum">${requestScope.post.savenum}人收藏</li>
                <li id="thankNum">${requestScope.post.thanknum}人感谢</li>
            </ul>
        </div>
    </div>
    <!--box end-->

    <div class="box" style="margin-top:20px;">
        <div class="talk-item muted" style="font-size: 12px">
            个回复 | 直到2015年12月25日 22:23:34
        </div>
        <c:forEach items="${requestScope.replyList}" var="reply">
            <div class="talk-item">
                <table class="talk-table">
                    <tr>
                        <td width="50">
                            <img class="avatar" src="${reply.avatar}?imageView2/1/w/40/h/40" alt="">
                        </td>
                        <td width="auto">
                            <a href="" style="font-size: 12px">${reply.user.username}</a> <span style="font-size: 12px" class="reply">4小时前</span>
                            <br>
                            <p style="font-size: 14px">${reply.content}</p>
                        </td>
                        <td width="70" align="right" style="font-size: 12px">
                            <a href="" title="回复"><i class="fa fa-reply"></i></a>&nbsp;
                            <span class="badge">1</span>
                        </td>
                    </tr>
                </table>
            </div>
        </c:forEach>
        <div class="talk-item">
            <table class="talk-table">
                <tr>
                    <td width="50">
                        <img class="avatar" src="http://7xp5t4.com1.z0.glb.clouddn.com/Fqb8f9uDknAt2ilBoY-ipSZRMes-?imageView2/1/w/40/h/40" alt="">
                    </td>
                    <td width="auto">
                        <a href="" style="font-size: 12px">fankay</a> <span style="font-size: 12px" class="reply">4小时前</span>
                        <br>
                        <p style="font-size: 14px">不知道国内有哪些公司开始用 react-native 了呢？我就知道天猫 Pad 版部分</p>
                    </td>
                    <td width="70" align="right" style="font-size: 12px">
                        <a href="" title="回复"><i class="fa fa-reply"></i></a>&nbsp;
                        <span class="badge">1</span>
                    </td>
                </tr>
            </table>
        </div>

        <div class="talk-item">
            <table class="talk-table">
                <tr>
                    <td width="50">
                        <img class="avatar" src="http://7xp5t4.com1.z0.glb.clouddn.com/Fqb8f9uDknAt2ilBoY-ipSZRMes-?imageView2/1/w/40/h/40" alt="">
                    </td>
                    <td width="auto">
                        <a href="" style="font-size: 12px">fankay</a> <span style="font-size: 12px" class="reply">4小时前</span>
                        <br>
                        <p style="font-size: 14px">不知道国内有哪些公司开始用 react-native 了呢？我就知道天猫 Pad 版部分</p>
                    </td>
                    <td width="70" align="right" style="font-size: 12px">
                        <a href="" title="回复"><i class="fa fa-reply"></i></a>&nbsp;
                        <span class="badge">2</span>
                    </td>
                </tr>
            </table>
        </div>

        <div class="talk-item">
            <table class="talk-table">
                <tr>
                    <td width="50">
                        <img class="avatar" src="http://7xp5t4.com1.z0.glb.clouddn.com/Fqb8f9uDknAt2ilBoY-ipSZRMes-?imageView2/1/w/40/h/40" alt="">
                    </td>
                    <td width="auto">
                        <a href="" style="font-size: 12px">fankay</a> <span style="font-size: 12px" class="reply">4小时前</span>
                        <br>
                        <p style="font-size: 14px">不知道国内有哪些公司开始用 react-native 了呢？我就知道天猫 Pad 版部分</p>
                    </td>
                    <td width="70" align="right" style="font-size: 12px">
                        <a href="" title="回复"><i class="fa fa-reply"></i></a>&nbsp;
                        <span class="badge">3</span>
                    </td>
                </tr>
            </table>
        </div>

        <div class="talk-item">
            <table class="talk-table">
                <tr>
                    <td width="50">
                        <img class="avatar" src="http://7xp5t4.com1.z0.glb.clouddn.com/Fqb8f9uDknAt2ilBoY-ipSZRMes-?imageView2/1/w/40/h/40" alt="">
                    </td>
                    <td width="auto">
                        <a href="" style="font-size: 12px">fankay</a> <span style="font-size: 12px" class="reply">4小时前</span>
                        <br>
                        <p style="font-size: 14px">不知道国内有哪些公司开始用 react-native 了呢？我就知道天猫 Pad 版部分</p>
                    </td>
                    <td width="70" align="right" style="font-size: 12px">
                        <a href="" title="回复"><i class="fa fa-reply"></i></a>&nbsp;
                        <span class="badge">4</span>
                    </td>
                </tr>
            </table>
        </div>

        <div class="talk-item">
            <table class="talk-table">
                <tr>
                    <td width="50">
                        <img class="avatar" src="http://7xp5t4.com1.z0.glb.clouddn.com/Fqb8f9uDknAt2ilBoY-ipSZRMes-?imageView2/1/w/40/h/40" alt="">
                    </td>
                    <td width="auto">
                        <a href="" style="font-size: 12px">fankay</a> <span style="font-size: 12px" class="reply">4小时前</span>
                        <br>
                        <p style="font-size: 14px">不知道国内有哪些公司开始用 react-native 了呢？我就知道天猫 Pad 版部分</p>
                    </td>
                    <td width="70" align="right" style="font-size: 12px">
                        <a href="" title="回复"><i class="fa fa-reply"></i></a>&nbsp;
                        <span class="badge">50</span>
                    </td>
                </tr>
            </table>
        </div>

    </div>
        <c:choose>
            <c:when test="${not empty sessionScope.curr_user}">
                <div class="box" style="margin:20px 0px;">
                    <a name="reply"></a>
                    <div class="talk-item muted" style="font-size: 12px"><i class="fa fa-plus"></i> 添加一条新回复</div>
                    <form action="" style="padding: 15px;margin-bottom:0px;" id="replyForm">
                        <input type="hidden" value="${requestScope.post.id}" name="postId">
                        <textarea name="content" id="editor"></textarea>
                    </form>
                    <div class="talk-item muted" style="text-align: right;font-size: 12px">
                        <span class="pull-left">请尽量让自己的回复能够对别人有帮助回复</span>
                        <button class="btn btn-primary" id="replyBtn">发布</button>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                    <div class="talk-item muted" style="text-align: left;font-size: 16px">
                        如需回复，请<a href="/login?redirect=/showPost?postId=${requestScope.post.id}#reply"><button class="btn btn-primary">登录</button></a>或<a href="/reg?redirect=/showPost?postId=${requestScope.post.id}#reply"><button class="btn btn-primary">注册</button></a>之后回复
                    </div>
            </c:otherwise>
        </c:choose>


</div>
<!--container end-->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/editer/scripts/module.min.js"></script>
<script src="/static/js/editer/scripts/hotkeys.min.js"></script>
<script src="/static/js/editer/scripts/uploader.min.js"></script>
<script src="/static/js/editer/scripts/simditor.min.js"></script>
    <script src="/static/js/jquery.validate.min.js"></script>
    <script src="/static/js/highlight/js/highlight.pack.js"></script>

<script>
    $(function(){
        var editor = new Simditor({
            textarea: $('#editor'),
            toolbar:false
            //optional options
        });
        $("#replyBtn").click(function () {
            $("#replyForm").submit();
        });
        $("#replyForm").validate({
            errorElement:'span',
            errorClass:'text-error',
            rules:{
                content:{required:true}
            },
            messages:{content:{required:"内容不能为空"}},
            submitHandler:function (form) {
                $.ajax({
                    url:"/reply",
                    type:"post",
                    data:$(form).serialize(),
                    beforeSend:function () {
                      $("#replyBtn").text("回复中...").attr("disabled","disabled");
                    },
                    success:function (data) {
                        alert("保存成功");
                        $("#editor").val("");
                    },
                    error:function () {
                        alert("服务器异常");
                    },
                    complete:function () {
                        $("#replyBtn").text("回复").removeAttr("disabled");
                    }
                });
            }
        });
        <%--function fn(way,content,count) {--%>
            <%--$.get("/showPost?type=save&&postId=${requestScope.post.id}").done(function (json) {--%>
                <%--if(json.state == "success"){--%>
                    <%--$("content").text(json.data.savenum);--%>
                <%--}--%>
            <%--}).error(function () {--%>
                <%--alert("服务器异常");--%>

            <%--});--%>
        <%--}--%>
        $("#save").click(function () {
            $.get("/showPost?type=save&&postId=${requestScope.post.id}").done(function (json) {
                if(json.state == "success"){
                    $("#saveNum").text(json.data.savenum +"人收藏");
                    alert("收藏成功");
                }
            }).error(function () {
                alert("服务器异常");

            });
        });
        $("#thank").click(function () {
            $.get("/showPost?type=thank&&postId=${requestScope.post.id}").done(function (json) {
                if(json.state == "success"){
                    $("#thankNum").text(json.data.thanknum +"感谢");
                    alert("感谢成功");
                }
            }).error(function () {
                alert("服务器异常");

            });
        });
        hljs.initHighlightingOnLoad();

    });
</script>

</body>
</html>
