package utils;

import java.lang.reflect.Field;

public class ToStringUtil {

  public static String toString(Object obj) {
    StringBuilder sb = new StringBuilder(obj.getClass().getName() + " [");
    Class<?> currentClass = obj.getClass();
    while (currentClass != null) {
      Field[] fields = currentClass.getDeclaredFields();
      for (Field field : fields) {
        field.setAccessible(true);
        try {
          sb.append(field.getName()).append("=").append(field.get(obj)).append(", ");
        } catch (IllegalAccessException e) {
          e.fillInStackTrace();
        }
      }
      currentClass = currentClass.getSuperclass();
    }
    if (sb.length() > obj.getClass().getName().length() + 2) {
      sb.setLength(sb.length() - 2); // Remove the last comma and space
    }
    sb.append("]");
    return sb.toString();
  }
}