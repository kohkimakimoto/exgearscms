package com.appspot.exgearscms.service.config;

import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

import com.appspot.exgearscms.model.config.MyPageConfig;


public class MyPageConfigService {

    public boolean update(MyPageConfig config, Map<String, Object> input) {
        Validators validators = new Validators(input);
        if (!validators.validate()) {
            return false;
        }
        BeanUtil.copy(input, config);
        config.save();
        return true;
    }
    
}
