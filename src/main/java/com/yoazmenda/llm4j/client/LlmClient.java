package com.yoazmenda.llm4j.client;

import com.yoazmenda.llm4j.provider.LlmProvider;

import java.io.IOException;

public class LlmClient {
    private final LlmProvider provider;

    public LlmClient(LlmProvider provider) {
        this.provider = provider;
    }

    public String getCompletion(String prompt) throws LlmClientException {
        try {
            return provider.getCompletions(prompt);
        } catch (IOException e) {
            throw new LlmClientException(e);
        }
    }
}