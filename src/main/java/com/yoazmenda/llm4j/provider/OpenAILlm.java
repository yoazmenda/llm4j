package com.yoazmenda.llm4j.provider;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class OpenAILlm implements LlmProvider {
    private String apiKey;
    private String modelName;
    private Double temperature;
    private Integer maxTokens;

    private OpenAiService service;

    public OpenAILlm(String apiKey, String modelName, Double temperature, Integer maxTokens) {
        this.apiKey = apiKey;
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
                .build();
        return service.createCompletion(completionRequest).getChoices().get(0).getText();
    }
}
