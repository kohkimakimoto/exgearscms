package com.appspot.exgearscms.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WebUserServiceTest extends AppEngineTestCase {

    private WebUserService service = new WebUserService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
