package com.yoazmenda.llm4j.provider;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenAILlm implements LlmProvider {

    private static final Logger logger = LoggerFactory.getLogger(OpenAILlm.class);

    private String modelName;
    private Double temperature;
    private Integer maxTokens;
    private OpenAiService service;

    public OpenAILlm(String apiKey, String modelName, Double temperature, Integer maxTokens) {
        this.modelName = modelName;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        service = new OpenAiService(apiKey);
    }

    @Override
    public String getCompletions(String prompt) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model(modelName)
                .maxTokens(maxTokens)
                .temperature(temperature)
                .n(1)
                .build();
        logger.debug("completion request: {}", completionRequest.toString());
        String response = service.createCompletion(completionRequest).getChoices().get(0).getText();
        logger.debug("completion response: {}", response);
        return response;
    }
}
