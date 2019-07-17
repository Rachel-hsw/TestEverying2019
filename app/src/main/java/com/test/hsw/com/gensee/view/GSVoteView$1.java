package com.gensee.view;

import android.os.Handler;
import android.os.Message;
import com.gensee.vote.VotePlayerGroup;

class GSVoteView$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.obj;
    switch (paramMessage.what)
    {
    case 401:
    case 402:
    default:
      return;
    case 403:
      VotePlayerGroup localVotePlayerGroup3 = (VotePlayerGroup)localObject;
      GSVoteView.access$0(this.this$0);
      this.this$0.add(localVotePlayerGroup3);
      return;
    case 404:
    case 406:
      VotePlayerGroup localVotePlayerGroup2 = (VotePlayerGroup)localObject;
      GSVoteView.access$0(this.this$0);
      this.this$0.voteResult(localVotePlayerGroup2);
      return;
    case 405:
    }
    VotePlayerGroup localVotePlayerGroup1 = (VotePlayerGroup)localObject;
    this.this$0.submit(localVotePlayerGroup1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSVoteView.1
 * JD-Core Version:    0.6.0
 */