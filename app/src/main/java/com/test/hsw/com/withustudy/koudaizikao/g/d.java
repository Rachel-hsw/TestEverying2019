package com.withustudy.koudaizikao.g;

import com.withustudy.koudaizikao.entity.Major;
import com.withustudy.koudaizikao.entity.Province;
import com.withustudy.koudaizikao.entity.content.ProvMajorsContent;
import java.util.Iterator;
import java.util.List;
import koudai.db.MajorDBDao;
import koudai.db.ProvinceDBDao;
import koudai.db.e;
import koudai.db.g;

class d
  implements Runnable
{
  d(ProvMajorsContent paramProvMajorsContent, MajorDBDao paramMajorDBDao, ProvinceDBDao paramProvinceDBDao)
  {
  }

  public void run()
  {
    Iterator localIterator1 = this.a.getProvMajors().iterator();
    if (!localIterator1.hasNext())
      return;
    Province localProvince = (Province)localIterator1.next();
    String str1 = localProvince.getProvId();
    String str2 = localProvince.getProvName();
    Iterator localIterator2 = localProvince.getMajor().iterator();
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        g localg = new g();
        localg.a(str1);
        localg.b(str2);
        this.c.c(localg);
        break;
      }
      Major localMajor = (Major)localIterator2.next();
      String str3 = localMajor.getMajorId();
      String str4 = localMajor.getMajorName();
      String str5 = localMajor.getProvName();
      e locale = new e();
      locale.a(str3);
      locale.c(str5);
      locale.b(str4);
      this.b.c(locale);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.d
 * JD-Core Version:    0.6.0
 */