package com.appspot.exgearscms.model.config;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MyPageConfigTest extends AppEngineTestCase {

    private MyPageConfig model = new MyPageConfig();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
