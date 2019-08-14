package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.withustudy.koudaizikao.entity.SubjectFavoriteExercise;
import com.withustudy.koudaizikao.entity.req.FavoriteExercise;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class a extends Handler
{
  a(ActivityCollectSubject paramActivityCollectSubject)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1:
    case 4:
    case 5:
    case 6:
    default:
      return;
    case 3:
      if (ActivityCollectSubject.access$0(this.a) != null)
        ActivityCollectSubject.access$0(this.a).clear();
      Iterator localIterator2 = ActivityCollectSubject.access$1(this.a).getFavoriteExercise().iterator();
      while (true)
      {
        if (!localIterator2.hasNext())
        {
          if (ActivityCollectSubject.access$3(this.a) != null)
            break;
          ActivityCollectSubject.access$4(this.a, new ActivityCollectSubject.a(this.a));
          ActivityCollectSubject.access$5(this.a).setAdapter(ActivityCollectSubject.access$3(this.a));
          return;
        }
        FavoriteExercise localFavoriteExercise = (FavoriteExercise)localIterator2.next();
        String str = localFavoriteExercise.getExerciseId();
        if (ActivityCollectSubject.access$2(this.a).contains(str))
          continue;
        ActivityCollectSubject.access$0(this.a).add(localFavoriteExercise);
      }
      ActivityCollectSubject.access$3(this.a).notifyDataSetChanged();
      return;
    case 0:
      if (ActivityCollectSubject.access$0(this.a) != null)
        ActivityCollectSubject.access$0(this.a).clear();
      ActivityCollectSubject.access$0(this.a).addAll(ActivityCollectSubject.access$1(this.a).getFavoriteExercise());
      if (ActivityCollectSubject.access$3(this.a) == null)
      {
        ActivityCollectSubject.access$4(this.a, new ActivityCollectSubject.a(this.a));
        ActivityCollectSubject.access$5(this.a).setAdapter(ActivityCollectSubject.access$3(this.a));
        ActivityCollectSubject.access$6(this.a, true);
        return;
      }
      ActivityCollectSubject.access$3(this.a).notifyDataSetChanged();
      return;
    case 2:
      Toast.makeText(this.a.getApplicationContext(), "删除成功！", 0).show();
      Iterator localIterator1 = ActivityCollectSubject.access$7(this.a).keySet().iterator();
      while (true)
      {
        if (!localIterator1.hasNext())
        {
          ActivityCollectSubject.access$0(this.a).clear();
          ActivityCollectSubject.access$0(this.a).addAll(ActivityCollectSubject.access$8(this.a));
          ActivityCollectSubject.access$0(this.a).size();
          ActivityCollectSubject.access$3(this.a).notifyDataSetChanged();
          return;
        }
        Integer localInteger = (Integer)localIterator1.next();
        ActivityCollectSubject.access$7(this.a).put(localInteger, Boolean.valueOf(false));
      }
    case 7:
      Toast.makeText(this.a.getApplicationContext(), "删除失败！", 0).show();
      return;
    case 8:
    }
    ActivityCollectSubject.access$9(this.a).setVisibility(0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.a
 * JD-Core Version:    0.6.0
 */