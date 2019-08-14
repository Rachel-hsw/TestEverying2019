package com.gensee.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.gensee.vote.VotePlayerAnswer;
import java.util.Iterator;
import java.util.List;

class GSVoteView$VoteReceiveAdapter$ViewHolder$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Iterator localIterator = this.val$answersList.iterator();
    int i;
    do
    {
      i = 0;
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this.val$voteAnswer.setM_bChoose(((CheckBox)paramView).isChecked());
          if (i != 1)
            break;
          if (!((CheckBox)paramView).isChecked())
          {
            GSVoteView localGSVoteView2 = GSVoteView.VoteReceiveAdapter.access$2(GSVoteView.VoteReceiveAdapter.ViewHolder.access$0(this.this$2));
            GSVoteView.access$3(localGSVoteView2, -1 + GSVoteView.access$2(localGSVoteView2));
          }
          return;
        }
        if (!((VotePlayerAnswer)localIterator.next()).isM_bChoose())
          continue;
        i++;
      }
    }
    while ((i != 0) || (!((CheckBox)paramView).isChecked()));
    GSVoteView localGSVoteView1 = GSVoteView.VoteReceiveAdapter.access$2(GSVoteView.VoteReceiveAdapter.ViewHolder.access$0(this.this$2));
    GSVoteView.access$3(localGSVoteView1, 1 + GSVoteView.access$2(localGSVoteView1));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSVoteView.VoteReceiveAdapter.ViewHolder.2
 * JD-Core Version:    0.6.0
 */