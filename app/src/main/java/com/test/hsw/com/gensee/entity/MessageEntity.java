package com.gensee.entity;

public class MessageEntity
{
  public static final int CHAT_GROUP = 1;
  public static final int CHAT_GUEST = 2;
  public static final int CHAT_SINGLE;
  private String content;
  private int dataFlag;
  private long groupId;
  private int id;
  private String nickName;
  private long receiveId;
  private long sendId;
  private int status;
  private String time;
  private int type;

  public MessageEntity()
  {
  }

  public MessageEntity(int paramInt1, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    this.id = paramInt1;
    this.sendId = paramLong1;
    this.nickName = paramString1;
    this.receiveId = paramLong2;
    this.content = paramString2;
    this.time = paramString3;
    this.type = paramInt2;
    this.status = paramInt3;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MessageEntity localMessageEntity;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localMessageEntity = (MessageEntity)paramObject;
    }
    while (this.id == localMessageEntity.id);
    return false;
  }

  public String getContent()
  {
    return this.content;
  }

  public int getDataFlag()
  {
    return this.dataFlag;
  }

  public long getGroupId()
  {
    return this.groupId;
  }

  public int getId()
  {
    return this.id;
  }

  public String getNickName()
  {
    return this.nickName;
  }

  public long getReceiveId()
  {
    return this.receiveId;
  }

  public long getSendId()
  {
    return this.sendId;
  }

  public int getStatus()
  {
    return this.status;
  }

  public String getTime()
  {
    return this.time;
  }

  public int getType()
  {
    return this.type;
  }

  public int hashCode()
  {
    return 31 + this.id;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public void setDataFlag(int paramInt)
  {
    this.dataFlag = paramInt;
  }

  public void setGroupId(long paramLong)
  {
    this.groupId = paramLong;
  }

  public void setId(int paramInt)
  {
    this.id = paramInt;
  }

  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }

  public void setReceiveId(long paramLong)
  {
    this.receiveId = paramLong;
  }

  public void setSendId(long paramLong)
  {
    this.sendId = paramLong;
  }

  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }

  public void setTime(String paramString)
  {
    this.time = paramString;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
  }

  public String toString()
  {
    return "MessageEntity [id=" + this.id + ", sendId=" + this.sendId + ", nickName=" + this.nickName + ", receiveId=" + this.receiveId + ", content=" + this.content + ", time=" + this.time + ", type=" + this.type + ", status=" + this.status + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.MessageEntity
 * JD-Core Version:    0.6.0
 */