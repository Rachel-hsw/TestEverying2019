package com.gensee.entity;

import android.content.Context;
import java.util.UUID;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class QAMsg extends BaseMsg
{
  private static final String QA = "<module name=\"qa\" userid=\"%s\"><qamsg id=\"%s\" name=\"%s\"><![CDATA[%s]]></qamsg></module>";
  private static final long serialVersionUID = -4222713026296454093L;
  private String answer;
  private String answerId;
  private String answerOwner;
  private long answerTimestamp;
  private boolean isCancel = false;
  private String questId;
  private long questOwnerId;
  private String questOwnerName;
  private long questTimgstamp;
  private String question;
  private long timestamp;

  public QAMsg()
  {
    this("qa");
  }

  public QAMsg(String paramString)
  {
    setModule("qa");
    setType(paramString);
  }

  public QAMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this();
    this.questId = paramString1;
    this.question = paramString2;
    this.questOwnerName = paramString3;
    this.answerId = paramString4;
    this.answer = paramString5;
    this.answerOwner = paramString6;
    this.questTimgstamp = paramLong1;
    this.answerTimestamp = paramLong2;
    this.questOwnerId = paramLong3;
    this.isCancel = paramBoolean;
  }

  private void onQuestion(Node paramNode)
  {
    this.questId = getNodeAttrString(paramNode, "id");
    this.questTimgstamp = getNodeAttrLong(paramNode, "timestamp");
    this.questOwnerName = getNodeAttrString(paramNode, "user");
    this.questOwnerId = getNodeAttrLong(paramNode, "questionownerid");
    this.question = paramNode.getTextContent();
    if (this.question == null);
    for (String str = ""; ; str = this.question.trim())
    {
      this.question = str;
      return;
    }
  }

  private void onanswer(Node paramNode)
  {
    this.answerOwner = getNodeAttrString(paramNode, "user");
    this.answerTimestamp = getNodeAttrLong(paramNode, "timestamp");
    this.answer = paramNode.getTextContent();
    if (this.answer == null);
    for (String str = ""; ; str = this.answer.trim())
    {
      this.answer = str;
      return;
    }
  }

  public String getAnswer()
  {
    return this.answer;
  }

  public String getAnswerId()
  {
    return this.answerId;
  }

  public String getAnswerOwner()
  {
    return this.answerOwner;
  }

  public long getAnswerTimestamp()
  {
    return this.answerTimestamp;
  }

  public String getAnswerUser()
  {
    return this.answerOwner;
  }

  public String getQuestId()
  {
    return this.questId;
  }

  public long getQuestOwnerId()
  {
    return this.questOwnerId;
  }

  public String getQuestOwnerName()
  {
    return this.questOwnerName;
  }

  public long getQuestTimgstamp()
  {
    return this.questTimgstamp;
  }

  public String getQuestion()
  {
    return this.question;
  }

  public long getTimestamp()
  {
    return this.timestamp;
  }

  protected String getXml()
  {
    if (this.questOwnerId == 0L)
      return "";
    if ((this.questId == null) || ("".equals(this.questId)))
      this.questId = UUID.randomUUID().toString();
    if ((this.questOwnerName == null) || ("".equals(this.questOwnerName)))
      return "";
    if ((this.question == null) || ("".equals(this.question)))
      return "";
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(this.questOwnerId);
    arrayOfObject[1] = this.questId;
    arrayOfObject[2] = this.questOwnerName;
    arrayOfObject[3] = this.question;
    return String.format("<module name=\"qa\" userid=\"%s\"><qamsg id=\"%s\" name=\"%s\"><![CDATA[%s]]></qamsg></module>", arrayOfObject);
  }

  public boolean isCancel()
  {
    return this.isCancel;
  }

  protected BaseMsg onXmlNode(Context paramContext, Node paramNode)
  {
    if ((paramContext == null) || (paramNode == null))
      this = null;
    String str1;
    do
    {
      return this;
      str1 = getType();
      if (!"qa".equals(str1))
        continue;
      this.timestamp = getNodeAttrLong(paramNode, "timestamp");
      NodeList localNodeList = paramNode.getChildNodes();
      int j;
      if (localNodeList != null)
      {
        int i = localNodeList.getLength();
        j = 0;
        if (j < i);
      }
      else
      {
        sendBroadCast(paramContext, "gs.action.rec.msg.qa");
        return this;
      }
      Node localNode = localNodeList.item(j);
      if (localNode == null);
      while (true)
      {
        j++;
        break;
        String str2 = localNode.getNodeName();
        if ("question".equals(str2))
        {
          onQuestion(localNode);
          continue;
        }
        if (!"answer".equals(str2))
          continue;
        onanswer(localNode);
      }
    }
    while (!"qahistroy".equals(str1));
    this.questTimgstamp = getNodeAttrLong(paramNode, "questiontimestamp");
    this.questId = getNodeAttrString(paramNode, "id");
    this.question = getNodeAttrString(paramNode, "question");
    this.questOwnerName = getNodeAttrString(paramNode, "questionowner");
    this.questOwnerId = getNodeAttrLong(paramNode, "questionownerid");
    this.answerOwner = getNodeAttrString(paramNode, "answerowner");
    this.answerId = getNodeAttrString(paramNode, "answerid");
    this.answer = getNodeAttrString(paramNode, "answer");
    this.answerTimestamp = getNodeAttrLong(paramNode, "qaanswertimestamp");
    sendBroadCast(paramContext, "gs.action.rec.msg.qahistroy");
    return this;
  }

  public void setAnswer(String paramString)
  {
    this.answer = paramString;
  }

  public void setAnswerId(String paramString)
  {
    this.answerId = paramString;
  }

  public void setAnswerOwner(String paramString)
  {
    this.answerOwner = paramString;
  }

  public void setAnswerTimestamp(long paramLong)
  {
    this.answerTimestamp = paramLong;
  }

  public void setAnswerUser(String paramString)
  {
    this.answerOwner = paramString;
  }

  public void setCancel(boolean paramBoolean)
  {
    this.isCancel = paramBoolean;
  }

  public void setQuestId(String paramString)
  {
    this.questId = paramString;
  }

  public void setQuestOwnerId(long paramLong)
  {
    this.questOwnerId = paramLong;
  }

  public void setQuestOwnerName(String paramString)
  {
    this.questOwnerName = paramString;
  }

  public void setQuestTimgstamp(long paramLong)
  {
    this.questTimgstamp = paramLong;
  }

  public void setQuestion(String paramString)
  {
    this.question = paramString;
  }

  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }

  public String toString()
  {
    return "QAMsg [timestamp=" + this.timestamp + ", questId=" + this.questId + ", questTimgstamp=" + this.questTimgstamp + ", questOwnerName=" + this.questOwnerName + ", questOwnerId=" + this.questOwnerId + ", question=" + this.question + ", answerOwner=" + this.answerOwner + ", answerId=" + this.answerId + ", answerTimestamp=" + this.answerTimestamp + ", answer=" + this.answer + ", toString()=" + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.QAMsg
 * JD-Core Version:    0.6.0
 */