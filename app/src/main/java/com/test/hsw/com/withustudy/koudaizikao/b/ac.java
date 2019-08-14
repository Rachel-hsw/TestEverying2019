package com.withustudy.koudaizikao.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.entity.Post;
import java.util.List;

class ac
  implements View.OnClickListener
{
  ac(ab paramab, int paramInt)
  {
  }

  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", ((Post)ab.a(this.a).get(this.b)).getTopic_id());
    Message localMessage = ab.b(this.a).obtainMessage(4, localBundle);
    ab.b(this.a).sendMessage(localMessage);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.ac
 * JD-Core Version:    0.6.0
 */