package com.appspot.exgearscms.service.widget;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserInfoWidgetServiceTest extends AppEngineTestCase {

    private UserInfoWidgetService service = new UserInfoWidgetService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
