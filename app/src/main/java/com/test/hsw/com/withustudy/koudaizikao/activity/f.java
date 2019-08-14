package com.withustudy.koudaizikao.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.HashMap;

class f
  implements AdapterView.OnItemClickListener
{
  f(ActivityErrorListActivity paramActivityErrorListActivity)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Toast.makeText(this.a.getApplicationContext(), paramInt, 0).show();
    Boolean localBoolean = (Boolean)ActivityErrorListActivity.j(this.a).get(Integer.valueOf(paramInt));
    ImageView localImageView = (ImageView)paramView.findViewById(2131296928);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      localImageView.setBackgroundResource(2130837807);
      ActivityErrorListActivity.j(this.a).put(Integer.valueOf(paramInt), Boolean.valueOf(true));
      return;
    }
    localImageView.setBackgroundResource(2130838198);
    ActivityErrorListActivity.j(this.a).put(Integer.valueOf(paramInt), Boolean.valueOf(false));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.f
 * JD-Core Version:    0.6.0
 */