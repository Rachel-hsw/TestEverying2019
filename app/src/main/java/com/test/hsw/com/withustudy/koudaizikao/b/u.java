package com.withustudy.koudaizikao.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.withustudy.koudaizikao.activity.MyPostActivity.b;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.fragment.FavoritePostFragment.b;
import java.util.List;

class u
  implements View.OnClickListener
{
  u(t paramt, int paramInt)
  {
  }

  public void onClick(View paramView)
  {
    ImageView localImageView = ((t.a)paramView.getTag()).f;
    if ((localImageView != null) && (localImageView.getVisibility() == 0))
      localImageView.setVisibility(4);
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", ((Post)t.a(this.a).get(this.b)).getTopic_id());
    Message localMessage;
    if ((t.b(this.a) instanceof MyPostActivity.b))
      localMessage = t.b(this.a).obtainMessage(3, localBundle);
    while (true)
    {
      t.b(this.a).sendMessage(localMessage);
      return;
      if ((t.b(this.a) instanceof FavoritePostFragment.b))
      {
        localMessage = t.b(this.a).obtainMessage(1, localBundle);
        continue;
      }
      localMessage = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.u
 * JD-Core Version:    0.6.0
 */