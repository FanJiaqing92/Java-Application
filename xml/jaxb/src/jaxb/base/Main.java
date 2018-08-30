package jaxb.base;

import jaxb.base.pojo.Server;

public class Main {
    public static void main(String[] args){
        String xmlPath = "src\\jaxb\\base\\Server.xml";
        JaxbBase base = new JaxbBase(xmlPath);
        Server server = getServer();
        base.write(server);
    }

    private static Server getServer(){
        Server server = new Server();
        server.setId(1);
        server.setIp("1.1.1.1");
        server.setName("Test");
        server.setPort(8088);
        return server;
    }
}