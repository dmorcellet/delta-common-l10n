package delta.common.utils.l10n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import delta.common.utils.l10n.dates.DateFormatSpecification;
import delta.common.utils.l10n.dates.DateFormatsManager;
import delta.common.utils.l10n.numbers.NumberFormatsManager;

/**
 * Facade for formats access.
 * @author DAM
 */
public class LocalizedFormats
{
  private static DateFormatsManager _dateFormatsMgr=new DateFormatsManager();
  private static NumberFormatsManager _numberFormatsMgr=new NumberFormatsManager();

  /**
   * Initialize the localization system.
   * @param configuration Configuration to use.
   */
  public static void init(L10nConfiguration configuration)
  {
    _dateFormatsMgr.init(configuration);
    _numberFormatsMgr.init(configuration);
  }

  /**
   * Get the number format for integers.
   * @return A number format for integers.
   */
  public static NumberFormat getIntegerNumberFormat()
  {
    NumberFormat format=_numberFormatsMgr.getNumberFormatSpecification().getIntegerFormat();
    return format;
  }

  /**
   * Get the number format for real numbers.
   * @param minDigits Minimum number of fractional digits.
   * @param maxDigits Maximum number of fractional digits.
   * @return A number format for real numbers.
   */
  public static NumberFormat getRealNumberFormat(int minDigits, int maxDigits)
  {
    return getRealNumberFormat(minDigits,maxDigits,false);
  }

  /**
   * Get the number format for real numbers.
   * @param minDigits Minimum number of fractional digits.
   * @param maxDigits Maximum number of fractional digits.
   * @param percentage Percentage or not.
   * @return A number format for real numbers.
   */
  public static NumberFormat getRealNumberFormat(int minDigits, int maxDigits, boolean percentage)
  {
    NumberFormat format=_numberFormatsMgr.getNumberFormatSpecification().getRealNumberFormat(minDigits,maxDigits,percentage);
    return format;
  }

  /**
   * Get the format for date/time.
   * @return A format for date/time.
   */
  public static DateFormat getDateTimeFormat()
  {
    SimpleDateFormat format=_dateFormatsMgr.getDateTimeFormatSpecification().getFormat();
    return format;
  }

  /**
   * Get the format for date.
   * @return A format for date.
   */
  public static DateFormat getDateFormat()
  {
    SimpleDateFormat format=_dateFormatsMgr.getDateFormatSpecification().getFormat();
    return format;
  }

  /**
   * Get the date format specification to use.
   * @return a date format specification.
   */
  public static DateFormatSpecification getDateFormatSpecification()
  {
    return _dateFormatsMgr.getDateFormatSpecification();
  }

  /**
   * Get the date/time format specification to use.
   * @return a date/time format specification.
   */
  public static DateFormatSpecification getDateTimeFormatSpecification()
  {
    return _dateFormatsMgr.getDateTimeFormatSpecification();
  }
}
