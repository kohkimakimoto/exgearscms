package com.appspot.exgearscms.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class Config implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String myPageTitle;

    @Attribute(lob = true)
    private String myPageDescription;

    private int myPageType;

    @Attribute(lob = true)
    private String profile;

    public void save() {
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(this);
        tx.commit();
    }

    public String getMyPageTitle() {
        return myPageTitle;
    }

    public void setMyPageTitle(String myPageTitle) {
        this.myPageTitle = myPageTitle;
    }

    public String getMyPageDescription() {
        return myPageDescription;
    }

    public void setMyPageDescription(String myPageDescription) {
        this.myPageDescription = myPageDescription;
    }

    public int getMyPageType() {
        return myPageType;
    }

    public void setMyPageType(int myPageType) {
        this.myPageType = myPageType;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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
        Config other = (Config) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

}
