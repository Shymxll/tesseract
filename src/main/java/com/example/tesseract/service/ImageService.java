package com.example.tesseract.service;

import java.io.File;

import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
public class ImageService {

    public String getOcrText(String imagePath) {
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("tur");

        try {

            File imageFile = new File(imagePath);
            String tesseractPath = "src/main/resources/Tesseract-OCR/tessdata";
            tesseract.setDatapath(tesseractPath);
            String result = tesseract.doOCR(imageFile);

            return result;
        } catch (TesseractException e) {
            return "Error while reading image";
        }

    }

    public static String extractTextFromImage(File imageFile) {
        Tesseract tesseract = new Tesseract();
        try {
            String text = tesseract.doOCR(imageFile);
            return text;
        } catch (TesseractException e) {
            // Tesseract OCR hatası
            e.printStackTrace();
            return null;
        }
    }
}
