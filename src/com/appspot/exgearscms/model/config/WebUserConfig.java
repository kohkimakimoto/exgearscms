package com.appspot.exgearscms.model.config;

import java.io.Serializable;

import com.appspot.exgearscms.model.WebUser;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.InverseModelRef;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class WebUserConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String nickname;

    private String gravatarEmail;

    @Attribute(lob = true)
    private String profile;

    @Attribute(persistent = false)
    private InverseModelRef<WebUser, WebUserConfig> webUserRef = new InverseModelRef<WebUser, WebUserConfig>(WebUser.class, "webUserConfigRef", this);

    public void save() {
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(this);
        tx.commit();
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
        WebUserConfig other = (WebUserConfig) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setGravatarEmail(String gravatarEmail) {
        this.gravatarEmail = gravatarEmail;
    }

    public String getGravatarEmail() {
        return gravatarEmail;
    }

    public InverseModelRef<WebUser, WebUserConfig> getWebUserRef() {
        return webUserRef;
    }

}
