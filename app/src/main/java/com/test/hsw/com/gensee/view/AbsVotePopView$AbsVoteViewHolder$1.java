package com.gensee.view;

import android.view.View;
import android.view.View.OnClickListener;

class AbsVotePopView$AbsVoteViewHolder$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (AbsVotePopView.AbsVoteViewHolder.access$0(this.this$1).interfaceSelectOther != null)
    {
      AbsVotePopView.AbsVoteViewHolder.access$0(this.this$1).interfaceSelectOther.sendToOther(this.val$position);
      AbsVotePopView.AbsVoteViewHolder.access$0(this.this$1).dismiss();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.AbsVotePopView.AbsVoteViewHolder.1
 * JD-Core Version:    0.6.0
 */