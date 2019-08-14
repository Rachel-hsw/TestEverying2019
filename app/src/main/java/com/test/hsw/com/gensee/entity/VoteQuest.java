package com.gensee.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VoteQuest
  implements Serializable
{
  public static final String TYPE_MULTI = "multi";
  public static final String TYPE_SINGLE = "single";
  public static final String TYPE_TEXT = "text";
  private static final long serialVersionUID = 4631616639131304932L;
  private String answer;
  private String id;
  private List<VoteQuestItem> questItems;
  private int score;
  private String subject;
  private String submitAnswer;
  private int total;
  private String type;

  public VoteQuest()
  {
  }

  public VoteQuest(Node paramNode)
  {
    this.id = BaseMsg.getNodeAttrString(paramNode, "id");
    this.type = BaseMsg.getNodeAttrString(paramNode, "type");
    this.score = BaseMsg.getNodeAttrInt(paramNode, "score");
    this.answer = BaseMsg.getNodeAttrString(paramNode, "answer");
    this.total = BaseMsg.getNodeAttrInt(paramNode, "total");
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
      return;
    }
    Node localNode = localNodeList.item(j);
    String str1;
    if (localNode != null)
    {
      str1 = localNode.getNodeName();
      if (!"item".equals(str1))
        break label128;
      onItem(localNode);
    }
    label128: 
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

  private void onItem(Node paramNode)
  {
    if (this.questItems == null)
      this.questItems = new ArrayList();
    this.questItems.add(new VoteQuestItem(paramNode));
  }

  public String getAnswer()
  {
    return this.answer;
  }

  public String getId()
  {
    return this.id;
  }

  public List<VoteQuestItem> getQuestItems()
  {
    return this.questItems;
  }

  public int getScore()
  {
    return this.score;
  }

  public String getSubject()
  {
    return this.subject;
  }

  public String getSubmitAnswer()
  {
    return this.submitAnswer;
  }

  public int getTotal()
  {
    return this.total;
  }

  public String getType()
  {
    return this.type;
  }

  public int getXml(StringBuilder paramStringBuilder)
  {
    String str;
    if ("text".equals(this.type))
      if (this.submitAnswer == null)
      {
        str = "";
        paramStringBuilder.append("<question id=\"" + this.id + "\">" + "<item idx=\"0\">" + str + "</item>");
      }
    Object localObject1;
    int j;
    int k;
    while (true)
    {
      paramStringBuilder.append("</question>");
      return 0;
      str = this.submitAnswer;
      break;
      if ("multi".equals(this.type))
      {
        paramStringBuilder.append("<question id=\"" + this.id + "\">");
        int n = this.questItems.size();
        for (int i1 = 0; i1 < n; i1++)
        {
          VoteQuestItem localVoteQuestItem2 = (VoteQuestItem)this.questItems.get(i1);
          if (localVoteQuestItem2 == null)
            continue;
          localVoteQuestItem2.getXml(paramStringBuilder, i1);
        }
        continue;
      }
      if (!"single".equals(this.type))
        break label336;
      paramStringBuilder.append("<question id=\"" + this.id + "\">");
      localObject1 = null;
      int i = this.questItems.size();
      j = 0;
      k = -1;
      if (j < i)
        break label269;
      if ((k == -1) || (localObject1 == null))
        break label334;
      localObject1.getXml(paramStringBuilder, k);
    }
    label269: VoteQuestItem localVoteQuestItem1 = (VoteQuestItem)this.questItems.get(j);
    Object localObject2;
    int m;
    if ((localVoteQuestItem1 != null) && (localVoteQuestItem1.isSelected()))
      if (k == -1)
      {
        localObject2 = localVoteQuestItem1;
        m = j;
      }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      k = m;
      break;
      if (j == k)
      {
        return -1;
        label334: return -1;
        label336: return -1;
      }
      m = k;
      localObject2 = localObject1;
    }
  }

  public void setAnswer(String paramString)
  {
    this.answer = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setQuestItems(List<VoteQuestItem> paramList)
  {
    this.questItems = paramList;
  }

  public void setScore(int paramInt)
  {
    this.score = paramInt;
  }

  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }

  public void setSubmitAnswer(String paramString)
  {
    this.submitAnswer = paramString;
  }

  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public String toString()
  {
    return "VoteQuest [id=" + this.id + ", type=" + this.type + ", score=" + this.score + ", answer=" + this.answer + ", subject=" + this.subject + ", total=" + this.total + ", questItems=" + this.questItems + ", submitAnswer=" + this.submitAnswer + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.VoteQuest
 * JD-Core Version:    0.6.0
 */