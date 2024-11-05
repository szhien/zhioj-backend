package com.zhien.zhioj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhien.zhioj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zhien.zhioj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.zhien.zhioj.model.entity.Question;
import com.zhien.zhioj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhien.zhioj.model.entity.User;
import com.zhien.zhioj.model.vo.QuestionSubmitVO;
import com.zhien.zhioj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zhien
 * @description 针对表【question_submit(题目提交)】的数据库操作Service
 * @createDate 2024-11-02 16:23:46
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return 题目提交的id
     */
    Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param request
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param request
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
