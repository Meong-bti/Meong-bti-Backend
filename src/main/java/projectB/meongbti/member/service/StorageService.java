package projectB.meongbti.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import projectB.meongbti.member.entity.FileData;
import projectB.meongbti.member.repository.FileDataRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageService {



    private final FileDataRepository fileDataRepository;

    String folderPath = System.getProperty("user.dir");


    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String[] nameParts = fileName.split("\\.");
        String extension = nameParts[nameParts.length - 1];
        fileName = nameParts[0] + "_" + System.currentTimeMillis() + "." + extension;
        String filePath = folderPath + fileName;

            FileData fileData=fileDataRepository.save(FileData.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        if (!fileData.isPresent()) {
            throw new IOException("File not found in repository: " + fileName);
        }
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }


}
