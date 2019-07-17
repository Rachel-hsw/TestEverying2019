package com.withustudy.koudaizikao.activity;

import a.a.a.e.k;
import java.util.List;
import koudai.db.UserAnsDao;
import koudai.db.UserAnsDao.Properties;

class ao
  implements Runnable
{
  ao(MainActivity paramMainActivity)
  {
  }

  public void run()
  {
    List localList = MainActivity.access$20(this.a).k().a(UserAnsDao.Properties.g.a(MainActivity.access$9(this.a)), new k[0]).d();
    MainActivity.access$20(this.a).c(localList);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ao
 * JD-Core Version:    0.6.0
 */