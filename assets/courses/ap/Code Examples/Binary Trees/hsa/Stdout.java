package hsa;

/**
 * The Stdout class writes text to standard output. The class is a
 * superset of PrintWriter adding formatted output and integrated
 * error checking.
 * <p>
 * This class is not meant to be instantiated.
 * <p>
 * Full documentation for the classes in the hsa package available at:
 * <br>
 *                      http://www.holtsoft.com/java/hsa_package.html
 * <p>
 * @author Tom West
 * @version 2.0 99/02/01
 */

public class Stdout
{
    private static TextOutputFile out = new TextOutputFile ();

    /**
     * Close Stdout to further writing.
     */
    public static void close ()
    {
	// Ignore the closing of standard output
    } // close (void)


    /**
     * Write the text representation of an 8-bit integer (a "byte") to
     * standard output.
     *
     * @param number The number to be written to the standard output.
     */
    public static void print (byte number)
    {
	out.print (number);
    } // print (byte)


    /**
     * Write the text representation of an 8-bit integer (a "byte")
     * to standard output with a specified field size.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void print (byte number, int fieldSize)
    {
	out.print (number, fieldSize);
    } // print (byte, int)


    /**
     * Write a character to standard output.
     *
     * @param ch The character to be written to standard output.
     */
    public static void print (char ch)
    {
	out.print (ch);
    } // print (char)


    /**
     * Write a character to standard output with a specified field size..
     *
     * @param ch The character to be written to standard output.
     * @param fieldSize The field width that the character is to be written in.
     */
    public static void print (char ch, int fieldSize)
    {
	out.print (ch, fieldSize);
    } // print (char, int)


    /**
     * Write a double precision floating point number (a "double") to
     * standard output.
     *
     * @param number The number to be written to standard output.
     */
    public static void print (double number)
    {
	out.print (number);
    } // print (double)


    /**
     * Write a double precision floating point number (a "double") to
     * standard output with a specified field size.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void print (double number, int fieldSize)
    {
	out.print (number, fieldSize);
    } // print (double, int)


    /**
     * Write a double precision floating point number (a "double") to
     * standard output with a specified field size and a specified number
     * of decimal places.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     * @param decimalPlaces The number of decimal places of the number
     *    to be displayed.
     */
    public static void print (double number, int fieldSize, int decimalPlaces)
    {
	out.print (number, fieldSize, decimalPlaces);
    } // print (double, int, int)


    /**
     * Write a floating point number (a "float") to standard output.
     *
     * @param number The number to be written to standard output.
     */
    public static void print (float number)
    {
	out.print (number);
    } // print (float)


    /**
     * Write a floating point number (a "float") to
     * standard output with a specified field size.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void print (float number, int fieldSize)
    {
	out.print (number, fieldSize);
    } // print (float, int)


    /**
     * Write a floating point number (a "double") to standard output with
     * a specified field size and a specified number of decimal places.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     * @param decimalPlaces The number of decimal places of the number
     *    to be displayed.
     */
    public static void print (float number, int fieldSize, int decimalPlaces)
    {
	out.print (number, fieldSize, decimalPlaces);
    } // print (float, int, int)


    /**
     * Write the text representation of an 32-bit integer (an "int") to
     * standard output.
     *
     * @param number The number to be written to standard output.
     */
    public static void print (int number)
    {
	out.print (number);
    } // print (int)


    /**
     * Write the text representation of an 32-bit integer (an "int")
     * to standard output with a specified field size.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void print (int number, int fieldSize)
    {
	out.print (number, fieldSize);
    } // print (int, int)


    /**
     * Write the text representation of an 64-bit integer (a "long") to
     * standard output.
     *
     * @param number The number to be written to standard output.
     */
    public static void print (long number)
    {
	out.print (number);
    } // print (long)


    /**
     * Write the text representation of an 64-bit integer (a "long")
     * to standard output with a specified field size.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void print (long number, int fieldSize)
    {
	out.print (number, fieldSize);
    } // print (long, int)


    /**
     * Write a string to standard output.
     *
     * @param text The string to be written to standard output.
     */
    public static void print (String text)
    {
	out.print (text);
    } // print (String)


    /**
     * Write a string to standard output with a specified field size..
     *
     * @param text The string to be written to standard output.
     * @param fieldSize The field width that the string is to be written in.
     */
    public static void print (String text, int fieldSize)
    {
	out.print (text, fieldSize);
    } // print (String, int)


    /**
     * Write the text representation of an 16-bit integer (a "short") to
     * standard output.
     *
     * @param number The number to be written to standard output.
     */
    public static void print (short number)
    {
	out.print (number);
    } // print (short)


    /**
     * Write the text representation of an 16-bit integer (a "short")
     * to standard output with a specified field size.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void print (short number, int fieldSize)
    {
	out.print (number, fieldSize);
    } // print (short, int)


    /**
     * Write the text representation of a boolean to standard output.
     *
     * @param value The boolean to be written to standard output.
     */
    public static void print (boolean value)
    {
	out.print (value);
    } // print (boolean)


    /**
     * Write the text representation of a boolean to standard output with a
     * specified field size.
     *
     * @param value The boolean to be written to standard output.
     * @param fieldSize The field width that the boolean is to be written in.
     */
    public static void print (boolean value, int fieldSize)
    {
	out.print (value, fieldSize);
    } // print (boolean, int)


