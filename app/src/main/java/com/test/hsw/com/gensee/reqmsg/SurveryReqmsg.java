package com.gensee.reqmsg;

public class SurveryReqmsg extends AbsReqmsg
{
  private boolean answerSelected;
  private String commandId;
  private String questionId;
  String userId;

  public SurveryReqmsg()
  {
  }

  public SurveryReqmsg(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.userId = paramString1;
    this.commandId = paramString2;
    this.questionId = paramString3;
    this.answerSelected = paramBoolean;
  }

  protected String createModuleBody()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.commandId;
    arrayOfObject[1] = this.questionId;
    arrayOfObject[2] = String.valueOf(this.answerSelected);
    return String.format("<command commandid=\"%s\">\n<question id=\"%s\">\n<answer selected=\"%s\">\n</answer>\n</question>\n</command>", arrayOfObject);
  }

  public String getCommandId()
  {
    return this.commandId;
  }

  public String getData()
  {
    return getData("survery", this.userId);
  }

  public String getQuestionId()
  {
    return this.questionId;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public boolean isAnswerSelected()
  {
    return this.answerSelected;
  }

  public void setAnswerSelected(boolean paramBoolean)
  {
    this.answerSelected = paramBoolean;
  }

  public void setCommandId(String paramString)
  {
    this.commandId = paramString;
  }

  public void setQuestionId(String paramString)
  {
    this.questionId = paramString;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public String toString()
  {
    return "SurveryReqmsg [userId=" + this.userId + ", commandId=" + this.commandId + ", questionId=" + this.questionId + ", answerSelected=" + this.answerSelected + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.reqmsg.SurveryReqmsg
 * JD-Core Version:    0.6.0
 */