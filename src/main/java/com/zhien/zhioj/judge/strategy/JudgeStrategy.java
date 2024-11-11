package com.zhien.zhioj.judge.strategy;

import com.zhien.zhioj.judge.codesandbox.model.JudgeInfo;

/**
 * @author Zhien
 * @version 1.0
 * @name JudgeStrategy
 * @description 判题策略
 * @createDate 2024/11/11 11:41
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
