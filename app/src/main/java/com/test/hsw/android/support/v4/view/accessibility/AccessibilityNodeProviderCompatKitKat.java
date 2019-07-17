package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;

class AccessibilityNodeProviderCompatKitKat
{
  public static Object newAccessibilityNodeProviderBridge(AccessibilityNodeInfoBridge paramAccessibilityNodeInfoBridge)
  {
    return new AccessibilityNodeProviderCompatKitKat.1(paramAccessibilityNodeInfoBridge);
  }

  static abstract interface AccessibilityNodeInfoBridge
  {
    public abstract Object createAccessibilityNodeInfo(int paramInt);

    public abstract List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt);

    public abstract Object findFocus(int paramInt);

    public abstract boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat
 * JD-Core Version:    0.6.0
 */