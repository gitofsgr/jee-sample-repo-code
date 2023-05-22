package com.sgr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Email{
// Implement Email Class according to the specifiaction..
Header header;
String body;
String greetings;


Email(Header header,String body,String greetings)
{
	this.header = header;
	this.body = body;
	this.greetings = greetings;
}

}
class Header{
// Implemet the Header Class according to the specifiaction.
String from;
String to;

//from = header.from;



Header(String from,String to)
{
	this.from = from;
	this.to  = to;
}

}


class EmailOperations{
// Implemet the Three methods specified in the specified.	
	public int emailVerify(Email e)
	{
		String strOne = e.header.from;
		String strTwo = e.header.to;

		Pattern pattern =  Pattern.compile("[a-zA-Z_]@[a-zA-Z].[a-zA-Z]");
		Matcher matcherFrom = pattern.matcher(strOne);
		Matcher matcherTo = pattern.matcher(strTwo);

		if(matcherFrom.find()==true && matcherTo.find()==true)
		{
			return 2;
		}
		else if(matcherFrom.find()==false || matcherTo.find()==false)
		{
			return 1;
		}

		return 0;
	}
	public String bodyEncryption(Email e)
	{
		String msg = e.body;
		String newMsg="";
		String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < msg.length(); i++)
        {
			if(msg.charAt(i)==' ')
			{
				newMsg = newMsg + " ";
				
			}
			else
			{
	            int charPosition = alpha.indexOf(msg.charAt(i));
	            int keyVal = (3 + charPosition) % 52;
	            char replaceVal = alpha.charAt(keyVal);
	            newMsg = newMsg + replaceVal;
			}
        }
		/*
		 * for(int i=0;i<msg.length();i++) { char ch = msg.charAt(i); if(ch!=' ') ch =
		 * (char) (ch + 3); if(ch=='z')
		 * 
		 * newMsg = newMsg + String.valueOf(ch);
		 * 
		 * }
		 */
		return newMsg;
	}
	public String greetingMessage(Email e)
	{
		String rega = e.greetings;
		String mail = e.header.to;
		String name = "";
		
		for(int i=0;i<mail.length();i++)
		{
			char ch = mail.charAt(i);
			if(ch=='@')
			{
				
				break;
			}
			name = name + String.valueOf(ch);
		}
		return rega +" "+ name;
	}
}


public class Source {
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
    // You can Implement your main() to check your Program.

	Header header = new Header("Sagar@gmail.com","Kartik12@gmail.com");
	Email email = new Email(header,"Hi There Hows you","Regards");

	EmailOperations eo = new EmailOperations();
	
	System.out.println(eo.emailVerify(email));
	System.out.println(eo.bodyEncryption(email));
	System.out.println(eo.greetingMessage(email));
	
}
}
