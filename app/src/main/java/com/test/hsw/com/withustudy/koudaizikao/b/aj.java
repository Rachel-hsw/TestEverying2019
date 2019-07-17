package com.withustudy.koudaizikao.b;

import a.a.a.e.k;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.withustudy.koudaizikao.g.h;
import java.util.List;
import koudai.db.CourseJiangYiInforDao;
import koudai.db.CourseJiangYiInforDao.Properties;
import koudai.db.b;

class aj
  implements View.OnClickListener
{
  aj(ah paramah, String paramString, int paramInt)
  {
  }

  public void onClick(View paramView)
  {
    h.a("handout=:" + this.b);
    List localList = ah.c(this.a).k().a(CourseJiangYiInforDao.Properties.c.a(this.b), new k[0]).d();
    if ((localList != null) && (localList.size() > 0))
    {
      switch (((b)localList.get(0)).g().intValue())
      {
      default:
        return;
      case 0:
        ah.a(this.a, this.c, this.b);
        return;
      case 1:
        Toast.makeText(ah.b(this.a), "正在下载", 0).show();
        return;
      case 2:
      }
      this.a.a(this.b);
      return;
    }
    ah.a(this.a, this.c, this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.aj
 * JD-Core Version:    0.6.0
 */