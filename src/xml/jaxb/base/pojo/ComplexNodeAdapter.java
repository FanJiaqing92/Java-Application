package xml.jaxb.base.pojo;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ComplexNodeAdapter extends XmlAdapter<String, ComplexNode> {
    @Override
    public ComplexNode unmarshal(String totalName) throws Exception {
        return new ComplexNode(totalName);
    }

    @Override
    public String marshal(ComplexNode node) throws Exception {
        return node.getTotalName();
    }
}
