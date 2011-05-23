package com.appspot.exgearscms.controller.admin.config;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.cool.util.Messages;
import com.appspot.exgearscms.model.Config;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.ConfigService;
import com.appspot.exgearscms.service.WebUserService;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);

        WebUserService webUserService = new WebUserService();
        ConfigService configService = new ConfigService();

        WebUser webUser = webUserService.getWebUser();

        Config config = webUser.getConfigRef().getModel();
        if (config == null) {
            config = new Config();
            config.save();
            webUser.getConfigRef().setModel(config);
            webUser.save();
        }

        if ("POST".equals(request.getMethod()) && configService.update(config, requestMap)) {
            Messages messages = new Messages(request);
            messages.add("設定情報を更新しました。");
        } else {
            BeanUtil.copy(config, requestMap);
        }

        return forward("index.jsp");
    }
}
