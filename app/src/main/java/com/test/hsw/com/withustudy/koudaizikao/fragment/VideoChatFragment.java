package com.withustudy.koudaizikao.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.gensee.entity.ChatMsg;
import com.gensee.media.VODPlayer;
import com.gensee.player.OnChatListener;
import com.gensee.player.Player;
import com.gensee.view.ChatEditText;
import com.withustudy.koudaizikao.b.ag;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.base.n;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.g.h;
import java.util.ArrayList;
import java.util.List;

public class VideoChatFragment extends AbsBaseFragment
{
  public static final int a = 1;
  public static final int b = 2;
  private VODPlayer c;
  private Player d;
  private ListView e;
  private List<ChatMsg> f;
  private ag g;
  private LinearLayout h;
  private ChatEditText i;
  private Button j;
  private int k;
  private boolean l = false;
  private boolean m;
  private b n;
  private a o;
  private InputMethodManager p;

  public VideoChatFragment(VODPlayer paramVODPlayer)
  {
    this.c = paramVODPlayer;
    this.l = false;
  }

  public VideoChatFragment(Player paramPlayer, int paramInt)
  {
    this.d = paramPlayer;
    this.k = paramInt;
    this.l = true;
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903169, null);
  }

  public void a()
  {
    this.p = ((InputMethodManager)this.y.getSystemService("input_method"));
    this.n = new b(this);
    this.o = new a();
    this.f = new ArrayList();
    this.g = new ag(this.y, this.f);
  }

  public void a(View paramView)
  {
    this.e = ((ListView)paramView.findViewById(2131297111));
    this.h = ((LinearLayout)paramView.findViewById(2131297112));
    this.i = ((ChatEditText)paramView.findViewById(2131297113));
    this.j = ((Button)paramView.findViewById(2131297114));
  }

  public void a(ChatMsg paramChatMsg)
  {
    this.f.add(paramChatMsg);
    this.g.a(this.k);
    this.g.notifyDataSetChanged();
    this.e.setSelection(this.e.getBottom());
  }

  public void a(List<ChatMsg> paramList)
  {
    this.f = paramList;
  }

  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public void b()
  {
    if (!this.l)
      this.h.setVisibility(8);
    this.e.setAdapter(this.g);
    this.e.setSelector(2131034189);
  }

  public void c()
  {
    if (this.d != null)
      this.d.setOnChatListener(this.o);
    this.j.setOnClickListener(this.o);
  }

  public void d()
  {
    try
    {
      this.p.hideSoftInputFromWindow(((AbsBaseActivity)this.y).getCurrentFocus().getWindowToken(), 2);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  class a
    implements View.OnClickListener, OnChatListener
  {
    a()
    {
    }

    public void onChatWithPerson(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
    {
    }

    public void onChatWithPublic(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
    {
      h.a("收到公聊消息", paramString2, paramString3);
      ChatMsg localChatMsg = new ChatMsg();
      localChatMsg.setSenderId(paramLong);
      localChatMsg.setSender(paramString1);
      localChatMsg.setContent(paramString2);
      localChatMsg.setRichText(paramString3);
      localChatMsg.setTimeStamp(System.currentTimeMillis());
      VideoChatFragment.d(VideoChatFragment.this).sendMessage(VideoChatFragment.d(VideoChatFragment.this).obtainMessage(1, localChatMsg));
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131297114:
      }
      if (!VideoChatFragment.c(VideoChatFragment.this))
      {
        Toast.makeText(VideoChatFragment.b(VideoChatFragment.this), "直播开始才能聊天哦", 0).show();
        VideoChatFragment.d(VideoChatFragment.this).sendEmptyMessage(2);
        return;
      }
      if ((VideoChatFragment.e(VideoChatFragment.this).getChatText().equals("")) && (VideoChatFragment.e(VideoChatFragment.this).getRichText().equals("")))
      {
        Toast.makeText(VideoChatFragment.b(VideoChatFragment.this), "请输入聊天内容", 0).show();
        return;
      }
      VideoChatFragment.f(VideoChatFragment.this).chatToPublic(VideoChatFragment.e(VideoChatFragment.this).getChatText(), VideoChatFragment.e(VideoChatFragment.this).getRichText(), null);
      h.a("发出公聊消息", VideoChatFragment.e(VideoChatFragment.this).getChatText(), VideoChatFragment.e(VideoChatFragment.this).getRichText());
      VideoChatFragment.d(VideoChatFragment.this).sendEmptyMessage(2);
      ChatMsg localChatMsg = new ChatMsg();
      localChatMsg.setContent(VideoChatFragment.e(VideoChatFragment.this).getChatText());
      localChatMsg.setRichText(VideoChatFragment.e(VideoChatFragment.this).getRichText());
      localChatMsg.setSenderId(Long.valueOf(VideoChatFragment.g(VideoChatFragment.this)).longValue());
      localChatMsg.setSender(VideoChatFragment.h(VideoChatFragment.this).v());
      localChatMsg.setTimeStamp(System.currentTimeMillis());
      VideoChatFragment.this.a(localChatMsg);
      VideoChatFragment.e(VideoChatFragment.this).setText("");
    }

    public void onMute(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        h.a("用户被禁言");
        return;
      }
      h.a("用户被取消禁言");
    }

    public void onPublish(boolean paramBoolean)
    {
    }

    public void onReconnection()
    {
    }

    public void onRoomMute(boolean paramBoolean)
    {
    }
  }

  private static class b extends n<VideoChatFragment>
  {
    public b(VideoChatFragment paramVideoChatFragment)
    {
      super();
    }

    protected void a(VideoChatFragment paramVideoChatFragment, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        paramVideoChatFragment.a((ChatMsg)paramMessage.obj);
        return;
      case 2:
      }
      try
      {
        VideoChatFragment.a(paramVideoChatFragment).hideSoftInputFromWindow(((AbsBaseActivity)VideoChatFragment.b(paramVideoChatFragment)).getCurrentFocus().getWindowToken(), 2);
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.VideoChatFragment
 * JD-Core Version:    0.6.0
 */