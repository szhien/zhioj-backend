package com.zhien.zhioj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhien.zhioj.model.dto.question.QuestionQueryRequest;
import com.zhien.zhioj.model.entity.Question;
import com.zhien.zhioj.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhien.zhioj.model.entity.User;
import com.zhien.zhioj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zhien
 * @description 针对表【question(题目)】的数据库操作Service
 * @createDate 2024-11-02 16:21:14
 */
public interface QuestionService extends IService<Question> {

    /**
     * 校验
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 获取题目封装(提供创建题目的用户信息)
     *
     * @param question           题目信息
     * @param createQuestionUser 创建题目的用户信息
     * @return
     */
    QuestionVO getQuestionVO(Question question, User createQuestionUser);

    /**
     * 获取题目封装
     *
     * @param question 题目信息
     * @return
     */
    QuestionVO getQuestionVO(Question question);


    /**
     * 分页获取题目封装
     *
     * @param questionPage
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage);
}
