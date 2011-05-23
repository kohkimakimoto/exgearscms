package com.appspot.exgearscms.controller.p;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import com.appspot.exgearscms.controller.p.PageController;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PageControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/p/page");
        PageController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/p/page.jsp"));
    }
}
