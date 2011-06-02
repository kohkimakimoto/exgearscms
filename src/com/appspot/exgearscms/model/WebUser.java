package com.appspot.exgearscms.model;

import java.io.Serializable;

import com.appspot.exgearscms.cool.util.MD5Util;
import com.appspot.exgearscms.model.config.MyPageConfig;
import com.appspot.exgearscms.model.config.WebUserConfig;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class WebUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String email;

    private String uid;

    private String name;

    private boolean active = true;

    private boolean authenticated = true;

    private boolean admin = false;

    @Attribute(persistent = false)
    private User guser = null;

    private ModelRef<Config> configRef = new ModelRef<Config>(Config.class);

    private ModelRef<MyPageConfig> myPageConfigRef = new ModelRef<MyPageConfig>(MyPageConfig.class);

    private ModelRef<WebUserConfig> webUserConfigRef = new ModelRef<WebUserConfig>(WebUserConfig.class);

    public void save() {
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(this);
        tx.commit();
    }

    public String getUrl() {
        return "/" + uid + "/";
    }

    public String getLogoutUrl() {
        UserService userService = UserServiceFactory.getUserService();
        return userService.createLogoutURL("/");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getGuser() {
        return guser;
    }

    public void setGuser(User guser) {
        this.guser = guser;
    }

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        WebUser other = (WebUser) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public ModelRef<Config> getConfigRef() {
        return configRef;
    }

    public Config getConfig() {
        return getConfigRef().getModel();
    }

    public void setConfig(Config config) {
        getConfigRef().setModel(config);
    }

    public MyPageConfig getMyPageConfig() {
        return getMyPageConfigRef().getModel();
    }

    public void setMyPageConfig(MyPageConfig myPageConfig) {
        getMyPageConfigRef().setModel(myPageConfig);
    }

    public WebUserConfig getWebUserConfig() {
        return getWebUserConfigRef().getModel();
    }

    public void setWebUserConfig(WebUserConfig webUserConfig) {
        getWebUserConfigRef().setModel(webUserConfig);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ModelRef<MyPageConfig> getMyPageConfigRef() {
        return myPageConfigRef;
    }

    public ModelRef<WebUserConfig> getWebUserConfigRef() {
        return webUserConfigRef;
    }

    public String getProfileImageUrl() {
        WebUserConfig config = getWebUserConfig();
        String email = config.getGravatarEmail();
        if (email == null || email.equals("")) {
            return "/static/default/images/icon/user-80x80.png";
        }
        String hash = MD5Util.md5Hex(email);
        String url = "http://www.gravatar.com/avatar/";
        return url + hash;
    }

    public String getProfileImageUrl22() {
        WebUserConfig config = getWebUserConfig();
        String email = config.getGravatarEmail();
        if (email == null || email.equals("")) {
            return "/static/default/images/icon/user-22x22.png";
        }
        String hash = MD5Util.md5Hex(email);
        String url = "http://www.gravatar.com/avatar/";
        return url + hash + "?s=22";
    }

    public String getGravatarImageUrl() {
        String hash = MD5Util.md5Hex(email);
        String url = "http://www.gravatar.com/avatar/";
        return url + hash;
    }

}
