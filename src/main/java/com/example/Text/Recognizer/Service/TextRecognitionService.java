package com.example.Text.Recognizer.Service;

import ai.djl.inference.Predictor;
import com.example.Text.Recognizer.TextRecognitionRepository.TextRecognitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public class TextRecognitionService {

    @Autowired
    private TextRecognitionRepository textRecognitionRepository;

    public String recognizeText(MultipartFile file) throws IOException {
        // Load the pre-trained model.
        PretrainedModel model = textRecognitionRepository.loadModel();

        // Create a predictor for the model.
        Predictor predictor = model.newPredictor();

        // Read the image file.
        BufferedImage image = ImageIO.read(file.getInputStream());

        // Perform the text recognition.
        String recognizedText = predictor.recognizeText(image);

        return recognizedText;
    }
}