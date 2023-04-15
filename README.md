# llm4j


## llm4j: A java library for AI applications powered by large language models

llm4j is an open source Java library that provides a unified interface for interacting with various Large Language Models (LLMs) such as OpenAI, HuggingFace, and custom/self-hosted LLMs. Inspired by Python's langchain, llm4j aims to simplify the integration of LLMs into Java projects, particularly Spring applications, and enable the creation of standalone applications and complex agent/tools-based apps powered by LLM AI models.

## Goals
### Ease of use: 
Designed with Java projects in mind, llm4j offers easy integration into existing Java applications, particularly Spring-based ones.
### Standardized approach
The library provides an abstract LLMTemplate that allows the user to interact with different LLMs without worrying about the specifics of each implementation (OpenAI, HuggingFace as well as custom/self hosted LLMs).
### Improve
The world of AI applications and LLMs is exploding. We can't tell what is going to happen next, but the goal is to stay updated and listen to users feedback and use-cases and support them quickly while maintaining good development practices and, code quality and backwards competabilty as much as possible

## Getting Started
### Prerequisites
Java 8 or higher
Maven or Gradle build tool
### Installation
Add the following dependency to your pom.xml (Maven)

### Maven
```
<dependency>
  <groupId>com.yoazmenda.llm4j</groupId>
  <artifactId>llm4j</artifactId>
  <version>1.0.0</version>
</dependency>
```

Usage
Create an instance of the LLMTemplate for your desired LLM:
```
import com.example.llm4j.*;

LLMTemplate openAiClient = new LLMTemplate("your-api-key");
LLMTemplate huggingFaceClient = new HuggingFaceClient("your-api-key");
Use the LLMTemplate to interact with the LLM:

String prompt = "Translate the following English text to French: 'Hello, world!'";
String response = openAIClient.generate(prompt);

System.out.println(response);

```
Contributing
Please read CONTRIBUTING.md for details on our code of conduct and the process for submitting pull requests.

License
This project is licensed under the MIT License - see the LICENSE.md file for details.