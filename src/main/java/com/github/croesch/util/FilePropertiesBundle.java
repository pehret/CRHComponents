package com.github.croesch.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * This is a bundle manager, that handles different bundles and can give messages from them. It is possible to register
 * a bundle and the bundles belonging to it with language, country and variant from the locale. The difference to
 * {@link PropertyResourceBundle} is, that the properties can be located on file system. And there will be no exception
 * when asking the value for a special key.
 * 
 * @author croesch
 * @since (Date: 2010/12/23 14:02:45 )
 */
@SuppressWarnings("nls")
public final class FilePropertiesBundle {

  /** the file extension of the property files */
  private static final String EXTENSION = ".properties";

  /** map of resource bundles that have been called */
  private static Map<String, ResourceBundle> bundles = new HashMap<String, ResourceBundle>();

  /**
   * Don't call this! Hide constructor of utility class.
   * 
   * @author croesch
   * @since Date: 12.02.2011 19:48:47
   */
  private FilePropertiesBundle() {
    throw new AssertionError();
  }

  /**
   * Creates a resource bundle of the given file name. And adds it to the map if the given name is not yet available in
   * the map of resource bundles. If an IOException occurs the bundle will be {@code null}.
   * 
   * @author croesch
   * @since Date: 12.02.2011 20:02:05
   * @param name the file name <b>without</b> file extension
   */
  private static void registerBundle(final String name) {
    if (!bundles.containsKey(name)) {
      try {
        final ResourceBundle b = new PropertyResourceBundle(new FileInputStream(new File(name + EXTENSION)));
        bundles.put(name, b);
      } catch (final IOException e) {
        bundles.put(name, null);
      }
    }
  }

  /**
   * Returns the value for the given key from the given file name. {@code null} is returned if the key is not found. The
   * given file name will be extended by the default file extension.
   * 
   * @author croesch
   * @since 12.02.2011 20:02:05
   * @param bundle base file name, without extension
   * @param key the key to lookup in the filename
   * @see #getText(String, String, Locale)
   * @see #getText(String, String)
   * @return the value for the given key or {@code null} if the key or file wasn't found
   */
  public static String getMessageFromSingleBundle(final String bundle, final String key) {
    if (key != null) {

      registerBundle(bundle);

      try {
        final ResourceBundle b = bundles.get(bundle);
        if (b != null) {
          return b.getString(key);
        }
      } catch (final MissingResourceException e) {
        return null;
      }
    }
    return null;
  }

  /**
   * Get a text for the given key. Generates for different bundle names, as
   * {@link ResourceBundle#getBundle(String, Locale, ClassLoader)} does. The method will search for the key in the four
   * bundles. If one contains the key the value will be returned. If not it will search in the next bundle. If no bundle
   * contains the key, it will return {@code null}. The locale to derive the file names will be the default locale.
   * 
   * @author croesch
   * @since 12.02.2011 20:02:05
   * @param bundle the name of the properties file, without ".properties"!
   * @param key the key in the properties file
   * @see #getMessageFromSingleBundle(String, String)
   * @see #getText(String, String, Locale)
   * @return the text for the key or null if the key wasn't found
   */
  public static String getText(final String bundle, final String key) {
    return getText(bundle, key, Locale.getDefault());
  }

  /**
   * Get a text for the given key. Generates for different bundle names, as
   * {@link ResourceBundle#getBundle(String, Locale, ClassLoader)} does. The method will search for the key in the four
   * bundles. If one contains the key the value will be returned. If not it will search in the next bundle. If no bundle
   * contains the key, it will return {@code null}. The locale will be used to derive the file names.
   * 
   * @author croesch
   * @since 12.02.2011 20:02:05
   * @param bundle the name of the properties file, without ".properties"!
   * @param key the key in the properties file
   * @param loc the locale to derive the file names from
   * @see #getMessageFromSingleBundle(String, String)
   * @see #getText(String, String)
   * @return the text for the key or null if the key wasn't found
   */
  public static String getText(final String bundle, final String key, final Locale loc) {

    if (loc == null) {
      throw new IllegalArgumentException();
    }

    final String[] names = Generator.generateFrom(loc).defaultNamesStartingWith(bundle);
    String text = null;
    for (int i = 0; text == null && i < names.length; ++i) {
      text = getMessageFromSingleBundle(names[i], key);
    }
    return text;
  }
}
