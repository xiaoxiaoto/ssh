package org.aoto.tools.upload;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface IUploadFile {
public Boolean uploadFile(String fileName,CommonsMultipartFile  file,String path);
}
