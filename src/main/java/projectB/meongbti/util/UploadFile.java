package projectB.meongbti.util;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class UploadFile {

    private String uploadFilename;
    private String storeFilename;

    public UploadFile() {
    }

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFilename = uploadFileName;
        this.storeFilename = storeFileName;
    }
}
