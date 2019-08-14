package org.android.spdy;

public enum RequestPriority
{
  private int priority;

  static
  {
    HIGH = new RequestPriority("HIGH", 1, 1);
    MEDIUM = new RequestPriority("MEDIUM", 2, 2);
    LOW = new RequestPriority("LOW", 3, 3);
    LOWEST = new RequestPriority("LOWEST", 4, 4);
    IDLE = new RequestPriority("IDLE", 5, 5);
    DEFAULT_PRIORITY = new RequestPriority("DEFAULT_PRIORITY", 6, 1);
    RequestPriority[] arrayOfRequestPriority = new RequestPriority[7];
    arrayOfRequestPriority[0] = HIGHEST;
    arrayOfRequestPriority[1] = HIGH;
    arrayOfRequestPriority[2] = MEDIUM;
    arrayOfRequestPriority[3] = LOW;
    arrayOfRequestPriority[4] = LOWEST;
    arrayOfRequestPriority[5] = IDLE;
    arrayOfRequestPriority[6] = DEFAULT_PRIORITY;
    $VALUES = arrayOfRequestPriority;
  }

  private RequestPriority(int paramInt)
  {
    this.priority = paramInt;
  }

  int getPriorityInt()
  {
    return this.priority;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.RequestPriority
 * JD-Core Version:    0.6.0
 */