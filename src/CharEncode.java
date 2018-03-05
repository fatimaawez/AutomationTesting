import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CharEncode {

	public static String encodeURIParam(String s,boolean printLog) throws UnsupportedEncodingException {

		String ret = null;

		try {
			ret = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
			if(printLog){
				System.out.println("Encoded:["+s+"]["+ret+"]");
			}
		} catch (UnsupportedEncodingException e) {
			throw e;
		}

		return ret;
	}
}