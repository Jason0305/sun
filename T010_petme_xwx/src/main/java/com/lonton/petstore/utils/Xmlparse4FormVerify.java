package com.lonton.petstore.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
  * Title:Xmlparse4FormVerify
  * description: 读取xml中配置的表单验证信息
  * company: linker
  * @author zhanjp
  * @date 2016年2月22日 上午9:33:59
  */
public class Xmlparse4FormVerify {


    private static DocumentBuilder db = null;
    
            private static DocumentBuilderFactory dbf = null;
    
            private static Document dt = null;
    
            public static Xmlparse4FormVerify xp;
    
            
            /**
      * 初始化DocumentBuilder等信息
      * @return
      */
            public Xmlparse4FormVerify getInstance(){
        if(xp==null){
            xp = new Xmlparse4FormVerify();
        }
        return xp;
    }
    
            static{
        try {
            //返回documentBuilderFactory
            dbf = DocumentBuilderFactory.newInstance();
            
            db = dbf.newDocumentBuilder();
//            String basePath = new Xmlparse4FormVerify().getClass().getClassLoader().getResource("/").getPath();
            String basePath = "";
            File f = new File(basePath + "formVerify.xml");
            //获取xml文件的dom对象
            dt = db.parse(f);
        } catch (ParserConfigurationException  e) {
            e.printStackTrace();
            System.out.println("class:Xmlparse4FormVerify>>documentBuilder对象初始化失败。");
        } catch (SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("class:Xmlparse4FormVerify>>解析formVerify.xml文档失败");
        }
    }
    
            /**
      * 根据表单ID和表单参数进行校验
      * @param formId 表单ID
      * @param pMap 表单参数
      * @return flag-0：成功,1:失败; msg-消息
      * @throws Exception
      */
            public static String verifyForm(String formId,Map<String, String> pMap)throws Exception{
        if(dt==null){
            throw new Exception("未能正确初始化。");
        }
        String errorInfo = null;
        //开始解析xml文档
        //获取xml文件跟节点
        Element element = dt.getDocumentElement();
        //获取根节点下的子节点列表
        NodeList cList = element.getChildNodes();
        List<Node> forms = new ArrayList<>();
        for (int i = 0; i < cList.getLength(); i++) {
            Node tNode = cList.item(i);
            if(tNode.getNodeName().equals("form")){
                forms.add(tNode);
            }
        }
        for (int i = 0; i < forms.size(); i++) {
            Node node1 = forms.get(i);
            String nodeId = node1.getAttributes().getNamedItem("id").getNodeValue();
            //            System.out.println("节点id:" + nodeId+","+"节点name"+node1.getNodeName());
            if(nodeId.equals(formId)){
                NodeList cList2 = node1.getChildNodes();
                //开始校验
                Set<String> keys = pMap.keySet();
                Iterator<String> iter = keys.iterator();
                while (iter.hasNext()) {
                    String key = iter.next();
                    for (int j = 0; j < cList2.getLength(); j++) {
                        Node node = cList2.item(j);
                        //                        System.out.println("clist2,node:"+node.getNodeName());
                        if(node.getNodeName().equals(key)){
                            String value = pMap.get(key);
                            String preText = "";
                            String rule = "";
                            NodeList cList3 = node.getChildNodes();
                            
                            for(int m = 0;m < cList3.getLength(); m++){
                                if(cList3.item(m).getNodeName()=="text"){
                                    preText = cList3.item(m).getTextContent();
                                }else if(cList3.item(m).getNodeName()=="rule"){
                                    rule = cList3.item(m).getTextContent();
                                }
                            }
                            //TODO 校验
                            errorInfo = new VerifyRegularUtil().verify(value, preText,  rule);
                            if(errorInfo!=null){
                                return errorInfo;
                            }
                        }
                    }
                    
                }
                break;
            }
        }
        return errorInfo;
    }
}
