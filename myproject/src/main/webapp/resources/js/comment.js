$(document).ready(function(){
	// 게시글 번호 불러오기
	var bno=$("#bno").val();
	
	// DB SELECT 불러오는 함수 호출
	list(bno);
	
	// 댓글 쓰기 버튼 클릭
	$("#addRpl").on("click", function(){
		// db insert 함수 호출
		add({reply:$("#reply").val(), replyer:$("#replyer").val(), bno:bno});
		$("#reply").val("");
	})
	
	// 옵션 버튼 클릭
	$("#c_area").on("click", "a", function(e){
		e.preventDefault(); // 고유 이벤트 중지
		var rno=$(this).data("rno");
		$("#replyNo").val(rno);
		
		rplGet(rno);
		
		if($(this).hasClass("modifyRpl")){
			$(".modal-title").html("댓글 수정");
			$(".modalDelBtn").hide();
			$(".modalModBtn").show();
		}
		else if($(this).hasClass("removeRpl")){
			$(".modal-title").html("댓글 삭제");
			$(".modalModBtn").hide();
			$(".modalDelBtn").show();
		}
		
		$(".modal").modal("show");
	})
	
	// 모달 내 수정 버튼 클릭
	$(".modalModBtn").on("click", function(){
		modify({reply:$("#replyText").val(), rno:$("#replyNo").val(), bno:bno});
	})
	
	// 모달 내 삭제 버튼 클릭
	$(".modalDelBtn").on("click", function(){
		remove({rno:$("#replyNo").val(), bno:bno});
	})
	
}) // document.ready 종료

// 함수 선언
// 댓글 작성
function add(reply){
	$.ajax({
		type:"post",
		url:"/replies/new",
		// JSON 객체를 String 객체로 변환
		data:JSON.stringify(reply),
		// 보내는 자원 형식 명시, 헤더에 실리는 정보
		contentType:"application/json; charset=utf-8",
		success:function(result){
			if(result=="success"){
				// 작성이 성공되었을 때 새 댓글이 보이게
				list(reply.bno);
			}
		}
	})
}

// 댓글 목록 리스트
function list(bno){
	// ajax 이용하여 DB에 SELECT
	// get방식일 때 한정적 사용
	$.getJSON("/replies/list/"+bno+".json", function(data){		
		var str="";
		for(var i=0; i<data.length; i++){
			str+="<li data-rno='"+data[i].rno+"'>";
			str+="<div class='c_title'>";
			str+="<span id='c_replyer'><strong>"+data[i].replyer+"</strong></span>";
			str+="<span id='c_replyDate'>"+data[i].replyDate+"</span>";
			str+="</div>"
			str+="<div id='c_reply'>"+data[i].reply+"</div>";
			str+="<div class='c_option'>";
			str+="<a href='#' data-rno='"+data[i].rno+"' class='modifyRpl'>수정</a>";
			str+="<a href='#' data-rno='"+data[i].rno+"' class='removeRpl'>삭제</a>";
			str+="</div>";
			str+="</li>";
		}
		$("#c_area").html(str);
	})
}

// 모달창에 댓글 내용 select
function rplGet(rno){
	$.getJSON("/replies/detail/"+rno+".json", function(data){
		$("#replyNo").val(data.rno);
		$("#replyWriter").val(data.replyer);
		$("#replyText").val(data.reply);
	})
}

// 댓글 수정
function modify(reply){
	$.ajax({
		type:"put",
		url:"/replies/modify",
		data:JSON.stringify(reply),
		contentType:"application/json; charset=utf-8",
		success:function(result){
			if(result=="success"){
				$(".modal").modal("hide");
				list(reply.bno);
			}
		}
	})
}

// 댓글 삭제
function remove(reply){
	$.ajax({
		type:"delete",
		url:"/replies/remove/"+reply.rno,
		success:function(result){
			if(result=="success"){
				$(".modal").modal("hide");
				list(reply.bno);
			}
		}
	})
}