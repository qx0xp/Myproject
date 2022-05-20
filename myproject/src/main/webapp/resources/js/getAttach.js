$(document).ready(function(){
	// 방식 get, 조건 bno
	var bno=$("#bno").val();
	
	$.getJSON("/board/attach", {bno:bno}, function(list){
		// select후, boardDetail에 출력
		console.log(list);
		
		var str="";
		$(list).each(function(i, attach){
			// 이미지면 출력
			if(attach.image){
				str+="<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-image='"+attach.image+"'>";
				str+="<img src='/display?fileName="+encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName)+"'>";
				str+="</li>";
				
			} else{
				// 이미지 아니면 링크 클릭하여 다운 처리
				str+="<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-image='"+attach.image+"'>";
				str+="<a href='/download?fileName="+encodeURIComponent(attach.uploadPath+"/"+attach.uuid+"_"+attach.fileName)+"'>"+attach.fileName+"</a>";
				str+="</li>";
			}
		})
		
		$("#preview ul").html(str);
	})
})