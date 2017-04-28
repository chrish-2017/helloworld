<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" />
<title>JSSDk配置</title>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
    function jssdk() {
        $.ajax({
            url : "http://chrish.ngrok.cc/jssdk",
            type : 'post',
            dataType : 'json',
            contentType : "application/x-www-form-urlencoded; charset=utf-8",
            data : {
                'url' : location.href.split('#')[0]
            },
            success : function(data) {
                wx.config({
                    debug : false,
                    appId : data.data.appId,
                    timestamp : data.data.timestamp,
                    nonceStr : data.data.nonceStr,
                    signature : data.data.signature,
                    jsApiList : [ 'checkJsApi', 'onMenuShareTimeline',
                            'onMenuShareAppMessage', 'onMenuShareQQ',
                            'onMenuShareWeibo', 'hideMenuItems',
                            'showMenuItems', 'hideAllNonBaseMenuItem',
                            'showAllNonBaseMenuItem', 'translateVoice',
                            'startRecord', 'stopRecord', 'onRecordEnd',
                            'playVoice', 'pauseVoice', 'stopVoice',
                            'uploadVoice', 'downloadVoice', 'chooseImage',
                            'previewImage', 'uploadImage', 'downloadImage',
                            'getNetworkType', 'openLocation', 'getLocation',
                            'hideOptionMenu', 'showOptionMenu', 'closeWindow',
                            'scanQRCode', 'chooseWXPay',
                            'openProductSpecificView', 'addCard', 'chooseCard',
                            'openCard' ]
                });
            }
        });
    }
 
    window.onload = function() {
        jssdk();
    };
    
    $(document).ready(function(){
        $(".choose").click(function(){
            wx.ready(function () {
                wx.chooseImage({
                    count: 1, // 默认9
                    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
                    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
                    success: function (res) {
                        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
                        $(".choose").attr("id", localIds);
                        $("<img/>").attr("src", localIds).appendTo($("body"));
                    }
                });
            });
            
        });
        $(".upload").click(function(){
            wx.ready(function () {
                wx.uploadImage({
                    localId: $(".choose").attr("id"), // 需要上传的图片的本地ID，由chooseImage接口获得
                    isShowProgressTips: 1, // 默认为1，显示进度提示
                    success: function (res) {
                        var serverId = res.serverId; // 返回图片的服务器端ID
                        $(".upload").attr("id", serverId);
                    }
                });
            });
            
        });
        $(".download").click(function(){
            wx.ready(function () {
                wx.downloadImage({
                    serverId: $(".upload").attr("id"), // 需要下载的图片的服务器端ID，由uploadImage接口获得
                    isShowProgressTips: 1, // 默认为1，显示进度提示
                    success: function (res) {
                        var localId = res.localId; // 返回图片下载后的本地ID
                        $(".download").attr("id", localId);
                        $("<img/>").attr("src", localId).appendTo($("body"));
                    }
                });
            });
            
        });
    });
</script>
</head>
<body>
<button type="button" class="choose">选择</button>
<button type="button" class="upload">上传</button>
<button type="button" class="download">下载</button>
</body>
</html>
