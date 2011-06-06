package com.appspot.exgearscms.service.widget;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NewArticlesServiceTest extends AppEngineTestCase {

    private NewArticlesWidgetService service = new NewArticlesWidgetService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
