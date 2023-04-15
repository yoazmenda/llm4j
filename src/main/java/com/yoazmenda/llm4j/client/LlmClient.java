package com.yoazmenda.llm4j.client;

import com.yoazmenda.llm4j.provider.LlmProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class LlmClient {
    private static final Logger logger = LoggerFactory.getLogger(LlmClient.class);
    private final LlmProvider provider;

    public LlmClient(LlmProvider provider) {
        logger.info("Creating LLM Client from provider={}", provider.getClass());
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