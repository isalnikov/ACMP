/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.sportloto;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author i.salnikov
 */
public class FileLoader {

    public static void main(String[] args) throws MalformedURLException, IOException {
        InputStream input = new URL("https://totalutil-test-processing.azurewebsites.net/downloadfile?terminal_Id=2000006703&file_Id=9ae9f8d0-4ca5-4139-ac3a-9a13374eb5ef").openStream();
        ZipInputStream zis = new ZipInputStream(input);
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println(entry);
        }
    }
}
