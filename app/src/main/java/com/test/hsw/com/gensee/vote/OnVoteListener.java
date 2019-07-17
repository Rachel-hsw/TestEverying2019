package com.gensee.vote;

public abstract interface OnVoteListener
{
  public static final int SUBMIT_FORCE_ANSWER_LACKED = 1;
  public static final int SUBMIT_NO_ANSWER = 2;

  public abstract void onVotePostUrl(String paramString, long paramLong);

  public abstract void onVotePublish(VotePlayerGroup paramVotePlayerGroup);

  public abstract void onVotePublishResult(VotePlayerGroup paramVotePlayerGroup);

  public abstract void onVoteSubmitRet(int paramInt);

  public static abstract interface VOTE
  {
    public static final int VOTE_ADD = 401;
    public static final int VOTE_DEADLINT = 406;
    public static final int VOTE_DEL = 402;
    public static final int VOTE_JOIN_CONFIREM = 400;
    public static final int VOTE_POST_URL = 407;
    public static final int VOTE_PUBLISH = 403;
    public static final int VOTE_PUBLISH_RESULT = 404;
    public static final int VOTE_SUBMIT = 405;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vote.OnVoteListener
 * JD-Core Version:    0.6.0
 */