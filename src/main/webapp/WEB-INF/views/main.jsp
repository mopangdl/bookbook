<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 메인</title>
<style>
*{margin:0; padding:0; list-style:none;}
body{background:#E2F5E8; font-size:12px;}
.content-wrap{width:320px; margin:0 auto; padding-top:50px;}
.content-wrap .header_btn{background:#E2F5E8; width:320px; height:30px; display:table; padding:10px 0; position:fixed; top:0; left:50%; transform:translate(-50%, 0); z-index:10;}
.content-wrap .header_btn .write_btn{padding:0 10px; cursor:pointer; width:120px; height:30px; text-align:center; display:table-cell; vertical-align:middle; background:#22B14C; border-radius:7px; color:#fff; font-weight:bold;}
.content-wrap .list{display:flex; flex-direction:column; width:100%;}
.content-wrap .list .post_wrap{width:300px; height:400px; border-radius:10px; background:#fff; padding:15px 10px; position:relative; margin-top:15px;}
.content-wrap .list .post_wrap:first-child{margin-top:0;}
.content-wrap .list .post_wrap .profile{padding-bottom:10px; height:20px; display:flex; margin-top:10px; position:relative;}
.content-wrap .list .post_wrap .profile .profile-id{color:#22B14C; margin-left:10px;}
.content-wrap .list .post_wrap .profile .more{position:absolute; top:0; right:3px;}
.content-wrap .list .post_wrap .profile .more .ico{position:relative; width:20px; height:20px; cursor:pointer;}
.content-wrap .list .post_wrap .profile .more .ico i{display:block; width:4px; height:4px; border-radius:50%; background:#999; position:absolute; left:50%;}
.content-wrap .list .post_wrap .profile .more .ico i:nth-child(1){top:0; transform:translate(-50%, 0);}
.content-wrap .list .post_wrap .profile .more .ico i:nth-child(2){top:50%; transform:translate(-50%, -50%);}
.content-wrap .list .post_wrap .profile .more .ico i:nth-child(3){bottom:0; transform:translate(-50%, 0);}
.content-wrap .list .post_wrap .profile .more .toggle{display:block; position:absolute; top:-12px; right:22px; width:120px; height:30px; padding-top:10px; background:#fff; border:1px solid #e3e3e3; border-radius:7px; z-index:1;}
.content-wrap .list .post_wrap .profile .more .toggle span{font-size:11px; text-align: center;cursor:pointer; width: calc(50% - 1px);display: block;float: left;line-height: 20px;border-left: 1px solid #e3e3e3;}
.content-wrap .list .post_wrap .profile .more .toggle span:first-child{border-left:0;}
.content-wrap .list .post_wrap .cont{border:1px solid #e3e3e3; padding:10px; min-height:100px; max-height:160px; overflow:auto;}
.content-wrap .list .post_wrap .date_wrap{display:flex; flex-direction:row-reverse; margin-top:10px;}
.content-wrap .list .post_wrap .date_wrap .created_date{color:#999; font-size:11px;}
.content-wrap .list .post_wrap .comment-area{overflow:hidden; max-height:50px;}
.content-wrap .list .post_wrap .comment-area .comment{color:#222; display:flex;}
.content-wrap .list .post_wrap .comment-area .comment.depth-1{margin-top:5px;}
.content-wrap .list .post_wrap .comment-area .comment.depth-2{color:#999; padding-left:15px;}
.content-wrap .list .post_wrap .comment-area .comment .profile-id{color:#22B14C; white-space:nowrap;}
.content-wrap .list .post_wrap .comment-area .comment .comment-con{color:#222;}
.content-wrap .list .post_wrap .bottom_info{position:absolute; bottom:30px; left:10px; width:calc(100% - 20px);}
.content-wrap .list .post_wrap .bottom_info .count-info{display:flex; flex-direction:row-reverse;}
.content-wrap .list .post_wrap .bottom_info .count-info span{margin:5px 5px 15px 10px;}
.content-wrap .list .post_wrap .bottom_info .count-info span.count-comment{cursor:pointer;}
.content-wrap .list .post_wrap .bottom_info .btn_wrap{width:100%; display:table;}
.content-wrap .list .post_wrap .bottom_info .btn_wrap div{border:1px solid #fff; width:50%; height:30px; padding:0 10px; cursor:pointer; text-align:center; display:table-cell; vertical-align:middle; background:#22B14C; color:#fff; font-weight:bold;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="content-wrap">
        <div class="header_btn">
	        <div class="write_btn" onClick="goPostWrite();">포스트 작성하기</div>
	    </div>
		<ul class="list" id="postList">
			<li class="post_wrap">
                <div class="inner_wrap">
                    <div class="profile">
                        <span class="profile-id">아이디</span>
                        <div class="more">
                            <div class="ico">
                                <i></i>
                                <i></i>
                                <i></i>
                            </div>
                            <div class="toggle">
                                <span class="modify">수정</span>
                                <span class="delete">삭제</span>
                            </div> 
                        </div>
                    </div>
                    <div class="cont">
                        <strong class="title">제목</strong><br/>
                        내용내용
                    </div>
                    <div class="date_wrap">
                        <span class="created_date">작성일자</span>
                    </div>
                    <div class="comment-area">
                        <p class="comment depth-1">-&nbsp;<span class="profile-id">아이디</span>&nbsp;<span class="comment-con">댓글</span></p>
                        <p class="comment depth-2">ㄴ&nbsp;<span class="profile-id">아이디</span>&nbsp;<span class="comment-con">대댓글</span></p>
                    </div>
                    <div class="bottom_info">
                        <p class="count-info">
                            <span class="count-comment">댓글더보기 <b>3</b></span>
                            <span class="count-like">좋아요수 <b>0</b></span>
                        </p>
                        <div class="btn_wrap">
                            <div class="like_btn">♡ 좋아요</div>
                            <div class="comment_btn">댓글 작성</div>
                        </div>
                    </div>
                </div>
            </li>
		</ul>
	</div>
<script>
$(document).ready(function(){
	getPostList();
});

function getPostList(){
	$.ajax({
		url:'/ajax/IgPost/getPostList',
		method : 'GET',
		dataType : 'JSON',
		success : function(rlt){
			var dataResult= "";
			dataResult = rlt;
			console.log(dataResult);
			var html = '';
		    dataResult.forEach(function(item){
		    	html +='<li class="post_wrap" id="post_'+item.post_id+'">';
		    	html +='    <div class="inner_wrap">';
		    	html +='        <div class="profile">';
		    	html +='            <span class="profile-id">'+item.post_user_id+'</span>';
		    	html +='            <div class="more">';
		    	html +='                <div class="ico">';
		    	html +='                    <i></i>';
		    	html +='                    <i></i>';
		    	html +='                    <i></i>';
		    	html +='                </div>';
// 		    	html +='                <div class="toggle">';
// 		    	html +='                    <span class="modify">수정</span>';
// 		    	html +='                    <span class="delete">삭제</span>';
// 		    	html +='                </div> ';
		    	html +='            </div>';
		    	html +='        </div>';
		    	html +='        <div class="cont">';
		    	html +='            <strong class="title">'+item.post_title+'</strong><br/>';
		    	html +=             item.post_contents;
		    	html +='        </div>';
		    	html +='        <div class="date_wrap">';
		    	html +='            <span class="created_date">'+item.post_created_date+'</span>';
		    	html +='        </div>';
// 		    	html +='        <div class="comment-area">';
// 		    	html +='            <p class="comment depth-1">-&nbsp;<span class="profile-id">아이디</span>&nbsp;<span class="comment-con">댓글</span></p>';
// 		    	html +='            <p class="comment depth-2">ㄴ&nbsp;<span class="profile-id">아이디</span>&nbsp;<span class="comment-con">대댓글</span></p>';
// 		    	html +='        </div>';
		    	html +='        <div class="bottom_info">';
		    	html +='            <p class="count-info">';
		    	html +='                <span class="count-comment">댓글더보기 <b>3</b></span>';
		    	html +='                <span class="count-like">좋아요수 <b>0</b></span>';
		    	html +='            </p>';
		    	html +='            <div class="btn_wrap">';
		    	html +='                <div class="like_btn">♡ 좋아요</div>';
		    	html +='                <div class="comment_btn">댓글 작성</div>';
		    	html +='            </div>';
		    	html +='        </div>';
		    	html +='    </div>';
		    	html +='</li>';
		    });
		    $('#postList').html(html);
		},error : function(err){
			console.log(err);
		}
	})
}

function goPostWrite(){
	location.href = '/views/PostRegistForm';
}
</script>
</body>
</html>