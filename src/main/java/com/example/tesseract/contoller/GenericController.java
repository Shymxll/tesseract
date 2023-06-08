package com.example.tesseract.contoller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tesseract.service.ImageService;



@Controller
public class GenericController {
    
    private ImageService imageService;

    private GenericController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public String getOcrText(Model model) {
        String imagePath = "src/main/resources/imgs/Screenshot_5.png";
        File imageFile = new File(imagePath);
        String text= this.imageService.getOcrText(imagePath);
        model.addAttribute("text", text);
        return "index";
    }
}
