package com.withustudy.koudaizikao.b;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.activity.ShowPictureActivity;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.entity.PostReply;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class y
  implements View.OnClickListener
{
  y(w paramw, int paramInt1, int paramInt2)
  {
  }

  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type", "online");
    localBundle.putInt("currentitem_key", this.b);
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; ; i++)
    {
      if (i >= ((PostReply)w.d(this.a).get(this.c)).getPost_files().size())
      {
        localBundle.putSerializable("image_name", (Serializable)localArrayList);
        ((AbsBaseActivity)w.a(this.a)).startNewActivity(ShowPictureActivity.class, false, localBundle);
        return;
      }
      localArrayList.add(((java.lang.String)((PostReply)w.d(this.a).get(this.c)).getPost_files().get(i)).split(";")[0]);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.y
 * JD-Core Version:    0.6.0
 */