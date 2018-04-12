package pack.upload;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FileValidator implements Validator {

	//파일 유무 확인용
	public boolean supports(Class<?> arg0) {
	
		return false;
	}
	
	public void validate(Object upFile, Errors errors) {
		UploadFile file = (UploadFile)upFile;
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file", ""," 업로드할 파일을 선택하시오");
		}
	}
}
