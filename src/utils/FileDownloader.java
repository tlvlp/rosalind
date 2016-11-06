/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.*;
import java.io.*;

/**
 * Downloads files
 * copied from http://stackoverflow.com/a/28269150/7061661
 * @author tlvlp
 */
public class FileDownloader {
    public static Path download(String sourceUrl, String targetDirectory) throws MalformedURLException, IOException {
            URL url = new URL(sourceUrl);
            String fileName = url.getFile();
            Path targetPath = new File(targetDirectory + fileName).toPath();
            Files.copy(url.openStream(), targetPath,
                StandardCopyOption.REPLACE_EXISTING);
            return targetPath;
        }

}
