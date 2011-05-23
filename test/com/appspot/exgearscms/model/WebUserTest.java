package com.appspot.exgearscms.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WebUserTest extends AppEngineTestCase {

    private WebUser model = new WebUser();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
