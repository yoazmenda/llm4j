package com.yoazmenda.llm4j.provider;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoazmenda.HuggingFaceInference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HuggingFaceLlm implements LlmProvider {

    private static final Logger logger = LoggerFactory.getLogger(HuggingFaceLlm.class);
    private final HuggingFaceInference huggingFaceInference;

    public HuggingFaceLlm(String repoId, String apiKey, Double temperature, Integer maxTokens) {
        huggingFaceInference = new HuggingFaceInference(repoId, apiKey, temperature, maxTokens);
    }

    @Override
    public String getCompletions(String prompt) throws IOException {
        logger.debug("completion request: {}", prompt);
        String response = huggingFaceInference.infer(prompt);

        // Parse the JSON response using Jackson
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response);
        String generatedText = rootNode.get(0).get("generated_text").asText();

        logger.debug("completion response: {}", generatedText);
        return generatedText;
    }
}
