package com.gensee.entity;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VoteMsg extends BaseMsg
{
  private static final long serialVersionUID = -7316864347733340977L;
  private String confId;
  private String id;
  private String name;
  private String ownerId;
  private List<VoteQuest> quests;
  private String siteId;
  private boolean skip;
  private String subject;
  private String tId;
  private long timestamp;
  private int total;
  private String userId;
  private String version;
  private String voteType;

  public VoteMsg()
  {
    setModule("vote");
    setType("vote");
  }

  private void onQuestion(Node paramNode)
  {
    if (this.quests == null)
      this.quests = new ArrayList();
    this.quests.add(new VoteQuest(paramNode));
  }

  public String getConfId()
  {
    return this.confId;
  }

  public String getData()
  {
    return getXml();
  }

  public String getId()
  {
    return this.id;
  }

  public String getOwnerId()
  {
    return this.ownerId;
  }

  public List<VoteQuest> getQuests()
  {
    return this.quests;
  }

  public String getSiteId()
  {
    return this.siteId;
  }

  public String getSubject()
  {
    return this.subject;
  }

  public long getTimestamp()
  {
    return this.timestamp;
  }

  public int getTotal()
  {
    return this.total;
  }

  public String getVersion()
  {
    return this.version;
  }

  public String getVoteSubmitXml()
  {
    return getXml();
  }

  public String getVoteType()
  {
    return this.voteType;
  }

  protected String getXml()
  {
    Iterator localIterator = this.quests.iterator();
    String str1 = "";
    if (!localIterator.hasNext())
      if (this.name != null)
        break label191;
    label191: for (String str2 = ""; ; str2 = this.name)
    {
      if (this.tId == null)
        break label200;
      return "<voteSubmit siteid=\"" + this.siteId + "\" userid=\"" + this.userId + "\" username=\"" + str2 + "\" confid=\"" + this.confId + "\" live=\"false\" tid=\"" + this.tId + "\"><command id=\"" + this.id + "\" >" + str1 + "</command></voteSubmit>";
      VoteQuest localVoteQuest = (VoteQuest)localIterator.next();
      if (localVoteQuest == null)
        break;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localVoteQuest.getXml(localStringBuilder) == -1)
        break;
      str1 = str1 + localStringBuilder.toString();
      break;
    }
    label200: return "<module name=\"vote\"  siteid=\"" + this.siteId + "\" confid=\"" + this.confId + "\" userid=\"" + this.userId + "\" live=\"true\" username=\"" + str2 + "\" ver=\"2\"><command id=\"" + this.id + "\" type=\"submit\" userid=\"" + this.userId + "\">" + str1 + "</command></module>";
  }

  public boolean isSkip()
  {
    return this.skip;
  }

  protected BaseMsg onXmlNode(Context paramContext, Node paramNode)
  {
    if (paramNode == null)
      return super.onXmlNode(paramContext, paramNode);
    this.version = getNodeAttrString(paramNode, "version");
    this.id = getNodeAttrString(paramNode, "id");
    this.voteType = getNodeAttrString(paramNode, "type");
    this.skip = getNodeAttrBool(paramNode, "skip");
    this.timestamp = getNodeAttrLong(paramNode, "timestamp");
    this.total = getNodeAttrInt(paramNode, "total");
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
      sendBroadCast(paramContext, "gs.action.rec.msg.vote");
      return this;
    }
    Node localNode = localNodeList.item(j);
    String str1;
    if (localNode != null)
    {
      str1 = localNode.getNodeName();
      if (!"question".equals(str1))
        break label155;
      onQuestion(localNode);
    }
    label155: 
    do
    {
      j++;
      break;
    }
    while (!"subject".equals(str1));
    this.subject = localNode.getTextContent();
    if (this.subject == null);
    for (String str2 = ""; ; str2 = this.subject.trim())
    {
      this.subject = str2;
      break;
    }
  }

  public BaseMsg parseXml(Node paramNode)
  {
    this.siteId = getNodeAttrString(paramNode, "siteid");
    this.confId = getNodeAttrString(paramNode, "confid");
    this.ownerId = getNodeAttrString(paramNode, "userid");
    NodeList localNodeList = paramNode.getChildNodes();
    int i;
    if (localNodeList != null)
    {
      i = localNodeList.getLength();
      if (i != 0)
        break label54;
    }
    while (true)
    {
      return null;
      label54: for (int j = 0; j < i; j++)
      {
        Node localNode = localNodeList.item(j);
        if ("command".equals(localNode.getNodeName()))
          return onXmlNode(null, localNode);
      }
    }
  }

  public void setConfId(String paramString)
  {
    this.confId = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setOwnerId(String paramString)
  {
    this.ownerId = paramString;
  }

  public void setQuests(List<VoteQuest> paramList)
  {
    this.quests = paramList;
  }

  public void setSiteId(String paramString)
  {
    this.siteId = paramString;
  }

  public void setSkip(boolean paramBoolean)
  {
    this.skip = paramBoolean;
  }

  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }

  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }

  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public void setVersion(String paramString)
  {
    this.version = paramString;
  }

  public void setVoteType(String paramString)
  {
    this.voteType = paramString;
  }

  public void settId(String paramString)
  {
    this.tId = paramString;
  }

  public String toString()
  {
    return "VoteMsg [version=" + this.version + ", id=" + this.id + ", voteType=" + this.voteType + ", skip=" + this.skip + ", timestamp=" + this.timestamp + ", subject=" + this.subject + ", total=" + this.total + ", quests=" + this.quests + ", userId=" + this.userId + ", siteId=" + this.siteId + ", confId=" + this.confId + ", name=" + this.name + ", tId=" + this.tId + "," + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.VoteMsg
 * JD-Core Version:    0.6.0
 */