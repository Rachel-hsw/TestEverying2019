package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.entity.ChapterSectionListBean;
import com.withustudy.koudaizikao.entity.ChapterSummary;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.g.h;
import java.util.Iterator;
import java.util.List;

class l extends Handler
{
  l(ChapterSectionListActivity paramChapterSectionListActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 102:
        List localList2 = ChapterSectionListActivity.a(this.a).getChapterSummary();
        if (localList2 == null)
          break;
        ChapterSectionListActivity.b(this.a).clear();
        ChapterSectionListActivity.b(this.a).addAll(localList2);
        if (localList2 != null)
        {
          Iterator localIterator;
          if (ChapterSectionListActivity.c(this.a) == null)
          {
            ChapterSectionListActivity.a(this.a, new ChapterSectionListActivity.a(this.a, ChapterSectionListActivity.b(this.a)));
            ChapterSectionListActivity.d(this.a).setAdapter(ChapterSectionListActivity.c(this.a));
            boolean bool = ChapterSectionListActivity.a(this.a).isHasLastFlag();
            if (!bool)
              break;
            h.a("初次蒙层hasLastFlag=" + bool);
            h.a("hasLastFlag=" + bool);
            localIterator = localList2.iterator();
          }
          else
          {
            int j;
            for (int i = 0; ; i = j)
            {
              if (!localIterator.hasNext())
              {
                ChapterSectionListActivity.a(this.a, i);
                return;
                ChapterSectionListActivity.c(this.a).notifyDataSetChanged();
                break;
              }
              j = i + ((ChapterSummary)localIterator.next()).getDoneExerciseNum();
              h.a("total=" + j);
            }
          }
        }
        else
        {
          h.a("章节列表数据解析实体bean内部为null");
          return;
        }
      case 1:
        ChapterSectionListActivity.b(this.a, 0);
        return;
      case 101:
        if (ChapterSectionListActivity.e(this.a) == null)
          break;
        List localList1 = ChapterSectionListActivity.e(this.a).getUrls();
        if ((localList1 == null) || (localList1.size() <= 0))
          break;
        Urls localUrls = (Urls)localList1.get(0);
        String str1 = localUrls.getUrl_short();
        String str2 = localUrls.getUrl_long();
        h.a("url_short ", str1);
        h.a("url_long ", str2);
        ChapterSectionListActivity.a(this.a, new a(this.a, ChapterSectionListActivity.d(this.a)));
        ChapterSectionListActivity.f(this.a).c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
        ChapterSectionListActivity.f(this.a).a(str2);
        ChapterSectionListActivity.f(this.a).d(str1);
        ChapterSectionListActivity.f(this.a).b("口袋自考");
        ChapterSectionListActivity.f(this.a).b();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.l
 * JD-Core Version:    0.6.0
 */