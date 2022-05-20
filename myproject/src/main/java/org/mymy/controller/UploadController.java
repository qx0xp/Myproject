package org.mymy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.mymy.model.AttachFileDTO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public void uploadFileGet() {}
	
	// 현재 날짜 메서드
	private String getFolder() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date(); // 현재 날짜
		String str=sdf.format(date);
		return str.replace("-", File.separator); // "-" -> 원화 표시로 변경
	}
	
	// 이미지 타입 검사 메서드(이미지=1)
	private boolean checkImgType(File file) {
		// 예외 필요
		try {
			// Files.probeContentType(): 파일 확장자를 통해 마임타입 판단, 확장자 없으면 null
			// File.toPath(): File객체를 Path객체로 변환
			String contentType=Files.probeContentType(file.toPath());
			// startsWith(): 어떤 문자열이 특정 문자로 시작하는지 확인, 리턴타입 boolean
			return contentType.startsWith("image");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 파일 업로드
	@RequestMapping(value="/upload", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.POST)
	public ResponseEntity<ArrayList<AttachFileDTO>> uploadFilePost(MultipartFile[] uploadFile) {
		// ArrayList list 생성
		ArrayList<AttachFileDTO> list=new ArrayList<>();
		String uploadFolder="D:\\fileUpload";
		// 폴더 생성
		File uploadPath=new File(uploadFolder, getFolder());
		// 만약 폴더가 없을 때
		if(!uploadPath.exists()) {
			uploadPath.mkdirs(); // 한 번에 여러 디렉토리 생성
		}
		
		for(int i=0; i<uploadFile.length; i++) {
			// DTO 생성
			AttachFileDTO attachDTO=new AttachFileDTO();
			System.out.println("실파일명" + uploadFile[i].getOriginalFilename());
			System.out.println("실파일크기" + uploadFile[i].getSize());
			
			// 중복명 방지
			// 실파일명
			String uploadFileName=uploadFile[i].getOriginalFilename();
			attachDTO.setFileName(uploadFileName);
			// UUID 문자열 생성, 리턴타입 UUID
			UUID uuid=UUID.randomUUID();
			// 업로드 파일명=UUID+"_"+실파일명
			uploadFileName=uuid.toString()+"_"+uploadFileName;
			attachDTO.setUuid(uuid.toString()); // UUID 리턴타입 UUID
			attachDTO.setUploadPath(getFolder());
			// File객체 생성, 저장 경로에 업로드 파일명 매치
			File saveFile=new File(uploadPath, uploadFileName);
			
			try {
				// transferTo(): 저장 경로에 실질적으로 파일 저장
				uploadFile[i].transferTo(saveFile); // transferTo: 예외 필요
				
				// 이미지 타입이면 썸네일 생성
				if(checkImgType(saveFile)) {
					attachDTO.setImage(true);
					// 원본 파일 그대로 두고 썸네일 생성
					// FileOutputStream(): 주어진 파일을 쓰기 위한 객체 생성, 기존 파일 존재하면 지우고 새 파일 생성
					FileOutputStream thumbnail=new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
					// 이미지 복사, 썸네일, 너비, 높이 
					// InputStream은 데이터를 읽어들이는 통로
					Thumbnailator.createThumbnail(uploadFile[i].getInputStream(), thumbnail, 100, 100);
					// 메모리에서 썸네일 회수
					thumbnail.close();
				}
				list.add(attachDTO); // 인자로 전달된 객체를 어레이리스트에 추가
				System.out.println("list:" + list); // 들어감 확인
			} catch(Exception e) {
				e.getMessage();
			}
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	// 이미지 주소 설계
	// <img src="display?fileName='파일 경로와 파일명'">
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public ResponseEntity<byte[]> getFile(String fileName) {
		File file=new File("D:\\fileUpload\\"+fileName);
		System.out.println("img주소설계:" + file); // 확인
		ResponseEntity<byte[]> result=null;
		
		try {
			HttpHeaders headers=new HttpHeaders();
			headers.add("Content-Type", Files.probeContentType(file.toPath()));
			result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
			// 지정 File내용을 byte[]로 복사
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 이미지 파일 아니면 다운로드 걸기
	// application/octet-stream 지정
	@RequestMapping(value="/download", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE, method=RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile(String fileName){
		// Resource인터페이스 : 저수준 리소스에 대한 액세스를 추상화하기 위한 인터페이스
		Resource resource=new FileSystemResource("D:\\uploadFile\\"+fileName);
		String resourceName=resource.getFilename();
		HttpHeaders headers=new HttpHeaders();
		try {
			// 다운로드 했을 때 파일명 한글 깨짐 방지
			headers.add("Content-Disposition", "attachment;fileName="+new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
