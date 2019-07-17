package com.umeng.socialize.view;

import android.location.Location;
import android.widget.Toast;
import com.umeng.socialize.location.a;
import com.umeng.socialize.location.b;

class w extends b
{
  w(ShareActivity paramShareActivity, a parama)
  {
    super(parama);
  }

  protected void a(Location paramLocation)
  {
    super.onPostExecute(paramLocation);
    ShareActivity.a(this.a, paramLocation);
    ShareActivity.b(this.a, false);
    if ((paramLocation == null) && (!this.a.isFinishing()))
      Toast.makeText(ShareActivity.p(this.a), "获取地理位置失败，请稍候重试.", 0).show();
  }

  protected void onCancelled()
  {
    super.onCancelled();
    ShareActivity.b(this.a, false);
  }

  protected void onPreExecute()
  {
    super.onPreExecute();
    ShareActivity.b(this.a, true);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.w
 * JD-Core Version:    0.6.0
 */