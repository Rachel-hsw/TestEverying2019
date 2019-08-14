package com.umeng.message.protobuffer;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.Message.Datatype;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;

public final class PushResponse extends Message
{
  public static final responseCode DEFAULT_CODE = responseCode.SUCCESS;
  public static final String DEFAULT_DESCRIPTION = "";
  private static final long a;

  @ProtoField(tag=1, type=Message.Datatype.ENUM)
  public final responseCode code;

  @ProtoField(tag=2, type=Message.Datatype.STRING)
  public final String description;

  @ProtoField(tag=3)
  public final Info info;

  private PushResponse(Builder paramBuilder)
  {
    this(paramBuilder.code, paramBuilder.description, paramBuilder.info);
    a(paramBuilder);
  }

  public PushResponse(responseCode paramresponseCode, String paramString, Info paramInfo)
  {
    this.code = paramresponseCode;
    this.description = paramString;
    this.info = paramInfo;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    PushResponse localPushResponse;
    do
    {
      return true;
      if (!(paramObject instanceof PushResponse))
        return false;
      localPushResponse = (PushResponse)paramObject;
    }
    while ((a(this.code, localPushResponse.code)) && (a(this.description, localPushResponse.description)) && (a(this.info, localPushResponse.info)));
    return false;
  }

  public int hashCode()
  {
    int i = this.b;
    int j;
    int k;
    if (i == 0)
    {
      if (this.code == null)
        break label90;
      j = this.code.hashCode();
      k = j * 37;
      if (this.description == null)
        break label95;
    }
    label90: label95: for (int m = this.description.hashCode(); ; m = 0)
    {
      int n = 37 * (m + k);
      Info localInfo = this.info;
      int i1 = 0;
      if (localInfo != null)
        i1 = this.info.hashCode();
      i = n + i1;
      this.b = i;
      return i;
      j = 0;
      break;
    }
  }

  public static final class Builder extends Message.Builder<PushResponse>
  {
    public PushResponse.responseCode code;
    public String description;
    public PushResponse.Info info;

    public Builder()
    {
    }

    public Builder(PushResponse paramPushResponse)
    {
      super();
      if (paramPushResponse == null)
        return;
      this.code = paramPushResponse.code;
      this.description = paramPushResponse.description;
      this.info = paramPushResponse.info;
    }

    public PushResponse build()
    {
      return new PushResponse(this, null);
    }

    public Builder code(PushResponse.responseCode paramresponseCode)
    {
      this.code = paramresponseCode;
      return this;
    }

    public Builder description(String paramString)
    {
      this.description = paramString;
      return this;
    }

    public Builder info(PushResponse.Info paramInfo)
    {
      this.info = paramInfo;
      return this;
    }
  }

  public static final class Info extends Message
  {
    public static final String DEFAULT_DEVICETOKENS = "";
    public static final Integer DEFAULT_LAUNCHPOLICY = Integer.valueOf(0);
    public static final Integer DEFAULT_TAGPOLICY = Integer.valueOf(0);
    public static final Integer DEFAULT_TAGREMAINCOUNT = Integer.valueOf(0);
    public static final String DEFAULT_TAGS = "";
    private static final long a;

    @ProtoField(tag=3, type=Message.Datatype.STRING)
    public final String deviceTokens;

    @ProtoField(tag=1, type=Message.Datatype.INT32)
    public final Integer launchPolicy;

    @ProtoField(tag=2, type=Message.Datatype.INT32)
    public final Integer tagPolicy;

    @ProtoField(tag=4, type=Message.Datatype.INT32)
    public final Integer tagRemainCount;

    @ProtoField(tag=5, type=Message.Datatype.STRING)
    public final String tags;

    private Info(Builder paramBuilder)
    {
      this(paramBuilder.launchPolicy, paramBuilder.tagPolicy, paramBuilder.deviceTokens, paramBuilder.tagRemainCount, paramBuilder.tags);
      a(paramBuilder);
    }

