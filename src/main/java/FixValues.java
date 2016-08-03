import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

import org.joda.time.format.ISODateTimeFormat;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transformer.TransformerException;
import org.mule.el.datetime.DateTime;
import org.mule.transformer.AbstractMessageTransformer;

import antlr.collections.List;

public class FixValues implements Callable{
@Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
		// we'll generate an array that has for every timestamp a value (default: 0) according to its granularity
		LinkedList<HashMap<DateTime, Integer>> filledArray = new LinkedList<HashMap<DateTime, Integer>>();
		
        MuleMessage m = eventContext.getMessage();
        String granularity = m.getInvocationProperty("granularity");

        Object startDateTime = m.getInvocationProperty("startDateTime");
        Object endDateTime = m.getInvocationProperty("endDateTime");
        LinkedList<Map<String, DateTime>> a = (LinkedList<Map<String, DateTime>>) m.getPayload();
        
        ListIterator it = (ListIterator) a.iterator();
        while (it.hasNext()) {
        	Object k = it.next();
        	System.out.println(k);
        	
        	Map<String, DateTime> cast = (Map<String, DateTime>) k;
        	System.out.println(cast);
//        	Object x = k.get("x");
//        	System.out.println(x);
//
////        	String customFormat = "yyyy-MM-dd HH:mm:ss";
////        	org.joda.time.format.DateTimeFormatter dtf = ISODateTimeFormat.dateTime();
////        	org.joda.time.LocalDateTime parsedDate = dtf.parseLocalDateTime(x);
//            
//        	int y = Integer.parseInt(k.get("y").toString());
//        	System.out.println(y);        	
    	}
        	
        return eventContext.getMessage().getPayload();
    }
}