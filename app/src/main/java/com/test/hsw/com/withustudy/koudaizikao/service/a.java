package com.withustudy.koudaizikao.service;

import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.entity.req.push.ReqPushAnser;
import com.withustudy.koudaizikao.entity.req.push.UserAnswers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class a
  implements Runnable
{
  a(PushExcerciseService paramPushExcerciseService, UserSubject paramUserSubject)
  {
  }

  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.a.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        ReqPushAnser localReqPushAnser = new ReqPushAnser();
        localReqPushAnser.setUserAnswers(localArrayList);
        localReqPushAnser.setUserSubject(this.b);
        c.b().p().a(this.a, localReqPushAnser, 0);
        return;
      }
      Integer localInteger = (Integer)localIterator.next();
      localArrayList.add((UserAnswers)this.a.a.get(localInteger));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.service.a
 * JD-Core Version:    0.6.0
 */