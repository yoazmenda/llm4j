# llm4j
## llm4j: A Java library for AI applications powered by large language models
llm4j is an open-source Java library that provides a unified interface for interacting with various Large Language Models (LLMs) such as OpenAI, HuggingFace, and custom/self-hosted LLMs. Inspired by Python's langchain, llm4j aims to simplify the integration of LLMs into Java projects, particularly Spring applications, and enable the creation of standalone applications and complex agent/tools-based apps powered by LLM AI models.

## Goals
Ease of use:
Designed with Java projects in mind, llm4j offers easy integration into existing Java applications.

### Standardized approach:
The library provides a simple and consistent way to interact with different LLMs without worrying about the specifics of each implementation (OpenAI, HuggingFace, and custom/self-hosted LLMs).

### Always Improve:
The world of AI applications and LLMs is rapidly evolving. Our goal is to stay updated, listen to users' feedback and use cases, and support them quickly while maintaining good development practices, code quality, and backward compatibility as much as possible.

### Getting Started
Prerequisites
Java 8 or higher
Maven or Gradle build tool
Installation
Add the following dependency to your pom.xml (Maven):

```
<dependency>
    <groupId>com.yoazmenda.llm4j</groupId>
    <artifactId>llm4j</artifactId>
    <version>1.0.0</version>
</dependency>
```
### Usage
Create an instance of the LlmClient for your desired LLM:


```
import com.yoazmenda.llm4j.*;

// For OpenAI
OpenAIProvider openAiProvider = new OpenAILlm("your-api-key", "model-name", 0.8, 50);
LlmClient openAIClient = new LlmClient(openAiProvider);

String prompt = "Translate the following English text to French: 'Hello, world!'";
String response = openAIClient.getCompletions(prompt);

System.out.println(response);
```

### Contributing
Please read CONTRIBUTING.md for details on our code of conduct and the process for submitting pull requests.

License
This project is licensed under the MIT License - see the LICENSE.md file for details.