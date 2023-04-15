package com.yoazmenda.llm4j.provider;

public class TestLlmProvider implements LlmProvider {

    public TestLlmProvider() {
    }

    @Override
    public String getCompletions(String prompt) {
        return prompt; // echo
    }
}
