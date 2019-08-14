package com.withustudy.koudaizikao.fragment;

import android.os.Handler;
import android.os.Message;
import com.withustudy.koudaizikao.activity.ActivityErrorListActivity;
import com.withustudy.koudaizikao.entity.ErrorExercise;
import com.withustudy.koudaizikao.entity.SubjectErrorExercise;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class h extends Handler
{
  List<ErrorExercise> a;
  SubjectErrorExercise b;

  h(ErrorListFragement paramErrorListFragement)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 3:
        this.a = ((List)ErrorListFragement.a(this.c).b.get(Integer.valueOf(ErrorListFragement.b(this.c))));
        if (this.a == null)
        {
          this.a = new ArrayList();
          ErrorListFragement.a(this.c).b.put(Integer.valueOf(ErrorListFragement.b(this.c)), this.a);
        }
        this.a.clear();
        this.b = this.c.a;
        if (this.b != null)
        {
          List localList2 = this.b.getErrorExercise();
          if ((localList2 != null) && (localList2.size() > 0))
            this.a.addAll(localList2);
        }
        ErrorListFragement.a(this.c, this.a);
        ErrorListFragement.c(this.c);
        return;
      case 2:
        this.a = ((List)ErrorListFragement.a(this.c).b.get(Integer.valueOf(ErrorListFragement.b(this.c))));
        if (this.a == null)
        {
          this.a = new ArrayList();
          ErrorListFragement.a(this.c).b.put(Integer.valueOf(ErrorListFragement.b(this.c)), this.a);
        }
        this.a.clear();
        this.b = this.c.a;
        if (this.b != null)
        {
          List localList1 = this.b.getErrorExercise();
          if ((localList1 != null) && (localList1.size() > 0))
            this.a.addAll(localList1);
        }
        ErrorListFragement.a(this.c, this.a);
        ErrorListFragement.d(this.c);
      case 1:
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.h
 * JD-Core Version:    0.6.0
 */