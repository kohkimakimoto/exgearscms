package com.appspot.exgearscms.service.config;

import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

import com.appspot.exgearscms.model.config.WebUserConfig;


public class WebUserConfigService {
    
    public boolean update(WebUserConfig config, Map<String, Object> input) {
        Validators validators = new Validators(input);
        if (!validators.validate()) {
            return false;
        }
        BeanUtil.copy(input, config);
        config.save();
        return true;
    }
}
