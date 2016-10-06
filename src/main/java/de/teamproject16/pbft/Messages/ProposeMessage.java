package de.teamproject16.pbft.Messages;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by IngridBoldt on 29.09.16.
 */
public class ProposeMessage extends Message {

    Number node;
    Number leader;
    Number proposal;
    ArrayList value_store;

    public ProposeMessage(Number type, Number sequence_no, Number node, Number leader, Number proposal, ArrayList value_store) {
        super(type, sequence_no);
        this.node = node;
        this.leader = leader;
        this.proposal = proposal;
        this.value_store = value_store;
    }

    public static ProposeMessage messageDecipher(JSONObject data) throws JSONException {
        return new ProposeMessage((Number) data.get("type"), (Number) data.get("sequence_no"), (Number) data.get("node"),
                (Number) data.get("leader"), (Number) data.get("proposal"), (ArrayList) data.get("value_store"));
    }

    public JSONObject messageEncode() throws JSONException {
        JSONObject data = super.messageEncode();
        data.put("node", this.node);
        data.put("leader", this.leader);
        data.put("proposal", this.proposal);
        data.put("value_store", this.value_store);
        return data;
    }
}

