package com.gensee.entity;

import java.io.Serializable;

public class UserInfo
  implements Serializable
{
  private static final long serialVersionUID = 2513621532827349798L;
  private int chatId;
  private String name;
  private int role;
  private long userId;

  public UserInfo()
  {
  }

  public UserInfo(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    this.userId = paramLong;
    this.name = paramString;
    this.role = paramInt1;
    this.chatId = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    UserInfo localUserInfo;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localUserInfo = (UserInfo)paramObject;
    }
    while (this.userId == localUserInfo.userId);
    return false;
  }

  public int getChatId()
  {
    return this.chatId;
  }

  public String getName()
  {
    return this.name;
  }

  public int getRole()
  {
    return this.role;
  }

  public long getUserId()
  {
    return this.userId;
  }

  public int hashCode()
  {
    return (int)(31 + this.userId);
  }

  public boolean isAssistant()
  {
    return (0x4 & this.role) == 4;
  }

  public boolean isAttendee()
  {
    return (0x8 & this.role) == 8;
  }

  public boolean isAttendeeWeb()
  {
    return (0x10 & this.role) == 16;
  }

  public boolean isHost()
  {
    return (0x1 & this.role) == 1;
  }

  public boolean isPresenter()
  {
    return (0x2 & this.role) == 2;
  }

  public void setChatId(int paramInt)
  {
    this.chatId = paramInt;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setRole(int paramInt)
  {
    this.role = paramInt;
  }

  public void setUserId(long paramLong)
  {
    this.userId = paramLong;
  }

  public String toString()
  {
    return "UserInfo [userId=" + this.userId + ", name=" + this.name + ", role=" + this.role + ", chatId=" + this.chatId + "]";
  }

  public void update(UserInfo paramUserInfo)
  {
    if ((paramUserInfo != null) && (paramUserInfo.getUserId() == this.userId))
    {
      this.name = paramUserInfo.getName();
      this.role = paramUserInfo.getRole();
      this.chatId = paramUserInfo.getChatId();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.UserInfo
 * JD-Core Version:    0.6.0
 */