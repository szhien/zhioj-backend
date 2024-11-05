package com.zhien.zhioj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhien.zhioj.common.BaseResponse;
import com.zhien.zhioj.common.ErrorCode;
import com.zhien.zhioj.common.ResultUtils;
import com.zhien.zhioj.exception.BusinessException;
import com.zhien.zhioj.exception.ThrowUtils;
import com.zhien.zhioj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zhien.zhioj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.zhien.zhioj.model.entity.QuestionSubmit;
import com.zhien.zhioj.model.entity.User;
import com.zhien.zhioj.model.vo.QuestionSubmitVO;
import com.zhien.zhioj.service.QuestionSubmitService;
import com.zhien.zhioj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 題目提交接口
 *
 * @author Zhien
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return 题目提交的id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                               HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能提交，然后会提交代码
        final User loginUser = userService.getLoginUser(request);
        Long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取列表（封装类）
     *
     * @param questionQuerySubmitRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitVOByPage(@RequestBody QuestionSubmitQueryRequest questionQuerySubmitRequest,
                                                                           HttpServletRequest request) {
        long current = questionQuerySubmitRequest.getCurrent();
        long size = questionQuerySubmitRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionQuerySubmitRequest));
        User loginUser = userService.getLoginUser(request);
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }


}
