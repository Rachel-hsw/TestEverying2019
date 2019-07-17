package com.gensee.chat.msg;

import java.text.SimpleDateFormat;

public abstract class AbsChatMessage
{
  public static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
  public static final SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
  protected String mSendUserName;
  protected String rich;
  protected long sendUserId;
  protected String text;
  protected long time;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AbsChatMessage localAbsChatMessage;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localAbsChatMessage = (AbsChatMessage)paramObject;
      if (this.text == null)
      {
        if (localAbsChatMessage.text != null)
          return false;
      }
      else if (!this.text.equals(localAbsChatMessage.text))
        return false;
    }
    while (this.sendUserId == localAbsChatMessage.sendUserId);
    return false;
  }

  public String getRich()
  {
    return this.rich;
  }

  public long getSendUserId()
  {
    return this.sendUserId;
  }

  public String getSendUserName()
  {
    return this.mSendUserName;
  }

  public String getText()
  {
    return this.text;
  }

  public long getTime()
  {
    return this.time;
  }

  public int hashCode()
  {
    if (this.text == null);
    for (int i = 0; ; i = this.text.hashCode())
      return 31 * (i + 31) + (int)(this.sendUserId ^ this.sendUserId >>> 32);
  }

  public void setRich(String paramString)
  {
    this.rich = paramString;
  }

  public void setSendUserId(long paramLong)
  {
    this.sendUserId = paramLong;
  }

  public void setSendUserName(String paramString)
  {
    this.mSendUserName = paramString;
  }

  public void setText(String paramString)
  {
    this.text = paramString;
  }

  public void setTime(long paramLong)
  {
    this.time = paramLong;
  }

  public static abstract interface IMesssageType
  {
    public static final String PRIVATE_MSG_TYPE = "private";
    public static final String PUBLIC_MSG_TYPE = "public";
    public static final String SYS_MSG_TYPE = "sys";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.chat.msg.AbsChatMessage
 * JD-Core Version:    0.6.0
 */