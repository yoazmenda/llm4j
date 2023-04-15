package com.yoazmenda.llm4j.provider;

public class HuggingFaceLlm implements LlmProvider {
    private String apiKey;
    private String modelName;
    private Integer maxTokens;

    public HuggingFaceLlm(String apiKey, String modelName, Integer maxTokens) {
        //todo: implement
        this.apiKey = apiKey;
        this.modelName = modelName;
        this.maxTokens = maxTokens;
    }

    @Override
    public String getCompletions(String prompt) {
        return "";
    }
}
