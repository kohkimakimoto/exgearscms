package com.appspot.exgearscms.controller.article;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ShowControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/article/show");
        ShowController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/article/show.jsp"));
    }
}
