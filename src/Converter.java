import java.nio.ByteBuffer;
import java.nio.ByteOrder;
public class Converter {

	/**
	 * Converts String to ByteArray
	 * @param userData
	 * @return
	 */
	public byte[] StringtoByte(String userData)
	{
		byte[] b = userData.getBytes();
		return b;
	}
	/**
	 * Converts String to shortArray not Short
	 * @param userData
	 * @return
	 */
	public short[] StringtoShort(String userData)
	{
		byte[] b = userData.getBytes(); // << redundancy we can call StringtoByte
		short[] shorts = new short[(b.length/2)];
		ByteBuffer.wrap(b).order(ByteOrder.BIG_ENDIAN).asShortBuffer().get(shorts);
		return shorts;
	}
	/**
	 * Converts shorttoString
	 * @param byteArray
	 * @return
	 */
	private String shorttoString(byte byteArray[]) {
		String s= new String(byteArray);
		//System.out.println( new String(new byte[] {0x63}));
		return s;
	}
	
	public static void main(String[] args)
	{
		Converter conv= new Converter();
		conv.StringtoShort("tag");
		System.out.println(conv.shorttoString(conv.StringtoByte("hadokenaa")));
		
	}
}
