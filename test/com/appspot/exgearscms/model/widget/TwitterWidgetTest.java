package com.appspot.exgearscms.model.widget;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TwitterWidgetTest extends AppEngineTestCase {

    private TwitterWidget model = new TwitterWidget();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
