package com.gensee.vote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VotePlayerGroup
{
  private String confId;
  private boolean m_bDeadline = false;
  private boolean m_bForce = false;
  private boolean m_bPublish = false;
  private boolean m_bPublishResult = false;
  private boolean m_bSubmited;
  private long m_owner = 0L;
  private List<VotePlayerQuestion> m_questions = new ArrayList();
  private String m_strId = "";
  private String m_strText = "";
  private long[] m_users = new long[0];
  private String name;
  private String siteId;
  private int total;
  private String type = "STANDAR";
  private String userId;

  public VotePlayerGroup cloneData()
  {
    int i = 0;
    VotePlayerGroup localVotePlayerGroup = new VotePlayerGroup();
    localVotePlayerGroup.m_bDeadline = this.m_bDeadline;
    localVotePlayerGroup.m_bForce = this.m_bForce;
    localVotePlayerGroup.m_bPublish = this.m_bPublish;
    localVotePlayerGroup.m_bPublishResult = this.m_bPublishResult;
    localVotePlayerGroup.m_owner = this.m_owner;
    int j = 0;
    if (j >= this.m_questions.size())
    {
      localVotePlayerGroup.m_strId = this.m_strId;
      localVotePlayerGroup.m_strText = this.m_strText;
    }
    while (true)
    {
      if (i >= this.m_users.length)
      {
        localVotePlayerGroup.type = this.type;
        return localVotePlayerGroup;
        localVotePlayerGroup.m_questions.add(((VotePlayerQuestion)this.m_questions.get(j)).cloneData());
        j++;
        break;
      }
      localVotePlayerGroup.m_users[i] = this.m_users[i];
      i++;
    }
  }

  public Object[] getArrayQuestions()
  {
    return this.m_questions.toArray();
  }

  public String getConfId()
  {
    return this.confId;
  }

  public long getM_owner()
  {
    return this.m_owner;
  }

  public List<VotePlayerQuestion> getM_questions()
  {
    return this.m_questions;
  }

  public String getM_strId()
  {
    return this.m_strId;
  }

  public String getM_strText()
  {
    return this.m_strText;
  }

  public long[] getM_users()
  {
    return this.m_users;
  }

  public String getName()
  {
    return this.name;
  }

  public String getSiteId()
  {
    return this.siteId;
  }

  public int getTotal()
  {
    return this.total;
  }

  public String getType()
  {
    return this.type;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public boolean haveAllAnswer()
  {
    for (int i = 0; ; i++)
    {
      int j;
      if (i >= this.m_questions.size())
        j = 1;
      boolean bool;
      do
      {
        return j;
        bool = ((VotePlayerQuestion)this.m_questions.get(i)).haveAnswer();
        j = 0;
      }
      while (!bool);
    }
  }

  public boolean haveAnswer()
  {
    for (int i = 0; ; i++)
    {
      if (i >= this.m_questions.size())
        return false;
      if (((VotePlayerQuestion)this.m_questions.get(i)).haveAnswer())
        return true;
    }
  }

  public boolean isEqual(VotePlayerGroup paramVotePlayerGroup)
  {
    if ((paramVotePlayerGroup.m_bDeadline != this.m_bDeadline) || (paramVotePlayerGroup.m_bForce != this.m_bForce) || (paramVotePlayerGroup.m_bPublish != this.m_bPublish) || (paramVotePlayerGroup.m_bPublishResult != this.m_bPublishResult) || (paramVotePlayerGroup.m_owner != this.m_owner) || (!paramVotePlayerGroup.m_strId.equals(this.m_strId)) || (!paramVotePlayerGroup.m_strText.equals(this.m_strText)) || (!paramVotePlayerGroup.type.equals(this.type)));
    do
      return false;
    while (this.m_questions.size() != paramVotePlayerGroup.m_questions.size());
    return this.m_questions.containsAll(paramVotePlayerGroup.m_questions);
  }

  public boolean isM_bDeadline()
  {
    return this.m_bDeadline;
  }

  public boolean isM_bForce()
  {
    return this.m_bForce;
  }

  public boolean isM_bPublish()
  {
    return this.m_bPublish;
  }

  public boolean isM_bPublishResult()
  {
    return this.m_bPublishResult;
  }

  public boolean isM_bSubmited()
  {
    return this.m_bSubmited;
  }

  public boolean isVoteSubmmit()
  {
    return this.m_bSubmited;
  }

  public void setArrayQuestions(VotePlayerQuestion[] paramArrayOfVotePlayerQuestion)
  {
    this.m_questions.addAll(Arrays.asList(paramArrayOfVotePlayerQuestion));
  }

  public void setArrayUsers(long[] paramArrayOfLong)
  {
    this.m_users = paramArrayOfLong;
  }

  public void setConfId(String paramString)
  {
    this.confId = paramString;
  }

  public void setM_bDeadline(boolean paramBoolean)
  {
    this.m_bDeadline = paramBoolean;
  }

  public void setM_bForce(boolean paramBoolean)
  {
    this.m_bForce = paramBoolean;
  }

  public void setM_bPublish(boolean paramBoolean)
  {
    this.m_bPublish = paramBoolean;
  }

  public void setM_bPublishResult(boolean paramBoolean)
  {
    this.m_bPublishResult = paramBoolean;
  }

  public void setM_bSubmited(boolean paramBoolean)
  {
    this.m_bSubmited = paramBoolean;
  }

  public void setM_owner(long paramLong)
  {
    this.m_owner = paramLong;
  }

  public void setM_questions(List<VotePlayerQuestion> paramList)
  {
    this.m_questions = paramList;
  }

  public void setM_strId(String paramString)
  {
    this.m_strId = paramString;
  }

  public void setM_strText(String paramString)
  {
    this.m_strText = paramString;
  }

  public void setM_users(long[] paramArrayOfLong)
  {
    this.m_users = paramArrayOfLong;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setSiteId(String paramString)
  {
    this.siteId = paramString;
  }

  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public static final class VoteGroupType
  {
    public static final String VOTE_GROUP_OTHER = "OTHER";
    public static final String VOTE_GROUP_STANDAR = "STANDAR";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vote.VotePlayerGroup
 * JD-Core Version:    0.6.0
 */