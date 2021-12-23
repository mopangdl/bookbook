<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포스트 등록</title>
<style>
*{margin:0; padding:0; list-style:none;}
body{background:#E2F5E8; font-size:12px;}
.content-wrap{width:320px; margin:0 auto; padding-top:50px;}
.content-wrap .header_btn{background:#E2F5E8; width:320px; height:30px; display:table; padding:10px 0; position:fixed; top:0; left:50%; transform:translate(-50%, 0); z-index:10;}
.content-wrap .header_btn .write_btn{padding:0 10px; cursor:pointer; width:120px; height:30px; text-align:center; display:table-cell; vertical-align:middle; background:#22B14C; border-radius:7px; color:#fff; font-weight:bold;}
.content-wrap .list{display:flex; flex-direction:column; width:100%;}
.content-wrap .list .post_wrap{width:300px; height:400px; border-radius:10px; background:#fff; padding:15px 10px; position:relative; margin-top:15px;}
.content-wrap .list .post_wrap:first-child{margin-top:0;}
.content-wrap .list .post_wrap .profile{padding-bottom:10px;}
.content-wrap .list .post_wrap .profile .profile-id{color:#22B14C; margin-left:10px;}
.content-wrap .list .post_wrap .cont{border:1px solid #e3e3e3; padding:10px; min-height:100px;}
.content-wrap .list .post_wrap .cont textarea{min-height:100px; resize:none; width:100%;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="content-wrap">
	<div class="header_btn">
	    <div class="write_btn" onClick="registPost();">포스트 등록하기</div>
	</div>
	<ul class="list">
	    <li class="post_wrap">
	        <div class="inner_wrap">
	            <div class="profile">
	                <span class="profile-id">* 아이디 : <input type="text" id="postUserId"></span><br/>         
	                <span class="profile-pw">* 패스워드 : <input type="text" id="postUserPw"></span>
	            </div>
	            <div class="cont">
	                <strong class="title">* 제목</strong><input type="text" id="postTitle"><br/>
	                <textarea id="postContents" placeholder="내용입력"></textarea>
	            </div>
	        </div>
	    </li>
	</ul>
</div>
<script>
function registPost(){
	console.log("등록하기 클릭");
	var postUserId = $('#postUserId').val();
    var postUserPw = $('#postUserPw').val();
	var postTitle = $('#postTitle').val();
    var postContents = $('#postContents').val();
    var params = {
    		post_user_id : postUserId,
    		post_password : postUserPw,
    		post_title :postTitle,
    		post_contents : postContents
        };
    console.log(params)
    $.ajax({
        url : '/ajax/IgPost/insertPost',
        method : 'POST',
        data : JSON.stringify(params),
        success : function(rlt){
            console.log(rlt);
            console.log(rlt.result);
            console.log(rlt.reason);
            if(rlt.result == 'success'){
                alert('등록되었습니다.');
                location.href = '/views/main';
            }else{
                alert('뭔가 잘못');
            }
        },
        error : function(err){
            console.log(err);
        }
    })
}
</script>
</body>
</html>