package com.appspot.exgearscms.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-06-07 00:26:33")
/** */
public final class WebUserMeta extends org.slim3.datastore.ModelMeta<com.appspot.exgearscms.model.WebUser> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, java.lang.Boolean> active = new org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, java.lang.Boolean>(this, "active", "active", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, java.lang.Boolean> admin = new org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, java.lang.Boolean>(this, "admin", "admin", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, java.lang.Boolean> authenticated = new org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, java.lang.Boolean>(this, "authenticated", "authenticated", boolean.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.exgearscms.model.WebUser> email = new org.slim3.datastore.StringAttributeMeta<com.appspot.exgearscms.model.WebUser>(this, "email", "email");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.appspot.exgearscms.model.WebUser, org.slim3.datastore.ModelRef<com.appspot.exgearscms.model.config.MyPageConfig>, com.appspot.exgearscms.model.config.MyPageConfig> myPageConfigRef = new org.slim3.datastore.ModelRefAttributeMeta<com.appspot.exgearscms.model.WebUser, org.slim3.datastore.ModelRef<com.appspot.exgearscms.model.config.MyPageConfig>, com.appspot.exgearscms.model.config.MyPageConfig>(this, "myPageConfigRef", "myPageConfigRef", org.slim3.datastore.ModelRef.class, com.appspot.exgearscms.model.config.MyPageConfig.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.exgearscms.model.WebUser> name = new org.slim3.datastore.StringAttributeMeta<com.appspot.exgearscms.model.WebUser>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.exgearscms.model.WebUser> uid = new org.slim3.datastore.StringAttributeMeta<com.appspot.exgearscms.model.WebUser>(this, "uid", "uid");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.WebUser, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.appspot.exgearscms.model.WebUser, org.slim3.datastore.ModelRef<com.appspot.exgearscms.model.config.WebUserConfig>, com.appspot.exgearscms.model.config.WebUserConfig> webUserConfigRef = new org.slim3.datastore.ModelRefAttributeMeta<com.appspot.exgearscms.model.WebUser, org.slim3.datastore.ModelRef<com.appspot.exgearscms.model.config.WebUserConfig>, com.appspot.exgearscms.model.config.WebUserConfig>(this, "webUserConfigRef", "webUserConfigRef", org.slim3.datastore.ModelRef.class, com.appspot.exgearscms.model.config.WebUserConfig.class);

    private static final WebUserMeta slim3_singleton = new WebUserMeta();

    /**
     * @return the singleton
     */
    public static WebUserMeta get() {
       return slim3_singleton;
    }

    /** */
    public WebUserMeta() {
        super("WebUser", com.appspot.exgearscms.model.WebUser.class);
    }

    @Override
    public com.appspot.exgearscms.model.WebUser entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.appspot.exgearscms.model.WebUser model = new com.appspot.exgearscms.model.WebUser();
        model.setActive(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("active")));
        model.setAdmin(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("admin")));
        model.setAuthenticated(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("authenticated")));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setKey(entity.getKey());
        if (model.getMyPageConfigRef() == null) {
            throw new NullPointerException("The property(myPageConfigRef) is null.");
        }
        model.getMyPageConfigRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("myPageConfigRef"));
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setUid((java.lang.String) entity.getProperty("uid"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        if (model.getWebUserConfigRef() == null) {
            throw new NullPointerException("The property(webUserConfigRef) is null.");
        }
        model.getWebUserConfigRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("webUserConfigRef"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.appspot.exgearscms.model.WebUser m = (com.appspot.exgearscms.model.WebUser) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("active", m.isActive());
        entity.setProperty("admin", m.isAdmin());
        entity.setProperty("authenticated", m.isAuthenticated());
        entity.setProperty("email", m.getEmail());
        if (m.getMyPageConfigRef() == null) {
            throw new NullPointerException("The property(myPageConfigRef) must not be null.");
        }
        entity.setProperty("myPageConfigRef", m.getMyPageConfigRef().getKey());
        entity.setProperty("name", m.getName());
        entity.setProperty("uid", m.getUid());
        entity.setProperty("version", m.getVersion());
        if (m.getWebUserConfigRef() == null) {
            throw new NullPointerException("The property(webUserConfigRef) must not be null.");
        }
        entity.setProperty("webUserConfigRef", m.getWebUserConfigRef().getKey());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.appspot.exgearscms.model.WebUser m = (com.appspot.exgearscms.model.WebUser) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.appspot.exgearscms.model.WebUser m = (com.appspot.exgearscms.model.WebUser) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.appspot.exgearscms.model.WebUser m = (com.appspot.exgearscms.model.WebUser) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.appspot.exgearscms.model.WebUser m = (com.appspot.exgearscms.model.WebUser) model;
        if (m.getMyPageConfigRef() == null) {
            throw new NullPointerException("The property(myPageConfigRef) must not be null.");
        }
        m.getMyPageConfigRef().assignKeyIfNecessary(ds);
        if (m.getWebUserConfigRef() == null) {
            throw new NullPointerException("The property(webUserConfigRef) must not be null.");
        }
        m.getWebUserConfigRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.appspot.exgearscms.model.WebUser m = (com.appspot.exgearscms.model.WebUser) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.appspot.exgearscms.model.WebUser m = (com.appspot.exgearscms.model.WebUser) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        writer.setNextPropertyName("active");
        encoder = new org.slim3.datastore.json.Default();
        encoder.encode(writer, m.isActive());
        writer.setNextPropertyName("admin");
        encoder = new org.slim3.datastore.json.Default();
        encoder.encode(writer, m.isAdmin());
        writer.setNextPropertyName("authenticated");
        encoder = new org.slim3.datastore.json.Default();
        encoder.encode(writer, m.isAuthenticated());
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getEmail());
        }
        if(m.getGuser() != null){
            writer.setNextPropertyName("guser");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getGuser());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getMyPageConfigRef() != null && m.getMyPageConfigRef().getKey() != null){
            writer.setNextPropertyName("myPageConfigRef");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getMyPageConfigRef(), maxDepth, currentDepth);
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getName());
        }
        if(m.getUid() != null){
            writer.setNextPropertyName("uid");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getUid());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        if(m.getWebUserConfigRef() != null && m.getWebUserConfigRef().getKey() != null){
            writer.setNextPropertyName("webUserConfigRef");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getWebUserConfigRef(), maxDepth, currentDepth);
        }
        if(m.getWidgetListRef() != null){
            writer.setNextPropertyName("widgetListRef");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getWidgetListRef());
        }
        writer.endObject();
    }

    @Override
    protected com.appspot.exgearscms.model.WebUser jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.appspot.exgearscms.model.WebUser m = new com.appspot.exgearscms.model.WebUser();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("active");
        decoder = new org.slim3.datastore.json.Default();
        m.setActive(decoder.decode(reader, m.isActive()));
        reader = rootReader.newObjectReader("admin");
        decoder = new org.slim3.datastore.json.Default();
        m.setAdmin(decoder.decode(reader, m.isAdmin()));
        reader = rootReader.newObjectReader("authenticated");
        decoder = new org.slim3.datastore.json.Default();
        m.setAuthenticated(decoder.decode(reader, m.isAuthenticated()));
        reader = rootReader.newObjectReader("email");
        decoder = new org.slim3.datastore.json.Default();
        m.setEmail(decoder.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("guser");
        decoder = new org.slim3.datastore.json.Default();
        m.setGuser(decoder.decode(reader, m.getGuser()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("myPageConfigRef");
        decoder = new org.slim3.datastore.json.Default();
        decoder.decode(reader, m.getMyPageConfigRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("name");
        decoder = new org.slim3.datastore.json.Default();
        m.setName(decoder.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("uid");
        decoder = new org.slim3.datastore.json.Default();
        m.setUid(decoder.decode(reader, m.getUid()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
        reader = rootReader.newObjectReader("webUserConfigRef");
        decoder = new org.slim3.datastore.json.Default();
        decoder.decode(reader, m.getWebUserConfigRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("widgetListRef");
        decoder = new org.slim3.datastore.json.Default();
        return m;
    }
}