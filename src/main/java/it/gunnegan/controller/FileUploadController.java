package it.gunnegan.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("upload")
public class FileUploadController {
    private static final String UPLOAD_DIR = "./upload";

    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam(value = "key", required = true) String key) {
        String retString = "Funziona " + key;
        return new ResponseEntity<String>(retString, HttpStatus.OK);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {

        String fileNameOrig = getFileName(file);
        String fileExtension = getFileExtension(file);
        String filename = getRandomString();

        File targetFile = getTargetFile(fileExtension, filename);

        byte[] bytes = file.getBytes();
        file.transferTo(targetFile);
        String UploadedDirectory = targetFile.getAbsolutePath();

        return filename + " - SIZE " + file.getSize();
    }

    private String getRandomString() {
		return new Random().nextInt(999999) + "_" + System.currentTimeMillis();
	}

	private File getTargetFile(String fileExtn, String fileName) {
		File targetFile = new File(UPLOAD_DIR + fileName + fileExtn);
		return targetFile;
	}

    private String getFileExtension(MultipartFile inFile) {
		String fileExtention = inFile.getOriginalFilename().substring(inFile.getOriginalFilename().lastIndexOf('.'));
		return fileExtention;
	}

    private String getFileName(MultipartFile inFile) {
		String fileName = inFile.getOriginalFilename();
		return fileName;
	}

}
