package com.example.Text.Recognizer.TextRecognitionRepository;

import ai.djl.MalformedModelException;
import ai.djl.Model;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.translator.ImageClassificationTranslator;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelNotFoundException;
import ai.djl.repository.zoo.ModelZoo;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.zoo.PretrainedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.io.IOException;

@Repository
public class TextRecognitionRepository {

    @Autowired
    private ModelZoo modelZoo;




    public PretrainedModel loadModel() throws IOException {
        // Download the pre-trained model.
        PretrainedModel model = modelZoo.loadModel("PaddleOCR");

       // Model model = Model.load(PaddleOCR);  To load Local pre trained Model

        return model;
    }
}