package com.gensee.entity;

import android.content.Context;
import com.gensee.utils.StringUtil;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ChatMsg extends EmsMsg
{
  private static final String PRI_CHAT = "<module name=\"chat\" userid=\"%s\"><ems type=\"chat\" sender=\"%s\" senderid= \"%s\"><![CDATA[%s]]></ems></module>";
  private static final String PUB_CHAT = "<module name=\"groupchat\" userid=\"0\"><ems type=\"chat\" sender=\"%s\" senderid=\"%s\"><![CDATA[%s]]></ems></module>";
  private static final String TAG = "ChatMsg";
  private static final long serialVersionUID = 808834629165790017L;
  private String content;
  private String groupId;
  private boolean isGroup = false;
  private String receiverId;
  private String richText;
  private long timeStamp;

  public ChatMsg()
  {
    super("chat");
  }

  public ChatMsg(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this();
    this.isGroup = paramBoolean;
    this.content = paramString2;
    this.richText = paramString3;
    setSender(paramString1);
    setSenderId(paramLong);
  }

  public String getContent()
  {
    return this.content;
  }

  public String getGroupId()
  {
    return this.groupId;
  }

  public String getReceiverId()
  {
    return this.receiverId;
  }

  public String getRichText()
  {
    return this.richText;
  }

  public long getTimeStamp()
  {
    return this.timeStamp;
  }

  protected String getXml()
  {
    String str = getSender();
    long l = getSenderId();
    if (l == 0L)
      return "";
    if ("1".equals(Boolean.valueOf(this.isGroup)))
    {
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = str;
      arrayOfObject2[1] = Long.valueOf(l);
      arrayOfObject2[2] = this.content;
      return String.format("<module name=\"groupchat\" userid=\"0\"><ems type=\"chat\" sender=\"%s\" senderid=\"%s\"><![CDATA[%s]]></ems></module>", arrayOfObject2);
    }
    if ((this.receiverId == null) || ("".equals(this.receiverId)))
      return "";
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = this.receiverId;
    arrayOfObject1[1] = str;
    arrayOfObject1[2] = Long.valueOf(l);
    arrayOfObject1[3] = this.content;
    return String.format("<module name=\"chat\" userid=\"%s\"><ems type=\"chat\" sender=\"%s\" senderid= \"%s\"><![CDATA[%s]]></ems></module>", arrayOfObject1);
  }

  public boolean isGroup()
  {
    return this.isGroup;
  }

  protected BaseMsg onXmlNode(Context paramContext, Node paramNode)
  {
    setGroup(getNodeAttrBool(paramNode, "group"));
    setSender(getNodeAttrString(paramNode, "sender"));
    setSenderid(getNodeAttrString(paramNode, "senderid"));
    setSenderId(getNodeAttrLong(paramNode, "senderId"));
    this.groupId = getNodeAttrString(paramNode, "groupid");
    if (!StringUtil.isEmpty(this.groupId))
      this.isGroup = true;
    Object localObject1 = paramNode.getFirstChild().getNodeValue();
    NodeList localNodeList = paramNode.getChildNodes();
    int j;
    label119: String str;
    if ((localNodeList != null) && (localNodeList.getLength() > 0))
    {
      int i = localNodeList.getLength();
      j = 0;
      if (j < i);
    }
    else
    {
      if (localObject1 != null)
        break label219;
      str = "";
      label127: setContent(str);
      sendBroadCast(paramContext, "gs.action.rec.msg.chat");
      return this;
    }
    Node localNode = localNodeList.item(j);
    if (localNode != null)
      if (localNode.getNodeType() != 4);
    for (Object localObject2 = ((CDATASection)localNode).getTextContent(); ; localObject2 = localObject1)
    {
      j++;
      localObject1 = localObject2;
      break;
      if (!"richtext".equals(localNode.getNodeName()))
        continue;
      setRichText(localNode.getTextContent());
      break label119;
      label219: str = ((String)localObject1).trim();
      break label127;
    }
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public void setGroup(boolean paramBoolean)
  {
    this.isGroup = paramBoolean;
  }

  public void setGroupId(String paramString)
  {
    this.groupId = paramString;
  }

  public void setReceiverId(String paramString)
  {
    this.receiverId = paramString;
  }

  public void setRichText(String paramString)
  {
    this.richText = paramString;
  }

  public void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }

  public String toString()
  {
    return "ChatMsg [group=" + this.isGroup + ", groupId=" + this.groupId + ",receiverId=" + this.receiverId + ", content=" + this.content + ", richText=" + this.richText + ", timeStamp = " + this.timeStamp + "," + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.ChatMsg
 * JD-Core Version:    0.6.0
 */