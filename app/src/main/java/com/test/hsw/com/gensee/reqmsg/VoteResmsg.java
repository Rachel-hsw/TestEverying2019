package com.gensee.reqmsg;

public class VoteResmsg extends AbsReqmsg
{
  private String answer;
  private String commandId;
  private String nickName;
  private String questioned;
  private String userId;
  private String userName;

  public VoteResmsg()
  {
  }

  public VoteResmsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.userId = paramString1;
    this.commandId = paramString2;
    this.questioned = paramString3;
    this.answer = paramString4;
    this.userName = paramString5;
    this.nickName = paramString6;
  }

  protected String createModuleBody()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.commandId;
    arrayOfObject[1] = this.questioned;
    arrayOfObject[2] = this.answer;
    arrayOfObject[3] = this.userName;
    arrayOfObject[4] = this.nickName;
    return String.format("<command commandid=\"%s\" questioned=\"%s\" answer=\"%s\" username=\"%s\" nickname=\"%s\"", arrayOfObject);
  }

  public String getAnswer()
  {
    return this.answer;
  }

  public String getCommandId()
  {
    return this.commandId;
  }

  public String getData()
  {
    return getData("vote", this.userId);
  }

  public String getNickName()
  {
    return this.nickName;
  }

  public String getQuestioned()
  {
    return this.questioned;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public void setAnswer(String paramString)
  {
    this.answer = paramString;
  }

  public void setCommandId(String paramString)
  {
    this.commandId = paramString;
  }

  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }

  public void setQuestioned(String paramString)
  {
    this.questioned = paramString;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }

  public String toString()
  {
    return "VoteResmsg [userId=" + this.userId + ", commandId=" + this.commandId + ", questioned=" + this.questioned + ", answer=" + this.answer + ", userName=" + this.userName + ", nickName=" + this.nickName + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.reqmsg.VoteResmsg
 * JD-Core Version:    0.6.0
 */