    /**
     * Write a newline to standard output.
     */
    public static void println ()
    {
	out.println ();
    } // println (void)


    /**
     * Write the text representation of an 8-bit integer (a "byte") to
     * standard output followed by a newline.
     *
     * @param number The number to be written to standard output.
     */
    public static void println (byte number)
    {
	out.println (number);
    } // println (byte)


    /**
     * Write the text representation of an 8-bit integer (a "byte")
     * to standard output with a specified field size followed by a newline.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void println (byte number, int fieldSize)
    {
	out.println (number, fieldSize);
    } // println (byte, int)


    /**
     * Write a character to standard output followed by a newline.
     *
     * @param ch The character to be written to standard output.
     */
    public static void println (char ch)
    {
	out.println (ch);
    } // println (char)


    /**
     * Write a character to standard output with a specified field size..
     *
     * @param ch The character to be written to standard output.
     * @param fieldSize The field width that the character is to be written in.
     */
    public static void println (char ch, int fieldSize)
    {
	out.println (ch, fieldSize);
    } // print (char, int)


    /**
     * Write a double precision floating point number (a "double") to
     * standard output followed by a newline.
     *
     * @param number The number to be written to standard output.
     */
    public static void println (double number)
    {
	out.println (number);
    } // println (double)


    /**
     * Write a double precision floating point number (a "double") to
     * standard output with a specified field size followed by a newline.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void println (double number, int fieldSize)
    {
	out.println (number, fieldSize);
    } // println (double, int)


    /**
     * Write a double precision floating point number (a "double") to
     * standard output with a specified field size and a specified number
     * of decimal places followed by a newline.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     * @param decimalPlaces The number of decimal places of the number
     * to be displayed.
     */
    public static void println (double number, int fieldSize, int decimalPlaces)
    {
	out.println (number, fieldSize, decimalPlaces);
    } // println (double, int, int)


    /**
     * Write a floating point number (a "float") to standard output
     * followed by a newline.
     *
     * @param number The number to be written to standard output.
     */
    public static void println (float number)
    {
	out.println (number);
    } // println (float)


    /**
     * Write a floating point number (a "float") to standard output with a
     * specified field size followed by a newline.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void println (float number, int fieldSize)
    {
	out.println (number, fieldSize);
    } // println (float, int)


    /**
     * Write a floating point number (a "double") to standard output with
     * a specified field size and a specified number of decimal places
     * followed by a newline.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     * @param decimalPlaces The number of decimal places of the number
     * to be displayed.
     */
    public static void println (float number, int fieldSize, int decimalPlaces)
    {
	out.println (number, fieldSize, decimalPlaces);
    } // println (float, int, int)


    /**
     * Write the text representation of an 32-bit integer (an "int") to
     * standard output followed by a newline.
     *
     * @param number The number to be written to standard output.
     */
    public static void println (int number)
    {
	out.println (number);
    } // println (int)


    /**
     * Write the text representation of an 32-bit integer (an "int")
     * to standard output with a specified field size followed by a
     * newline.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void println (int number, int fieldSize)
    {
	out.println (number, fieldSize);
    } // println (int, int)


    /**
     * Write the text representation of an 64-bit integer (a "long") to
     * standard output followed by a newline.
     *
     * @param number The number to be written to standard output.
     */
    public static void println (long number)
    {
	out.println (number);
    } // println (long)


    /**
     * Write the text representation of an 64-bit integer (a "long")
     * to standard output with a specified field size followed by a
     * newline.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void println (long number, int fieldSize)
    {
	out.println (number, fieldSize);
    } // println (long, int)


    /**
     * Write a string to standard output followed by a newline.
     *
     * @param text The string to be written to standard output.
     */
    public static void println (String text)
    {
	out.println (text);
    } // print (String)


    /**
     * Write a string to standard output with a specified field size
     * followed by a newline.
     *
     * @param text The string to be written to standard output.
     * @param fieldSize The field width that the string is to be written in.
     */
    public static void println (String text, int fieldSize)
    {
	out.println (text, fieldSize);
    } // println (String, int)


    /**
     * Write the text representation of an 16-bit integer (a "short") to
     * standard output followed by a newline.
     *
     * @param number The number to be written to standard output.
     */
    public static void println (short number)
    {
	out.println (number);
    } // println (short)


    /**
     * Write the text representation of an 16-bit integer (a "short")
     * to standard output with a specified field size followed by a
     * newline.
     *
     * @param number The number to be written to standard output.
     * @param fieldSize The field width that the number is to be written in.
     */
    public static void println (short number, int fieldSize)
    {
	out.println (number, fieldSize);
    } // println (short, int)


    /**
     * Write the text representation of a boolean to standard output
     * followed by a newline.
     *
     * @param value The boolean to be written to standard output.
     */
    public static void println (boolean value)
    {
	out.println (value);
    } // println (boolean)


    /**
     * Write the text representation of a boolean to standard output with
     * a specified field size followed by a newline.
     *
     * @param value The boolean to be written to standard output.
     * @param fieldSize The field width that the boolean is to be written in.
     */
    public static void println (boolean value, int fieldSize)
    {
	out.println (value, fieldSize);
    } // println (boolean, int)
} // Stdout class
