package com.appspot.exgearscms.service.widget;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TwitterWidgetServiceTest extends AppEngineTestCase {

    private TwitterWidgetService service = new TwitterWidgetService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
