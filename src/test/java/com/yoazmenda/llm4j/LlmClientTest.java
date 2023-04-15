package com.yoazmenda.llm4j;

import com.yoazmenda.llm4j.client.LlmClient;
import com.yoazmenda.llm4j.client.LlmClientException;
import com.yoazmenda.llm4j.provider.HuggingFaceLlm;
import com.yoazmenda.llm4j.provider.LlmProvider;
import com.yoazmenda.llm4j.provider.OpenAILlm;
import com.yoazmenda.llm4j.provider.TestLlmProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LlmClientTest {

    @Test
    public void testTestLLM() throws LlmClientException {
        LlmProvider llmProvider = new TestLlmProvider();
        LlmClient llmClient = new LlmClient(llmProvider);
        String completions = llmClient.getCompletion("Hi there");
        assertNotNull(completions);
        assertEquals(completions, "Hi there");
    }

    @Test(enabled = false)
    public void testOpenAILLM() throws LlmClientException {
        LlmProvider llmProvider = new OpenAILlm(System.getenv("OPENAI_API_KEY"), "text-davinci-003", 0D, 10);
        LlmClient llmClient = new LlmClient(llmProvider);
        String completions = llmClient.getCompletion("Please respond with this exact character: x");
        assertEquals(completions, "\n\nx");
    }

    @Test(enabled = false)
    public void testHuggingFaceLLM() throws LlmClientException {
        LlmProvider llmProvider = new HuggingFaceLlm("gpt2", System.getenv("HF_API_KEY"), 0D, 10);
        LlmClient llmClient = new LlmClient(llmProvider);
        String result = llmClient.getCompletion("hello");
        assertFalse(result.isEmpty());
    }
}
