/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.kaaproject.kaa.server.appenders.pubnub.config.gen;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class PubNubConfig extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PubNubConfig\",\"namespace\":\"org.kaaproject.kaa.server.appenders.pubnub.config.gen\",\"fields\":[{\"name\":\"publishKey\",\"type\":\"string\",\"displayName\":\"Publish Key\",\"maxLength\":1000,\"by_default\":\"\"},{\"name\":\"subscribeKey\",\"type\":\"string\",\"displayName\":\"Subscribe Key\",\"maxLength\":1000,\"by_default\":\"\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence publishKey;
  @Deprecated public java.lang.CharSequence subscribeKey;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public PubNubConfig() {}

  /**
   * All-args constructor.
   */
  public PubNubConfig(java.lang.CharSequence publishKey, java.lang.CharSequence subscribeKey) {
    this.publishKey = publishKey;
    this.subscribeKey = subscribeKey;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return publishKey;
    case 1: return subscribeKey;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: publishKey = (java.lang.CharSequence)value$; break;
    case 1: subscribeKey = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'publishKey' field.
   */
  public java.lang.CharSequence getPublishKey() {
    return publishKey;
  }

  /**
   * Sets the value of the 'publishKey' field.
   * @param value the value to set.
   */
  public void setPublishKey(java.lang.CharSequence value) {
    this.publishKey = value;
  }

  /**
   * Gets the value of the 'subscribeKey' field.
   */
  public java.lang.CharSequence getSubscribeKey() {
    return subscribeKey;
  }

  /**
   * Sets the value of the 'subscribeKey' field.
   * @param value the value to set.
   */
  public void setSubscribeKey(java.lang.CharSequence value) {
    this.subscribeKey = value;
  }

  /** Creates a new PubNubConfig RecordBuilder */
  public static org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder newBuilder() {
    return new org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder();
  }
  
  /** Creates a new PubNubConfig RecordBuilder by copying an existing Builder */
  public static org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder newBuilder(org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder other) {
    return new org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder(other);
  }
  
  /** Creates a new PubNubConfig RecordBuilder by copying an existing PubNubConfig instance */
  public static org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder newBuilder(org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig other) {
    return new org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder(other);
  }
  
  /**
   * RecordBuilder for PubNubConfig instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PubNubConfig>
    implements org.apache.avro.data.RecordBuilder<PubNubConfig> {

    private java.lang.CharSequence publishKey;
    private java.lang.CharSequence subscribeKey;

    /** Creates a new Builder */
    private Builder() {
      super(org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.publishKey)) {
        this.publishKey = data().deepCopy(fields()[0].schema(), other.publishKey);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.subscribeKey)) {
        this.subscribeKey = data().deepCopy(fields()[1].schema(), other.subscribeKey);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing PubNubConfig instance */
    private Builder(org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig other) {
            super(org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.SCHEMA$);
      if (isValidValue(fields()[0], other.publishKey)) {
        this.publishKey = data().deepCopy(fields()[0].schema(), other.publishKey);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.subscribeKey)) {
        this.subscribeKey = data().deepCopy(fields()[1].schema(), other.subscribeKey);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'publishKey' field */
    public java.lang.CharSequence getPublishKey() {
      return publishKey;
    }
    
    /** Sets the value of the 'publishKey' field */
    public org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder setPublishKey(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.publishKey = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'publishKey' field has been set */
    public boolean hasPublishKey() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'publishKey' field */
    public org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder clearPublishKey() {
      publishKey = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'subscribeKey' field */
    public java.lang.CharSequence getSubscribeKey() {
      return subscribeKey;
    }
    
    /** Sets the value of the 'subscribeKey' field */
    public org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder setSubscribeKey(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.subscribeKey = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'subscribeKey' field has been set */
    public boolean hasSubscribeKey() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'subscribeKey' field */
    public org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig.Builder clearSubscribeKey() {
      subscribeKey = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public PubNubConfig build() {
      try {
        PubNubConfig record = new PubNubConfig();
        record.publishKey = fieldSetFlags()[0] ? this.publishKey : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.subscribeKey = fieldSetFlags()[1] ? this.subscribeKey : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}