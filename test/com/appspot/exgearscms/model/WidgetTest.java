package com.appspot.exgearscms.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WidgetTest extends AppEngineTestCase {

    private Widget model = new Widget();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
