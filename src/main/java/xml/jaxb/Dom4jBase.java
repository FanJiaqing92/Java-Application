package xml.jaxb;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Objects;

/**
 * 描述Dom4j如何解析xml文件和将对象转化成xml文件，更高级的用法在后续碰到了再补充。
 * 涉及的Java类包括Document，Element，Attribute，Node
 * @author Jiaqing Fan
 * @date 2018/09/10
 */
    //TODO 想要把被注释了的节点从Comment转化回Element
    //目前没有找到合适的方法，难道需要解析字符串然后重新创建吗？Dom4j没有这种api还是我还没有找到
public class Dom4jBase {
    private String xmlPath;
    private Document document;

    public Dom4jBase(String xmlPath){
        this.xmlPath = xmlPath;
    }

    public void parse(){
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(new File(xmlPath));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        if (Objects.isNull(document)){
            return;
        }
        //获取文件根节点
        Element root = document.getRootElement();

        //获取document下的所有node。其中有且只有一个Element（就是xml的根节点），会有零个或多个Comment
        //Node,Element,Comment都是接口，Node是Element和Comment的某一级父类，Element和Comment没有关系
        //如果想要获取document下的所有注释，遍历所有node，然后判断类型，是Element的就是根节点，是Comment的就是注释
        List<Node> nodeList = document.content();
        nodeList.forEach(node -> {
            if (node instanceof Element){
                System.out.println("这是根节点， Name: "  + node.getName());
                //这里根节点的内容中会输出空白符，我感觉这个空白符是xml中子节点外的换行
                System.out.println("这是根节点， Text: "  + node.getText());
            }
            else if (node instanceof Comment){
                //注释是没有节点名的，getName拿到的是null
                System.out.println("这是注释， Name: " + node.getName());
                //Text就是注释内容
                System.out.println("这是注释， Text: " + node.getText());
            }
        });
        //获取root下所有节点，这里只有一个
        List<Element> subRoot = root.elements();

        Element sub1 = subRoot.get(0);
        //获取sub1下所有元素节点，list中的顺序就是xml文件中的顺序。如果改变其中元素的顺序，然后直接打印，新生成的xml
        //文件中节点的顺序会是改变之后的节点顺序。所以，如果要在某个中间位置插入一个节点，添加到subList对应的index上就可以了。
        //除了获取所有的子节点，获取某一个节点名称的api。
        //list中不包括注释Comment
        List<Element> subList = sub1.elements();

        //如果要读取注释，则要使用content。但是其中会包括例如换行符之类的元素，所以需要甄别。
        List<Node> subNodeList = sub1.content();

        subNodeList.forEach(subNode -> {
            if (subNode instanceof Comment){
                System.out.println("这是一个注释，Text: " + subNode.getText());
            }
        });

        Element sub2 = subList.get(0);

        //Attribute也和Element类似，list中的顺序就是xml文档中属性的顺序。
        List<Attribute> sub2AttributeList = sub2.attributes();
        sub2AttributeList.forEach(attribute -> {
            //avoid findbugs, do noting.
        });

    }

    public void write(Document document){
        if (Objects.isNull(document)){
            return;
        }

        OutputFormat format = getOutputFormat();
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new OutputStreamWriter(
                    new FileOutputStream(xmlPath), "UTF-8"), format);
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

        //给1添加好多个节点
        Element subElement4 = DocumentHelper.createElement("sub4");
        subElement1.add(subElement4);

        Element subElement5 = DocumentHelper.createElement("sub5");
        subElement1.add(subElement5);

        Element subElement6 = DocumentHelper.createElement("sub6");
        subElement1.add(subElement6);

        Element subElement7 = DocumentHelper.createElement("sub7");
        subElement1.add(subElement7);

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


}
