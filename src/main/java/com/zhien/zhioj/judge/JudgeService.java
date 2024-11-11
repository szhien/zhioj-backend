package com.zhien.zhioj.judge;

import com.zhien.zhioj.model.entity.QuestionSubmit;

/**
 * @author Zhien
 * @version 1.0
 * @name JudgeService
 * @description 判题模块
 * @createDate 2024/11/11 10:47
 */

public interface JudgeService {
    /**
     * 执行判题
     *
     * @param questionId
     * @return
     */
    QuestionSubmit doJudge(long questionId);
}
