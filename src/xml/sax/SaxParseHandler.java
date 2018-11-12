package xml.sax;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName SaxParseHandler
 * Description 这个类是sax解析的核心类。定义了如何解析读取到的每一个元素。这也是sax复杂的地方
 * Author Jiaqing Fan
 * Date 2018/10/25
 */
public class SaxParseHandler extends DefaultHandler {

    private List<User> users;
    private String currentTag; // 记录当前解析到的节点名称
    private User user; // 记录当前的user

    /**
     * 文档解析开始调用
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        users = new ArrayList<>();
    }

    /**
     * 文档解析结束后调用
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    /**
     *
     * @param uri :
     * @param localName :
     * @param qName :
     */

    /**
     * 节点解析开始调用
     * @param uri 命名空间的uri
     * @param localName 标签的名称
     * @param qName 带命名空间的标签名称
     *              当命名空间被感知时，即 SAXParserFactory.setNamespaceAware(true)。如果tag中没有指明使用哪个命名空间prefix，
     *              即使用默认的命名空间时，qName的值和localName一致。但当tag中指明了命名空间prefix，例如h:user。则此时localName
     *              的值为user，qName的值为h:user
     * @param attributes 节点的属性
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (StringUtils.equals(qName, "h:user")) { // 是一个用户
            for (int i = 0; i < attributes.getLength(); i++) {
                user = new User();
                //暂时没有发现这两个有什么区别，难道属性也可以专门加命名空间？明天继续
                String attrQName = attributes.getQName(i);
                String attrLocalName = attributes.getLocalName(i);

                if (StringUtils.equals(attrQName, "id")){
                    user.setId(Long.parseLong(attributes.getValue(i)));
                }
            }
        }
        currentTag = localName; // 把当前标签记录下来
    }

    /**
     * 节点解析结束后调用
     * @param uri : 命名空间的uri
     * @param localName : 标签的名称
     * @param qName : 带命名空间的标签名称
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("endElement. localName: " + localName);
        if("user".equals(localName)){
            //users.add(user);
            user = null;
        }
        currentTag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch,start,length); // 将当前TextNode转换为String
        System.out.println("characters. value: " + value);
        if("name".equals(currentTag)){  // 当前标签为name标签，该标签无子标签，直接将上面获取到的标签的值封装到当前User对象中
            // 该节点为name节点
            //user.setName(value);
        }else if("password".equals(currentTag)){  // 当前标签为password标签，该标签无子标签，直接将上面获取到的标签的值封装到当前User对象中
            // 该节点为password节点
            //user.setPassword(value);
        }
    }

    public List<User> getUsers() {
        return users;
    }

}
