package com.koudai.test;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.activity.ShowPictureActivity;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class j
  implements View.OnClickListener
{
  j(BrushFragment paramBrushFragment, String paramString)
  {
  }

  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type", "online");
    localBundle.putInt("currentitem_key", 0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    localBundle.putSerializable("image_name", (Serializable)localArrayList);
    ((AbsBaseActivity)this.a.d).startNewActivity(ShowPictureActivity.class, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.j
 * JD-Core Version:    0.6.0
 */