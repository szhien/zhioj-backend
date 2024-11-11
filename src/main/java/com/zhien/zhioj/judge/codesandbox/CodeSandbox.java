package com.zhien.zhioj.judge.codesandbox;

import com.zhien.zhioj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zhien.zhioj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author Zhien
 * @version 1.0
 * @name CodeSandbox
 * @description 代码沙箱接口
 * @createDate 2024/11/08 16:25
 */
public interface CodeSandbox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest request);
}
