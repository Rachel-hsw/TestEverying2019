package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class v
  implements View.OnClickListener
{
  v(InformationDetailActivity paramInformationDetailActivity, List paramList)
  {
  }

  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type", "online");
    localBundle.putInt("currentitem_key", 0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(((String)this.b.get(((Integer)paramView.getTag()).intValue())).substring(2, -2 + ((String)this.b.get(((Integer)paramView.getTag()).intValue())).length()));
    localBundle.putSerializable("image_name", (Serializable)localArrayList);
    this.a.startNewActivity(ShowPictureActivity.class, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.v
 * JD-Core Version:    0.6.0
 */