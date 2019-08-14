package com.umeng.message.protobuffer;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.Message.Datatype;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;
import com.umeng.message.b.j;

public final class PushRequest extends Message
{
  public static final String DEFAULT_CHECKSUM = "";
  public static final entityEncodingFormat DEFAULT_ENCRYPTION;
  public static final j DEFAULT_ENTITY;
  public static final String DEFAULT_SALT = "";
  public static final Integer DEFAULT_SERIALNO = Integer.valueOf(0);
  public static final String DEFAULT_SIGNATURE = "";
  public static final Integer DEFAULT_TIMESTAMP = Integer.valueOf(0);
  public static final String DEFAULT_VERSION = "";
  private static final long a;

  @ProtoField(tag=5, type=Message.Datatype.STRING)
  public final String checksum;

  @ProtoField(tag=7, type=Message.Datatype.ENUM)
  public final entityEncodingFormat encryption;

  @ProtoField(tag=8, type=Message.Datatype.BYTES)
  public final j entity;

  @ProtoField(tag=6, type=Message.Datatype.STRING)
  public final String salt;

  @ProtoField(tag=3, type=Message.Datatype.INT32)
  public final Integer serialNo;

  @ProtoField(tag=2, type=Message.Datatype.STRING)
  public final String signature;

  @ProtoField(tag=4, type=Message.Datatype.INT32)
  public final Integer timestamp;

  @ProtoField(tag=1, type=Message.Datatype.STRING)
  public final String version;

  static
  {
    DEFAULT_ENCRYPTION = entityEncodingFormat.JSON;
    DEFAULT_ENTITY = j.a;
  }

  private PushRequest(Builder paramBuilder)
  {
    this(paramBuilder.version, paramBuilder.signature, paramBuilder.serialNo, paramBuilder.timestamp, paramBuilder.checksum, paramBuilder.salt, paramBuilder.encryption, paramBuilder.entity);
    a(paramBuilder);
  }

  public PushRequest(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, String paramString3, String paramString4, entityEncodingFormat paramentityEncodingFormat, j paramj)
  {
    this.version = paramString1;
    this.signature = paramString2;
    this.serialNo = paramInteger1;
    this.timestamp = paramInteger2;
    this.checksum = paramString3;
    this.salt = paramString4;
    this.encryption = paramentityEncodingFormat;
    this.entity = paramj;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    PushRequest localPushRequest;
    do
    {
      return true;
      if (!(paramObject instanceof PushRequest))
        return false;
      localPushRequest = (PushRequest)paramObject;
    }
    while ((a(this.version, localPushRequest.version)) && (a(this.signature, localPushRequest.signature)) && (a(this.serialNo, localPushRequest.serialNo)) && (a(this.timestamp, localPushRequest.timestamp)) && (a(this.checksum, localPushRequest.checksum)) && (a(this.salt, localPushRequest.salt)) && (a(this.encryption, localPushRequest.encryption)) && (a(this.entity, localPushRequest.entity)));
    return false;
  }

  public int hashCode()
  {
    int i = this.b;
    int j;
    int m;
    label45: int i1;
    label70: int i3;
    label96: int i5;
    label122: int i7;
    label148: int i8;
    if (i == 0)
    {
      if (this.version == null)
        break label220;
      j = this.version.hashCode();
      int k = j * 37;
      if (this.signature == null)
        break label225;
      m = this.signature.hashCode();
      int n = 37 * (m + k);
      if (this.serialNo == null)
        break label231;
      i1 = this.serialNo.hashCode();
      int i2 = 37 * (i1 + n);
      if (this.timestamp == null)
        break label237;
      i3 = this.timestamp.hashCode();
      int i4 = 37 * (i3 + i2);
      if (this.checksum == null)
        break label243;
      i5 = this.checksum.hashCode();
      int i6 = 37 * (i5 + i4);
      if (this.salt == null)
        break label249;
      i7 = this.salt.hashCode();
      i8 = 37 * (i7 + i6);
      if (this.encryption == null)
        break label255;
    }
    label220: label225: label231: label237: label243: label249: label255: for (int i9 = this.encryption.hashCode(); ; i9 = 0)
    {
      int i10 = 37 * (i9 + i8);
      j localj = this.entity;
      int i11 = 0;
      if (localj != null)
        i11 = this.entity.hashCode();
      i = i10 + i11;
      this.b = i;
      return i;
      j = 0;
      break;
      m = 0;
      break label45;
      i1 = 0;
      break label70;
      i3 = 0;
      break label96;
      i5 = 0;
      break label122;
      i7 = 0;
      break label148;
    }
  }

  public static final class Builder extends Message.Builder<PushRequest>
  {
    public String checksum;
    public PushRequest.entityEncodingFormat encryption;
    public j entity;
    public String salt;
    public Integer serialNo;
    public String signature;
    public Integer timestamp;
    public String version;

    public Builder()
    {
    }

    public Builder(PushRequest paramPushRequest)
    {
      super();
      if (paramPushRequest == null)
        return;
      this.version = paramPushRequest.version;
      this.signature = paramPushRequest.signature;
      this.serialNo = paramPushRequest.serialNo;
      this.timestamp = paramPushRequest.timestamp;
      this.checksum = paramPushRequest.checksum;
      this.salt = paramPushRequest.salt;
      this.encryption = paramPushRequest.encryption;
      this.entity = paramPushRequest.entity;
    }

    public PushRequest build()
    {
      return new PushRequest(this, null);
    }

    public Builder checksum(String paramString)
    {
      this.checksum = paramString;
      return this;
    }

    public Builder encryption(PushRequest.entityEncodingFormat paramentityEncodingFormat)
    {
      this.encryption = paramentityEncodingFormat;
      return this;
    }

    public Builder entity(j paramj)
    {
      this.entity = paramj;
      return this;
    }

    public Builder salt(String paramString)
    {
      this.salt = paramString;
      return this;
    }

    public Builder serialNo(Integer paramInteger)
    {
      this.serialNo = paramInteger;
      return this;
    }

    public Builder signature(String paramString)
    {
      this.signature = paramString;
      return this;
    }

    public Builder timestamp(Integer paramInteger)
    {
      this.timestamp = paramInteger;
      return this;
    }

    public Builder version(String paramString)
    {
      this.version = paramString;
      return this;
    }
  }

  public static enum entityEncodingFormat
    implements ProtoEnum
  {
    private final int a;

    static
    {
      entityEncodingFormat[] arrayOfentityEncodingFormat = new entityEncodingFormat[3];
      arrayOfentityEncodingFormat[0] = JSON;
      arrayOfentityEncodingFormat[1] = JSON_AES;
      arrayOfentityEncodingFormat[2] = JSON_RSA;
      b = arrayOfentityEncodingFormat;
    }

    private entityEncodingFormat(int arg3)
    {
      int j;
      this.a = j;
    }

    public int getValue()
    {
      return this.a;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.protobuffer.PushRequest
 * JD-Core Version:    0.6.0
 */