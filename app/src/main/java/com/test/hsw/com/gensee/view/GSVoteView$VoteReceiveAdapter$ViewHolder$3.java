package com.gensee.view;

import android.text.Editable;
import android.text.TextWatcher;
import com.gensee.vote.VotePlayerQuestion;

class GSVoteView$VoteReceiveAdapter$ViewHolder$3
  implements TextWatcher
{
  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.val$voteQuestion.setM_strAnwser(paramCharSequence.toString());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSVoteView.VoteReceiveAdapter.ViewHolder.3
 * JD-Core Version:    0.6.0
 */