import java.util.*;
import java.lang.*;
import java.io.*;

class stem
{
String st;
int len;

void step1a()
{
if(st.endsWith("s"))
{
      if (st.endsWith("sses"))
	{ remo(2);	 }
      else if(st.endsWith("ies"))
	{
	remo(3);
	setto("i");
	}
      else if(st.endsWith("ss"))
	{	System.out.println("no change");	}
      else if(st.endsWith("s"))
	{ remo(1); }
}
}


void step1b()
{
String stt="";
if (st.endsWith("eed"))
{
for(int i=0;i<=len-3;i++)
stt+=st.charAt(i);
int m=calcm(stt);
if(m>0)
remo(1);
}
else if (st.endsWith("ed") || st.endsWith("ing"))
{
for(int i=0;i<=len-2;i++)
stt+=st.charAt(i);
String stt1="";
for(int i=0;i<=len-3;i++)
stt1+=st.charAt(i);
if(st.endsWith("ed") && vowin(stt))
{
remo(2);
}
else if(st.endsWith("ing") && vowin(stt1))
{
remo(3);
}
if (st.endsWith("at")) { remo(2); setto("ate");}
else if (st.endsWith("bl")) { remo(2); setto("ble"); }
else if (st.endsWith("iz")) { remo(2); setto("ize"); }
else if (doublec() &&  (st.charAt(len)!='l' && st.charAt(len)!='s' &&  st.charAt(len)!='z'))
{
remo(1);
}
else
{
stt=st;
int m=calcm(stt);
if(m==1 && cvc(st))
{
setto("e");
}
}
}
}

void step1c()
{
if(vowin(st) && st.charAt(len)=='y')
{
remo(1);
setto("i");
}
}

void step2()
{
String stt="";
if (st.endsWith("ational"))
substep("ational","ate",0);
else if (st.endsWith("tional"))
substep("tional","tion",0);
else if (st.endsWith("enci"))
substep("enci","ence",0);
else if (st.endsWith("anci"))
substep("anci","ance",0);
else if (st.endsWith("izer"))
substep("izer","ize",0);
else if (st.endsWith("abli"))
substep("abli","able",0);
else if (st.endsWith("ization"))
substep("ization","ize",0);
else if (st.endsWith("ation"))
substep("ation","ate",0);
else if (st.endsWith("iviti"))
substep("ivity","ive",0);
}

void step3()
{
if (st.endsWith("icate"))
substep("icate","ic",0);
else if (st.endsWith("ative"))
substep("ative","",0);
else if (st.endsWith("alize"))
substep("alize","al",0);
else if (st.endsWith("iciti"))
substep("icity","ic",0);
else if (st.endsWith("ical"))
substep("ical","ic",0);
else if (st.endsWith("ful"))
substep("ful","",0);
else if (st.endsWith("ness"))
substep("ness","",0);
}

void step4()
{
if (st.endsWith("al"))
substep("al","",1);
else if (st.endsWith("ence"))
substep("ence","",1);
else if (st.endsWith("ance"))
substep("ance","",1);
else if (st.endsWith("er"))
substep("er","",1);
else if (st.endsWith("ic"))
substep("ic","",1);
else if (st.endsWith("able"))
substep("able","",1);
else if (st.endsWith("ible"))
substep("ible","",1);
else if (st.endsWith("ant"))
substep("ant","",1);
else if (st.endsWith("ement"))
substep("ement","",1);
else if (st.endsWith("ment"))
substep("ment","",1);
}

void step5a()
{
String stt="";
for(int i=0;i<=len-1;i++)
stt+=st.charAt(i);
int m=calcm(stt);
if(st.endsWith("e"))
{
if(m>1)
remo(1);
else if((m>1) && (!cvc(stt)))
remo(1);
}
}

void step5b()
{
int m=calcm(st);
if((m>1) && (st.endsWith("ll")))
substep("ll","l",1);
}

void substep(String st1, String st2,int m1)
{
int len1=st1.length();
String stt="";
{
if(len1<len)
{
for(int i=0;i<=len-len1;i++)
stt+=st.charAt(i);
int m=calcm(stt);
if(m>m1)
remo(len1);
setto(st2);
}
}
}

boolean  vowin(String stt)
{
int len1=stt.length()-1;
int k=0;
for(int i=0;i<=len1;i++)
{
if(!cons(stt.charAt(i)))
k++;
}
if(k>0)
return true;
else
return false;
}

boolean doublec()
{
if(st.charAt(len-1)==st.charAt(len))
return true;
else
return false;
}

boolean cvc(String st1)
{
if ((cons(st1.charAt(len-2))) && (cons(st1.charAt(len-1))) && (cons(st1.charAt(len))))
return true;
else
return false;
}

void remo(int a)
   {
        String ns="";
        int o = len-a;
	for(int k=0;k<=o;k++)
	{
	ns+=st.charAt(k);
	}
	st=ns;
      	len=st.length()-1;
   }

void setto(String s)
   {
	st+=s;
	len+=1;
    }

String pri()
{
	//System.out.println(st);
        return st;
}

boolean cons(char i)
{
switch (i)
      {  case 'a': case 'e': case 'i': case 'o': case 'u': return false;
         default: return true;
      }
   }

int calcm(String stt)
{
int len1=stt.length()-1;
int m=0;
int i=0;
int flag=0;
while(cons(stt.charAt(i)) )
	{
	i++;
	if(i>len1)
	break;
	}
while(i<=len1)
{
if(flag==0)
{
if(cons(stt.charAt(i)))
{
m++;
flag=1;
}
}
else if(flag==1)
{
if(!cons(stt.charAt(i)))
{
flag=0;
}
}
i++;
}
return m;
}

}//class ends here

   
    


