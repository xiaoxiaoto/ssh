package org.aoto.tools.upload.impl;

import java.io.File;

import org.aoto.tools.upload.IUploadFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadFile implements IUploadFile {

	@Override
	public Boolean uploadFile(String fileName, CommonsMultipartFile file,String path) {
		if (!file.isEmpty()) {
			String oldname = file.getOriginalFilename();
			String newname = fileName + oldname.substring(oldname.lastIndexOf("."));
			File localFile = new File(path, newname);
			try {
				file.getFileItem().write(localFile);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

}
