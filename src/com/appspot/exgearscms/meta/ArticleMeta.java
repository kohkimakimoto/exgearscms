package com.appspot.exgearscms.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-06-02 21:38:24")
/** */
public final class ArticleMeta extends org.slim3.datastore.ModelMeta<com.appspot.exgearscms.model.Article> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.Article, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.Article, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<com.appspot.exgearscms.model.Article> text = new org.slim3.datastore.StringUnindexedAttributeMeta<com.appspot.exgearscms.model.Article>(this, "text", "text");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.exgearscms.model.Article> title = new org.slim3.datastore.StringAttributeMeta<com.appspot.exgearscms.model.Article>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.Article, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.appspot.exgearscms.model.Article, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.appspot.exgearscms.model.Article, org.slim3.datastore.ModelRef<com.appspot.exgearscms.model.WebUser>, com.appspot.exgearscms.model.WebUser> webUserRef = new org.slim3.datastore.ModelRefAttributeMeta<com.appspot.exgearscms.model.Article, org.slim3.datastore.ModelRef<com.appspot.exgearscms.model.WebUser>, com.appspot.exgearscms.model.WebUser>(this, "webUserRef", "webUserRef", org.slim3.datastore.ModelRef.class, com.appspot.exgearscms.model.WebUser.class);

    private static final ArticleMeta slim3_singleton = new ArticleMeta();

    /**
     * @return the singleton
     */
    public static ArticleMeta get() {
       return slim3_singleton;
    }

    /** */
    public ArticleMeta() {
        super("Article", com.appspot.exgearscms.model.Article.class);
    }

    @Override
    public com.appspot.exgearscms.model.Article entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.appspot.exgearscms.model.Article model = new com.appspot.exgearscms.model.Article();
        model.setKey(entity.getKey());
        model.setText(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("text")));
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        if (model.getWebUserRef() == null) {
            throw new NullPointerException("The property(webUserRef) is null.");
        }
        model.getWebUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("webUserRef"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.appspot.exgearscms.model.Article m = (com.appspot.exgearscms.model.Article) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("text", stringToText(m.getText()));
        entity.setProperty("title", m.getTitle());
        entity.setProperty("version", m.getVersion());
        if (m.getWebUserRef() == null) {
            throw new NullPointerException("The property(webUserRef) must not be null.");
        }
        entity.setProperty("webUserRef", m.getWebUserRef().getKey());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.appspot.exgearscms.model.Article m = (com.appspot.exgearscms.model.Article) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.appspot.exgearscms.model.Article m = (com.appspot.exgearscms.model.Article) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.appspot.exgearscms.model.Article m = (com.appspot.exgearscms.model.Article) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.appspot.exgearscms.model.Article m = (com.appspot.exgearscms.model.Article) model;
        if (m.getWebUserRef() == null) {
            throw new NullPointerException("The property(webUserRef) must not be null.");
        }
        m.getWebUserRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.appspot.exgearscms.model.Article m = (com.appspot.exgearscms.model.Article) model;
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
        com.appspot.exgearscms.model.Article m = (com.appspot.exgearscms.model.Article) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getText() != null){
            writer.setNextPropertyName("text");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getText());
        }
        if(m.getTitle() != null){
            writer.setNextPropertyName("title");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getTitle());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        if(m.getWebUserRef() != null && m.getWebUserRef().getKey() != null){
            writer.setNextPropertyName("webUserRef");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getWebUserRef(), maxDepth, currentDepth);
        }
        writer.endObject();
    }

    @Override
    protected com.appspot.exgearscms.model.Article jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.appspot.exgearscms.model.Article m = new com.appspot.exgearscms.model.Article();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("text");
        decoder = new org.slim3.datastore.json.Default();
        m.setText(decoder.decode(reader, m.getText()));
        reader = rootReader.newObjectReader("title");
        decoder = new org.slim3.datastore.json.Default();
        m.setTitle(decoder.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
        reader = rootReader.newObjectReader("webUserRef");
        decoder = new org.slim3.datastore.json.Default();
        decoder.decode(reader, m.getWebUserRef(), maxDepth, currentDepth);
        return m;
    }
}