public class porter_stemmer
{
public static void main(String args[]) throws IOException
{
boolean s;
int ss=0,sss=1;
String[] stopWordsofwordnet = {
"without", "see", "unless", "due", "also", "must", "might", "like", "]", "[", "}", "{", "<", ">", "?", "\"", "\\", "/", ")", "(", "will", "may", "can", "much", "every", "the", "in", "other", "this", "the", "many", "any", "an", "or", "for", "in", "an", "an ", "is", "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren’t", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can’t", "cannot", "could",
"couldn’t", "did", "didn’t", "do", "does", "doesn’t", "doing", "don’t", "down", "during", "each", "few", "for", "from", "further", "had", "hadn’t", "has", "hasn’t", "have", "haven’t", "having",
"he", "he’d", "he’ll", "he’s", "her", "here", "here’s", "hers", "herself", "him", "himself", "his", "how", "how’s", "i ", " i", "i’d", "i’ll", "i’m", "i’ve", "if", "in", "into", "is",
"isn’t", "it", "it’s", "its", "itself", "let’s", "me", "more", "most", "mustn’t", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "ought", "our", "ours", "ourselves",
"out", "over", "own", "same", "shan’t", "she", "she’d", "she’ll", "she’s", "should", "shouldn’t", "so", "some", "such", "than",
"that", "that’s", "their", "theirs", "them", "themselves", "then", "there", "there’s", "these", "they", "they’d", "they’ll", "they’re", "they’ve",
"this", "those", "through", "to", "too", "under", "until", "up", "very", "was", "wasn’t", "we", "we’d", "we’ll", "we’re", "we’ve",
"were", "weren’t", "what", "what’s", "when", "when’s", "where", "where’s", "which", "while", "who", "who’s", "whom",
"why", "why’s", "with", "won’t", "would", "wouldn’t", "you", "you’d", "you’ll", "you’re", "you’ve", "your", "yours", "yourself", "yourselves",
"Without", "See", "Unless", "Due", "Also", "Must", "Might", "Like", "Will", "May", "Can", "Much", "Every", "The", "In", "Other", "This", "The", "Many", "Any", "An", "Or", "For", "In", "An", "An ", "Is", "A", "About", "Above", "After", "Again", "Against", "All", "Am", "An", "And", "Any", "Are", "Aren’t", "As", "At", "Be", "Because", "Been", "Before", "Being", "Below", "Between", "Both", "But", "By", "Can’t", "Cannot", "Could",
"Couldn’t", "Did", "Didn’t", "Do", "Does", "Doesn’t", "Doing", "Don’t", "Down", "During", "Each", "Few", "For", "From", "Further", "Had", "Hadn’t", "Has", "Hasn’t", "Have", "Haven’t", "Having",
"He", "He’d", "He’ll", "He’s", "Her", "Here", "Here’s", "Hers", "Herself", "Him", "Himself", "His", "How", "How’s", "I ", " I", "I’d", "I’ll", "I’m", "I’ve", "If", "In", "Into", "Is",
"Isn’t", "It", "It’s", "Its", "Itself", "Let’s", "Me", "More", "Most", "Mustn’t", "My", "Myself", "No", "Nor", "Not", "Of", "Off", "On", "Once", "Only", "Ought", "Our", "Ours", "Ourselves",
"Out", "Over", "Own", "Same", "Shan’t", "She", "She’d", "She’ll", "She’s", "Should", "Shouldn’t", "So", "Some", "Such", "Than",
"That", "That’s", "Their", "Theirs", "Them", "Themselves", "Then", "There", "There’s", "These", "They", "They’d", "They’ll", "They’re", "They’ve",
"This", "Those", "Through", "To", "Too", "Under", "Until", "Up", "Very", "Was", "Wasn’t", "We", "We’d", "We’ll", "We’re", "We’ve",
"Were", "Weren’t", "What", "What’s", "When", "When’s", "Where", "Where’s", "Which", "While", "Who", "Who’s", "Whom",
"Why", "Why’s", "With", "Won’t", "Would", "Wouldn’t", "You", "You’d", "You’ll", "You’re", "You’ve", "Your", "Yours", "Yourself", "Yourselves"
};
//System.out.println("Count of string array:"+stopWordsofwordnet.length);
System.out.println("____________________________________________");
System.out.println("********Porter stemmer algorithm***********");
System.out.println("____________________________________________");
System.out.println("Enter the word for stemming:");
Scanner scan=new Scanner(System.in);
String sca=scan.nextLine();
String s1=sca;

for(int i=0;i<=((stopWordsofwordnet.length)-1);i++)
{
if(s1.equals(stopWordsofwordnet[i]))
{
ss=1;
//sss=0;
break;

}
else{
ss=0;

}
}
if(ss==1){
System.out.println("Word is a stop word ");
}else{
int l1=s1.length();
stem ste=new stem();
ste.st=s1;
ste.len=l1-1;
ste.step1a();
ste.step1b();
ste.step1c();
ste.step2();
ste.step3();
ste.step4();
ste.step5a();
ste.step5b();
String op = ste.pri();
System.out.println("stem of "+s1+" is "+op);
System.out.println("____________________________________________");
        //String stem_word = stem_word("summaries");
//System.out.println("stem of summaries is "+stem_word);

}}
}