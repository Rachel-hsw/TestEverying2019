package com.gensee.entity;

public class ContactEntity
{
  private int id;
  private boolean isActivated;
  private String name;
  private boolean showHead = true;
  private int uRMCount = 0;
  private String userId;

  public ContactEntity()
  {
  }

  public ContactEntity(String paramString1, String paramString2)
  {
    this.userId = paramString1;
    this.name = paramString2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ContactEntity localContactEntity;
    do
      while (true)
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localContactEntity = (ContactEntity)paramObject;
        if (this.userId != null)
          break;
        if (localContactEntity.userId != null)
          return false;
      }
    while (this.userId.equals(localContactEntity.userId));
    return false;
  }

  public int getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public int getuRMCount()
  {
    return this.uRMCount;
  }

  public int hashCode()
  {
    if (this.userId == null);
    for (int i = 0; ; i = this.userId.hashCode())
      return i + 31;
  }

  public boolean isActivated()
  {
    return this.isActivated;
  }

  public boolean isShowHead()
  {
    return this.showHead;
  }

  public void setActivated(boolean paramBoolean)
  {
    this.isActivated = paramBoolean;
  }

  public void setId(int paramInt)
  {
    this.id = paramInt;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setShowHead(boolean paramBoolean)
  {
    this.showHead = paramBoolean;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public void setuRMCount(int paramInt)
  {
    this.uRMCount = paramInt;
  }

  public String toString()
  {
    return "ContactEntity [id=" + this.id + ", userId=" + this.userId + ", name=" + this.name + ", showHead=" + this.showHead + ", isActivated=" + this.isActivated + ", uRMCount=" + this.uRMCount + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.ContactEntity
 * JD-Core Version:    0.6.0
 */