package com.appspot.exgearscms.model.widget;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserInfoWidgetTest extends AppEngineTestCase {

    private UserInfoWidget model = new UserInfoWidget();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
