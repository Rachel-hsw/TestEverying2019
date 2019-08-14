package com.gensee.entity;

import java.io.Serializable;
import org.w3c.dom.Node;

public class VoteQuestItem
  implements Serializable
{
  private static final long serialVersionUID = 6268417741981959766L;
  private String content;
  private boolean correct;
  private String id;
  private boolean isSelected;
  private int total;

  public VoteQuestItem()
  {
  }

  public VoteQuestItem(Node paramNode)
  {
    this.id = BaseMsg.getNodeAttrString(paramNode, "id");
    this.correct = BaseMsg.getNodeAttrBool(paramNode, "correct");
    this.total = BaseMsg.getNodeAttrInt(paramNode, "total");
    this.content = paramNode.getTextContent();
    if (this.content == null);
    for (String str = ""; ; str = this.content.trim())
    {
      this.content = str;
      return;
    }
  }

  public String getContent()
  {
    return this.content;
  }

  public String getId()
  {
    return this.id;
  }

  public int getTotal()
  {
    return this.total;
  }

  public void getXml(StringBuilder paramStringBuilder, int paramInt)
  {
    if (this.isSelected)
      paramStringBuilder.append("<item idx=\"" + paramInt + "\" id=\"" + this.id + "\"/>");
  }

  public boolean isCorrect()
  {
    return this.correct;
  }

  public boolean isSelected()
  {
    return this.isSelected;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public void setCorrect(boolean paramBoolean)
  {
    this.correct = paramBoolean;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }

  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }

  public String toString()
  {
    return "VoteQuestItem [id=" + this.id + ", correct=" + this.correct + ", content=" + this.content + ", total=" + this.total + ", isSelected=" + this.isSelected + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.VoteQuestItem
 * JD-Core Version:    0.6.0
 */