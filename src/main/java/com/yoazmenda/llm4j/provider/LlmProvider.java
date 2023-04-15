package com.yoazmenda.llm4j.provider;

import java.io.IOException;

public interface LlmProvider {
    String getCompletions(String prompt) throws IOException;
}
