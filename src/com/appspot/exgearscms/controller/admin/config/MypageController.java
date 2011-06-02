package com.appspot.exgearscms.controller.admin.config;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.cool.util.Messages;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.config.MyPageConfig;
import com.appspot.exgearscms.service.WebUserService;
import com.appspot.exgearscms.service.config.MyPageConfigService;

public class MypageController extends Controller {

    WebUserService webUserService = new WebUserService();
    MyPageConfigService myPageConfigService = new MyPageConfigService();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);

        WebUser webUser = webUserService.getWebUser();

        MyPageConfig config = webUser.getMyPageConfigRef().getModel();
        if (config == null) {
            config = new MyPageConfig();
            config.save();
            webUser.getMyPageConfigRef().setModel(config);
            webUser.save();
        }

        if ("POST".equals(request.getMethod()) && myPageConfigService.update(config, requestMap)) {
            Messages messages = new Messages(request);
            messages.add("設定情報を更新しました。");
        } else {
            BeanUtil.copy(config, requestMap);
        }

        return forward("mypage.jsp");
    }
}
