package pack.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping(value="upload", method=RequestMethod.GET)
	public String getUploadForm() {
		return "uploadform";
	}
	
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public ModelAndView submitUpload(
			@ModelAttribute("uploadFile") UploadFile uploadFile,
			BindingResult result	) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		// 에러 검사 : 업로드 파일 유무 
		MultipartFile file = uploadFile.getFile();
		fileValidator.validate(uploadFile, result);
		
		String fileName = file.getOriginalFilename();
		if(result.hasErrors()) {
			//업로드할 파일을 선택하지 않은 경우 form에 에러 메세지를 출력함
			return new ModelAndView("uploadform");
		}
		
		try {
			inputStream = file.getInputStream();
			
			File newFile = new File("c:/work/upload/" + fileName);
			if(newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];
			
			while((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes,0,read);
			}
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		return new ModelAndView("uploadfile", "filename", fileName);
	}
}










