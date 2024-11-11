package com.zhien.zhioj;

import com.zhien.zhioj.judge.codesandbox.CodeSandbox;
import com.zhien.zhioj.judge.codesandbox.CodeSandboxFactory;
import com.zhien.zhioj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zhien.zhioj.judge.codesandbox.model.ExecuteCodeResponse;
import com.zhien.zhioj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 主类测试
 *
 * @author Zhien
 */
@SpringBootTest
class MainApplicationTests {
    @Value(value = "${codesandbox.type}")
    private String type;

    @Test
    public void main() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder().code(code).language(language).inputList(inputList).build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        System.out.println(executeCodeResponse);

    }


}
