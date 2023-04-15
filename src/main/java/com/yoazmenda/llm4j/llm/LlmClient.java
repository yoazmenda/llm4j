package com.yoazmenda.llm4j.llm;

import com.yoazmenda.llm4j.prompt.PromptTemplate;
import com.yoazmenda.llm4j.provider.LlmProvider;

public class LlmClient {
    private final LlmProvider provider;

    public LlmClient(LlmProvider provider) {
        this.provider = provider;
    }

    public String getCompletions(String prompt) {
        return provider.getCompletions(prompt);
    }
}