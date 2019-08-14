package com.gensee.view;

import android.view.View;
import android.view.View.OnClickListener;

class AbsChatToPopView$PopChatAdapter$ViewChatHolder$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (AbsChatToPopView.access$1(AbsChatToPopView.PopChatAdapter.access$0(AbsChatToPopView.PopChatAdapter.ViewChatHolder.access$0(this.this$2))) != null)
    {
      AbsChatToPopView.access$1(AbsChatToPopView.PopChatAdapter.access$0(AbsChatToPopView.PopChatAdapter.ViewChatHolder.access$0(this.this$2))).sendToChatOther(this.val$position);
      AbsChatToPopView.PopChatAdapter.access$0(AbsChatToPopView.PopChatAdapter.ViewChatHolder.access$0(this.this$2)).dismiss();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.AbsChatToPopView.PopChatAdapter.ViewChatHolder.1
 * JD-Core Version:    0.6.0
 */