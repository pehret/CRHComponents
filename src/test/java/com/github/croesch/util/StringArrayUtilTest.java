package com.github.croesch.util;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * Provides some basic test methods for {@link StringArrayUtil}
 * 
 * @author croesch
 * @since Date: 19.02.2011 15:22:35
 */
@SuppressWarnings("nls")
public class StringArrayUtilTest {
  private static String[] arr1_1 = new String[] {};

  private static String[] arr1_2 = new String[] {};

  private static String[] arr2_1 = new String[] {""};

  private static String[] arr2_2 = new String[] {""};

  private static String[] arr3_1 = new String[] {"a", "b", "c", "d"};

  private static String[] arr3_2 = new String[] {"a", "b", "c", "d"};

  /**
   * Test method for {@link StringArrayUtil#hashCode()}.
   */
  @Test
  public void testHashCode_Equal() {
    StringArrayUtil sau1 = new StringArrayUtil(arr1_1);
    StringArrayUtil sau2 = new StringArrayUtil(arr1_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.hashCode() == sau1.hashCode());
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.hashCode() == sau1.hashCode());
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.hashCode() == sau1.hashCode());
    assertThat(sau1).isEqualTo(sau2);
  }

  /**
   * Test method for {@link StringArrayUtil#hashCode()}.
   */
  @Test
  public void testHashCode_Unequal() {
    StringArrayUtil sau1 = new StringArrayUtil(arr1_1);
    StringArrayUtil sau2 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.hashCode() == sau1.hashCode());
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.hashCode() == sau1.hashCode());
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.hashCode() == sau1.hashCode());
    assertThat(sau1).isNotEqualTo(sau2);
  }

  /**
   * Test method for {@link StringArrayUtil#equals(Object)}.
   */
  @Test
  public void testEquals_Reflexive() {
    StringArrayUtil sau = new StringArrayUtil(arr1_1);
    assertThat(sau).isEqualTo(sau);

    sau = new StringArrayUtil(arr2_1);
    assertThat(sau).isEqualTo(sau);

    sau = new StringArrayUtil(arr3_1);
    assertThat(sau).isEqualTo(sau);
  }

  /**
   * Test method for {@link StringArrayUtil#equals(Object)}.
   */
  @Test
  public void testEquals_Symmetric() {
    StringArrayUtil sau1 = new StringArrayUtil(arr1_1);
    StringArrayUtil sau2 = new StringArrayUtil(arr1_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr1_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr1_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr1_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr2_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr3_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr1_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr2_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isEqualTo(sau2);
    assertThat(sau1.equals("")).isEqualTo("".equals(sau1));
    assertThat(sau1).isNotEqualTo("");

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr3_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr1_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr2_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr3_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau1));
    assertThat(sau1).isEqualTo(sau2);
  }

  /**
   * Test method for {@link StringArrayUtil#equals(Object)}.
   */
  @Test
  public void testEquals_Transitivity() {
    StringArrayUtil sau1 = new StringArrayUtil(arr1_1);
    StringArrayUtil sau2 = new StringArrayUtil(arr1_1);
    StringArrayUtil sau3 = new StringArrayUtil(arr1_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau3)).isEqualTo(sau1.equals(sau3));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr2_1);
    sau3 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau3)).isEqualTo(sau1.equals(sau3));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr3_1);
    sau3 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau3)).isEqualTo(sau1.equals(sau3));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr1_2);
    sau3 = new StringArrayUtil(arr1_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau3)).isEqualTo(sau1.equals(sau3));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr2_2);
    sau3 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau3)).isEqualTo(sau1.equals(sau3));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr3_2);
    sau3 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau2.equals(sau3)).isEqualTo(sau1.equals(sau3));
    assertThat(sau1).isEqualTo(sau2);
  }

  /**
   * Test method for {@link StringArrayUtil#equals(Object)}.
   */
  @Test
  public void testEquals_Consistency() {
    StringArrayUtil sau1 = new StringArrayUtil(arr1_1);
    StringArrayUtil sau2 = new StringArrayUtil(arr1_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr1_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr1_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr2_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr3_2);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr1_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr2_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr1_1);
    sau2 = new StringArrayUtil(arr3_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2))
      .isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2))
      .isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2))
      .isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr1_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr2_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isEqualTo(sau2);

    sau1 = new StringArrayUtil(arr2_1);
    sau2 = new StringArrayUtil(arr3_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr1_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr2_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isNotEqualTo(sau2);

    sau1 = new StringArrayUtil(arr3_1);
    sau2 = new StringArrayUtil(arr3_1);
    assertThat(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2))
      .isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2))
      .isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2)).isEqualTo(sau1.equals(sau2));
    assertThat(sau1).isEqualTo(sau2);
  }

  /**
   * Test method for {@link StringArrayUtil#equals(Object)}.
   */
  @Test
  public void testEquals_NullFalse() {
    StringArrayUtil sau = new StringArrayUtil(arr1_1);
    assertThat(sau).isNotEqualTo(null);

    sau = new StringArrayUtil(arr1_2);
    assertThat(sau).isNotEqualTo(null);

    sau = new StringArrayUtil(arr2_1);
    assertThat(sau).isNotEqualTo(null);

    sau = new StringArrayUtil(arr2_2);
    assertThat(sau).isNotEqualTo(null);

    sau = new StringArrayUtil(arr3_1);
    assertThat(sau).isNotEqualTo(null);

    sau = new StringArrayUtil(arr3_2);
    assertThat(sau).isNotEqualTo(null);
  }

  /**
   * Tests the constructor {@link StringArrayUtil#StringArrayUtil(String[])} and if the arguments are internally copied.
   * 
   * @author croesch
   * @since Date: 19.02.2011 16:23:57
   */
  @Test
  public void testReferences() {
    String[] arr1 = {" a", " b", "c "};
    String[] arr2 = {" a", " b", "c "};
    String[] arr3 = {" A", " b", "c "};
    String[] arr4 = {"A", "b", "c", "d", "e", "f"};
    StringArrayUtil sau1 = new StringArrayUtil(arr1);
    StringArrayUtil sau2 = new StringArrayUtil(arr2);
    StringArrayUtil sau3 = new StringArrayUtil(arr3);
    StringArrayUtil sau4 = new StringArrayUtil(arr4);

    assertThat(sau1).isEqualTo(sau2);
    assertThat(sau1).isNotEqualTo(sau3);
    assertThat(sau2).isNotEqualTo(sau3);

    arr2[0] = arr3[0];
    assertThat(sau1).isEqualTo(sau2);

    arr1 = sau1.toLeftAlignedArray();
    arr1[0] = "asd";
    assertThat(sau1).isEqualTo(sau2);

    arr1 = sau1.toRightAlignedArray();
    arr1[0] = "asd";
    assertThat(sau1).isEqualTo(sau2);

    arr1 = sau1.toCentreAlignedArray();
    arr1[0] = "asd";
    assertThat(sau1).isEqualTo(sau2);

    sau3 = sau1.trim();
    assertThat(sau1).isEqualTo(sau2);
    assertThat(sau1).isNotSameAs(sau3);

    sau3 = sau4.trim();
    assertThat(sau3).isSameAs(sau4);
    assertThat(sau3).isEqualTo(sau4);
    assertThat(sau4).isSameAs(sau4.trim());
  }
}
