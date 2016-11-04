package com.mmk.common.tool;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {
	
	private Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(value = "/image/upload")
	@ResponseBody
	public Map<String, Object> upload(MultipartFile file, String callback) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (file.getSize() > 0) {
			try {
				String imageUrl = FileClient.getDefault().upload("tuan", file).getImageUrl();
				result.put("success", true);
				 result.put("file", imageUrl);
				 result.put("callback", callback);
				 
			} catch (IOException e) {
				result.put("success", false);
				result.put("message", e.getMessage());
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		return result;
	}
}
