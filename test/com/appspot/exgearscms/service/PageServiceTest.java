package com.appspot.exgearscms.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PageServiceTest extends AppEngineTestCase {

    private PageService service = new PageService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
