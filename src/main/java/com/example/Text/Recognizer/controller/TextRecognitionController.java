package com.example.Text.Recognizer.controller;


import com.example.Text.Recognizer.Service.TextRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
    public class TextRecognitionController {

        @Autowired
        private TextRecognitionService textRecognitionService;

        @PostMapping("/recognize")
        public String recognizeText(@RequestParam("file") MultipartFile file) throws IOException {
            String recognizedText = textRecognitionService.recognizeText(file);
            return recognizedText;
        }
    }

