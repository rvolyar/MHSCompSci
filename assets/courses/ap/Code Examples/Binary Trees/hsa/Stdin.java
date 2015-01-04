package hsa;

/**
 * The Stdin class reads text from standard input. The class
 * contains the same readLine method as BufferedReader and
 * adds methods to read all the Java primitive data types
 * with integrated error checking.  It also handles EOF.
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

public class Stdin
{
    protected static TextInputFile in = null;
    
    /**
     * Closes Stdin to further reading.
     */
    public static void close ()
    {
	if (in != null)
	{
	    in.close ();
	    in = null;
	}
    } // close (void)


    /**
     * Returns whether there is an eof before the next token.
     *
     * @return Whether there is an eof before the next token
     */
    public static boolean eof ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return in.eof ();
    } // eof (void)


    /**
     * Read a boolean from standard input.
     * The actual text entered must be either "true" or "false"
     * although case is irrelvant.
     *
     * @return The boolean value read from the file.
     */
    public static boolean readBoolean ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readBoolean ());
    } // readBoolean (void)


    /**
     * Read an 8-bit integer (a "byte") from standard input.
     * The actual text entered be a number from -128 to 127.
     *
     * @return The byte value read from standard input.
     */
    public static byte readByte ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readByte ());
    } // byte readByte (void)


    /**
     * Read a single character from standard input.
     *
     * @return The character read from standard input.
     */
    public static char readChar ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readChar ());
    } // char readChar (void)


    /**
     * Read a double precision floating point number (a "double") from
     * standard input.
     *
     * @return The double value read from standard input.
     */
    public static double readDouble ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readDouble ());
    } // double readDouble (void)


    /**
     * Read a floating point number (a "float") from standard input.
     *
     * @return The float value read from standard input.
     */
    public static float readFloat ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readFloat ());
    } // float readFloat (void)


    /**
     * Read a 32-bit integer (an "int") from standard input.
     * The actual text entered must be a number from -2147483648
     * to 2147483647.
     *
     * @return The int value read from standard input.
     */
    public static int readInt ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readInt ());
    } // int readInt (void)


    /**
     * Read a full line of text from standard input.
     *
     * @return The line of text read from standard input.
     */
    public static String readLine ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readLine ());
    } // String readLine (void)


    /**
     * Read a 64-bit integer (a "long") from standard input.
     *
     * @return The long value read from standard input.
     */
    public static long readLong ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readLong ());
    } // long readLong (void)


    /**
     * Read a 16-bit integer (a "short") from standard input.
     * The actual text entered must be a number from -32768 to 32767.
     *
     * @return The short value read from standard input.
     */
    public static short readShort ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readShort ());
    } // short readShort (void)


    /**
     * Read a token from standard input.
     *
     * @return The token read from standard input.
     */
    public static String readString ()
    {
	if (in == null)
	{
	    in = new TextInputFile ();
	}

	return (in.readString ());
    } // String readString (void)
} /* Stdin class */
