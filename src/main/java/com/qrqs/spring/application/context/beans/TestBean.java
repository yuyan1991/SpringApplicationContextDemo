package com.qrqs.spring.application.context.beans;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class TestBean {
    private String context;

    public void hello() {
        log.info("hello" + context);
    }
}
