package com.gensee.chat.msg;

public class PrivateMessage extends AbsChatMessage
{
  protected String mReceiveName;
  protected long receiveUserId;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!super.equals(paramObject))
        return false;
    }
    while (getClass() == paramObject.getClass());
    return false;
  }

  public String getReceiveName()
  {
    return this.mReceiveName;
  }

  public long getReceiveUserId()
  {
    return this.receiveUserId;
  }

  public void setReceiveName(String paramString)
  {
    this.mReceiveName = paramString;
  }

  public void setReceiveUserId(long paramLong)
  {
    this.receiveUserId = paramLong;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.chat.msg.PrivateMessage
 * JD-Core Version:    0.6.0
 */