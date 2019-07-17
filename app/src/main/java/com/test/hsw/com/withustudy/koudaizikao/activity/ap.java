package com.withustudy.koudaizikao.activity;

import a.a.a.e.k;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.entity.req.push.ReqPushAnser;
import com.withustudy.koudaizikao.entity.req.push.UserAnswers;
import com.withustudy.koudaizikao.g.n;
import java.util.Iterator;
import java.util.List;
import koudai.db.UserAnsDao;
import koudai.db.UserAnsDao.Properties;

class ap
  implements Runnable
{
  ap(MainActivity paramMainActivity, String paramString1, String paramString2, long paramLong)
  {
  }

  public void run()
  {
    try
    {
      this.a.userList.clear();
      a.a.a.e.i locali = MainActivity.access$20(this.a).k();
      com.withustudy.koudaizikao.g.h.a("查找的批次id----------------------------------------------------" + this.b);
      Iterator localIterator = locali.a(UserAnsDao.Properties.g.a(this.b), new k[0]).d().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          com.withustudy.koudaizikao.g.h.a("题目数=" + this.a.userList.size());
          com.withustudy.koudaizikao.g.h.a("推送题目数=" + this.a.userList.size());
          ReqPushAnser localReqPushAnser = new ReqPushAnser();
          localReqPushAnser.setUserAnswers(this.a.userList);
          localReqPushAnser.setVersionName(MainActivity.access$1(this.a).p());
          localReqPushAnser.setClientType(n.a());
          localReqPushAnser.setImei(n.d(MainActivity.access$2(this.a)));
          localReqPushAnser.setNet(n.c(MainActivity.access$2(this.a)));
          UserSubject localUserSubject = new UserSubject();
          localUserSubject.setSubjectId(MainActivity.access$22(this.a));
          localUserSubject.setUid(MainActivity.access$1(this.a).i());
          localReqPushAnser.setUserSubject(localUserSubject);
          localReqPushAnser.setBrushType(this.c);
          localReqPushAnser.setMockCostTime(this.d);
          c.b().p().a(this.a, localReqPushAnser, 100);
          return;
        }
        koudai.db.h localh = (koudai.db.h)localIterator.next();
        Boolean localBoolean1 = localh.d();
        if ((localBoolean1 == null) || (!localBoolean1.booleanValue()))
          continue;
        Long localLong = localh.b();
        String str1 = localh.j();
        String str2 = localh.k();
        String str3 = localh.i();
        Double localDouble = localh.f();
        Boolean localBoolean2 = localh.e();
        UserAnswers localUserAnswers = new UserAnswers();
        localUserAnswers.setBrushTime(localLong.longValue());
        localUserAnswers.setCorrect(localBoolean2.booleanValue());
        localUserAnswers.setUserScore(localDouble.doubleValue());
        localUserAnswers.setUserAnswer(MainActivity.access$21(this.a, localUserAnswers, str3));
        localUserAnswers.setKpointId(str2);
        localUserAnswers.setExerciseId(str1);
        this.a.userList.add(localUserAnswers);
      }
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ap
 * JD-Core Version:    0.6.0
 */