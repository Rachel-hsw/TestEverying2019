package com.gensee.view.xlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public abstract class XListViewFooter extends LinearLayout
{
  public static final int STATE_LOADING = 2;
  public static final int STATE_NORMAL = 0;
  public static final int STATE_READY = 1;
  private View mContentView;
  private Context mContext;
  private TextView mHintView;
  private View mProgressBar;

  public XListViewFooter(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }

  public XListViewFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }

  private void initView(Context paramContext)
  {
    this.mContext = paramContext;
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.mContext).inflate(getFooterViewLayoutId(), null);
    addView(localLinearLayout);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.mContentView = localLinearLayout.findViewById(getFooterContentTvId());
    this.mProgressBar = localLinearLayout.findViewById(getFooterProgressbarId());
    this.mHintView = ((TextView)localLinearLayout.findViewById(getFooterHintTvId()));
  }

  public int getBottomMargin()
  {
    return ((LinearLayout.LayoutParams)this.mContentView.getLayoutParams()).bottomMargin;
  }

  protected abstract int getFooterContentTvId();

  protected abstract int getFooterHintNormalStrId();

  protected abstract int getFooterHintReadyStrId();

  protected abstract int getFooterHintTvId();

  protected abstract int getFooterProgressbarId();

  protected abstract int getFooterViewLayoutId();

  public void hide()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mContentView.getLayoutParams();
    localLayoutParams.height = 0;
    this.mContentView.setLayoutParams(localLayoutParams);
  }

  public void loading()
  {
    this.mHintView.setVisibility(8);
    this.mProgressBar.setVisibility(0);
  }

  public void normal()
  {
    this.mHintView.setVisibility(0);
    this.mProgressBar.setVisibility(8);
  }

  public void setBottomMargin(int paramInt)
  {
    if (paramInt < 0)
      return;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mContentView.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.mContentView.setLayoutParams(localLayoutParams);
  }

  public void setState(int paramInt)
  {
    this.mHintView.setVisibility(4);
    this.mProgressBar.setVisibility(4);
    this.mHintView.setVisibility(4);
    if (paramInt == 1)
    {
      this.mHintView.setVisibility(0);
      this.mHintView.setText(getFooterHintReadyStrId());
      return;
    }
    if (paramInt == 2)
    {
      this.mProgressBar.setVisibility(0);
      return;
    }
    this.mHintView.setVisibility(0);
    this.mHintView.setText(getFooterHintNormalStrId());
  }

  public void show()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mContentView.getLayoutParams();
    localLayoutParams.height = -2;
    this.mContentView.setLayoutParams(localLayoutParams);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.xlistview.XListViewFooter
 * JD-Core Version:    0.6.0
 */