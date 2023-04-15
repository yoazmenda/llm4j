package com.yoazmenda.llm4j.prompt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PromptTemplate {

    private final String formatString;
    private final List<String> inputVariables;

    public PromptTemplate(String formatString, List<String> inputVariables) {
        if (formatString == null) {
            throw new IllegalArgumentException("Format string must not be null");
        }
        if (inputVariables == null) {
            throw new IllegalArgumentException("Input variables must not be null");
        }
        this.formatString = formatString;
        this.inputVariables = new ArrayList<>(inputVariables);
    }

    public String format(Object... args) {
        if (args == null) {
            throw new NullPointerException("Arguments must not be null");
        }
        if (args.length != inputVariables.size()) {
            throw new IllegalArgumentException("Wrong number of arguments provided");
        }
        String formattedString = formatString;
        for (int i = 0; i < inputVariables.size(); i++) {
            String inputVariable = inputVariables.get(i);
            String arg = args[i].toString();
            formattedString = formattedString.replace("{" + inputVariable + "}", arg);
        }
        return formattedString;
    }

    public List<String> getInputVariables() {
        return Collections.unmodifiableList(inputVariables);
    }

    public String getFormatString() {
        return formatString;
    }

    public PromptTemplate withInputVariables(List<String> inputVariables) {
        if (inputVariables == null) {
            throw new IllegalArgumentException("Input variables must not be null");
        }
        return new PromptTemplate(formatString, inputVariables);
    }

    public PromptTemplate withFormatString(String formatString) {
        if (formatString == null) {
            throw new IllegalArgumentException("Format string must not be null");
        }
        return new PromptTemplate(formatString, inputVariables);
    }

}
