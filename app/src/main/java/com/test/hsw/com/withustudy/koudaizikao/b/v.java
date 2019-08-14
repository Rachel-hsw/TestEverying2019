package com.withustudy.koudaizikao.b;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.activity.ShowPictureActivity;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.entity.Post;
import java.io.Serializable;
import java.util.List;

class v
  implements View.OnClickListener
{
  v(t paramt, int paramInt1, int paramInt2)
  {
  }

  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type", "online");
    localBundle.putInt("currentitem_key", this.b);
    localBundle.putSerializable("image_name", (Serializable)((Post)t.a(this.a).get(this.c)).getPost_files());
    ((AbsBaseActivity)t.c(this.a)).startNewActivity(ShowPictureActivity.class, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.v
 * JD-Core Version:    0.6.0
 */