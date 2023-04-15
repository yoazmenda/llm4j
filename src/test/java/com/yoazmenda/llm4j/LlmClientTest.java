package com.yoazmenda.llm4j;

import com.yoazmenda.llm4j.llm.LlmClient;
import com.yoazmenda.llm4j.provider.LlmProvider;
import com.yoazmenda.llm4j.provider.TestLlmProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Unit test for LlmTemplate
 */
public class LlmClientTest {

    @Test
    public void testTestLLMTemplate()
    {
        LlmProvider llmProvider = new TestLlmProvider();
        LlmClient llmClient = new LlmClient(llmProvider);
        String completions = llmClient.getCompletions("Hi there");
        assertNotNull(completions);
        assertEquals(completions, "Hi there");
    }
}
