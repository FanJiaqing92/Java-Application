package xml.dom4j.base;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 描述Dom4j如何解析xml文件和将对象转化成xml文件，更高级的用法在后续碰到了再补充。
 * 涉及的Java类包括Document，Element，Attribute，Node
 * @author Jiaqing Fan
 * @date 2018/09/10
 */
public class Dom4jBase {
    private String xmlPath;
    private Document document;

    public Dom4jBase(String xmlPath){
        this.xmlPath = xmlPath;
    }

    public void print(){
        parse();
        if (Objects.isNull(document)){
            return;
        }
        Element root = document.getRootElement();
        Queue<Element> upQueue = new LinkedList<>();
        Queue<Element> downQueue = new LinkedList<>();
        upQueue.add(root);
        while (!upQueue.isEmpty() || !downQueue.isEmpty()){
            if (upQueue.isEmpty()){
                upQueue.addAll(downQueue);
                downQueue.clear();
                System.out.println();
                System.out.println();
                continue;
            }
            Element element = upQueue.poll();
            System.out.println("Tag: " + element.getName());
            List<Attribute> attributeList = element.attributes();
            attributeList.forEach(attribute ->
                    System.out.println(" Attribute: name = " + attribute.getName() + " value = " + attribute.getValue())
            );
            System.out.println();
            downQueue.addAll(element.elements());
        }
    }

    public void write(Document document){
        if (Objects.isNull(document)){
            return;
        }

        OutputFormat format = getOutputFormat();
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileWriter(new File(xmlPath)), format);
            writer.write(document);
            //官方api建议write之后马上进行flush操作
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (Objects.nonNull(writer)) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 返回一个可以直接被写成xml文件的document对象
     */
    public Document getDocument(){

        Document document = DocumentHelper.createDocument();

        document.addComment("这是document的注释");

        //给document添加一个根节点，只能添加一次
        Element root = DocumentHelper.createElement("root");
        document.add(root);

        //再添加运行时会报错
        //Element root2 = DocumentHelper.createElement("root2");
        //document.add(root2);

        document.addComment("这是document的注释2");

        //给root添加一个子节点
        Element subElement1 = DocumentHelper.createElement("sub1");
        root.add(subElement1);

        //给1添加一个子节点2
        Element subElement2 = DocumentHelper.createElement("sub2");
        subElement1.add(subElement2);
        //给节点添加属性，会按照add的顺序显示在xml中
        subElement2.addAttribute("name", "subElement2");
        subElement2.addAttribute("id", "2");

        //给1添加一个被注释过的节点
        Element subElement3 = DocumentHelper.createElement("sub3");
        Comment comment1 = DocumentHelper.createComment(subElement3.asXML());
        subElement1.add(comment1);

        //给1单纯的添加一个注释
        Comment comment2 = DocumentHelper.createComment("这是一个注释");
        subElement1.add(comment2);

        return document;
    }
    private OutputFormat getOutputFormat(){

        //紧凑的格式
        //OutputFormat format = OutputFormat.createCompactFormat();

        //缩进的格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        return format;
    }

    private void parse(){
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(new File(xmlPath));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
