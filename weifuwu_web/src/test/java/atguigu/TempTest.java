package atguigu;

import com.alibaba.fastjson.JSONObject;

/**
 * @author gmq
 * @date 2019/12/31
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class TempTest {

    public static void main(String[] args) {

        String inParam="\n" +
                "{\n" +
                "\t\"ROOT\": {\n" +
                "\t\t\"HEADER\": {\n" +
                "\t\t\t\"POOL_ID\": \"1\",\n" +
                "\t\t\t\"DB_ID\": \"\",\n" +
                "\t\t\t\"OP_CODE\": \"1646\",\n" +
                "\t\t\t\"CHANNEL_ID\": \"11\",\n" +
                "\t\t\t\"PASSWORD\": \"65a0ec385ca6a0c1e20d1f8270c28303\",\n" +
                "\t\t\t\"ROUTING\": {\n" +
                "\t\t\t\t\"ROUTE_KEY\": \"11\",\n" +
                "\t\t\t\t\"ROUTE_VALUE\": \"230650002901006511\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"PARENT_CALL_ID\": \"61E984EB41709FB6B866B1BC5DAA2725\",\n" +
                "\t\t\t\"TENANT_ID\": \"23\",\n" +
                "\t\t\t\"USERNAME\": \"aheb00\",\n" +
                "\t\t\t\"IP_ADDRESS\": \"172.19.65.206\",\n" +
                "\t\t\t\"KEEP_LIVE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"BODY\": {\n" +
                "\t\t\t\"MSG_TYPE\": {\n" +
                "\t\t\t\t\"ORDER_TYPE_ID\": \"2\",\n" +
                "\t\t\t\t\"DB_ID\": \"A1\",\n" +
                "\t\t\t\t\"EXE_ORDER\": \"1\",\n" +
                "\t\t\t\t\"PLAN_CODE\": \"1000006724\",\n" +
                "\t\t\t\t\"BATCH_TYPE\": \"0\",\n" +
                "\t\t\t\t\"AUTO_CONFIRM\": \"X\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"OPR_INFO\": {\n" +
                "\t\t\t\t\"LOGIN_NO\": \"aheb00\",\n" +
                "\t\t\t\t\"REGION_ID\": \"2301\",\n" +
                "\t\t\t\t\"OP_CODE\": \"1646\",\n" +
                "\t\t\t\t\"SYSTEM_NOTE\": \"\",\n" +
                "\t\t\t\t\"CUST_ID_TYPE\": \"2\",\n" +
                "\t\t\t\t\"CUST_ID_VALUE\": \"230670003004269778\",\n" +
                "\t\t\t\t\"SERVICE_NO\": \"15046414597\",\n" +
                "\t\t\t\t\"CHANNEL_TYPE\": \"6\",\n" +
                "\t\t\t\t\"CONTACT_ID\": \"1120041000000000000086120\",\n" +
                "\t\t\t\t\"MSG_GROUP\": \"\",\n" +
                "\t\t\t\t\"GROUP_ID\": \"10031\",\n" +
                "\t\t\t\t\"OP_NOTE\": \"增加付费计划\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"BUSIINFO_LIST\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"SERIAL_NO\": \"0\",\n" +
                "\t\t\t\t\t\"PROD_PRC_LIST\": [],\n" +
                "\t\t\t\t\t\"ORDER_LINE_FEELIST\": [],\n" +
                "\t\t\t\t\t\"BUSI_LINE_LIST\": [],\n" +
                "\t\t\t\t\t\"MAIN_SVC_ID\": \"S00107\",\n" +
                "\t\t\t\t\t\"BUSI_MODEL\": {\n" +
                "\t\t\t\t\t\t\"ID_NO\": \"230670003004269778\",\n" +
                "\t\t\t\t\t\t\"CONTRACTATT_TYPE\": \"14\",\n" +
                "\t\t\t\t\t\t\"BILL_FLAG\": \"1\",\n" +
                "\t\t\t\t\t\t\"PAY_TYPE\": \"0\",\n" +
                "\t\t\t\t\t\t\"OP_TYPE\": \"I\",\n" +
                "\t\t\t\t\t\t\"PAY_VALUE\": \"0.0\",\n" +
                "\t\t\t\t\t\t\"CONTRACT_NO\": \"230171100009204703\",\n" +
                "\t\t\t\t\t\t\"NOW_FLAG\": \"Y\",\n" +
                "\t\t\t\t\t\t\"SEND_FLAG\": \"N\",\n" +
                "\t\t\t\t\t\t\"RATE_FLAG\": \"N\",\n" +
                "\t\t\t\t\t\t\"CYCLE_TYPE\": \"0\",\n" +
                "\t\t\t\t\t\t\"OP_NOTE\": \"增加付费计划\",\n" +
                "\t\t\t\t\t\t\"CUST_NAME\": \"孙**\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"ACTION_ID\": \"16460\",\n" +
                "\t\t\t\t\t\"IS_PARALLEL\": \"N\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        JSONObject inParamObject = JSONObject.parseObject(inParam);
        JSONObject headerObject = (JSONObject) JsonUtil.getValue(inParamObject, "ROOT.HEADER");
        String sendMessageInParam = "{\n" +
                "                            \"ROOT\":{\n" +
                "                                \"BODY\":{\n" +
                "                                    \"ORDER_ID\":\"\",\n" +
                "                                    \"PLAN_CODE\":\"\",\n" +
                "                                    \"BATCH_TYPE\":\"\",\n" +
                "                                    \"DB_ID\":\"\"\n" +
                "                                }\n" +
                "                            }\n" +
                "                        }";
        JSONObject sendMessageObject = JSONObject.parseObject(sendMessageInParam);
        JSONObject rootObject = (JSONObject) JsonUtil.getValue(sendMessageObject, "ROOT");
        rootObject.put("HEADER",headerObject);
        JSONObject bodyObject = (JSONObject) JsonUtil.getValue(sendMessageObject, "ROOT.BODY");
        bodyObject.put("ORDER_ID","111");
        bodyObject.put("PLAN_CODE","222");
        bodyObject.put("BATCH_TYPE","333");
        bodyObject.put("DB_ID","444");
        String sendMessageInParam1 = sendMessageObject.toString();
        System.out.println(sendMessageInParam1);
    }

    public static void test1(TraversalType traversalType) {
        switch (traversalType) {
            case PRE_ORDER:
                System.out.println("PRE_ORDER");
            case IN_ORDER:
                System.out.println(111);
                break;
            case POST_ORDER:
                System.out.println(222);
        }
    }

}
