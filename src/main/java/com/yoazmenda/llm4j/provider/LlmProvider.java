package com.yoazmenda.llm4j.provider;

import com.yoazmenda.llm4j.client.LlmClientException;

import java.io.IOException;

public interface LlmProvider {
    String getCompletions(String prompt) throws IOException;
}
