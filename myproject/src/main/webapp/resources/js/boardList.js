$(document).ready(function(){
	$("#searchBtn").on("click", function(){
		if($("#keyword").val()==""){
			alert("키워드를 입력하세요.");
			return false;
		}
		
		$("#pageNum").val("1");
		$("#searchForm").submit();
	})
	
	$(".pageNo").on("click", function(e){
		e.preventDefault();
		
		$("#pageNum").val($(this).attr("href"));
		$("#searchForm").submit();
	})
})