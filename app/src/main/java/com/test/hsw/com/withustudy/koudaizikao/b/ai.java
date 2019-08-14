package com.withustudy.koudaizikao.b;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.withustudy.koudaizikao.g.h;

class ai
  implements Handler.Callback
{
  ai(ah paramah)
  {
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 0:
      ah.b localb;
      TextView localTextView;
      String str2;
      do
        while (true)
        {
          return false;
          localb = (ah.b)paramMessage.obj;
          int i = 1 + ah.b.a(localb);
          int j = ah.a(this.a).getFirstVisiblePosition();
          int k = ah.a(this.a).getLastVisiblePosition();
          if ((i < j) || (i > k))
            continue;
          View localView = ah.a(this.a).getChildAt(i - j);
          ProgressBar localProgressBar = (ProgressBar)localView.findViewById(2131297351);
          localTextView = (TextView)localView.findViewById(2131297352);
          String str1 = (String)localProgressBar.getTag();
          if (!ah.b.b(localb).equals(str1))
            continue;
          h.a("childAt=" + localView);
          localProgressBar.setMax(ah.b.c(localb));
          localProgressBar.setProgress(ah.b.d(localb));
          localProgressBar.setVisibility(0);
          str2 = (String)localTextView.getTag();
          if (ah.b.d(localb) != ah.b.c(localb))
            break;
          h.a(ah.b(this.a), "下载完成");
          localProgressBar.setVisibility(8);
          if (!ah.b.b(localb).equals(str2))
            continue;
          localTextView.setText("查看讲义");
          localTextView.setBackgroundResource(2130837766);
          localTextView.setVisibility(0);
          return false;
        }
      while (!ah.b.b(localb).equals(str2));
      localTextView.setText("讲义下载");
      localTextView.setBackgroundResource(2130837767);
      localTextView.setVisibility(0);
      return false;
    case 1:
    }
    Toast.makeText(ah.b(this.a), "文件不存在！", 0).show();
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.ai
 * JD-Core Version:    0.6.0
 */