package com.gensee.vote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VotePlayerQuestion
{
  public static final int DEFAULT_VOTE_QUESTION_ANSWERS = 6;
  public static final int MAX_VOTE_QUESTION_ANSWERS = 20;
  private List<VotePlayerAnswer> m_answers = new ArrayList();
  private int m_nResultUser = 0;
  private int m_nScore = 0;
  private String m_strAnwser = "";
  private String m_strId = "";
  private String m_strText = "";
  private String m_strType = "single";
  private long[] m_users = new long[0];
  private int total;

  public void addDefaultAnswers()
  {
    for (int i = 0; ; i++)
    {
      if (i >= 6)
        return;
      this.m_answers.add(new VotePlayerAnswer());
    }
  }

  public VotePlayerQuestion cloneData()
  {
    VotePlayerQuestion localVotePlayerQuestion = new VotePlayerQuestion();
    localVotePlayerQuestion.m_nResultUser = this.m_nResultUser;
    localVotePlayerQuestion.m_nScore = this.m_nScore;
    localVotePlayerQuestion.m_strAnwser = this.m_strAnwser;
    localVotePlayerQuestion.m_strId = this.m_strId;
    localVotePlayerQuestion.m_strText = this.m_strText;
    localVotePlayerQuestion.m_strType = this.m_strType;
    int i = 0;
    int j = this.m_users.length;
    int k = 0;
    if (i >= j);
    while (true)
    {
      if (k >= this.m_answers.size())
      {
        return localVotePlayerQuestion;
        localVotePlayerQuestion.m_users[i] = this.m_users[i];
        i++;
        break;
      }
      localVotePlayerQuestion.m_answers.add(((VotePlayerAnswer)this.m_answers.get(k)).cloneData());
      k++;
    }
  }

  public void copyData(VotePlayerQuestion paramVotePlayerQuestion)
  {
    this.m_nResultUser = paramVotePlayerQuestion.m_nResultUser;
    this.m_nScore = paramVotePlayerQuestion.m_nScore;
    this.m_strAnwser = paramVotePlayerQuestion.m_strAnwser;
    this.m_strId = paramVotePlayerQuestion.m_strId;
    this.m_strText = paramVotePlayerQuestion.m_strText;
    this.m_strType = paramVotePlayerQuestion.m_strType;
    this.m_answers.clear();
    for (int i = 0; ; i++)
    {
      if (i >= paramVotePlayerQuestion.m_answers.size())
        return;
      this.m_answers.add(((VotePlayerAnswer)paramVotePlayerQuestion.m_answers.get(i)).cloneData());
    }
  }

  public boolean equals(Object paramObject)
  {
    VotePlayerQuestion localVotePlayerQuestion = (VotePlayerQuestion)paramObject;
    if ((!this.m_strId.equals(localVotePlayerQuestion.m_strId)) || (!this.m_strText.equals(localVotePlayerQuestion.m_strText)) || (!this.m_strAnwser.equals(localVotePlayerQuestion.m_strAnwser)) || (this.m_nScore != localVotePlayerQuestion.m_nScore) || (!this.m_strType.equals(localVotePlayerQuestion.m_strType)) || (this.m_nResultUser != localVotePlayerQuestion.m_nResultUser));
    do
      return false;
    while (this.m_answers.size() != localVotePlayerQuestion.m_answers.size());
    return this.m_answers.containsAll(localVotePlayerQuestion.m_answers);
  }

  public Object[] getArrayAnswers()
  {
    return this.m_answers.toArray();
  }

  public List<VotePlayerAnswer> getM_answers()
  {
    return this.m_answers;
  }

  public int getM_nResultUser()
  {
    return this.m_nResultUser;
  }

  public int getM_nScore()
  {
    return this.m_nScore;
  }

  public String getM_strAnwser()
  {
    return this.m_strAnwser;
  }

  public String getM_strId()
  {
    return this.m_strId;
  }

  public String getM_strText()
  {
    return this.m_strText;
  }

  public String getM_strType()
  {
    return this.m_strType;
  }

  public long[] getM_users()
  {
    return this.m_users;
  }

  public int getTotal()
  {
    return this.total;
  }

  public int getUsersSize()
  {
    return this.m_users.length;
  }

  public boolean haveAnswer()
  {
    if ("text".equals(this.m_strType))
      if ((this.m_strAnwser != null) && (!"".equals(this.m_strAnwser)));
    while (true)
    {
      return false;
      return true;
      for (int i = 0; i < this.m_answers.size(); i++)
        if (((VotePlayerAnswer)this.m_answers.get(i)).isM_bChoose())
          return true;
    }
  }

  public void setArrayAnswes(VotePlayerAnswer[] paramArrayOfVotePlayerAnswer)
  {
    this.m_answers.addAll(Arrays.asList(paramArrayOfVotePlayerAnswer));
  }

  public void setArrayUsers(long[] paramArrayOfLong)
  {
    this.m_users = paramArrayOfLong;
  }

  public void setM_answers(List<VotePlayerAnswer> paramList)
  {
    this.m_answers = paramList;
  }

  public void setM_nResultUser(int paramInt)
  {
    this.m_nResultUser = paramInt;
  }

  public void setM_nScore(int paramInt)
  {
    this.m_nScore = paramInt;
  }

  public void setM_strAnwser(String paramString)
  {
    this.m_strAnwser = paramString;
  }

  public void setM_strId(String paramString)
  {
    this.m_strId = paramString;
  }

  public void setM_strText(String paramString)
  {
    this.m_strText = paramString;
  }

  public void setM_strType(String paramString)
  {
    this.m_strType = paramString;
  }

  public void setM_users(long[] paramArrayOfLong)
  {
    this.m_users = paramArrayOfLong;
  }

  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }

  public static class VoteQuestionType
  {
    public static final String MULTI_TYPE = "multi";
    public static final String SINGLE_TYPE = "single";
    public static final String TEXT_TYPE = "text";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vote.VotePlayerQuestion
 * JD-Core Version:    0.6.0
 */