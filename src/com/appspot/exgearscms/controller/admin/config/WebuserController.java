package com.appspot.exgearscms.controller.admin.config;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.cool.util.Messages;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.config.MyPageConfig;
import com.appspot.exgearscms.model.config.WebUserConfig;
import com.appspot.exgearscms.service.WebUserService;
import com.appspot.exgearscms.service.config.MyPageConfigService;
import com.appspot.exgearscms.service.config.WebUserConfigService;

public class WebuserController extends Controller {
    WebUserService webUserService = new WebUserService();
    WebUserConfigService webUserConfigService = new WebUserConfigService();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);

        WebUser webUser = webUserService.getWebUser();

        WebUserConfig config = webUser.getWebUserConfigRef().getModel();
        if (config == null) {
            config = new WebUserConfig();
            config.save();
            webUser.getWebUserConfigRef().setModel(config);
            webUser.save();
        }

        if ("POST".equals(request.getMethod()) && webUserConfigService.update(config, requestMap)) {
            Messages messages = new Messages(request);
            messages.add("設定情報を更新しました。");
        } else {
            BeanUtil.copy(config, requestMap);
        }

        return forward("webuser.jsp");
    }
}
