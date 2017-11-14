package com.concretepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.concretepage.service.FileService;

@Controller
@RequestMapping("file")
public class FileUploadController {

	@Qualifier("fileService")
	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@PostMapping("/upload")
	public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) {
		String name = file.getOriginalFilename();
		if (!file.isEmpty()) {
			try {

				fileService.readFile(file);
				
				// byte[] bytes = file.getBytes();
				// BufferedOutputStream stream = new BufferedOutputStream(new
				// FileOutputStream(new File(name)));
				// stream.write(bytes);
				// stream.close();

				return "You successfully uploaded " + name + " into " + name + "-uploaded !";

			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

}
