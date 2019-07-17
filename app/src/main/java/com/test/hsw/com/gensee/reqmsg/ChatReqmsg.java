package com.gensee.reqmsg;

public class ChatReqmsg extends AbsReqmsg
{
  private String message;
  private String receiverId;
  private String userId;

  public ChatReqmsg()
  {
  }

  public ChatReqmsg(String paramString1, String paramString2, String paramString3)
  {
    this.receiverId = paramString1;
    this.userId = paramString2;
    this.message = paramString3;
  }

  protected String createModuleBody()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.receiverId;
    arrayOfObject[1] = this.message;
    return String.format("<chat receiverid=\"%s\">%s</chat>", arrayOfObject);
  }

  public String getData()
  {
    return getData("chat", this.userId);
  }

  public String getMessage()
  {
    return this.message;
  }

  public String getReceiverId()
  {
    return this.receiverId;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public void setMessage(String paramString)
  {
    this.message = paramString;
  }

  public void setReceiverId(String paramString)
  {
    this.receiverId = paramString;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public String toString()
  {
    return "ChatReqmsg [receiverId=" + this.receiverId + ", userId=" + this.userId + ", message=" + this.message + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.reqmsg.ChatReqmsg
 * JD-Core Version:    0.6.0
 */