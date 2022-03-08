/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Services;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kristian
 */
@Service
public class ManagerUploadedFilesService {
    
    private String rootDir;
    private String destinationDir;
    private String subDir;
    
    {
        rootDir= System.getProperty("user.dir");
        destinationDir= rootDir.concat("/src/main/resources/static/images/");
        subDir="uploaded/";
    }
    
    public String store(MultipartFile file) {
        
        String newNameFile = sanitizeNameFile(file.getOriginalFilename());
        
        try {
                file.transferTo(new File(destinationDir.concat(subDir).concat(newNameFile)));
                return subDir.concat(newNameFile);
                
            } catch (IOException e) {
                System.out.println(e);
            }
        return null;
    }
    
    private String generateShortId(int length){
        String Characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder id = new StringBuilder();
        while(length-- > 0){
            int getRandomCharacter = (int) (Math.random() * Characters.length());
            id.append(Characters.charAt(getRandomCharacter));
        }
        return id.toString();
    }
    
    private String sanitizeNameFile(String namefile){
        String id = generateShortId(5);
        namefile = namefile.replace(" ", "-");
        namefile = id.concat("-").concat(namefile);
        return namefile;
    }
    
}