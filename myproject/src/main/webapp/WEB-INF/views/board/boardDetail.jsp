<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NOTICE</title>

<!-- 웹폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">

<!-- jquery -->
<script src="../../resources/js/jquery.js"></script>

<!-- js-->
<script type="text/javascript" src="../../resources/js/comment.js"></script>
<script type="text/javascript" src="../../resources/js/getAttach.js"></script>

<!-- bootstrap -->
<script src="../../resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="../../resources/css/bootstrap.css">

<!-- css -->
<link rel="stylesheet" href="../../resources/css/boardDetail.css">
</head>
<body>
	<div id="wrap">
    	<div class="content">
            <h2>${bdetail.title}</h2>
            <div class="board_area">
                <div class="board_info">
                    <input type="hidden" id="bno" value="${bdetail.bno}">
                    <span class="writer">${bdetail.writer}</span>
                    <span class="regdate">${bdetail.regdate}</span>
                    <span class="count">${bdetail.count}</span>
                </div>
            
                <div class="board_content">
                	${bdetail.content}	
                </div>
                <div id="preview">
                	<ul></ul>
                </div>
                
                <!-- 좋아요 -->
               	<div class="good">
	               	<div id="goodBtn"><img src="../../resources/img/good_empty.png" id="goodImg"></div>
	               	<div id="goodCnt">${goodCnt}</div>
                </div>
			</div>
                
           <!-- 댓글 -->
           <div id="comment">
               <c:if test="${login==null}">
               <div class="c_header">
               	! 댓글을 쓸 권한이 없습니다. <a href="/login">로그인</a>
               </div>
               </c:if>
               <div class="c_container">
                   <ul id="c_area">
   
                   </ul>
               </div>
			<c:if test="${login!=null}">
			<div class="c_footer">				
                   <input type="hidden" id="replyer" name="replyer" value="${login.name}">
                   <textarea id="reply" name="reply" class="c_reply" placeholder="내용을 작성해주세요."></textarea>
                   <button id="addRpl" class="c_addRpl">등록</button>
            </div>
			</c:if>
           	</div> <!-- #comment -->
            
            <div class="board_footer">
                <input type="button" class="listBtn" value="목록" onclick="location.href='/board?bgno='+${bdetail.bgno}">
                <input type="button" class="removeBtn" value="삭제" onclick="location.href='/board/remove?bgno='+${bdetail.bgno}+'&bno='+${bdetail.bno}">
                <input type="submit" class="modifyBtn" value="수정" onclick="location.href='/board/modify?bno='+${bdetail.bno}">
            </div>
        
            <div class="modal fade" id="modifyModal" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">댓글 수정창</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                   <input type="hidden" id="replyNo" name="replyNo" readonly>
                                <input type="hidden" id="replyWriter" name="replyWriter" readonly>
                                <label for="replyText">댓글 내용</label>
                                <input class="form-control" id="replyText" name="replyText">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default pull-left" data-dismiss="modal">닫기</button>
                            <button type="button" class="btn btn-success modalModBtn">수정</button>
                            <button type="button" class="btn btn-danger modalDelBtn">삭제</button>
                        </div>
                    </div>
                </div>
             </div> <!-- .modal -->
        </div> <!--.content-->
        <%@include file="../footer.jsp" %>
    </div>
    <!-- 좋아요 -->
	<script>
		var goodVal=${goodChk};
		
		if(goodVal>0){ // 좋아요 눌렀을 때
			console.log(goodVal); // 확인용
			console.log("좋아요 누름");
			$("#goodImg").prop("src", "../../resources/img/good_full.png");
			$("#goodBtn").prop("name", goodVal);
		} else{ // 좋아요 안 눌렀을 때
			console.log(goodVal); // 확인용
			console.log("좋아요 안 누름");
			$("#goodImg").prop("src", "../../resources/img/good_empty.png");
			$("#goodBtn").prop("name", goodVal);
		}
		
		$("#goodBtn").on("click", function(){
			$.ajax({
				url: "/good",
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify({
					bno: '${bdetail.bno}',
					goodVal: $("#goodBtn").prop("name")
				}),
				success: function(data){
					console.log(data);
					$("#goodBtn").prop("name", data.goodVal);
					if(data.goodVal==0){
						$("#goodImg").prop("src", "../../resources/img/good_empty.png");
						$("#goodCnt").html(data.goodCnt);
					} else{
						$("#goodImg").prop("src", "../../resources/img/good_full.png");
						$("#goodCnt").html(data.goodCnt);
					}
				},
				error: function(){
					alert("로그인을 해주세요.");
				}
			})
		})
	</script>
</body>
</html>