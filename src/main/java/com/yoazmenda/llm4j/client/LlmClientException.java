package com.yoazmenda.llm4j.client;

import java.io.IOException;

public class LlmClientException extends Exception {
    public LlmClientException(IOException e) {
        super(e);
    }
}
