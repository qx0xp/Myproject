$(document).ready(function(){
	$("#searchBtn").on("click", function(e){
		if($("#type").val()==""){
			alert("검색 종류를 선택하세요.");
			return false;
		}
		
		if($("#keyword").val().length==0){
			alert("키워드를 입력하세요.");
			return false;
		}
		
		// 검색 버튼 클릭 시, 무조건 1페이지부터 검사
		$("#pageNum").val("1");
		
		$("#searchForm").submit();
	})
	
	$(".pageNo").on("click", function(e){
		e.preventDefault();
		$("#pageNum").val($(this).attr("href"));
		
		$("#searchForm").submit();
	})
})