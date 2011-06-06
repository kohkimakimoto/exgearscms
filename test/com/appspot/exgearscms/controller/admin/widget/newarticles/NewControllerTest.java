package com.appspot.exgearscms.controller.admin.widget.newarticles;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NewControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/widget/newarticles/new");
        NewController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/admin/widget/newarticles/new.jsp"));
    }
}
