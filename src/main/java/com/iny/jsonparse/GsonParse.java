package com.iny.jsonparse;

import com.google.gson.Gson;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zcy on 2018/1/12.
 */
public class GsonParse {
    public static void main(String args[])throws Exception{

        String s = "[{\"attrKey\":\"包装规格\",\"attrVal\":\"500页/包\"},{\"attrKey\":\"产品类型\",\"attrVal\":\"复印纸\"},{\"attrKey\":\"颜色分类\",\"attrVal\":\"白\"},{\"attrKey\":\"幅面\",\"attrVal\":\"A3\"},{\"attrKey\":\"适用范围\",\"attrVal\":\"双面复印\"}]";
        ItemAttrs[] is =  parse(s);
        if(is == null){
            throw new Exception("解析错误");
        }else{
            for (ItemAttrs i:is) {
                //     System.out.print(i.getGroup());
                for (OtherAttributes o:i.getOtherAttributes()) {
                    System.out.println(i.getGroup()+"->"+o.getAttrKey()+":"+o.getAttrVal());
                }

            }

        }

    }

    private static ItemAttrs[] parse(String json){
        Gson g = new Gson();
        ItemAttrs[] items=null;
        OtherAttributes[] oa=null;
        if(json.contains("group")){
            items = g.fromJson(json,ItemAttrs[].class);
        }else{
            oa = g.fromJson(json,OtherAttributes[].class);
        }

        return items;
    }


    class ItemAttrs{
        String group;
        OtherAttributes[] otherAttributes;

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public OtherAttributes[] getOtherAttributes() {
            return otherAttributes;
        }

        public void setOtherAttributes(OtherAttributes[] otherAttributes) {
            otherAttributes = otherAttributes;
        }
    }

    class OtherAttributes{
        String propertyId;
        String attrKey;
        String attrVal;
        String group;

        public String getPropertyId() {
            return propertyId;
        }

        public void setPropertyId(String propertyId) {
            this.propertyId = propertyId;
        }

        public String getAttrKey() {
            return attrKey;
        }

        public void setAttrKey(String attrKey) {
            this.attrKey = attrKey;
        }

        public String getAttrVal() {
            return attrVal;
        }

        public void setAttrVal(String attrVal) {
            this.attrVal = attrVal;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }
    }
}


