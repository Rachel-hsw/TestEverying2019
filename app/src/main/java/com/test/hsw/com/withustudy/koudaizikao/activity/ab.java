package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.entity.ChapterKpointSummaryW;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.util.List;

class ab extends Handler
{
  ab(KnowledgeExplainActivity paramKnowledgeExplainActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 0:
        List localList2 = KnowledgeExplainActivity.a(this.a).getChapterKpointSummary();
        if (localList2 != null)
          if (KnowledgeExplainActivity.b(this.a) == null)
          {
            KnowledgeExplainActivity.a(this.a, new KnowledgeExplainActivity.a(this.a, localList2));
            KnowledgeExplainActivity.c(this.a).setAdapter(KnowledgeExplainActivity.b(this.a));
          }
        while (true)
        {
          KnowledgeExplainActivity.d(this.a).b();
          return;
          KnowledgeExplainActivity.b(this.a).notifyDataSetChanged();
          continue;
          h.a("知识点讲解数据解析实体bean实体内部为null");
        }
      case 1:
        KnowledgeExplainActivity.e(this.a);
        return;
      case 101:
        if (KnowledgeExplainActivity.f(this.a) == null)
          break;
        List localList1 = KnowledgeExplainActivity.f(this.a).getUrls();
        if ((localList1 == null) || (localList1.size() <= 0))
          break;
        Urls localUrls = (Urls)localList1.get(0);
        String str1 = localUrls.getUrl_short();
        String str2 = localUrls.getUrl_long();
        h.a("url_short ", str1);
        h.a("url_long ", str2);
        KnowledgeExplainActivity.a(this.a, new a(this.a, KnowledgeExplainActivity.c(this.a)));
        KnowledgeExplainActivity.g(this.a).c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
        KnowledgeExplainActivity.g(this.a).a(str2);
        KnowledgeExplainActivity.g(this.a).d(str1);
        KnowledgeExplainActivity.g(this.a).b("口袋自考");
        KnowledgeExplainActivity.g(this.a).b();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ab
 * JD-Core Version:    0.6.0
 */