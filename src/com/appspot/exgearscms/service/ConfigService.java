package com.appspot.exgearscms.service;

import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.model.Config;
import com.google.appengine.api.datastore.Transaction;


public class ConfigService {

    public boolean update(Config config, Map<String, Object> input) {
        Validators validators = new Validators(input);
        if (!validators.validate()) {
            return false;
        }
        BeanUtil.copy(input, config);
        config.save();
        return true;
    }

}
