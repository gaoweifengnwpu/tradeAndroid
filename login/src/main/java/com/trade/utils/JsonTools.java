package com.trade.utils;


import org.json.JSONObject;

/**
 * Created by GWF on 2018/1/28.
 */

public class JsonTools {

    public JsonTools() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {"result":{"resultCode":1,"resultMessage":"登录成功"}}
     *
     * @param jsonString
     * @return
     */
    public static ResultMessage getResultMessage(String jsonString) {
        ResultMessage message = null;

        try {
            JSONObject sourceObject = new JSONObject( jsonString );
            JSONObject jsonObject = sourceObject.getJSONObject( "result" );
            message = new ResultMessage();
            message.setResultCode( jsonObject.getInt( "resultCode" ) );
            message.setResultMessage( jsonObject.getString( "resultMessage" ) );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return message;
    }
}
