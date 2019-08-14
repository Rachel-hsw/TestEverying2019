package com.gensee.vote;

public class VotePlayerAnswer
{
  private boolean m_bChoose = false;
  private boolean m_bCorrect = false;
  private int m_nResultUser = 0;
  private String m_strId = "";
  private String m_strText = "";
  private long[] m_users = new long[0];
  private int total;

  public VotePlayerAnswer cloneData()
  {
    VotePlayerAnswer localVotePlayerAnswer = new VotePlayerAnswer();
    localVotePlayerAnswer.m_strId = this.m_strId;
    localVotePlayerAnswer.m_strText = this.m_strText;
    localVotePlayerAnswer.m_bCorrect = this.m_bCorrect;
    localVotePlayerAnswer.m_bChoose = this.m_bChoose;
    localVotePlayerAnswer.m_nResultUser = this.m_nResultUser;
    return localVotePlayerAnswer;
  }

  public boolean equals(Object paramObject)
  {
    VotePlayerAnswer localVotePlayerAnswer = (VotePlayerAnswer)paramObject;
    return (this.m_strId.equals(localVotePlayerAnswer.m_strId)) && (this.m_strText.equals(localVotePlayerAnswer.m_strText)) && (this.m_bCorrect == localVotePlayerAnswer.m_bCorrect) && (this.m_bChoose == localVotePlayerAnswer.m_bChoose) && (this.m_nResultUser == localVotePlayerAnswer.m_nResultUser);
  }

  public int getM_nResultUser()
  {
    return this.m_nResultUser;
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

  public int getTotal()
  {
    return this.total;
  }

  public int getUsersSize()
  {
    return this.m_users.length;
  }

  public boolean isM_bChoose()
  {
    return this.m_bChoose;
  }

  public boolean isM_bCorrect()
  {
    return this.m_bCorrect;
  }

  public void setArrayUsers(long[] paramArrayOfLong)
  {
    this.m_users = paramArrayOfLong;
  }

  public void setM_bChoose(boolean paramBoolean)
  {
    this.m_bChoose = paramBoolean;
  }

  public void setM_bCorrect(boolean paramBoolean)
  {
    this.m_bCorrect = paramBoolean;
  }

  public void setM_nResultUser(int paramInt)
  {
    this.m_nResultUser = paramInt;
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

  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vote.VotePlayerAnswer
 * JD-Core Version:    0.6.0
 */