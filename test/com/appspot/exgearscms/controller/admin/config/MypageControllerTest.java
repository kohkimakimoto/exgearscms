package com.appspot.exgearscms.controller.admin.config;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MypageControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/config/mypage");
        MypageController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/admin/config/mypage.jsp"));
    }
}
