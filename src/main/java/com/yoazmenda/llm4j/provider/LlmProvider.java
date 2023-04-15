package com.yoazmenda.llm4j.provider;

import com.yoazmenda.llm4j.llm.LlmClient;

public interface LlmProvider {
    String getCompletions(String prompt);
}
