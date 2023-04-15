package com.yoazmenda.llm4j.provider;

import com.yoazmenda.HuggingFaceInference;

import java.io.IOException;

public class HuggingFaceLlm implements LlmProvider {
    private final HuggingFaceInference huggingFaceInference;

    public HuggingFaceLlm(String repoId, String apiKey, Double temperature, Integer maxTokens) {
        huggingFaceInference = new HuggingFaceInference(repoId, apiKey, temperature, maxTokens);
    }

    @Override
    public String getCompletions(String prompt) throws IOException {
        return huggingFaceInference.infer(prompt);
    }
}
