package com.zhien.zhioj.model.dto.questionsubmit;

import lombok.Data;

/**
 * @author Zhien
 * @version 1.0
 * @name JudgeCase
 * @description 判题信息
 * @createDate 2024/11/02 17:14
 */
@Data
public class JudgeInfo {

    //程序执行信息
    private String message;

    //运行耗时（ms）
    private Long time;

    //运行占用内存（KB）
    private Long memory;

}
