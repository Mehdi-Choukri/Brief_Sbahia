package domaine.classes;

public class Main {

	public static void main(String[] args) {

		Token t = new Token();
		final String secretKey = t.generate();
		 
	    String originalString = "123456789";
	    String hashedPassword = AES.encrypt(originalString, secretKey) ;
 
	    
	    String encryptedString = AES.encrypt(hashedPassword, secretKey) ;
	    String decryptedString = AES.decrypt(encryptedString, secretKey) ;
	     
	    System.out.println(hashedPassword);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);

	}

}