    public Info(Integer paramInteger1, Integer paramInteger2, String paramString1, Integer paramInteger3, String paramString2)
    {
      this.launchPolicy = paramInteger1;
      this.tagPolicy = paramInteger2;
      this.deviceTokens = paramString1;
      this.tagRemainCount = paramInteger3;
      this.tags = paramString2;
    }

    public boolean equals(Object paramObject)
    {
      if (paramObject == this);
      Info localInfo;
      do
      {
        return true;
        if (!(paramObject instanceof Info))
          return false;
        localInfo = (Info)paramObject;
      }
      while ((a(this.launchPolicy, localInfo.launchPolicy)) && (a(this.tagPolicy, localInfo.tagPolicy)) && (a(this.deviceTokens, localInfo.deviceTokens)) && (a(this.tagRemainCount, localInfo.tagRemainCount)) && (a(this.tags, localInfo.tags)));
      return false;
    }

    public int hashCode()
    {
      int i = this.b;
      int j;
      int m;
      label45: int i1;
      label70: int i2;
      if (i == 0)
      {
        if (this.launchPolicy == null)
          break label142;
        j = this.launchPolicy.hashCode();
        int k = j * 37;
        if (this.tagPolicy == null)
          break label147;
        m = this.tagPolicy.hashCode();
        int n = 37 * (m + k);
        if (this.deviceTokens == null)
          break label153;
        i1 = this.deviceTokens.hashCode();
        i2 = 37 * (i1 + n);
        if (this.tagRemainCount == null)
          break label159;
      }
      label142: label147: label153: label159: for (int i3 = this.tagRemainCount.hashCode(); ; i3 = 0)
      {
        int i4 = 37 * (i3 + i2);
        String str = this.tags;
        int i5 = 0;
        if (str != null)
          i5 = this.tags.hashCode();
        i = i4 + i5;
        this.b = i;
        return i;
        j = 0;
        break;
        m = 0;
        break label45;
        i1 = 0;
        break label70;
      }
    }

    public static final class Builder extends Message.Builder<PushResponse.Info>
    {
      public String deviceTokens;
      public Integer launchPolicy;
      public Integer tagPolicy;
      public Integer tagRemainCount;
      public String tags;

      public Builder()
      {
      }

      public Builder(PushResponse.Info paramInfo)
      {
        super();
        if (paramInfo == null)
          return;
        this.launchPolicy = paramInfo.launchPolicy;
        this.tagPolicy = paramInfo.tagPolicy;
        this.deviceTokens = paramInfo.deviceTokens;
        this.tagRemainCount = paramInfo.tagRemainCount;
        this.tags = paramInfo.tags;
      }

      public PushResponse.Info build()
      {
        return new PushResponse.Info(this, null);
      }

      public Builder deviceTokens(String paramString)
      {
        this.deviceTokens = paramString;
        return this;
      }

      public Builder launchPolicy(Integer paramInteger)
      {
        this.launchPolicy = paramInteger;
        return this;
      }

      public Builder tagPolicy(Integer paramInteger)
      {
        this.tagPolicy = paramInteger;
        return this;
      }

      public Builder tagRemainCount(Integer paramInteger)
      {
        this.tagRemainCount = paramInteger;
        return this;
      }

      public Builder tags(String paramString)
      {
        this.tags = paramString;
        return this;
      }
    }
  }

  public static enum responseCode
    implements ProtoEnum
  {
    private final int a;

    static
    {
      INVALID_REQUEST = new responseCode("INVALID_REQUEST", 1, 1);
      SERVER_EXCEPTION = new responseCode("SERVER_EXCEPTION", 2, 2);
      responseCode[] arrayOfresponseCode = new responseCode[3];
      arrayOfresponseCode[0] = SUCCESS;
      arrayOfresponseCode[1] = INVALID_REQUEST;
      arrayOfresponseCode[2] = SERVER_EXCEPTION;
      b = arrayOfresponseCode;
    }

    private responseCode(int arg3)
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
 * Qualified Name:     com.umeng.message.protobuffer.PushResponse
 * JD-Core Version:    0.6.0
 */