package com.appspot.exgearscms.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-06-02 20:32:52")
/** */
public final class ConfigMeta extends org.slim3.datastore.ModelMeta<com.appspot.exgearscms.model.Config> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.Config, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.Config, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.Config, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.Config, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final ConfigMeta slim3_singleton = new ConfigMeta();

    /**
     * @return the singleton
     */
    public static ConfigMeta get() {
       return slim3_singleton;
    }

    /** */
    public ConfigMeta() {
        super("Config", com.appspot.exgearscms.model.Config.class);
    }

    @Override
    public com.appspot.exgearscms.model.Config entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.appspot.exgearscms.model.Config model = new com.appspot.exgearscms.model.Config();
        model.setKey(entity.getKey());
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.appspot.exgearscms.model.Config m = (com.appspot.exgearscms.model.Config) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.appspot.exgearscms.model.Config m = (com.appspot.exgearscms.model.Config) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.appspot.exgearscms.model.Config m = (com.appspot.exgearscms.model.Config) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.appspot.exgearscms.model.Config m = (com.appspot.exgearscms.model.Config) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.appspot.exgearscms.model.Config m = (com.appspot.exgearscms.model.Config) model;
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
        com.appspot.exgearscms.model.Config m = (com.appspot.exgearscms.model.Config) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.appspot.exgearscms.model.Config jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.appspot.exgearscms.model.Config m = new com.appspot.exgearscms.model.Config();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
        return m;
    }
}