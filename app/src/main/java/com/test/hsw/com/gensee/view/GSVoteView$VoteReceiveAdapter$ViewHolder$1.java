package com.gensee.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import com.gensee.vote.VotePlayerAnswer;
import java.util.Iterator;
import java.util.List;

class GSVoteView$VoteReceiveAdapter$ViewHolder$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Iterator localIterator1;
    int i;
    Iterator localIterator2;
    if (((RadioButton)paramView).isChecked())
    {
      localIterator1 = this.val$answersList.iterator();
      i = 0;
      if (!localIterator1.hasNext())
      {
        if (i == 0)
        {
          GSVoteView localGSVoteView2 = GSVoteView.VoteReceiveAdapter.access$2(GSVoteView.VoteReceiveAdapter.ViewHolder.access$0(this.this$2));
          GSVoteView.access$3(localGSVoteView2, 1 + GSVoteView.access$2(localGSVoteView2));
        }
        localIterator2 = this.val$rbButtonList.iterator();
        label72: if (localIterator2.hasNext())
          break label128;
      }
    }
    while (true)
    {
      this.val$voteAnswer.setM_bChoose(((RadioButton)paramView).isChecked());
      return;
      VotePlayerAnswer localVotePlayerAnswer = (VotePlayerAnswer)localIterator1.next();
      if (localVotePlayerAnswer.isM_bChoose())
        i = 1;
      localVotePlayerAnswer.setM_bChoose(false);
      break;
      label128: RadioButton localRadioButton = (RadioButton)localIterator2.next();
      if ((localRadioButton == (RadioButton)paramView) || (!localRadioButton.isChecked()))
        break label72;
      localRadioButton.setChecked(false);
      break label72;
      GSVoteView localGSVoteView1 = GSVoteView.VoteReceiveAdapter.access$2(GSVoteView.VoteReceiveAdapter.ViewHolder.access$0(this.this$2));
      GSVoteView.access$3(localGSVoteView1, -1 + GSVoteView.access$2(localGSVoteView1));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSVoteView.VoteReceiveAdapter.ViewHolder.1
 * JD-Core Version:    0.6.0
 */