package com.gensee.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.gensee.chat.MsgQueue;
import com.gensee.chat.msg.AbsChatMessage;
import java.util.List;

class AbsChatAdapter$AbsChatViewHolder$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    AbsChatAdapter.access$0(AbsChatAdapter.AbsChatViewHolder.access$0(this.this$1)).remove(this.val$positon);
    MsgQueue.getIns().deleteMsg(this.val$mAbsChatMessage);
    AbsChatAdapter.AbsChatViewHolder.access$0(this.this$1).notifyDataSetChanged();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.adapter.AbsChatAdapter.AbsChatViewHolder.1
 * JD-Core Version:    0.6.0
 */