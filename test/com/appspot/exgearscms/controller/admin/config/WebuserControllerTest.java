package com.appspot.exgearscms.controller.admin.config;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WebuserControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/config/webuser");
        WebuserController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/admin/config/webuser.jsp"));
    }
}
