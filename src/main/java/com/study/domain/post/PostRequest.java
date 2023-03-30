package com.study.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

    private Long id;             // PK
    private String title;        // 제목
    private String content;      // 내용
    private String content2;
    private String content3;
    private String content4;
    private String problem;
    private String writer;       // 작성자
    private String exp;
    private String ansnum;
    private Boolean noticeYn;    // 공지글 여부




}