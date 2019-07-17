package com.withustudy.koudaizikao.b;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.entity.req.Comment;
import java.util.List;

class j
  implements View.OnClickListener
{
  j(i parami, int paramInt)
  {
  }

  public void onClick(View paramView)
  {
    Comment localComment = (Comment)i.a(this.a).get(this.b);
    i.b localb = new i.b(this.a);
    localb.c = localComment;
    localb.b = this.b;
    Message localMessage = i.b(this.a).obtainMessage(7, localb);
    i.b(this.a).sendMessage(localMessage);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.j
 * JD-Core Version:    0.6.0
 */