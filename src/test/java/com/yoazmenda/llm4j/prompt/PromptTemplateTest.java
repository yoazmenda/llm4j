package com.yoazmenda.llm4j.prompt;

import com.yoazmenda.llm4j.prompt.PromptTemplate;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class PromptTemplateTest {

    @Test
    void testFormatWithNoInputVariables() {
        PromptTemplate promptTemplate = new PromptTemplate("Tell me a joke.", new ArrayList<>(Arrays.asList()));
        assertEquals("Tell me a joke.", promptTemplate.format());
    }

    @Test
    void testFormatWithOneInputVariable() {
        PromptTemplate promptTemplate = new PromptTemplate("Tell me a {adjective} joke.", new ArrayList<>(Arrays.asList("adjective")));
        assertEquals("Tell me a funny joke.", promptTemplate.format("funny"));
    }

    @Test
    void testFormatWithMultipleInputVariables() {
        PromptTemplate promptTemplate = new PromptTemplate("Tell me a {adjective} joke about {content}.", new ArrayList<>(Arrays.asList("adjective", "content")));
        assertEquals("Tell me a funny joke about chickens.", promptTemplate.format("funny", "chickens"));
    }

    @Test
    void testFormatWithWrongNumberOfArguments() {
        PromptTemplate promptTemplate = new PromptTemplate("Tell me a {adjective} joke.", new ArrayList<>(Arrays.asList("adjective")));
        assertThrows(IllegalArgumentException.class, () -> promptTemplate.format("funny", "chickens"));
    }

    @Test
    void testGetInputVariables() {
        PromptTemplate promptTemplate = new PromptTemplate("Tell me a {adjective} joke about {content}.", new ArrayList<>(Arrays.asList("adjective", "content")));
        assertEquals(new ArrayList<>(Arrays.asList("adjective", "content")), promptTemplate.getInputVariables());
    }

}