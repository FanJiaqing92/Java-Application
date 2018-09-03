package xml.jaxb.base;

public class ComplexNode {
    private static final String NAME_SEPARATOR = "-";

    private String first;
    private String second;
    private String third;

    public ComplexNode(String totalName){
        initNode(totalName);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getTotalName(){
        StringBuilder sb = new StringBuilder(64);
        sb.append(first).append(NAME_SEPARATOR).append(second).append(NAME_SEPARATOR)
                .append(third).append(NAME_SEPARATOR);
        return sb.toString();
    }

    private void initNode(String totalName){
    }
}
