public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        int index = 0;
        for (int i = 0; i < letterBlock.length; i++)
        {
            for (int x = 0; x < letterBlock[i].length; x++)
            {
                if (index < str.length())
                {
                    letterBlock[i][x] = str.substring(index, index + 1);
                    index++;
                }
                else
                {
                    letterBlock[i][x] = "A";
                }
            }
        }
    }

    /* Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String message = "";
        for (int i = 0; i < letterBlock[0].length; i++)
        {
            for (int x = 0; x < letterBlock.length; x++)
            {
                message += letterBlock[x][i];
            }
        }
        return message;
    }

    /* Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        int maxLetters = numRows * numCols;
        String encryption = "";
        int firstIndex = 0;
        int times;
        if (message.length() % maxLetters == 0)
        {
            times = message.length() / maxLetters;
        }
        else
        {
            times = (message.length() / maxLetters) + 1;
        }
        for (int i = 0; i < times; i++)
        {
            if (firstIndex + maxLetters < message.length())
            {
                fillBlock(message.substring(firstIndex, firstIndex + maxLetters));
                encryption += encryptBlock();
                firstIndex = firstIndex + maxLetters;
            }
            else
            {
                fillBlock(message.substring(firstIndex));
                encryption += encryptBlock();
            }
        }
        return encryption;
    }

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        int sectionLen = numRows * numCols;
        int start = 0;
        int end = sectionLen;
        String message = "";
        while (end <= encryptedMessage.length())
        {
            message += decryptSection(encryptedMessage, start, end);
            start += sectionLen;
            end += sectionLen;
        }
        while (message.substring(message.length() - 1).equals("A"))
        {
            message = message.substring(0, message.length() - 1);
        }
        return message;
    }

    public String decryptSection(String message, int start, int end)
    {
        String[][] arrd = new String[numRows][numCols];
        String section = message.substring(start, end);
        int index = section.length() - 1;
        for (int x = arrd[0].length - 1; x >= 0; x--)
        {
            for (int i = arrd.length - 1; i >= 0; i--)
            {
                arrd[i][x] = section.substring(index, index + 1);
                index--;
            }
        }
        String decrypt = "";
        for (int i = 0; i < arrd.length; i++)
        {
            for (int x = 0; x < arrd[i].length; x++)
            {
                decrypt += arrd[i][x];
            }
        }
        return decrypt;
    }
}
