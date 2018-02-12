package transformers;

import java.util.HashMap;
import java.util.LinkedList;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.util.CaseInsensitiveHashMap;

public class AddTotal implements Callable {
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		LinkedList<CaseInsensitiveHashMap> pay = (LinkedList<CaseInsensitiveHashMap>) eventContext.getMessage()
				.getPayload();

		// Build entry for totals
		CaseInsensitiveHashMap c = new CaseInsensitiveHashMap();
		c.put("type", "total");
		c.put("archived_amount_ok", eventContext.getMessage().getInvocationProperty("total_archived_amount_ok"));
		c.put("archived_bytes_ok", eventContext.getMessage().getInvocationProperty("total_archived_bytes_ok"));
		c.put("archived_amount_nok", eventContext.getMessage().getInvocationProperty("total_archived_amount_nok"));
		c.put("archived_bytes_nok", eventContext.getMessage().getInvocationProperty("total_archived_bytes_nok"));

		// Add to payload
		pay.add(c);

		return pay;
	}
}
